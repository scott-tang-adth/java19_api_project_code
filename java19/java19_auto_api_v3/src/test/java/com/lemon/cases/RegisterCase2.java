package com.lemon.cases;
import com.lemon.pojo.CaseInfo;
import com.lemon.pojo.CaseInfo2;
import com.lemon.utils.ExcelUtils;
import com.lemon.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author luojie
 * @date 2020/6/11 - 21:34
 * 柠檬班创新教育极致服务
 *
 * 注册用例
 */
public class RegisterCase2 {

    @Test(dataProvider = "datas")
    public void test(CaseInfo caseInfo) {
        HttpResponse response = HttpUtils.call(caseInfo);
    }

    @DataProvider
    public Object[] datas() {
        Object[] datas = ExcelUtils.getDatas(0, 1, CaseInfo.class);
        return datas;
    }

}
