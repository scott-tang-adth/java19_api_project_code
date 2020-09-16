package com.lemon.reflect;


public class Student {

    private String name;
    public int age;

    private Student( String name, int age ) {
        this.name = name;
        this.age = age;
    }

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
