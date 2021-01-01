package com.gms.backend_gms.repository;

import com.gms.backend_gms.entity.PackageInsurance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PackageRepository extends MongoRepository<PackageInsurance,String> {
//    List<PackageInsurance> fineAllByUserId(String userId);
}
