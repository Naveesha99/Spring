package com.excel.upload.Services;

import com.excel.upload.Models.UploadLecturerModel;
import com.excel.upload.Models.UploadModel;
import com.excel.upload.Repositories.LecturerRepository;
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
    private UploadRepository uploadRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private UploadReader uploadReader;

    public void importData(MultipartFile file) throws IOException {
        List<UploadModel> models = uploadReader.readStudentExcel(file);
        uploadRepository.saveAll(models);
    }

    public List<UploadModel> getAllData() {
        return uploadRepository.findAll();
    }

    public void importLecturerData(MultipartFile file) throws IOException {
        List<UploadLecturerModel> models = uploadReader.readLecturerExcel(file);
        lecturerRepository.saveAll(models);
    }

    public List<UploadLecturerModel> getAllLecturerData() {
        return lecturerRepository.findAll();
    }
}

