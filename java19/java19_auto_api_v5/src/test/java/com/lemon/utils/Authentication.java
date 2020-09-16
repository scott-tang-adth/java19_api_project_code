package com.lemon.utils;

import com.alibaba.fastjson.JSONPath;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luojie
 * @date 2020/6/18 - 21:22
 * 柠檬班创新教育极致服务
 *
 * 接口鉴权类
 */
public class Authentication {
    //类似于jmeter用户变量  vars
    public static Map<String,Object> VARS = new HashMap<>();


    /**
     * 使用jsonpath获取内容存储到VARS变量，给其他接口使用。
     * @param json              json字符串
     * @param expression        jsonpath表达式
     * @param key               存储到VARS中的key
     */
    public static void json2Vars(String json,String expression,String key) {
        //如果json不是空，则继续操作
        if(StringUtils.isNotBlank(json)) {
            //使用jsonpath获取内容
            Object obj = JSONPath.read(json,expression);
            System.out.println(key + ":" + obj);
            //如果获取内容不是，存入VARS变量，给其他接口使用。
            if(obj != null) {
                Authentication.VARS.put(key, obj);
            }
        }
    }
}
