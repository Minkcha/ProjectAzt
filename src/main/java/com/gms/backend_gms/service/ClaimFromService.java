package com.gms.backend_gms.service;

import com.gms.backend_gms.entity.*;
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


    public User addClaim(String userId, ClaimFrom claimFrom) {
        claimFrom.setDate(getDateClaim());
        claimFromRepository.save(claimFrom);

        User user = userRepository.findById(userId).get();
        if (user.getClaims() == null) {
            user.setClaims(new ArrayList<String>());
        }
        user.getClaims().add(claimFrom.getClaimId());
        userRepository.save(user);

        PackageInsurance packageInsurance = packageRepository.findById(claimFrom.getPackageId()).get();
        int typeP = packageInsurance.getTypePackage();
        double percent;

        if (typeP == 1) {
            percent = 0.3;
        } else if (typeP == 2) {
            percent = 0.4;
        } else {
            percent = 1;
        }

        double amountLimit = packageInsurance.getAmountLimit() - claimFrom.getPrice() * percent;
        if (amountLimit < 0) {
            amountLimit = 0;
        }
        packageInsurance.setAmountLimit(amountLimit);
        packageRepository.save(packageInsurance);

        return user;
    }

    public void upDateAmoutLimit(double price, String packageId) {
        PackageInsurance packageInsurance = packageRepository.findById(packageId).get();

    }

    private String getDateClaim() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        return sdf.format(new Date());
    }


    public ArrayList<ClaimFrom> findAllClaims(UserClaims userClaims){
        ArrayList<ClaimFrom> claimFrom = new ArrayList<>();
        userClaims.getUserClaims().forEach((id) -> {
            ClaimFrom c = claimFromRepository.findById(id).get();
            claimFrom.add(c);
        });
        return claimFrom;
    }


}
