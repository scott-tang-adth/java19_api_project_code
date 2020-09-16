package com.lemon.testng;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Demo1 {

      @Test
      public void f()
      {

          System.out.println("Demo1.f");
      }

      //@Test(dependsOnMethods = {"f"},threadPoolSize = 3, invocationCount = 10,  timeOut = 10000)
      @Test
      public void f2()
      {

          System.out.println("Demo1.f2");
      }
      @BeforeSuite
      public void f3(){
          System.out.println("Demo1.@BeforeSuite.f3");
      }
      @BeforeTest
      public void  f4(){
          System.out.println("Demo1.@BeforeTest.f4");
      }

}
