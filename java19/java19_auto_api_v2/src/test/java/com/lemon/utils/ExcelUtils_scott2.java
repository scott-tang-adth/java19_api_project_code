package com.lemon.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;


/**
 * @author by Scott.Tang
 * @Description ADTH
 * @date 2020/9/16.
 * @Copyright 精宇（上海）电子科技有限公司。 All rights reserved
 */
public class ExcelUtils_scott2 {

    public static void main( String[] args ) throws Exception {

        String path=System.getProperty("user.dir")+"/java19_auto_api_v2/src/test/resources/cases_v1.xls";

        FileInputStream fis=new FileInputStream(path);

        Workbook excel = WorkbookFactory.create(fis);

        Sheet sheet = excel.getSheetAt(0);

       int  lastRowNum=sheet.getLastRowNum();

        for(int i=1;i<lastRowNum;i++) {

            Row row = sheet.getRow(i);

            int  lastCellNum = row.getLastCellNum();

            for(int j=0;j<lastCellNum;j++){

                Cell cell = row.getCell(j);

                cell.setCellType(CellType.STRING);

                System.out.println(cell.getStringCellValue()+",");
            }
            System.out.println();
        }
    }
}
