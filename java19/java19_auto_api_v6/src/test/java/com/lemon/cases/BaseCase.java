package com.lemon.cases;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.lemon.constants.Constants;
import com.lemon.pojo.CaseInfo;
import com.lemon.pojo.WriteBackData;
import com.lemon.utils.ExcelUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.Map;
import java.util.Set;

/**
 * @author luojie
 * @date 2020/6/20 - 10:43
 * 柠檬班创新教育极致服务
 *
 * 用例父类
 */
public class BaseCase {
    //读取testng.xml sheetIndex参数
    public int sheetIndex;

    @BeforeSuite
    public void init() {
        System.out.println("======================init===================");
        Constants.HEADERS.put("X-Lemonban-Media-Type","lemonban.v2");
        Constants.HEADERS.put("Content-Type","application/json");
    }

    @AfterSuite
    public void finish() {
        System.out.println("======================finish===================");
        //执行批量回写
        ExcelUtils.batchWrite();
    }

    @BeforeClass
    @Parameters({"sheetIndex"})
    public void beforeClass(int sheetIndex) {
        //System.out.println("LoginCase ===== sheetIndex:=============" + sheetIndex);
        this.sheetIndex = sheetIndex;
    }

    /**
     * 创建回写对象,添加到批量回写集合中
     * @param rownum            行号
     * @param cellnum           列号
     * @param content           回写内容
     */
    public void addWriteBackData(int rownum,int cellnum, String content) {
        WriteBackData wbd =
                new WriteBackData(sheetIndex,rownum, cellnum,content);
        //添加到回写集合
        ExcelUtils.wbdList.add(wbd);
    }

    /**
     * 接口响应断言
     * @param body                  接口响应字符串
     * @param expectResult          excel中响应期望值
     * @return                      断言结果
     */
    public boolean assertResponse(String body, String expectResult) {
        //json转成map
        Map<String,Object> map = JSONObject.parseObject(expectResult, Map.class);
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
