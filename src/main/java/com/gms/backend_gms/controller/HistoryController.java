package com.gms.backend_gms.controller;


import com.gms.backend_gms.entity.ClaimFrom;
import com.gms.backend_gms.entity.PackageInsurance;
import com.gms.backend_gms.entity.UserClaims;
import com.gms.backend_gms.entity.UserPackages;
import com.gms.backend_gms.service.ClaimFromService;
import com.gms.backend_gms.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {


    @Autowired
    PackageService packageService;

    @Autowired
    ClaimFromService claimFromService;

    @PostMapping("/findAllPackages")
    public List<PackageInsurance> getUserAllPackages(@RequestBody UserPackages userPackages){
        return packageService.findAllPackages(userPackages);
    }

    @PostMapping("/findAllClaims")
    public List<ClaimFrom> getUserAllPClaims(@RequestBody UserClaims userClaims){
        return claimFromService.findAllClaims(userClaims);
    }
}
