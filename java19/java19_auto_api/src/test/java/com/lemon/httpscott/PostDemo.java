package com.lemon.httpscott;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
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
public class PostDemo {

    public static void main( String[] args ) throws IOException {

        HttpPost post=new HttpPost("http://api.lemonban.com/futureloan/member/register");

        post.addHeader("X-Lemonban-Media-Type","lemonban.v2");

        post.addHeader("Content-Type","application/json");

        String json="{\"mobile_phone\": \"18502756881\",\"pwd\": \"12345678\"}";

        StringEntity stringEntity=new StringEntity(json,"utf8");

        post.setEntity(stringEntity);

        CloseableHttpClient client = HttpClients.createDefault();

        CloseableHttpResponse response = client.execute(post);

        int statusCode = response.getStatusLine().getStatusCode();

        System.out.println(statusCode);

        ProtocolVersion protocolVersion = response.getProtocolVersion();

        System.out.println(protocolVersion);

        Header[] allHeaders = response.getAllHeaders();

        System.out.println(Arrays.toString(allHeaders));

        Header[] headers = response.getHeaders("Content-Type");

        System.out.println(Arrays.toString(headers));

        HttpEntity entity = response.getEntity();

        String string = EntityUtils.toString(entity);

        System.out.println(string);




    }
}
