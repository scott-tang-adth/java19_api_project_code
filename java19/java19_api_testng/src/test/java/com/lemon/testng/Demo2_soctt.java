package com.lemon.testng;

import org.testng.annotations.*;

/**
 * @author by Scott.Tang
 * @Description ADTH
 * @date 2020/9/6.
 * @Copyright 精宇（上海）电子科技有限公司。 All rights reserved
 */
public class Demo2_soctt {

    @Test
    public void d(){
        System.out.println("Demo2_soctt.d");
    }
    @Test
    public void c(){
        System.out.println("Demo2_soctt.c");
    }

    @Test
    public void b() {
        System.out.println("Demo2.b");
    }

    @Test
    public void a() {
        System.out.println("Demo2.a");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Demo2.beforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Demo2.beforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Demo2.beforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Demo2.beforeMethod");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Demo2.afterSuite");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Demo2.afterTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Demo2.afterClass");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Demo2.afterMethod");
    }
}
