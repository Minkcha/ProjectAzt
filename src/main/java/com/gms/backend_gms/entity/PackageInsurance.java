package com.gms.backend_gms.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class PackageInsurance {

    @Id
    private String packageId;

    private int typePackage;
    private String expDate;
    private double amountLimit;
    private double price;

    public PackageInsurance(int typePackage,double price) {
        this.typePackage = typePackage;
        this.amountLimit = price;
        this.price = price;
    }



    public PackageInsurance(){}
}
