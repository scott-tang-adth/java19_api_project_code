package com.lemon.testng;

import org.testng.annotations.*;

public class Demo2 {

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
