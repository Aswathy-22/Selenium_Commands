package org.obs.utility;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ExcelTwoDimensionArray {
    public static void main(String[] args) throws FileNotFoundException {
        String excelFilePath = "C:\\Users\\91944\\Documents\\Book1.xlsx"; //file path
        try (FileInputStream inputStream = new FileInputStream(excelFilePath);
             Workbook workbook = WorkbookFactory.create(inputStream)) {
            List<List<String>> dataList = new ArrayList<>();//2d array
            // Assuming you are reading the first sheet in the Excel file
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    int cellCount = row.getPhysicalNumberOfCells();
                    List<String> rowData = new ArrayList<>();
                    for (int j = 0; j < cellCount; j++) {
                        Cell cell = row.getCell(j);
                        if (cell != null) {
                            // Assuming all cells contain string data
                            rowData.add(cell.getStringCellValue());
                        } else {
                            rowData.add(""); // Add an empty string for empty cells
                        }
                    }
                    dataList.add(rowData);
                }
            }
            // Print the data using indices
            for (int i = 0; i < dataList.size(); i++) {
                List<String> rowData = dataList.get(i);
                for (int j = 0; j < rowData.size(); j++) {
                    System.out.print("Row " + i + ", Column " + j + ": " + rowData.get(j) + "\t");
                }
                System.out.println(); // Move to the next row
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
