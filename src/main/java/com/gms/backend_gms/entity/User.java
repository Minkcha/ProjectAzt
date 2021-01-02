package com.gms.backend_gms.entity;

import com.mongodb.lang.NonNull;
import lombok.Data;

import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
//import javax.persistence.Id;
import java.util.ArrayList;

@Data
@Accessors(chain = true)
public class User {
    @Id
    private String userId;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private String citizenId;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String tel;

    private ArrayList<String> packageInsurances = new ArrayList<String>();
    private ArrayList<String> claims = new ArrayList<String>();

    public User(
            String name,
            String surname,
            String citizenId,
            String email,
            String password,
            String tel,
            ArrayList<String> packageInsurances,
            ArrayList<String> claims
    ) {
        this.name = name;
        this.surname = surname;
        this.citizenId = citizenId;
        this.email = email;
        this.password = password;
        this.tel = tel;
        this.packageInsurances = packageInsurances;
        this.claims = claims;
    }

    //    public void setPackage(String packageInsuranceId){
//        this.packages.add(packageInsuranceId);
//    }

}
