package com.designpaterns.cmp.infrastructure.database.model.membership;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MembershipRepository extends MongoRepository<Membership, String> {

}
