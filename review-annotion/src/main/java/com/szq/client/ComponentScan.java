package com.szq.client;

import com.szq.annotation.Component;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComponentScan {
    public static void main(String[] args) throws Exception{
        Map<String,Object> beanMap=new HashMap<>();
        //目前只知道包的名字，扫描这个包下的所有类，当这个类上有@Component注解的时候，实例化该对象，然后放到Map集合中
        String packageName="com.szq.bean";
        //开始写扫描程序
        String packagePath = packageName.replaceAll("\\.", "/");
        System.out.println(packagePath);
        //com是类的根路径下的一个目录
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        System.out.println(url);
        String path = url.getPath();
        System.out.println(path);
        //获取一个绝对路径的所有文件
        File file = new File(path);
        System.out.println(file);
        File[] files = file.listFiles();
        System.out.println(files);
        Arrays.stream(files).forEach(f->{
            try {
                System.out.println(f.getName().split("\\.")[0]);
                String className=packageName+"."+f.getName().split("\\.")[0];
                System.out.println(className);
                //通过反射机制解析注解
                Class<?> aClass = Class.forName(className);
                if (aClass.isAnnotationPresent(Component.class)) {
                    //创建对象
                    Component annotation = aClass.getAnnotation(Component.class);
                    String id = annotation.value();
                    //有这个注解都要创建对象
                    Constructor<?> constructor = aClass.getConstructor();
                    Object obj = constructor.newInstance();
                    beanMap.put(id,obj);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(beanMap);
    }
}
