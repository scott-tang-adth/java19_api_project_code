package com.lemon.utils;
import com.alibaba.fastjson.JSONPath;
import com.lemon.constants.Constants;
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

    /**
     * 使用jsonpath获取内容存储到vars变量中
     * @param json
     * @param expression
     * @param key
     */
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
    //获取带token 的请求头的集合
    public static Map<String, String> getTokenHeader() {
        //从vars中获取token
        Object token = Authentication.Vars.get("${token}");
        System.out.println("Recharge token:" + token);
        //2、添加到请求头
        //3、改造call支持传递请求头
        Map<String,String> headers = new HashMap<>();
        headers.put("Authorization","Bearer "+token);
        headers.putAll(Constants.HEADERS);
        return headers;
    }
}
