package com.lemon.cases;
import com.lemon.constants.Constants;
import com.lemon.pojo.CaseInfo;
import com.lemon.pojo.WriteBackData;
import com.lemon.utils.Authentication;
import com.lemon.utils.ExcelUtils;
import com.lemon.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.testng.annotations.*;
import java.util.HashMap;
import java.util.Map;

import static com.lemon.utils.Authentication.getTokenHeader;
import static com.lemon.utils.HttpUtils.call;

/**
 * @author by Scott
 * @date 2020/6/17.
 */
//1.去登录的case里的响应体里获取token
//2.token存起来
//3.充值的case 请求之前把token取出来放到请求头里
public class ChargeCase extends BaseCase{
    @Test(dataProvider = "datas")
    public void testCase( CaseInfo caseInfo)
    {
        //获取带token的请求头
        Map<String, String> headers = Authentication.getTokenHeader();
        //改造call方法支持传递请求头
        //注意这里的参数必须是headers，用constants.Constants.HEADERS会报错
        HttpResponse response = call(caseInfo.getMethod(), caseInfo.getContentType(), caseInfo.getUrl(), caseInfo.getParams(), headers);
        String body = HttpUtils.printResponse(response);
       // HttpUtils.printResponse(response);
        addWriteBackData(caseInfo.getId(),Constants.RESPONSE_WRTIE_BACK_CELLNUM,body);
        boolean assertResponseFlag = assertResponse(body, caseInfo.getExpectResult());
    }

    @DataProvider
    public Object[] datas() {
        Object[] datas = ExcelUtils.getDatas(sheetIndex, 1, CaseInfo.class);
        return datas;
    }
}
