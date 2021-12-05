package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class Seller  extends User{

   

    // Add the attributes found in the page below to this class
    //https://help.shopee.com.my/my/s/article/How-do-I-register-as-a-seller


    public double sellerProfit;
    public String sellerUsername;
    public String sellerEmail;
    public String sellerPhonenumber;
    public String sellerbankaccount;
    public String selleraddress;
    public String sellerpassword;


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

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getSellerPhonenumber() {
        return sellerPhonenumber;
    }

    public void setSellerPhonenumber(String sellerPhonenumber) {
        this.sellerPhonenumber = sellerPhonenumber;
    }

    public String getSellerbankaccount() {
        return sellerbankaccount;
    }

    public void setSellerbankaccount(String sellerbankaccount) {
        this.sellerbankaccount = sellerbankaccount;
    }

    public String getSelleraddress() {
        return selleraddress;
    }

    public void setSelleraddress(String selleraddress) {
        this.selleraddress = selleraddress;
    }

    public String getSellerpassword() {
        return sellerpassword;
    }

    public void setSellerpassword(String sellerpassword) {
        this.sellerpassword = sellerpassword;
    }
}
