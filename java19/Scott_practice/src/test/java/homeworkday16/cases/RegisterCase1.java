package homeworkday16.cases;
import homeworkday16.pojo.CaseInfo;
import homeworkday16.utils.ExcelUtils2;
import homeworkday16.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class RegisterCase1 {

    @Test(dataProvider = "datas")

    public void test( CaseInfo caseInfo) throws Exception {

        //HttpResponse response = HttpUtils.call(caseInfo.getMethod(),caseInfo.getContentType(),caseInfo.getUrl(),caseInfo.getParams());
        // HttpUtils.jsonPost(caseInfo.getUrl(),caseInfo.getParams());//这里只要七个中的两个参数传递
        //因为http请求的post和contentype是经常变化的所以我们需要在用之前来个判断
        //为了简化可以把这部分分支判断移到HttpUtils类里面去，详见RegisterCase2
       /* String method=caseInfo.getMethod();
        String contentype=caseInfo.getContentType();
        //如果请求方式是post
        if("post".equalsIgnoreCase(method))
        {   //如果参数类型是json
            if("json".equalsIgnoreCase(contentype))
            {
                HttpUtils.jsonPost(caseInfo.getUrl(),caseInfo.getParams());
                //如果参数类型是form
            }else if ("form".equalsIgnoreCase(contentype))
            {
                HttpUtils.formPost(caseInfo.getUrl(),caseInfo.getParams());
            }else {
                System.out.println("没有发送http请求"+caseInfo);
            }
            //如果请求方式是get
        }else if("get".equalsIgnoreCase(method))
        {
            HttpUtils.get(caseInfo.getUrl());
            //如果请求方式是patch
        }else if("patch".equalsIgnoreCase(method))
        {
            HttpUtils.patch(caseInfo.getUrl(),caseInfo.getParams());
        }else
        {
            System.out.println("没有发送http请求"+caseInfo);
        }
    }*/
        HttpResponse response = HttpUtils.call1(caseInfo);
    }

    @DataProvider
    public Object[] datas() throws Exception {
        Object[] datas = ExcelUtils2.getDatas(0,1,CaseInfo.class);//List转化成七个参数的一维数组
        return datas;
    }

}
