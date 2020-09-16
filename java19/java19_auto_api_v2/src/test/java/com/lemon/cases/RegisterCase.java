package com.lemon.cases;

import com.lemon.utils.HttpUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author luojie
 * @date 2020/6/11 - 21:34
 * 柠檬班创新教育极致服务
 *
 * 注册用例
 */
public class RegisterCase {

    @Test(dataProvider = "datas")
    public void test(String url,String params) throws Exception {
        HttpUtils.jsonPost(url,params);
    }

    @DataProvider
    public Object[][] datas() {
        Object[][] datas = {
                {"http://api.lemonban.com/futureloan/member/register",
                        "{\"mobile_phone\": \"13899999777\",\"pwd\": \"123456\"}"},
                {"http://api.lemonban.com/futureloan/member/register",
                        "{\"mobile_phone\": \"138999997\",\"pwd\": \"123456\"}"},
                {"http://api.lemonban.com/futureloan/member/register",
                        "{\"mobile_phone\": \"13899999777\",\"pwd\": \"12345678\"}"},
                {"http://api.lemonban.com/futureloan/member/register",
                        "{\"mobile_phone\": \"13899999777\",\"pwd\": \"12345678\"}"}
        };
        return datas;
    }

}
