package com.gms.backend_gms.entity;

import com.mongodb.lang.NonNull;
import lombok.Data;

@Data
public class Login {
    @NonNull
    private String email;
    @NonNull
    private String password;

    public Login(String email,String password){
        this.email = email;
        this.password = password;
    }
}
