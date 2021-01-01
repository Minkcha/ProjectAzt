package com.gms.backend_gms.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class PackageInsurance {

    @Id
    private String packageId;

    private int typePackage;
    private String expDate;
    private double amountLimit;
    private double price;

    public PackageInsurance(int typePackage, String expDate,double price) {
        this.typePackage = typePackage;
        this.expDate = expDate;
        this.amountLimit = price;
        this.price = price;
    }

}
