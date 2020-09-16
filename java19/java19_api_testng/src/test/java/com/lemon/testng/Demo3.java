package com.lemon.testng;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Demo3 {

    @Test
    @Parameters({"type","sheetIndex"})
    public void f(String t,int sheetIndex)
    {
        System.out.println("t = " + t + ", sheetIndex = " + sheetIndex);
    }
    @Test
    public void f()
    {
        System.out.println("Demo3.f");
    }
    @BeforeTest
    @Parameters({"sheetIndex2","sheetIndex","type"})//必须和testngxml配置文件里的parameter name一致
    public void BeforeTest(String type,int sheetIndex,String tst)//这里的参数可以随便定义，对应规则和上面的parameter一致
    {
        System.out.println("type = " + type + ", sheetIndex = " + sheetIndex + ", tst = " + tst);
    }
}
