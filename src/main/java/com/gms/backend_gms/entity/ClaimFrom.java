package com.gms.backend_gms.entity;


import com.mongodb.lang.NonNull;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
public class ClaimFrom {
    @Id
    private int claimId;

    @NonNull
    private String trackNumber;
    private String deliveryCompany;
    private int userId;
    private String date;
    private String photoProduct;
    private double price;
    private Boolean status;

    public ClaimFrom(String trackNumber, String deliveryCompany, int userId, String date, int claimId, String photoProduct, double price, Boolean status) {
        this.trackNumber = trackNumber;
        this.deliveryCompany = deliveryCompany;
        this.userId = userId;
        this.date = date;
        this.claimId = claimId;
        this.photoProduct = photoProduct;
        this.price = price;
        this.status = status;
    }

    public ClaimFrom(){}

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
