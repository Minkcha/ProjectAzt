package com.gms.backend_gms.entity;


import com.mongodb.lang.NonNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class PackageInsurance {

    @Id
    private String packageId;

    @NonNull
    private int typePackage;
    private String expDate;
    private double amountLimit;
    @NonNull
    private double price;
    private String detail;

    public PackageInsurance(int typePackage,double price) {
        this.typePackage = typePackage;
        this.amountLimit = price;
        this.price = price;
        if(typePackage == 1) {
            this.detail = "wdw";
        }
        else if(typePackage == 2){
            this.detail = "fmsmgkg";
        }
        else {
            this.detail = "gjiodjfgijfdok";
        }
    }

}
