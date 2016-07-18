package com.sunnywr;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setId(10);

        Filter f2 = new Filter();
        f2.setUserName("Lucy");
        f2.setAge(18);

        Filter f3 = new Filter();
        f3.setEmail("liu@sina.com,zh@163.com,77777@qq.com");

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);

        Filter2 filter2 = new Filter2();
        filter2.setAmount(10);
        filter2.setName("技术部");
        System.out.println(query(filter2));
    }

    private static String query(Object filter) {
        StringBuilder sb = new StringBuilder();
        //获取Class
        Class c = filter.getClass();

        //获取table name
        if(!c.isAnnotationPresent(Table.class))
            return null;
        Table t = (Table)c.getAnnotation(Table.class);
        String tableName = t.value();
        sb.append("SELECT * FROM ").append(tableName).append(" WHERE 1=1");

        //遍历所有字段
        Field[] fields = c.getDeclaredFields();
        for(Field field : fields) {
            //处理每个字段的SQL语句
            //1. 获取字段名
            if(c.isAnnotationPresent(Column.class))
                continue;
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();

            //2. 获取字段值
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0,1).toUpperCase()
                    + fieldName.substring(1);
            Object fieldValue = null;
            try {
                Method getMethod = c.getMethod(getMethodName);
                fieldValue = getMethod.invoke(filter);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //3. 组装SQL语句
            //处理null和0
            if(fieldValue == null ||
                    (fieldValue instanceof Integer && (Integer)fieldValue == 0))
                continue;
            sb.append(" AND ").append(fieldName);
            //处理String引号
            if(fieldValue instanceof String) {
                //处理多个查询条件
                if(((String) fieldValue).contains(",")) {
                    String[] values = ((String) fieldValue).split(",");
                    sb.append(" IN(");
                    for(String v : values) {
                        sb.append("'").append(v).append("'").append(",");
                    }
                    //去掉最后一个逗号
                    sb.deleteCharAt(sb.length()-1);
                    sb.append(")");
                } else {
                    sb.append("=").append("'").append(fieldValue).append("'");
                }
            }
            else if(fieldValue instanceof Integer) {
                sb.append("=").append(fieldValue);
            }
        }
        return sb.toString();
    }
}
