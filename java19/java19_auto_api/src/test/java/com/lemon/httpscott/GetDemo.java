package com.lemon.httpscott;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author by Scott.Tang
 * @Description ADTH
 * @date 2020/9/13.
 * @Copyright 精宇（上海）电子科技有限公司。 All rights reserved
 */
public class GetDemo {

    public static void main( String[] args ) throws IOException {

                //* 发送一个get请求
                //* 1、确定url  接口地址
                // * 2、确定请求类型（method）
                // * 3、请求参数,get请求没有参数
                // * 4、请求头
                //* 5、发送请求
                // * 6、接受请求
                // * 7、格式化请求
           // HttpGet get=new HttpGet("http://localhost:8080/futureloan/member/6/info");
        HttpGet get = new HttpGet("http://api.lemonban.com/futureloan/member/2/info");

         //   get.addHeader("X-Lemonban-Media-Type","lemonban.v2");
        get.addHeader("X-Lemonban-Media-Type","lemonban.v2");

            CloseableHttpClient client = HttpClients.createDefault();

            CloseableHttpResponse response = client.execute(get);

            Header[] allHeaders = response.getAllHeaders();

           Header[] headers = response.getHeaders("Content-Type");

           HttpEntity responseEntity = response.getEntity();

           String restring  = EntityUtils.toString(responseEntity);

           System.out.println(restring);

           System.out.println(Arrays.toString(headers));

          int statusCode = response.getStatusLine().getStatusCode();

          System.out.println(statusCode);



    }
}
