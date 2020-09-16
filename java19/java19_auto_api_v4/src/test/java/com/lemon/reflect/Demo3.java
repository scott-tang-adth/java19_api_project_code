package com.lemon.reflect;

import org.testng.annotations.Test;

/**
 * @author by Scott
 * @date 2020/6/18.
 */
public class Demo3 {

    @Test
    public void test() throws Exception {
        String str="com.lemon.reflect.Student";
        Class clazz = Class.forName(str);
        clazz.getDeclaredConstructor();
    }


}
