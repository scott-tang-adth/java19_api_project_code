package com.lemon.cases;

import com.lemon.constants.Constants;
import com.lemon.pojo.CaseInfo;
import com.lemon.pojo.WriteBackData;
import com.lemon.utils.ExcelUtils;
import com.lemon.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luojie
 * @date 2020/6/11 - 21:34
 * 柠檬班创新教育极致服务
 *
 * 注册用例
 * http://test.lemonban.com/futureloan/mvc/api/member/recharge?mobilephone=13212312311&amount=100
 */
public class RegisterCase extends BaseCase {
    //读取testng.xml sheetIndex参数
    public int sheetIndex;

    @BeforeClass
    @Parameters({"sheetIndex"})
    public void beforeClass(int sheetIndex) {
//        System.out.println("RegisterCase ==== sheetIndex:=============" + sheetIndex);
        this.sheetIndex = sheetIndex;
    }

    @Test(dataProvider = "datas")
    public void test(CaseInfo caseInfo) {
        //  1、参数化替换
        //	2、数据库前置查询结果(数据断言必须在接口执行前后都查询)
        //	3、调用接口
        HttpResponse response = HttpUtils.call(caseInfo.getMethod(),caseInfo.getContentType(),
                caseInfo.getUrl(),caseInfo.getParams(),Constants.HEADERS);
        String body = HttpUtils.printResponse(response);
        //	4、断言响应结果
        //{"$.code":0,"$.msg":"OK","$.data.mobile_phone":"15670890431"}
        boolean assertResponseFlag = assertResponse(body, caseInfo.getExpectResult());

        //	5、添加接口响应回写内容
        addWriteBackData(caseInfo.getId(),Constants.RESPONSE_WRTIE_BACK_CELLNUM,body);
        //	6、数据库后置查询结果
        //	7、据库断言
        //	8、添加断言回写内容
        //	9、添加日志
        //	10、报表断言
    }

    @DataProvider
    public Object[] datas() {
        Object[] datas = ExcelUtils.getDatas(sheetIndex, 1, CaseInfo.class);
        return datas;
    }

}
