package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtil {

    public static Object[][] getExcelData(String filePath, String sheetName) {
        Object[][] data = null;

        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheet(sheetName);

            int rowCount = sheet.getLastRowNum();  // number of data rows (header excluded)
            int colCount = sheet.getRow(0).getLastCellNum(); // number of columns

            data = new Object[rowCount][colCount];

            // start from row 1 -> skip header
            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);

                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = cell == null ? "" : cell.toString();
                }
            }

            wb.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
