package com.gms.backend_gms.controller;


import com.gms.backend_gms.entity.ClaimFrom;
import com.gms.backend_gms.entity.PackageInsurance;
import com.gms.backend_gms.repository.ClaimFromRepository;
import com.gms.backend_gms.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@RequestMapping("/claimFrom")
public class ClaimController {

    @Autowired
    ClaimFromRepository claimFromRepository;

    @Autowired
    PackageRepository packageRepository;

//    @Autowired
//    PackageInsurance packageInsurance;

//    @PostMapping("/addClaim")
//    public String addClaim(@RequestBody ClaimFrom claim){
//        ClaimFrom saveClaim = new ClaimFrom();
//        saveClaim.setTrackNumber(claim.getTrackNumber());
//
//        saveClaim.setPrice(claim.getPrice(),packageInsurance.getTypePackage());
//
//        saveClaim.setDeliveryCompany(claim.getDeliveryCompany());
//        saveClaim.setDate(getDateClaim().toString());
//        saveClaim.setPhotoProduct(claim.getPhotoProduct());
//
//        claimFromRepository.save(saveClaim);
//        return "Add claim with id : " + saveClaim.toString();
//    }





}
