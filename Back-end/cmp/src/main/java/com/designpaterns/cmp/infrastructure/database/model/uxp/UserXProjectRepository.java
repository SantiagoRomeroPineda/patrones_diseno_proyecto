package com.designpaterns.cmp.infrastructure.database.model.uxp;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserXProjectRepository extends MongoRepository<UserXProject, String> {

	List<UserXProject> findAllByUser__id(final String userId);


}
