package com.lemeon.httpdemo;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.util.Arrays;

public class CetCashPost {
    /**
     * 发送一个post请求
     * 1、确定url  接口地址
     * 2、确定请求类型（method）//HttpPost
     * 3、请求参数
     * 4、请求头
     * 5、发送请求
     * 6、接受请求
     * 7、格式化请求
     */
    public static void main(String[] args) throws Exception {

        //请求类型和url
        HttpPost post=new HttpPost("http://api.lemonban.com/futureloan//member/withdraw");
        //添加头
        post.addHeader("X-Lemonban-Media-Type","lemonban.v1");
        post.addHeader("Content-Type","application/json");
        //请求参数的joson 字符串
        String json = "{\"member_id\": 101, \"amount\": 500}";
        StringEntity stringEntity = new StringEntity(json,"utf-8");
        post.setEntity(stringEntity);
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(post);
        //获取响应头
        Header[] allHeaders = response.getAllHeaders();
        //Arrays工具类的toString 方法打印出内容
        System.out.println(Arrays.toString(allHeaders));
        //获取响应体
        HttpEntity entity = response.getEntity();

        //用EntityUtils工具类来处理 响应体的数据
        String body = EntityUtils.toString(entity);
        System.out.println(body);
        //获取响应状态码
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        System.out.println(statusCode);

    }
}
