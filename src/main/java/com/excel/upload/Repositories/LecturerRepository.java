package com.excel.upload.Repositories;

import com.excel.upload.Models.UploadLecturerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LecturerRepository extends MongoRepository<UploadLecturerModel, String> {
    List<UploadLecturerModel> findAll();
}
