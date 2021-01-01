package com.gms.backend_gms.service;


import com.gms.backend_gms.entity.PackageInsurance;
import com.gms.backend_gms.entity.User;
import com.gms.backend_gms.repository.ClaimFromRepository;
import com.gms.backend_gms.repository.PackageRepository;
import com.gms.backend_gms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private ClaimFromRepository claimFromRepository;

    public User addPackage(String id,PackageInsurance packageInsurance)
    {

        User user = userRepository.findById(id).orElseThrow();
        user.getPackageInsurances().add(packageRepository.save(packageInsurance));
        userRepository.save(user);
//        packageRepository.save(packageInsurance);
//        user.setPackages(packageInsurance.getPackageId());

        return user;
    }



}
