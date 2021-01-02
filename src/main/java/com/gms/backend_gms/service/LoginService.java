package com.gms.backend_gms.service;

import com.gms.backend_gms.entity.Login;
import com.gms.backend_gms.entity.User;
import com.gms.backend_gms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public User userLogin(Login login) throws Exception{
        List<User> user = userRepository.findFirstByEmail(login.getEmail());
        if(user.size() != 0){
            if(user.get(0).getEmail() == login.getEmail() && user.get(0).getPassword()==login.getPassword()){
                return user.get(0);
            }
            throw new Exception("email or password incorrect");
        }

        throw new Exception("user not found");
    }
}
