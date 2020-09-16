package com.lemeon.httpdemo;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.Arrays;

public class GetUserInfo {

    public static void main(String[] args) throws IOException {

        // 创建get请求并且写入接口地址
        HttpGet get=new HttpGet("http://api.lemonban.com/futureloan/member/2/info");
        //在get请求上按接口文档添加请求头
         get.addHeader("X-Lemonban-Media-Type","lemonban.v1");
         HttpClient client = HttpClients.createDefault();
        //创建客户端，发送get请求
       // CloseableHttpClient client = HttpClients.createDefault();
        //返回服务端响应
       // CloseableHttpResponse Response = client.execute(get);
        HttpResponse response = client.execute(get);
        //5.1、获取响应头
        Header[] allHeaders = response.getAllHeaders();
        //Arrays工具类的toString 方法
        System.out.println(Arrays.toString(allHeaders));
        //获取响应体
        HttpEntity entity = response.getEntity();
        //用EntityUtils工具类来处理 响应体的数据
       // System.out.println(entity);
        String body = EntityUtils.toString(entity);
        System.out.println(body);
        //获取响应状态码
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        System.out.println(statusCode);

    }
}
