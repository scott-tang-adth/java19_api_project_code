package com.lemon.reflect;

/**
 * @author luojie
 * @date 2020/6/16 - 21:11
 * 柠檬班创新教育极致服务
 * 反射：
 *     java程序在'运行时''动态'获取某个类的所有内容（对象、方法、属性）,并且可以调用（对象、方法、属性）。
 *     字节码对象
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        //编译 --> Demo.class --> 运行
        //Student s = new Student();
        //获取字节码对象有三种方式:
        Class clazz = Student.class;
        Student s = new Student();
        Class clazz2 = s.getClass();
        //最灵活
        Class clazz3 = Class.forName("com.lemon.reflect.Student");

        System.out.println(clazz);
        System.out.println(clazz == clazz2);
        System.out.println(clazz == clazz3);
    }
}
