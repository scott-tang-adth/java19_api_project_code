package com.lemon.testng;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo4 {
    @Test
    @Parameters({"type","sheetIndex"})

    public void f(String t,int sheetIndex)
    {


        System.out.println("t = " + t + ", sheetIndex = " + sheetIndex);
    }

}
