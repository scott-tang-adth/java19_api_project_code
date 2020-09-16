package com.lemon.cases;

import com.lemon.constants.Constants;
import com.lemon.pojo.CaseInfo;
import com.lemon.utils.Authentication;
import com.lemon.utils.ExcelUtils;
import com.lemon.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luojie
 * @date 2020/6/11 - 21:34
 * 柠檬班创新教育极致服务
 *
 * 充值用例
 */
public class Recharge {
    //读取testng.xml sheetIndex参数
    public int sheetIndex;

    @BeforeClass
    @Parameters({"sheetIndex"})
    public void beforeClass(int sheetIndex) {
        //System.out.println("LoginCase ===== sheetIndex:=============" + sheetIndex);
        this.sheetIndex = sheetIndex;
    }

    @Test(dataProvider = "datas")
    public void test(CaseInfo caseInfo) {
        //1、从VARS中获取token
        Object token = Authentication.VARS.get("${token}");
        System.out.println("Recharge token:" + token);
        //2、添加到请求头
        //3、改造call支持传递请求头
        Map<String,String> headers = new HashMap<>();
        headers.put("Authorization","Bearer " + token);
        headers.putAll(Constants.HEADERS);
        HttpResponse response = HttpUtils.call(caseInfo.getMethod(),caseInfo.getContentType(),
                caseInfo.getUrl(),caseInfo.getParams(), headers);
        //打印响应
        String body = HttpUtils.printResponse(response);
    }

    @DataProvider
    public Object[] datas() {
        Object[] datas = ExcelUtils.getDatas(sheetIndex, 1, CaseInfo.class);
        return datas;
    }

}
