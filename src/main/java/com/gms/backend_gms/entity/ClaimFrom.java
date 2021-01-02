package com.gms.backend_gms.entity;


import com.mongodb.lang.NonNull;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
public class ClaimFrom {
    @Id
    private String claimId;
    @NonNull
    private String packageId;
    @NonNull
    private String trackNumber;
    @NonNull
    private String nameProduct;
    @NonNull
    private String deliveryCompany;

    private String date;
    @NonNull
    private String photoProduct;
    @NonNull
    private double price;

    public ClaimFrom(String packageId,String trackNumber, String deliveryCompany, String photoProduct, double price,String nameProduct) {
        this.packageId = packageId;
        this.trackNumber = trackNumber;
        this.deliveryCompany = deliveryCompany;
        this.nameProduct = nameProduct;
        this.photoProduct = photoProduct;
        this.price = price;
    }
}
