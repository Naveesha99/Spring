package com.excel.upload.Functions;

import com.excel.upload.Models.UploadModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class UploadReader {
    public List<UploadModel> readExcel(MultipartFile file) throws IOException {
        List<UploadModel> models = new ArrayList<>();
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
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
