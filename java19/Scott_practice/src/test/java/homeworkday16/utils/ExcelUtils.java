package homeworkday16.utils;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import homeworkday16.pojo.CaseInfo2;

import java.io.FileInputStream;
import java.util.List;

public class ExcelUtils {

    public static void main( String[] args ) throws Exception {
        read();
    }
    public static void read() throws Exception {

        String path = ExcelUtils.class.getClassLoader().getResource("./cases_v1.xls").getPath();

        FileInputStream fis = new FileInputStream(path);

        ImportParams params=new ImportParams();
        //从第一个sheet开始读取
        //params.setStartRows(1);
        params.setStartSheetIndex(1);
        //每次读取1个sheet
        params.setSheetNum(1);
        //importExcel(Excel 文件流，映射关系字节流对象，导入参数)
        List<CaseInfo2>  CaseInfoList = ExcelImportUtil.importExcel(fis, CaseInfo2.class, params);
        for (CaseInfo2 caseInfo : CaseInfoList) {
            System.out.println(caseInfo);
        }

    }
}
