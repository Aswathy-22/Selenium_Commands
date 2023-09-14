package org.obs.utility;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ExcelSingleDimensionArray {
    public static void main(String[] args) throws IOException {
        String excelFilePath = "C:\\Users\\91944\\Documents\\Book1.xlsx"; // file path
        try (FileInputStream inputStream = new FileInputStream(excelFilePath);//read excel file
             Workbook workbook = WorkbookFactory.create(inputStream)) {//instance used to read excel file
            List<String> dataList = new ArrayList<>();//will hold all the list
            // Assuming you are reading the first sheet in the Excel file
            Sheet sheet = workbook.getSheetAt(0);//to get first sheet index 0
            int rowCount = sheet.getPhysicalNumberOfRows();//counting rows
            for (int i = 0; i < rowCount; i++) {//iterateing
                Row row = sheet.getRow(i);//instance used to get the contents till ith row
                if (row != null) {//not null
                    int cellCount = row.getPhysicalNumberOfCells();//column count
                    for (int j = 0; j < cellCount; j++) {//iterating
                        Cell cell = row.getCell(j);//content
                        if (cell != null) {
                            // Assuming all cells contain string data
                            dataList.add(cell.getStringCellValue());//getting sell values
                        }
                    }
                }
            }
            // Print the data using indices
            for (int i = 0; i < dataList.size(); i++) {
                System.out.println("Data at index " + i + ": " + dataList.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
