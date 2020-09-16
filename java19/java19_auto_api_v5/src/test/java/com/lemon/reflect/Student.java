package com.lemon.reflect;

/**
 * @author luojie
 * @date 2020/6/16 - 21:18
 * 柠檬班创新教育极致服务
 */
public class Student {
    private String name;
    public int age;

    public void show() {
        System.out.println("show.....");
    }

    private void print() {
        System.out.println("print.....");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
