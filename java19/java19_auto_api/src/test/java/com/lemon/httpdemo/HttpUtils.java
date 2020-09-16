package com.lemon.httpdemo;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author luojie
 * @date 2020/6/9 - 21:35
 * 柠檬班创新教育极致服务
 *
 * http 工具类， 发送http/https请求。
 */
public class HttpUtils {

    public static void main(String[] args) throws Exception  {
        /*
        * 静态方法：
        *       类名调用，不需要创建对象。
        *       静态方法可以直接调用静态方法。
        *
        * */
        HttpUtils.get("http://api.lemonban.com/futureloan/member/2/info");
//        HttpUtils.get("http://api.lemonban.com/futureloan/loans");
//        HttpUtils.get("https://www.baidu.com");

        HttpUtils.jsonPost("http://api.lemonban.com/futureloan/member/register",
                "{\"mobile_phone\": \"13899999666\",\"pwd\": \"123456\"}");

        HttpUtils.jsonPost("http://api.lemonban.com/futureloan/member/register",
                "{\"mobile_phone\": \"138999996\",\"pwd\": \"12345678\"}");

        HttpUtils.jsonPost("http://api.lemonban.com/futureloan/member/register",
                "{\"mobile_phone\": \"13899999666\",\"pwd\": \"12345678\"}");

        HttpUtils.jsonPost("http://api.lemonban.com/futureloan/member/register",
                "{\"mobile_phone\": \"13899999616\",\"pwd\": \"12345678\"}");
    }

    /**
     * 发送http get请求。
     * @param url
     *      url 必须带参数，如果不带不会自动携带参数。
     *      url?KEY=VALUE&KEY2=VALUE2
     *      url/xxx/yyy/2/zzz
     * @throws Exception
     */
    public static void get(String url) throws Exception {
        /**
         * 发送一个get请求
         * 1、确定url  接口地址
         * 2、确定请求类型（method）
         * 3、请求参数
         * 4、请求头
         * 5、发送请求
         * 6、接受响应
         * 7、格式化响应内容
         */
        //1、创建get请求并写入接口地址
        HttpGet get = new HttpGet(url);
        //2、在get请求上添加请求头
        get.addHeader("X-Lemonban-Media-Type","lemonban.v1");
        //3、创建一个客户端  XXXs  XXXUtils 工具类
        HttpClient client = HttpClients.createDefault();
        //4、客户端发送请求,并且返回响应对象（响应头、响应体、响应状态码）
        HttpResponse response = client.execute(get);
        //5、获取响应头、响应体、响应状态码
        //5.1、获取响应头
        printResponse(response);
    }

    /**
     * 发送http post请求。
     * @param url               接口请求地址
     * @param params            json格式的参数
     * @throws Exception
     */
    public static void jsonPost(String url,String params) throws Exception  {
        //1、创建POST请求并写入接口地址
        HttpPost post = new HttpPost(url);
        //2、在POST请求上添加请求头
        post.addHeader("X-Lemonban-Media-Type","lemonban.v1");
        post.addHeader("Content-Type","application/json");
        //3、请求参数 加载请求体里面
        StringEntity stringEntity = new StringEntity(params,"utf-8");
        post.setEntity(stringEntity);
        //4、创建一个客户端  XXXs  XXXUtils 工具类
        HttpClient client = HttpClients.createDefault();
        //5、客户端发送请求,并且返回响应对象（响应头、响应体、响应状态码）
        HttpResponse response = client.execute(post);
        //6、获取响应头、响应体、响应状态码
        printResponse(response);
    }

    /**
     * 获取响应头、响应体、状态码
     * @param response      http响应对象
     * @throws IOException
     */
    public static void printResponse(HttpResponse response) throws IOException {
        //6.1、获取响应头
        Header[] allHeaders = response.getAllHeaders();
        //Header[] headers = response.getHeaders("Content-Type");
        System.out.println(Arrays.toString(allHeaders));
        //5.2、获取响应体
        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);
        System.out.println(body);
        //5.3、响应状态码
        //链式编程 调用方法之后继续调用方法
        int statusCode = response.getStatusLine().getStatusCode();
        //上面的一句等于下面两句
        System.out.println(statusCode);
    }

}
