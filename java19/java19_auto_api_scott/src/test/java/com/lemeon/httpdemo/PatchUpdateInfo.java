package com.lemeon.httpdemo;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.util.Arrays;

public class PatchUpdateInfo {
    public static void main(String[] args) throws Exception {
        //通过url 创建HttpPactch 对象
        HttpPatch  patch=new HttpPatch("http://api.lemonban.com/futureloan/member/update");
        //加头
        patch.addHeader("X-Lemonban-Media-Type","lemonban.v1");
        patch.addHeader("Content-Type","application/json");
        //请求参数的json 字符串
        String json="{\"member_id\": 101, \"reg_name\": \"檬檬\"}";
        //转化成 StringEntity 类型
        StringEntity  StringEntity=new StringEntity(json,"utf-8");
        //设置请求参数
        patch.setEntity(StringEntity);
        //通过HttpClients类 创建 client对象
        HttpClient client = HttpClients.createDefault();
        //发送 请求获得响应对象
       // CloseableHttpResponse response = client.execute(patch);
        HttpResponse response = client.execute(patch);
        //获得响应头
        Header[] allHeaders = response.getAllHeaders();
        //打印解析响应头的内容,使用工具类Arrays的静态方法toString
        System.out.println(Arrays.toString(allHeaders));
        //获得响应状态码
        int code = response.getStatusLine().getStatusCode();
        System.out.println(code);
        //获得响应体里的数据  EntityUtils工具类中的 toString 方法
        HttpEntity responseEntity = response.getEntity();
        String s = EntityUtils.toString(responseEntity);
        System.out.println(s);

    }
}
