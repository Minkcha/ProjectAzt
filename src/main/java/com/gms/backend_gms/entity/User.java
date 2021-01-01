package com.gms.backend_gms.entity;

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

    private String name;
    private String surname;
    private String citizenId;
    private String email;
    private String password;
    private String tel;
    private ArrayList<PackageInsurance> packageInsurances = new ArrayList<>();
    private ArrayList<ClaimFrom> claims = new ArrayList<>();

    public User(String name, String surname, String citizenId, String email, String password, String tel) {
        this.name = name;
        this.surname = surname;
        this.citizenId = citizenId;
        this.email = email;
        this.password = password;
        this.tel = tel;
    }

//    public void setPackage(String packageInsuranceId){
//        this.packages.add(packageInsuranceId);
//    }

}
