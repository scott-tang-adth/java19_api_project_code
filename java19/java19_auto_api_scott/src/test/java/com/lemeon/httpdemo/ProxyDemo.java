package com.lemeon.httpdemo;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.util.Arrays;
public class ProxyDemo {
    public static void main(String[] args) throws Exception {
        /*
        *
         * httpClient 加代理主要用来抓包
         *
         */
        /**
         * 发送一个get请求
         * 1、确定url  接口地址
         * 2、确定请求类型（method）
         * 3、请求参数
         * 4、请求头
         * 5、发送请求
         * 6、接受请求
         * 7、格式化请求
         */
        //1、使用HttpClient完成用户信息（GET）、提现（Post）、更新昵称（Patch）三个接口的测试
        //创建get请求并且写入接口地址
        HttpGet get=new HttpGet("http://api.lemonban.com/futureloan/member/2/info");
        //在get请求上添加请求头
        get.addHeader("X-Lemonban-Media-Type","lemonban.v1");
        //创建客户端
        //CloseableHttpClient client = HttpClientBuilder.create().build()
        CloseableHttpClient client = HttpClients.createDefault();//HttpClient 从HttpClients创建而来
        //创建代理对象 打开fiddler设置为代理 port为fiddler的端口
        HttpHost proxy=new HttpHost("127.0.0.1",8888);
        //4、客户端发送代理请求,并且返回响应对象（响应头、响应体、响应状态码）
        HttpResponse response = client.execute(proxy,get);
        //5、获取响应头、响应体、响应状态码
        //5.1、获取响应头
        Header[] allHeaders = response.getAllHeaders();
        Header[] headers = response.getHeaders("Content-Type");
        System.out.println(Arrays.toString(headers));
        System.out.println(Arrays.toString(allHeaders));
        //5.2、获取响应体
        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);
        System.out.println(body);
        //5.3、响应状态码
        //链式编程 调用方法之后继续调用方法
        int statusCode = response.getStatusLine().getStatusCode();
        //上面的一句等于下面两句
        // StatusLine statusLine = response.getStatusLine();
        //int statusCode1 = statusLine.getStatusCode();
        //statusLine.getReasonPhrase()
        System.out.println(statusCode);
    }
}
