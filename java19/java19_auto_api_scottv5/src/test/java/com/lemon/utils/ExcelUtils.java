package com.lemon.utils;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.lemon.constants.Constants;
import com.lemon.pojo.CaseInfo;
import java.io.FileInputStream;
import java.util.List;

/**
 * @author luojie
 * @date 2020/6/11 - 21:42
 * 柠檬班创新教育极致服务
 *
 * excel 工具类
 */
public class ExcelUtils {

 /*   public static void main(String[] args) throws Exception {
        read(0,1, CaseInfo.class);
    }*/

    /**
     * 获取testng测试方法 数据驱动
     * @param sheetIndex    sheet开始位置
     * @param sheetNum      sheet个数
     * @param clazz         映射关系字节码
     * @return
     */
    public static Object[] getDatas(int sheetIndex,int sheetNum,Class clazz) {
        try {
           // List<CaseInfo> list = ExcelUtils.read(sheetIndex, sheetNum, CaseInfo.class);
            List<CaseInfo> list = ExcelUtils.read(sheetIndex, sheetNum, clazz);//注意
            //集合转成数组
            Object[] datas = list.toArray();
            return datas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 读取excel并返回映射关系集合
     * @param sheetIndex        sheet开始位置
     * @param sheetNum          sheet个数
     * @param clazz             映射关系字节码
     * @return
     * @throws Exception
     */
    public static List read(int sheetIndex,int sheetNum,Class clazz) throws Exception {
        //获取excel路径
        // ExcelUtils.class.getResourceAsStream("/cases_v1.xls");
        FileInputStream fis = new FileInputStream(Constants.EXCEL_PATH);
        //导入参数
        ImportParams params = new ImportParams();
        //从第一个sheet开始读取
        params.setStartSheetIndex(sheetIndex);
        //每次读取一个sheet
        params.setSheetNum(sheetNum);
        //importExcel(EXCEL文件流，映射关系字节码对象，导入参数) alt + enter
        List caseInfoList = ExcelImportUtil.importExcel(fis, clazz, params);
        return caseInfoList;
    }

}
