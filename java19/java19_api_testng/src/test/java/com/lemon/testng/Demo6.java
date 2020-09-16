package com.lemon.testng;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo6 {
    @Test(dataProvider ="datas2")
    public void f(String username ,String password)
    {
        System.out.println("username = " + username + ", password = " + password);
    }
    @DataProvider
    public Object[][]datas2()
    {
        Object[][]datas=new Object[4][2];
        datas[0][0]="zhasan1";
        datas[0][1]="123456";
        datas[1][0]="lisi1";
        datas[1][1]="123456";
        datas[2][0]="wangwu";
        datas[2][1]="123456";
        datas[3][0]="zhoaliu1";
        datas[3][1]="123456";
        return datas;
    }


}
