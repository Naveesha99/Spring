package com.excel.upload;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UploadRepository extends MongoRepository<UploadModel, String> {
}
