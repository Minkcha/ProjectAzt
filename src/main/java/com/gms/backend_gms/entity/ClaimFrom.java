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

    public ClaimFrom(String trackNumber, String deliveryCompany, String date, String photoProduct, double price,String nameProduct) {
        this.trackNumber = trackNumber;
        this.deliveryCompany = deliveryCompany;
        this.date = date;
        this.nameProduct = nameProduct;
        this.photoProduct = photoProduct;
        this.price = price;
    }

//    public ClaimFrom(){}

    public void setPrice(double price,int typeP){
        double percent;
        if (typeP == 1){
            percent = 0.3;
        }
        else if (typeP == 2){
            percent = 0.4 ;
        }
        else{ percent = 0.5;}

        this.price = price*typeP;
    }


}
