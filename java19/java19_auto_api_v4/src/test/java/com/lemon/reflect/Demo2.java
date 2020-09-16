package com.lemon.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author luojie
 * @date 2020/6/16 - 21:11
 * 柠檬班创新教育极致服务
 * 反射常用API
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
        String name = "com.lemon.reflect.Student";
        //获取字节码对象
        Class clazz3 = Class.forName(name);
        /*
            构造方法、成员变量、成员方法。
        * */
        //调用空参构造创建对象。
        //Object obj2 = new Student();
        Object obj = clazz3.newInstance();
//        System.out.println(obj);
        //私有属性 get/set    name  getName()     setName(String name)
        //构造方法、成员变量、成员方法。
//        Constructor[] constructors = clazz3.getConstructors();
//        System.out.println(Arrays.toString(constructors));

        //Field[] fields = clazz3.getFields();
//        Field[] fields = clazz3.getDeclaredFields();
//        System.out.println(Arrays.toString(fields));
        //获取name成员变量
//        Field fName =  clazz3.getDeclaredField("name");
//        Field fAge =  clazz3.getDeclaredField("age");
        //成员变量是由对象调用， s.name = "zhangsan"
        //暴力反射（调用私有成员）
//        fName.setAccessible(true);
//        fName.set(obj,"zhangsan");
//        //syso(s.name)
//        System.out.println(fName.get(obj));
//        Student s = (Student)obj; //向下转型 强转
//        System.out.println(s.getName());

//        Method[] methods = clazz3.getMethods();
//        System.out.println(Arrays.toString(methods));
//        Method mShow = clazz3.getDeclaredMethod("print");
//        // s.show();
//        mShow.setAccessible(true);
//        Object result = mShow.invoke(obj);
//        System.out.println(result);
        //解析 json  ---> name;
        Field fName =  clazz3.getDeclaredField("name");
        //setName
        String setMethodName = "set" + fName.getName().substring(0,1).toUpperCase() + fName.getName().substring(1);
        System.out.println(setMethodName);
        //getDeclaredMethod(方法名，方法参数1类型,方法参数2类型,..方法参数N类型,)
        Method mSetName = clazz3.getDeclaredMethod(setMethodName,fName.getType());
        mSetName.invoke(obj,"zhangsan");

        System.out.println(obj);

    }
}
