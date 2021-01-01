package com.gms.backend_gms.repository;

import com.gms.backend_gms.entity.ClaimFrom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClaimFromRepository extends MongoRepository<ClaimFrom,String> {
}
