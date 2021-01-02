package com.gms.backend_gms.service;


import com.gms.backend_gms.entity.PackageInsurance;
import com.gms.backend_gms.entity.User;
import com.gms.backend_gms.repository.PackageRepository;
import com.gms.backend_gms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PackageRepository packageRepository;


    public User addPackage(String id,PackageInsurance packageInsurance)
    {
        User user = userRepository.findById(id).get();
        packageInsurance.setExpDate(getDate());
        packageRepository.save(packageInsurance);
        if(user.getPackageInsurances() == null) {
            user.setPackageInsurances(new ArrayList<String>());
        }
        user.getPackageInsurances().add(packageInsurance.getPackageId());
        userRepository.save(user);

        return user;
    }

    public User addUser(User user) throws Exception {
        List<User> listUser = userRepository.findFirstByEmail(user.getEmail());
        User newUser;
        if(listUser.size() == 0) {
            newUser = userRepository.save(user);
        } else {
            throw new Exception("User with "+ user.getEmail() +" is already exist");
        }

        return newUser;
    }

    private String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        Date today = new Date();
        return sdf.format(new Date(today.getTime() + (1000L * 60 * 60 * 24 * 365)));
    }






}
