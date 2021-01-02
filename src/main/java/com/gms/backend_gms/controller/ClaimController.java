package com.gms.backend_gms.controller;


import com.gms.backend_gms.entity.ClaimFrom;
import com.gms.backend_gms.entity.PackageInsurance;
import com.gms.backend_gms.repository.ClaimFromRepository;
import com.gms.backend_gms.repository.PackageRepository;
import com.gms.backend_gms.service.ClaimFromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@RestController
@RequestMapping("/claimFrom")
@CrossOrigin
public class ClaimController {

    @Autowired
    ClaimFromRepository claimFromRepository;

    @Autowired
    PackageRepository packageRepository;

    @Autowired
    ClaimFromService claimFromService;

//    @Autowired
//    PackageInsurance packageInsurance;

    @PostMapping("/{id}/addClaim")
    public ResponseEntity<?> addClaim(@PathVariable String id, @RequestBody ClaimFrom claimFrom){
        return ResponseEntity.ok(claimFromService.addClaim(id,claimFrom));
    }






}
