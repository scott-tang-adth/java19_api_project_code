package com.lemon.utils;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
public class ExcelUtils3 {
    public static void main(String[] args) throws Exception {
        Object[][] datas = read();
        //证明下存进去了
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<2;j++)
            {
                System.out.println(datas[i][j]);
            }
        }
    }
    public static Object[][] read() throws Exception {
        //1、加载excel 文件
        FileInputStream fis = new FileInputStream("D:\\cases_v1.xls");
        //2、创建excel对象
        Workbook execl = WorkbookFactory.create(fis);
        //3、Sheet、Row、Cell
        Sheet sheet = execl.getSheetAt(0);
        Object[][] datas = new Object[sheet.getLastRowNum()][2];
        for (int i=0;i<sheet.getLastRowNum();i++)
        {
            Row row = sheet.getRow(i+1);
            Cell cell = row.getCell(2); //第一列 通过行号生成单元格
            cell.setCellType(CellType.STRING);
           // System.out.println(cell.getStringCellValue());
            datas[i][0]=cell.getStringCellValue();
            cell = row.getCell(5);//第四列 通过行号生成单元格
            cell.setCellType(CellType.STRING);
            //System.out.println(cell.getStringCellValue());
            datas[i][1]=cell.getStringCellValue();

        }
        return datas;
    }

}
