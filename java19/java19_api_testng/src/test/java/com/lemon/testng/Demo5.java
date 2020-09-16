package com.lemon.testng;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Demo5 {

    @Test(dataProvider ="datas" )//这里必须小写
    public void f(String username,String password)
    {
        System.out.println("username = " + username + ", password = " + password);
    }
    @DataProvider
    public Object[][] datas()
    {
        //Object[][] datas =new Object[2][3];
        Object[][] datas={{"zhasan","123456"},{"lisi","123456"},{"wangwu","123456"},{"zhaoliu","123456"}};
        return datas;
    }
}
