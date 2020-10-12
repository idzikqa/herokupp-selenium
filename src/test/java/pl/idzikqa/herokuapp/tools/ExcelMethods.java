package pl.idzikqa.herokuapp.tools;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.idzikqa.herokuapp.data.Configuration;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelMethods {


    public static Object[][] getDataFromOneCell(String name) {
        List<String> list = new ArrayList<>();
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        XSSFCell cell;
        Integer result;
        try {
            FileInputStream ExcelFile = new FileInputStream(Configuration.pathToExcel);
            workbook = new XSSFWorkbook(ExcelFile);
            sheet = workbook.getSheet(name);
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                cell = sheet.getRow(i + 1).getCell(0);
                result = (int) (cell.getNumericCellValue());
                list.add(String.valueOf(result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[][] returnTab = new Object[list.size()][1];
        for (int i = 0; i < list.size(); i++) {
            returnTab[i][0] = list.get(i);
        }
        return returnTab;
    }
}
