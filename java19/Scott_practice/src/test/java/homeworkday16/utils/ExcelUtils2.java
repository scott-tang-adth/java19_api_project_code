package homeworkday16.utils;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import homeworkday16.pojo.CaseInfo;
import homeworkday16.pojo.CaseInfo2;
import java.io.FileInputStream;
import java.util.List;

public class ExcelUtils2 {

    public static void main( String[] args ) throws Exception {

        List<CaseInfo> readList2 = read(0, 1, CaseInfo.class);
        for (CaseInfo caseInfo : readList2) {
            System.out.println(caseInfo);
        }
        List<CaseInfo2> readList = read(1, 1, CaseInfo2.class);
        for (CaseInfo2 caseInfo : readList) {
            System.out.println(caseInfo);
        }

    }

    /**
     * 获取testng测试方法，数据驱动
     * @param sheetIndex sheet 开始位置
     * @param sheetNum sheet 个数
     * @param clazz  映射关系字节码
     *
     * @return
     */

    public static Object[] getDatas(int sheetIndex,int sheetNum,Class clazz)

    {
        try {
            List list = ExcelUtils2.read(0, 1, CaseInfo.class);
            Object[] datas=list.toArray();
            return datas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //使用api函数把excel中的数据读到list中
    public static List read( int SheetIndex, int setSheetNum, Class clazz) throws Exception {

        String path = ExcelUtils2.class.getClassLoader().getResource("./cases_v1.xls").getPath();

        FileInputStream fis = new FileInputStream(path);

        ImportParams params=new ImportParams();
        //从第一个sheet开始读取
       // params.setStartRows(setStartRows);
        params.setStartSheetIndex(SheetIndex);
        //每次读取1个sheet
        params.setSheetNum(setSheetNum);
        //importExcel(Excel 文件流，映射关系字节流对象，导入参数)
        List CaseInfoList = ExcelImportUtil.importExcel(fis, clazz, params);
      /*  for (CaseInfo2 caseInfo : CaseInfoList) {
            System.out.println(caseInfo);
        }

        return CaseInfoList*/;
        fis.close();
        return CaseInfoList;

    }
}
