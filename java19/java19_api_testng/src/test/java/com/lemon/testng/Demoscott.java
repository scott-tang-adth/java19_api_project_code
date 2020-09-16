package com.lemon.testng;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author by Scott.Tang
 * @Description ADTH
 * @date 2020/9/6.
 * @Copyright 精宇（上海）电子科技有限公司。 All rights reserved
 */
public class Demoscott {

    @Test(dataProvider = "datas1")
    public void f2(String name,String password){

        System.out.println("name = " + name + ", password = " + password);
    }
    @DataProvider
    Object [][]datas1(){

        //
        //Object[][] datas =new Object[2][3];
        Object[][] datas1=new Object[4][2];
        return datas1;
    }

    @Test(dataProvider = "datas")

    public void f(User user){

        System.out.println(user);
    }

    @DataProvider //如果返回值是一个一维数组，f方法的参数只能有一个参数，如果是多个参数就不适合用次方法
    Object[]datas(){
        Object []datas=new Object[4];
        User user1=new User("zhangsan1","123456");
        User user2=new User("zhangsan2","123456");
        User user3=new User("zhangsan3","123456");
        User user4=new User("zhangsan4","123456");
        datas[0]=user1;
        datas[1]=user2;
        datas[2]=user3;
        datas[3]=user4;
        return datas;
    }


}
