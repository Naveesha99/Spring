package com.excel.upload.Services;

import com.excel.upload.Models.UploadModel;
import com.excel.upload.Repositories.UploadRepository;
import com.excel.upload.Functions.UploadReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UploadService {
    @Autowired
    private UploadRepository repository;

    @Autowired
    private UploadReader uploadReader;

    public void importData(String filepath) throws IOException {
        List<UploadModel> models = uploadReader.readExcel(filepath);
        repository.saveAll(models);
    }
}
