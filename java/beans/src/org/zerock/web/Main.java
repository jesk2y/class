package org.zerock.web;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args)throws Exception {

        Map<String, Object> param =
                new HashMap<>();
        param.put("name", "Darth Vader");
        param.put("age", 50);
        param.put("married", true);

        Class clz =
                Class.forName("org.zerock.domain.Member");

        Object obj = clz.newInstance();

        PropertyDescriptor[] props = Introspector.getBeanInfo(clz).getPropertyDescriptors();

        for(PropertyDescriptor p:props) {
            System.out.println(p.getName());


            Method setter = p.getWriteMethod();
            if(setter == null) {
                continue;
            }
            System.out.println(setter);

            setter.invoke(obj, param.get(p.getName()));
        }

        System.out.println(obj);

    }
}