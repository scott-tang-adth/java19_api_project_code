package com.lemon.testng;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author by Scott.Tang
 * @Description ADTH
 * @date 2020/9/6.
 * @Copyright 精宇（上海）电子科技有限公司。 All rights reserved
 */
public class Demo5_scott {

    @Test(dataProvider = "datas")

    public void f(String username,String password){

        System.out.println("username = " + username + ", password = " + password);
    }

    @DataProvider

    public Object[][]datas(){

       Object datas[][]={{"zhangsan","123456"},{"zhangsan1","123456"},{"zhangsan2","123456"},{"zhangsan3","123456"},{"zhangsan4","123456"}};

       return datas;
    }


   /* public static void main( String[] args ) {

        String abs[][]={{"zhangsan","123456"},{"zhangsan1","123456"},{"zhangsan2","123456"},{"zhangsan3","123456"},{"zhangsan4","123456"}};


      for (int i=0;i<=4;i++){

          for (int j=0;j<2;j++){

              System.out.println(abs[i][j]);
          }
      }

    }*/





}
