package com.gms.backend_gms.repository;

import com.gms.backend_gms.entity.PackageInsurance;
import com.gms.backend_gms.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PackageRepository extends MongoRepository<PackageInsurance,String> {
//    List<PackageInsurance> fineAllByUserId(String userId);
    List<User> findAllPackageByPackageId(String userId);
}
