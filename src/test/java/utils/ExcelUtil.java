package utils;

import commons.GlobalConstants;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtil {
    public static final String testDataExcelFileName = "testdata.xlsx";
    public static final String currentDir = GlobalConstants.PROJECT_PATH;
    public static String testDataExcelPath = null;
    private static XSSFWorkbook excelBook;
    private static XSSFSheet excelSheet;
    private static XSSFCell cell;
    private static XSSFRow row;

    @SneakyThrows
    public static void setExcelFileSheet(String sheetName){
        if (Platform.getCurrent().toString().toUpperCase().contains("MAC")){
            testDataExcelPath = currentDir + "/src/test/resources/";
        } else if (Platform.getCurrent().toString().toUpperCase().contains("WIN")){
            testDataExcelPath = currentDir + "\\src\\test\\resources\\";
        }

        FileInputStream ExcelFilePath = new FileInputStream(testDataExcelPath + testDataExcelFileName);
        excelBook = new XSSFWorkbook(ExcelFilePath);
        excelSheet = excelBook.getSheet(sheetName);
    }

    public static String getCellData(int rowNumber, int columnNumber){
        cell = excelSheet.getRow(rowNumber).getCell(columnNumber);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    public static XSSFRow getRowData(int rowNumber){
        row = excelSheet.getRow(rowNumber);
        return row;
    }

    public static int getRowCountInSheet(){
        return (excelSheet.getLastRowNum() - excelSheet.getFirstRowNum());
    }

    @SneakyThrows
    public static void setCellData(String value, int rowNumber, int columnNumber){
        row = excelSheet.getRow(rowNumber);
        cell = row.getCell(columnNumber);
        if (cell == null){
            cell = row.createCell(columnNumber);
            cell.setCellValue(value);
        } else {
            cell.setCellValue(value);
        }
        FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
        excelBook.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }
}
