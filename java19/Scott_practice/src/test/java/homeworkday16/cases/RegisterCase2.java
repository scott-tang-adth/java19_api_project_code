package homeworkday16.cases;
import homeworkday16.pojo.CaseInfo;
import homeworkday16.utils.ExcelUtils2;
import homeworkday16.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
 * 注册用例
 */
public class RegisterCase2 {

    @Test(dataProvider = "datas")
    public void test(CaseInfo caseInfo) {

      //  HttpResponse response = HttpUtils.call(caseInfo);
       // HttpResponse response = HttpUtils.call(caseInfo.getMethod(),caseInfo.getContentType(),caseInfo.getUrl(),caseInfo.getParams());
    }

    @DataProvider
    public Object[] datas() {
        Object[] datas = ExcelUtils2.getDatas(0, 1, CaseInfo.class);
        return datas;
    }

}
