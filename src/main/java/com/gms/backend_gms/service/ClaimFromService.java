package com.gms.backend_gms.service;

import com.gms.backend_gms.entity.ClaimFrom;
import com.gms.backend_gms.entity.PackageInsurance;
import com.gms.backend_gms.entity.User;
import com.gms.backend_gms.repository.ClaimFromRepository;
import com.gms.backend_gms.repository.PackageRepository;
import com.gms.backend_gms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Service
public class ClaimFromService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PackageRepository packageRepository;

    @Autowired
    ClaimFromRepository claimFromRepository;


    public User addClaim(String id,ClaimFrom claimFrom)
    {
        User user = userRepository.findById(id).get();
        claimFrom.setDate(getDateClaim().toString());
        claimFromRepository.save(claimFrom);
        if(user.getClaims() == null) {
            user.setClaims(new ArrayList<String>());
        }

        user.getClaims().add(claimFrom.getClaimId());
        userRepository.save(user);

        return user;
    }

    public void upDateAmoutLimit(double price,String packageId){
        PackageInsurance packageInsurance = packageRepository.findById(packageId).get();

    }

    private java.util.Date getDateClaim(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Date today = new Date();
        return today;
    }


}
