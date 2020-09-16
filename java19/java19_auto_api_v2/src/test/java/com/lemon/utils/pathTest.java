package com.lemon.utils;

/**
 * @author by Scott.Tang
 * @Description ADTH
 * @date 2020/9/16.
 * @Copyright 精宇（上海）电子科技有限公司。 All rights reserved
 */
public class pathTest {

    public static void main( String[] args ) {

        String path=pathTest.class.getClassLoader().getResource("./cases_v1.xls").getPath();

        System.out.println(path);

        String property = System.getProperty("user.dir");

        System.out.println(property);

        String path2= System.getProperty("user.dir")+"/java19_auto_api_v2/src/test/resources/cases_v1.xls";

        System.out.println(path2);
    }
}
