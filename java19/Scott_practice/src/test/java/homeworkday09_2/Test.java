package homeworkday09_2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Test {
    public static void main(String[] args) {
        String json = "{ \"name\": \"中国\", \"provinces\": [{ \"name\": \"黑龙江\", \"capital\": \"哈尔滨\" }, { \"name\": \"广东\", \"capital\": \"广州\" }, { \"name\": \"湖南\", \"capital\": \"长沙\" }] }";
        Country c = JSONObject.parseObject(json, Country.class);
       // Country c = JSON.parseObject(json, Country.class);
        System.out.println(c);
        String s = JSONObject.toJSONString(c);
        System.out.println(s);
    }

}

