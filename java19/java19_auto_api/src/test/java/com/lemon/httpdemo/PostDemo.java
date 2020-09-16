package com.lemon.httpdemo;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author luojie
 * @date 2020/6/9 - 21:21
 * 柠檬班创新教育极致服务
 */
public class PostDemo {
    public static void main(String[] args) throws Exception {
        /**
         * 发送一个post请求
         * 1、确定url  接口地址
         * 2、确定请求类型（method）
         * 3、请求参数
         * 4、请求头
         * 5、发送请求
         * 6、接受请求
         * 7、格式化请求
         */
        //1、创建POST请求并写入接口地址
        HttpPost post = new HttpPost("http://api.lemonban.com/futureloan/member/register");
        //2、在POST请求上添加请求头
        post.addHeader("X-Lemonban-Media-Type","lemonban.v1");
        post.addHeader("Content-Type","application/json");
        //3、请求参数 加载请求体里面
        String json = "{\"mobile_phone\": \"13899999666\",\"pwd\": \"12345678\"}";
        StringEntity stringEntity = new StringEntity(json,"utf-8");
        post.setEntity(stringEntity);
        //4、创建一个客户端  XXXs  XXXUtils 工具类
        HttpClient client = HttpClients.createDefault();
        //5、客户端发送请求,并且返回响应对象（响应头、响应体、响应状态码）
        HttpResponse response = client.execute(post);
        //6、获取响应头、响应体、响应状态码
        //6.1、获取响应头
        Header[] allHeaders = response.getAllHeaders();
        Header[] headers = response.getHeaders("Content-Type");
        System.out.println(Arrays.toString(headers));
        System.out.println(Arrays.toString(allHeaders));
        //6.2、获取响应体
        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);
        System.out.println(body);
        //6.3、响应状态码
        //链式编程 调用方法之后继续调用方法
        int statusCode = response.getStatusLine().getStatusCode();
        //上面的一句等于下面两句
        System.out.println(statusCode);
    }
}
