package org.myspringframework.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext{
    private Map<String,Object> stringObjects=new HashMap<>();
    /**
     * 解析myspring配置文件，然后初始化所有的Bean对象
     * @param configLocation spring配置文件的路径，配置文件应该放在类路径上
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        try {
            //解析myspring.xml文件，然后实例化Bean，将Bean存放到stringObjects集合当中。
            //这是dom4j解析XMl文件的核心对象
            SAXReader reader = new SAXReader();
            //获取应该输入流指向配置文件
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            //读文件
            Document document= reader.read(in);
            //获取所有的bean标签
            List<Node> nodes = document.selectNodes("//bean");
            //遍历bean标签
            nodes.forEach(node -> {
                try {
                    //                System.out.println(node);
                    //向下转型，使方法更加丰富
                    Element beanElt = (Element) node;
                    //获取id属性
                    String id = beanElt.attributeValue("id");
                    //获取class属性
                    String className = beanElt.attributeValue("class");
//                System.out.println(id);
//                System.out.println(className);
                    //通过反射机制创建对象，将其放到Map集合中，提前曝光。
                    //获取Class
                    Class<?> clazz = Class.forName(className);
                    //获取无参构造方法
                    Constructor<?> defauttCon = clazz.getConstructor();
                    //调用无参构造方法实例化bean
                    Object bean = defauttCon.newInstance();
                    //将Bean曝光，加入Map集合
                    stringObjects.put(id,bean);
                  /*  System.out.println(stringObjects);*/

                } catch (Exception e) {
                    e.printStackTrace();
                }

            });

            //再次把所有bean标签在遍历一次，这一次主要是给对象属性赋值
            nodes.forEach(node -> {

                try {
                    Element beanElt = (Element) node;
                    //获取id
                    String id = beanElt.attributeValue("id");
                    //获取className
                    String className = beanElt.attributeValue("class");
                    //获取Class
                    Class<?> aClass = Class.forName(className);
                    //获取该bean标签下的所有属性property标签
                    List<Element> propertys = beanElt.elements("property");
                    //遍历所有的属性标签
                    propertys.forEach(property->{
                        try {
                            //获取属性名
                            String propertyName = property.attributeValue("name");
                            //获取属性类型
                            Field field = aClass.getDeclaredField(propertyName);
                            //                    System.out.println(propertyName);
                            //获取set方法名
                            String setMethodName="set"+propertyName.toUpperCase().charAt(0)+propertyName.substring(1);
                            //获取set方法
                            Method setMethod = aClass.getDeclaredMethod(setMethodName, field.getType());
                            //获取具体的值
                            String value = property.attributeValue("value");
                            Object actualValue=null;
                            String ref = property.attributeValue("ref");
                            if (value != null) {
                                //说明这个值是简单类型
                                //调用set方法
                                //获取属性类型名
                                String propertyTypeSimpleName = field.getType().getSimpleName();
                                switch (propertyTypeSimpleName){
                                    case "byte":
                                        actualValue = Byte.parseByte(value);
                                        break;
                                    case "short":
                                    case "int":
                                        actualValue = Integer.parseInt(value);
                                        break;
                                    case "long":
                                    case "float":
                                    case "double":
                                    case "boolean":
                                    case "char":
                                    case "String":
                                        actualValue=value;
                                        break;
                                }
                                setMethod.invoke(stringObjects.get(id),actualValue);
                            }
                            if (ref != null) {
                                //说明这个值不是简单类型
                                //调用set方法
                                setMethod.invoke(stringObjects.get(id),stringObjects.get(ref));
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanName) {
        return stringObjects.get(beanName);
    }
}
