package com.lemon.cases;
import com.lemon.constants.Constants;
import com.lemon.pojo.CaseInfo;
import com.lemon.utils.Authentication;
import com.lemon.utils.ExcelUtils;
import com.lemon.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginCase extends BaseCase{

    @Test(dataProvider = "datas")
    public void test( CaseInfo caseInfo) {
        //获得响应对象
        HttpResponse response = HttpUtils.call(caseInfo.getMethod(),caseInfo.getContentType(),caseInfo.getUrl(),caseInfo.getParams(),Constants.HEADERS);
        //获得响应信息字符串
        String body = HttpUtils.printResponse(response);
        //获取token
        Authentication.json2vars(body,"$.data.token_info.token","${token}");
        //获取member_id
        Authentication.json2vars(body,"$.data.id","${member_id}");
        boolean assertResponseFlag = assertResponse(body, caseInfo.getExpectResult());
        addWriteBackData(caseInfo.getId(),Constants.RESPONSE_WRTIE_BACK_CELLNUM,body);

    }


    @DataProvider
    public Object[] datas() {
        //testng传过来sheetIndex的值
        Object[] datas = ExcelUtils.getDatas(sheetIndex, 1, CaseInfo.class);
        return datas;
    }

}
