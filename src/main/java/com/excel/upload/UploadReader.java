package com.excel.upload;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class UploadReader {
    public List<UploadModel> readExcel(String filenPath) throws IOException {
        List<UploadModel> models = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(filenPath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            UploadModel model = new UploadModel();
            model.setName(row.getCell(0).getStringCellValue());
            model.setCountry(row.getCell(1).getStringCellValue());
            models.add(model);
        }
        workbook.close();
        return models;
    }
}
