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
    //public static final String EXCEL_PATH = Constants.class.getClassLoader().getResource("./cases_v3.xlsx").getPath();
    public static final String EXCEL_PATH ="D:\\ideaCode\\java19\\java19_auto_api_v6\\src\\test\\resources\\cases_v3.xlsx";
    public static final Map<String,String> HEADERS = new HashMap<>();
    //excel 响应回写列
    public static final int RESPONSE_WRTIE_BACK_CELLNUM = 8;
}
