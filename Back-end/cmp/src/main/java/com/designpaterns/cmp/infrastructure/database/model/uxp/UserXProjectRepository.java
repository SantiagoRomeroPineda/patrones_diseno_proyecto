package com.designpaterns.cmp.infrastructure.database.model.uxp;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserXProjectRepository extends MongoRepository<UserXProject, String> {

}
