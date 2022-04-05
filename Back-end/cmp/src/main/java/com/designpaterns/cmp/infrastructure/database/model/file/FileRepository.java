package com.designpaterns.cmp.infrastructure.database.model.file;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<File, String> {

}
