package com.sjh.ioc;

import com.sjh.entity.Address;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyClassPathXmlApplicationContext implements MyApplicationContext {

    private Map<String,Object> iocMap = new HashMap<>();

    public MyClassPathXmlApplicationContext(String path) throws Exception {
        SAXReader reader = new SAXReader();
        //获取XML配置文件对象
        Document document = reader.read("./src/main/resources/"+path);
        //获取根节点，即beans标签
        Element root = document.getRootElement();
        //获取迭代器
        Iterator<Element> iterator = root.elementIterator();
        while(iterator.hasNext()){
            Element element = iterator.next();
            //获取bean标签的id内容
            String id = element.attributeValue("id");
            //获取bean标签的class内容
            String className = element.attributeValue("class");
            //通过反射创建对象
            Class clazz = Class.forName(className);
            //通过无参构造器创建对象
            Object instance = clazz.getConstructor().newInstance();
            //给对象的属性赋值
            Iterator<Element> proIter = element.elementIterator();
            while (proIter.hasNext()){
                Element property = proIter.next();//获取property标签对象
                String name = property.attributeValue("name");//获取property标签的name，即成员变量名
                String valueStr = property.attributeValue("value");//获取property标签的value，即成员变量值
                String methodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);//属性首字母大写
                Field field = clazz.getDeclaredField(name);
                Method method = clazz.getDeclaredMethod(methodName,field.getType());//第二个参数是set方法的参数类型
                Object value;
                if(field.getType().getName().equals("java.lang.Integer")) {//根据成员变量数据类型转换value
                    value = Integer.parseInt(valueStr);
                }else {
                    value = valueStr;
                }
                method.invoke(instance,value);//通过反射赋值
            }
            //把对象存入map
            iocMap.put(id,instance);
        }
        Object address = iocMap.get("address");
        Object student = iocMap.get("student");
        Class<?> clazz = student.getClass();
        Method setAddress = clazz.getDeclaredMethod("setAddress", Address.class);
        setAddress.invoke(student,address);
    }

    @Override
    public Object getBean(String id) {
        return iocMap.get(id);
    }
}
