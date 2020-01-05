package com.telran.repository;

import com.telran.entity.CompanyDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyDetailsRepository extends MongoRepository<CompanyDetails, String> {
}
