package com.lemon.utils;
import com.alibaba.fastjson.JSONPath;
import org.apache.commons.lang3.StringUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by Scott
 * @date 2020/6/19.
 */

/**
 * 接口鉴定权类
 */

public class Authentication {

    //用来存储类似于jmeter获取token中定义的用户自定义变量

    public static Map<String,Object> Vars=new HashMap<>();
    
    public static void json2vars(String json,String expression,String key)
    {
        //如果json不是空，继续操作
        if(StringUtils.isNotBlank(json))
        {
            //注意json和expression的字符串表示不一样 json表示json字符串
            // expression jsonpath 表达式
            //map对象的key
            Object obj = JSONPath.read(json, expression);
            System.out.println(key+":"+obj);
            //如果不为null则存到静态map对象中
            if(obj!=null)
            {
                Authentication.Vars.put(key, obj);
            }
        }

    }
}
