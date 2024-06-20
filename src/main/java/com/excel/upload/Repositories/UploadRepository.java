package com.excel.upload.Repositories;

import com.excel.upload.Models.UploadModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UploadRepository extends MongoRepository<UploadModel, String> {
}
