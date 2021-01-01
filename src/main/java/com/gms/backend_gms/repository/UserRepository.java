package com.gms.backend_gms.repository;

import com.gms.backend_gms.entity.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
  List<User> findFirstByUserId(String userId);
}
