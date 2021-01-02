package com.gms.backend_gms.controller;

import com.gms.backend_gms.entity.PackageInsurance;
import com.gms.backend_gms.entity.User;
import com.gms.backend_gms.entity.UserPackages;
import com.gms.backend_gms.repository.PackageRepository;
import com.gms.backend_gms.repository.UserRepository;
import com.gms.backend_gms.service.PackageService;
import com.gms.backend_gms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    UserService userService;

    @Autowired
    PackageService packageService;

    @PostMapping("/addUser")
    public ResponseEntity<String> saveUser(@RequestBody User user) throws Exception {
        try {
            userService.addUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Add user with id : " + user.getUserId());
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/findAllUsers")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public List<User> getUser(@PathVariable String userId){
        System.out.println(userId);
      return userRepository.findFirstByUserId(userId);
    }


    @PostMapping("/allPackages")
    public List<PackageInsurance> getUserAllPackages(@RequestBody UserPackages userPackages){
        return packageService.findAllPackages(userPackages);
    }

//    @PostMapping("/{id}/package")
//    public ResponseEntity<?> addPackage(@PathVariable String id, @RequestBody Map<String, Object> packageInsurance){
//        System.out.print("--------------------------------------");
//        System.out.println("[===]"+packageInsurance.get("id"));
//        return ResponseEntity.ok(userService.addPackage(id));
//    }

    @PostMapping("/{id}/addPackage")
    public ResponseEntity<?> addPackage(@PathVariable String id, @RequestBody PackageInsurance packageInsuranceT){
        return ResponseEntity.ok(userService.addPackage(id,packageInsuranceT));
    }
}


