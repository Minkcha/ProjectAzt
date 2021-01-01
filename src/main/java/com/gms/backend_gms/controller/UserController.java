package com.gms.backend_gms.controller;

import com.fasterxml.jackson.databind.node.TextNode;
import com.gms.backend_gms.entity.PackageInsurance;
import com.gms.backend_gms.entity.User;
import com.gms.backend_gms.repository.PackageRepository;
import com.gms.backend_gms.repository.UserRepository;
import com.gms.backend_gms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String saveUser(@RequestBody User user){
        User saveUser = userRepository.save(user);
        return "Add user with id : "+saveUser.getUserId();
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
