package homeworkday09;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestChina {
    public static void main(String[] args) {
        String json = "{ \"name\": \"中国\", \"provinces\": [{ \"name\": \"黑龙江\", \"capital\": \"哈尔滨\" }, { \"name\": \"广东\", \"capital\": \"广州\" }, { \"name\": \"湖南\", \"capital\": \"长沙\" }] }";
        ChinaPro chinaPro = JSONObject.parseObject(json, ChinaPro.class);
        // ChinaPro chinaPro = JSON.parseObject(json, ChinaPro.class);都可以
        System.out.println(chinaPro);
    }



}
