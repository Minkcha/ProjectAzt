package com.gms.backend_gms.service;


import com.gms.backend_gms.entity.PackageInsurance;
import com.gms.backend_gms.entity.User;
import com.gms.backend_gms.repository.ClaimFromRepository;
import com.gms.backend_gms.repository.PackageRepository;
import com.gms.backend_gms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Calendar;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PackageRepository packageRepository;

//    @Autowired
//    private PackageInsurance packageInsurance;

    @Autowired
    private ClaimFromRepository claimFromRepository;

    public User addPackage(String id,PackageInsurance packageInsurance)
    {

        User user = userRepository.findById(id).get();
        packageInsurance.setExpDate(getDate().toString());
        packageInsurance.setAmountLimit(packageInsurance.getPrice());
        packageRepository.save(packageInsurance);
        user.getPackageInsurances().add(packageInsurance.getPackageId());
        System.out.println(user);
        userRepository.save(user);

//        user.setPackages(packageInsurance.getPackageId());

        return user;
    }

    private java.util.Date getDate(){
        Calendar cal = Calendar.getInstance();
        java.util.Date today = cal.getTime();
        cal.add(Calendar.YEAR, 1); // to get previous year add -1
        java.util.Date nextYear = cal.getTime();
        return nextYear;
    }



}
