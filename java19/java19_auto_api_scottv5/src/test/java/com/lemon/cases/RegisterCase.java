package com.lemon.cases;
import com.lemon.constants.Constants;
import com.lemon.pojo.CaseInfo;
import com.lemon.utils.ExcelUtils;
import com.lemon.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.testng.annotations.*;

public class RegisterCase {

    public int sheetIndex;

    @BeforeClass
    @Parameters({"sheetIndex"})
    public void beforeClass(int sheetIndex) {
        //System.out.println("RegisterCase ===== sheetIndex:=============" + sheetIndex);
        this.sheetIndex=sheetIndex;//从testng参数中传过来的赋值给成员变量

    }
    @Test(dataProvider = "datas")

    public void test( CaseInfo caseInfo) throws Exception {
        HttpResponse response = HttpUtils.call(caseInfo.getMethod(),caseInfo.getContentType(),caseInfo.getUrl(),caseInfo.getParams(),Constants.HEADERS);
    }

    @DataProvider
    public Object[] datas() throws Exception {
        //这个方法从公用成员变量中或者传过来的值
        Object[] datas = ExcelUtils.getDatas(sheetIndex,1,CaseInfo.class);//List转化成七个参数的一维数组
        return datas;
    }

}
