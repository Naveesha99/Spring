package com.excel.upload.Services;

import com.excel.upload.Models.UploadModel;
import com.excel.upload.Repositories.UploadRepository;
import com.excel.upload.Functions.UploadReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class UploadService {
    @Autowired
    private UploadRepository repository;

    @Autowired
    private UploadReader uploadReader;

    public void importData(MultipartFile file) throws IOException {
        List<UploadModel> models = uploadReader.readExcel(file);
        repository.saveAll(models);
    }
}
