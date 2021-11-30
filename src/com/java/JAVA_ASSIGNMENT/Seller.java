package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class Seller  extends User{

    private double sellerProfit;
    private String sellerUsername;


    // Add the attributes found in the page below to this class
    //https://help.shopee.com.my/my/s/article/How-do-I-register-as-a-seller


    public double getSellerProfit() {
        return sellerProfit;
    }

    public void setSellerProfit(double sellerProfit) {
        this.sellerProfit = sellerProfit;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }
}
