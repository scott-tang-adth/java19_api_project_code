package java19_auto_api_scott_v4.cases;

import java19_auto_api_scott_v4.pojo.CaseInfo;
import java19_auto_api_scott_v4.pojo.CaseInfo2;
import java19_auto_api_scott_v4.utils.ExcelUtils;
import java19_auto_api_scott_v4.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author luojie
 * @date 2020/6/11 - 21:34
 * 柠檬班创新教育极致服务
 *
 * 注册用例
 */
public class LoginCase {
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
        HttpResponse response = HttpUtils.call(caseInfo.getMethod(),caseInfo.getContentType(),caseInfo.getUrl(),caseInfo.getParams());
    }

    @DataProvider
    public Object[] datas() {
        Object[] datas = ExcelUtils.getDatas(1, 1, CaseInfo.class);
        return datas;
    }

}
