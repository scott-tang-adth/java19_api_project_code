package com.lemon.httpscott;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author by Scott.Tang
 * @Description ADTH
 * @date 2020/9/14.
 * @Copyright 精宇（上海）电子科技有限公司。 All rights reserved
 */
public class ProxyDemo {

    public static void main( String[] args ) throws IOException {

        HttpGet get = new HttpGet("http://api.lemonban.com/futureloan/member/2/info");

        get.addHeader("X-Lemonban-Media-Type","lemonban.v2");


        CloseableHttpClient client = HttpClients.createDefault();

        //设置代理
        HttpHost proxy = new HttpHost("127.0.0.1",8888);//filler必须要打开

        //4.2、设置代理并发送请求
        HttpResponse response = client.execute(proxy,get);

        int statusCode = response.getStatusLine().getStatusCode();

        System.out.println(statusCode);

        Header[] allHeaders = response.getAllHeaders();

        Header[] headers = response.getHeaders("Content-Type");

        System.out.println(Arrays.toString(allHeaders));

        System.out.println(Arrays.toString(headers));

        HttpEntity entity = response.getEntity();

        System.out.println(EntityUtils.toString(entity));




    }
}
