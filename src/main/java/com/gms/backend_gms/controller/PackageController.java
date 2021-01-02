package com.gms.backend_gms.controller;


import com.gms.backend_gms.entity.PackageInsurance;
import com.gms.backend_gms.repository.PackageRepository;
import com.gms.backend_gms.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;

@RestController
@RequestMapping("/package")
public class PackageController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PackageRepository packageRepository;


    @PostMapping("/addPackage")
    public String addPackage(@RequestBody PackageInsurance packageInsurance) {
        packageInsurance.setExpDate(getDate().toString());
        packageRepository.save(packageInsurance);
        return "Add package with id : " + packageInsurance.toString();
    }



    private java.util.Date getDate(){
        Calendar cal = Calendar.getInstance();
        java.util.Date today = cal.getTime();
        cal.add(Calendar.YEAR, 1);
        java.util.Date nextYear = cal.getTime();
        return nextYear;
    }


}
