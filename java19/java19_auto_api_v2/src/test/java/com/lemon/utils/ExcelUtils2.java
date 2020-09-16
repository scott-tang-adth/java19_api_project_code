package com.lemon.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author luojie
 * @date 2020/6/11 - 21:42
 * 柠檬班创新教育极致服务
 *
 * excel 工具类
 */
public class ExcelUtils2 {
    public static void main(String[] args) throws Exception {
        Object[][] read = read();
    }

    public static Object[][] read() throws Exception {
        //1、加载excel 文件  LINUX WINDOW
        String path = ExcelUtils.class.getClassLoader().getResource("./cases_v1.xls").getPath();
        //String path = "java19_auto_api_v2/src/test/resources/cases_v1.xls";
        //String path = "src/test/resources/cases_v1.xls";
        FileInputStream fis = new FileInputStream(path);
        //2、创建excel对象
        Workbook execl = WorkbookFactory.create(fis);
        //3、Sheet、Row、Cell
        Sheet sheet = execl.getSheetAt(0);
        boolean flag = true;
        //循环所有row
        Object[][] datas = new Object[sheet.getLastRowNum()][2];
        for (Row row : sheet) {
            if(flag) {  //true
                flag = false;
                continue;
            }
            //循环所有cell
            for (Cell cell : row) {
                cell.setCellType(CellType.STRING);
                System.out.print(cell.getStringCellValue() + ",");
//                datas[i][0] = url;
//                datas[i][1] = params;
            }
            System.out.println();
        }
        return datas;
    }
}
