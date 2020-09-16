package com.lemon.utils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;

/**
 *
 1、完成从excel中读取 url 和 params 封装到 Object[][] datas 中，并在控制输出datas二维数组。
 */
public class ExcelUtils {
    public static void main(String[] args) throws Exception {
            Object[][] datas = read();
            RegisterCase reg=new RegisterCase();
    }
    public static Object[][] read() throws Exception {
        //1、加载excel 文件  LINUX WINDOW
        String path = ExcelUtils.class.getClassLoader().getResource("./cases_v1.xls").getPath();
        //String path = "java19_auto_api_v2/src/test/resources/cases_v1.xls";
        //String path = "src/test/resources/cases_v1.xls";Arrays.toStringArrays.toString
        //FileInputStream fis = new FileInputStream(path);
        FileInputStream fis = new FileInputStream("D:\\cases_v1.xls");
        //2、创建excel对象
        Workbook execl = WorkbookFactory.create(fis);
        //3、Sheet、Row、Cell
        Sheet sheet = execl.getSheetAt(0);
        boolean flag = true;
        //循环所有row
      //  Object[][] datas = new Object[sheet.getLastRowNum()][2];
     /*   for (Row row : sheet) {
            if(flag) {  //true
                flag = false;
                continue;
            }
            //循环所有cell
            for (Cell cell : row) {
                cell.setCellType(CellType.STRING);
                System.out.print(cell.getStringCellValue() + ",");

            }
            System.out.println();
        }*/

        Object[][] datas = new Object[sheet.getLastRowNum()][2];
        for (int i=0;i<sheet.getLastRowNum();i++)
        {
           //第一行是表头，所以跳一行
            /*Row row = sheet.createRow(i+1);
            Cell cell = row.createCell(0); //第一列 通过行号生成单元格
            cell.setCellType(CellType.STRING);
            datas[i][0]=cell.getStringCellValue();
            cell = row.createCell(3);//第四列 通过行号生成单元格
            cell.setCellType(CellType.STRING);
            datas[i][1]=cell.getStringCellValue();*/
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

        for(int i=0;i<7;i++)
        {
            for(int j=0;j<2;j++)
            {
                System.out.println(datas[i][j]);
            }
        }
        return datas;
    }

}
