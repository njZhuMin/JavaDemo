package com.sunnywr.proxy;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Proxy {
    public static Object newProxyInstance(Class infce, InvocationHandler h)
            throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String br = "\n";
        String methodStr = "";
        for(Method m : infce.getMethods()) {
            methodStr += "    public void " + m.getName() + "() {" + br +
                "        try { " + br +
                "            Method method = " + infce.getName() + ".class.getMethod(\""
                        + m.getName() + "\");" + br +
                "            h.invoke(this, method);" + br +
                "        } catch(Exception e) { e.printStackTrace(); }" + br +
                "    }";
        }
        String string = "package com.sunnywr.proxy;" + br +
            "import com.sunnywr.proxy.InvocationHandler;" + br +
            "import java.lang.reflect.Method;" + br +
            "public class $Proxy0 implements " + infce.getName() + " {" + br +
            "    private InvocationHandler h;" + br +
            "    public $Proxy0(InvocationHandler h) {" + br +
            "        this.h = h;" + br +
            "    }" + br +
                methodStr + br +
            "}";

        // 产生代理类java文件
        String filename = System.getProperty("user.dir")
                + "/target/classes/com/sunnywr/proxy/$Proxy0.java";
        File file = new File(filename);
        FileUtils.writeStringToFile(file, string, "utf-8");

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager =
                compiler.getStandardFileManager(null, null, null);
        // 获取文件
        Iterable units = fileManager.getJavaFileObjects(filename);
        // 编译任务
        JavaCompiler.CompilationTask task =
                compiler.getTask(null, fileManager, null, null, null, units);
        // 进行编译
        task.call();
        fileManager.close();

        // 将Class Load到内存中
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class clazz = classLoader.loadClass("com.sunnywr.proxy.$Proxy0");
        //System.out.println(clazz.getName());

        // 生成代理类
        Constructor constructor = clazz.getConstructor(InvocationHandler.class);
        return constructor.newInstance(h);
    }
}
