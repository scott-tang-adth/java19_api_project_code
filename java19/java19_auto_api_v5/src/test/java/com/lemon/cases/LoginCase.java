package com.lemon.cases;


import com.lemon.constants.Constants;
import com.lemon.pojo.CaseInfo;

import com.lemon.utils.Authentication;
import com.lemon.utils.ExcelUtils;
import com.lemon.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginCase {
    //读取testng.xml sheetIndex参数
    public int sheetIndex;
    @BeforeSuite
    public void init() {
        Constants.HEADERS.put("X-Lemonban-Media-Type","lemonban.v2");
        Constants.HEADERS.put("Content-Type","application/json");
    }
    @BeforeClass
    @Parameters({"sheetIndex"})
    public void beforeClass(int sheetIndex) {
        //System.out.println("LoginCase ===== sheetIndex:=============" + sheetIndex);
        this.sheetIndex = sheetIndex;
    }
    @Test(dataProvider = "datas")
    public void test(CaseInfo caseInfo) {
        HttpResponse response = HttpUtils.call(caseInfo.getMethod(),caseInfo.getContentType()
                ,caseInfo.getUrl(),caseInfo.getParams(), Constants.HEADERS);
        String body = HttpUtils.printResponse(response);
        //1、从响应体里面获取token
        Authentication.json2Vars(body,"$.data.token_info.token","${token}");
        //2、从响应体里面获取member_id
        Authentication.json2Vars(body,"$.data.id","${member_id}");

    }
    @DataProvider
    public Object[] datas() {
        Object[] datas = ExcelUtils.getDatas(sheetIndex, 1, CaseInfo.class);
        return datas;
    }

}
