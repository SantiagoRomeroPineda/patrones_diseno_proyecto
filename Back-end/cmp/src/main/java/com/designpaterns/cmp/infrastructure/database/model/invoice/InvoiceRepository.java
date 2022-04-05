package com.designpaterns.cmp.infrastructure.database.model.invoice;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvoiceRepository extends MongoRepository<Invoice, String> {

}
