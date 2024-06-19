package com.excel.upload;

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
