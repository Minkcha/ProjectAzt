package com.gms.backend_gms.service;


import com.gms.backend_gms.entity.PackageInsurance;
import com.gms.backend_gms.entity.User;
import com.gms.backend_gms.entity.UserPackages;
import com.gms.backend_gms.repository.PackageRepository;
import com.mongodb.BasicDBObject;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.persistence.Basic;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class PackageService {

    @Autowired
    PackageRepository packageRepository;

    public ArrayList<PackageInsurance> findAllPackages(UserPackages userPackages){
        ArrayList<PackageInsurance> packageInsurance = new ArrayList<>();
        userPackages.getUserPackages().forEach((id) -> {
            PackageInsurance p = packageRepository.findById(id).get();
            packageInsurance.add(p);
        });
        return packageInsurance;
    }
}
