package java19_auto_api_scott_v4.cases;
import java19_auto_api_scott_v4.pojo.CaseInfo;
import java19_auto_api_scott_v4.utils.ExcelUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static java19_auto_api_scott_v4.utils.HttpUtils.call;

/**
 * @author by Scott
 * @date 2020/6/17.
 */
public class ChargeCase {
    public int sheetIndex;
    @BeforeClass
    @Parameters({"sheetIndex"})//从testng.xml文件中  <parameter name="sheetIndex" value="1"></parameter>传递过来的
    public void beforeClass(int sheetIndex) {

        this.sheetIndex=sheetIndex;
    }
    @Test(dataProvider = "datas")
    public void testCase(CaseInfo caseInfo)
    {
        call(caseInfo.getMethod(),caseInfo.getContentType(),caseInfo.getUrl(),caseInfo.getParams());
    }
    @DataProvider
    public Object[] datas() {
        Object[] datas = ExcelUtils.getDatas(sheetIndex, 1, CaseInfo.class);
        return datas;
    }
}
