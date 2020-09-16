package com.lemon.cases;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.lemon.constants.Constants;
import com.lemon.pojo.WriteBackData;
import com.lemon.utils.ExcelUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.Map;
import java.util.Set;

import static com.lemon.utils.ExcelUtils.batchWrite;

/**
 * @author by Scott
 * @date 2020/6/23.
 */
public class BaseCase {

    int sheetIndex;

    @BeforeSuite//只执行一次
    public void init() {
        Constants.HEADERS.put("X-Lemonban-Media-Type", "lemonban.v2");
        Constants.HEADERS.put("Content-Type", "application/json");
    }

    @AfterSuite
    public void finish() {
        batchWrite();
    }

    @BeforeClass
    @Parameters({"sheetIndex"})
    public void beforeClass( int sheetIndex ) {
        //System.out.println("RegisterCase ===== sheetIndex:=============" + sheetIndex);
        this.sheetIndex = sheetIndex;//从testng参数中传过来的赋值给成员变量

    }
    //这里不能写static

    public void addWriteBackData(int rownum,int cellnum, String content) {
        WriteBackData wbd =
                new WriteBackData(sheetIndex,rownum, cellnum,content);
        //添加到回写集合
        ExcelUtils.wbdList.add(wbd);
    }
    //断言模块
    public boolean assertResponse(String body, String expectResult) {
        //json转成map
        Map<String,Object> map = JSONObject.parseObject(expectResult,Map.class);
        Set<String> keySet = map.keySet();
        boolean assertResponseFlag = true;
        for (String expression : keySet) {
            //1、获取期望值
            Object expectValue = map.get(expression);
            //2、通过jsonpath找到实际值
            Object actualValue = JSONPath.read(body,expression);
            //3、比较期望值和实际值
            if(expectValue == null && actualValue != null) {
                assertResponseFlag = false;
                break;
            }
            if(expectValue == null && actualValue == null) {
                continue;
            }
            if(!expectValue.equals(actualValue)) {
                assertResponseFlag = false;
                break;
            }
        }
        System.out.println("响应断言结果：" + assertResponseFlag);
        return assertResponseFlag;
    }
}