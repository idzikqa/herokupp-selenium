package pl.idzikqa.herokuapp.tools;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelMethods {
    public static String getDataFromCell(String path, String sheet, int row, int column) {
        XSSFWorkbook ExcelWBook;
        XSSFSheet ExcelWSheet;
        XSSFCell Cell;
        String result = "";
        try {
            FileInputStream ExcelFile = new FileInputStream(path);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(sheet);

            Cell = ExcelWSheet.getRow(row).getCell(column);
            result = Cell.getStringCellValue();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
//    String path = "//Users//atomar//Documents//workspace_personal//SeleniumWD2Tutorial//src//utilities//ExcelRead.xlsx";
//    String sheetName = "Sheet1";
