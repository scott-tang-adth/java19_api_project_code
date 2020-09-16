package com.lemon.cases;
import com.alibaba.fastjson.JSONPath;
import com.lemon.constants.Constants;
import com.lemon.pojo.CaseInfo;
import com.lemon.utils.Authentication;
import com.lemon.utils.ExcelUtils;
import com.lemon.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.testng.annotations.*;
public class LoginCase1 {
    //读取testng.xml sheetIndex参数
    public int sheetIndex;
    @BeforeSuite//只执行一次
    public void init()
    {
        Constants.HEADERS.put("X-Lemonban-Media-Type","lemonban.v2");
        Constants.HEADERS.put("Content-Type","application/json");
    }
    @BeforeClass
    @Parameters({"sheetIndex"})
    public void beforeClass(int sheetIndex) {

        this.sheetIndex=sheetIndex;
    }
    @Test(dataProvider = "datas")
    public void test( CaseInfo caseInfo) {
        //获得响应对象
        HttpResponse response = HttpUtils.call(caseInfo.getMethod(),caseInfo.getContentType(),caseInfo.getUrl(),caseInfo.getParams(),Constants.HEADERS);
        //获得响应信息字符串
        String body = HttpUtils.printResponse(response);

     /*   //从响应体里获得token
        //使用jsonpath获取$.data.token_info.token
        Object obj = JSONPath.read(body, "$.data.token_info.token");
        System.out.println("token"+obj);
        //将获取的token字符串存储到map对象vars中 封装在Authentication类中
        if(obj!=null) {
            Authentication.Vars.put("${token}", obj);
        }
        //取member_id
        Object obj2 = JSONPath.read(body, "$.data.member_id");
        //判断不为空然后存到静态的map对象中
        if(obj2!=null)
        {
            Authentication.Vars.put("${member_id}", obj2);
        }
        //上面的两个方法类似适合方法封装,注意方法不能嵌套方法否则报错*/

        //获取token
        Authentication.json2vars(body,"$.data.token_info.token","${token}");
        //获取member_id
        Authentication.json2vars(body,"$.data.id","${member_id}");


    }
    @DataProvider
    public Object[] datas() {
        //testng传过来sheetIndex的值
        Object[] datas = ExcelUtils.getDatas(sheetIndex, 1, CaseInfo.class);
        return datas;
    }

}
