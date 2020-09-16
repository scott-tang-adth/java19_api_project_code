package com.lemon.cases;
import com.lemon.constants.Constants;
import com.lemon.pojo.CaseInfo;
import com.lemon.utils.Authentication;
import com.lemon.utils.ExcelUtils;
import com.lemon.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.testng.annotations.*;
import java.util.HashMap;
import java.util.Map;
import static com.lemon.utils.HttpUtils.call;

/**
 * @author by Scott
 * @date 2020/6/17.
 */
//1.去登录的case里的响应体里获取token
//2.token存起来
//3.充值的case 请求之前把token取出来放到请求头里
public class ChargeCase {
    public int sheetIndex;
    @BeforeClass
    @Parameters({"sheetIndex"})//从testng.xml文件中 <parameter name="sheetIndex" value="1"></parameter>传递过来的
    public void beforeClass(int sheetIndex) {
        this.sheetIndex=sheetIndex;
    }
    @Test(dataProvider = "datas")
    public void testCase( CaseInfo caseInfo)
    {
        //从vars中获取token
        Object token = Authentication.Vars.get("${token}");
        System.out.println("Recharge token:" + token);
        //2、添加到请求头
        //3、改造call支持传递请求头
        Map<String,String> headers = new HashMap<>();
        headers.put("Authorization","Bearer "+token);
        headers.putAll(Constants.HEADERS);
        //改造call方法支持传递请求头
        //注意这里的参数必须是headers，用constants.Constants.HEADERS会报错
        HttpResponse response = call(caseInfo.getMethod(), caseInfo.getContentType(), caseInfo.getUrl(), caseInfo.getParams(), headers);
        HttpUtils.printResponse(response);
    }
    @DataProvider
    public Object[] datas() {
        Object[] datas = ExcelUtils.getDatas(sheetIndex, 1, CaseInfo.class);
        return datas;
    }
}
