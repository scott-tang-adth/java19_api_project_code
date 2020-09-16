package com.lemon.testng;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author by Scott.Tang
 * @Description ADTH
 * @date 2020/9/6.
 * @Copyright 精宇（上海）电子科技有限公司。 All rights reserved
 */
public class Demo3_scott {

    @Test
    @Parameters({"type","sheetindex"})
    public void f(String t,int sheetindex){
        System.out.println("t="+t+"sheetindex="+sheetindex);
    }

    @Test
    @Parameters({"scott","adth"})
    public void f1(String m,double n){

        System.out.println("m = " + m + ", n = " + n);

    }
}
