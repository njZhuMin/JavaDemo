import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectMethod {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList<String> list2 = new ArrayList<String>();
        System.out.println(list1.getClass() == list2.getClass());

        list2.add("hello");
        try {
            Method m = list2.getClass().getMethod("add", Object.class);
            m.invoke(list2, 100);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(list2.size());
        }
    }
}

class A {
    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + "," + b.toLowerCase());
    }

    public void print() {
        System.out.println("Hello world!");
    }
}