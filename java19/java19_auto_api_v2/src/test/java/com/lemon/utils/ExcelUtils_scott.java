package com.lemon.utils;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
/**
 * @author by Scott.Tang
 * @Description ADTH
 * @date 2020/9/16.
 * @Copyright 精宇（上海）电子科技有限公司。 All rights reserved
 */
public class ExcelUtils_scott {


    public static void main( String[] args ) throws Exception {

        //绝对路径
        String path = ExcelUtils_scott.class.getClassLoader().getResource("./cases_v1.xls").getPath();

        String path3="D:/ideaCode/java19/java19_auto_api_v2/src/test/resources/cases_v1.xls";

        String path2=System.getProperty("user.dir")+"/java19_auto_api_v2/src/test/resources/cases_v1.xls";

        FileInputStream fis=new FileInputStream(path2);

        Workbook excel = WorkbookFactory.create(fis);

        Sheet sheet = excel.getSheetAt(0);

        boolean flag=true;//用来跳过表头

        for (Row row : sheet) {

            if(flag){
                flag=false;
                continue;
            }
            for (Cell cell : row) {

                cell.setCellType(CellType.STRING);

                System.out.println(cell.getStringCellValue()+",");
            }
            System.out.println();
        }


    }

}
