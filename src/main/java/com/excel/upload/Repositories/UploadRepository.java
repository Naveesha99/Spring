package com.excel.upload.Repositories;

import com.excel.upload.Models.UploadModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UploadRepository extends MongoRepository<UploadModel, String> {
    List<UploadModel> findAll();
}

