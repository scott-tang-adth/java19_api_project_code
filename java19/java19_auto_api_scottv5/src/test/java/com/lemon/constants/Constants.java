package com.lemon.constants;


import java.util.HashMap;
import java.util.Map;

/**
 * @author luojie
 * @date 2020/6/16 - 20:23
 * 柠檬班创新教育极致服务
 *
 * 常量类 final
 */
public class Constants {
    //数据驱动excel路径
    public static final String EXCEL_PATH = Constants.class.getClassLoader().getResource("./cases_v3.xlsx").getPath();
    //D:/ideaCode/java19/Scott_practice/target/test-classes/cases_v3.xlsx

    //默认请求头 因为只要加一次头所以用BeforeSuite注解
    public static final Map<String,String>HEADERS=new HashMap<>();

}
