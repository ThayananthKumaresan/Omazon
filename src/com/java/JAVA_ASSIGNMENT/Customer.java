package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class Customer extends User{

    private String paymentPassword;
    private String address ;
    private Wallet userWallet;
    boolean firstTimeLogin ;

// For new user when register
    public Customer( ) {
        this.paymentPassword = "";
        this.address =  "";
        this.userWallet =  new Wallet();
        this.firstTimeLogin = true;
    }

    // For user to login
    public Customer( String email, String password) {
        super.setEmail(email);
        super.setPassword(password);
    }


    public Customer( String paymentPassword, String address ,Wallet userWallet , boolean firstTimeLogin) {
        this.paymentPassword = paymentPassword;
        this.address = address;
        this.userWallet = userWallet;
        this.firstTimeLogin = firstTimeLogin;

    }

    public Wallet getUserWallet() {
        return userWallet;
    }

    public void setUserWallet(Wallet userWallet) {
        this.userWallet = userWallet;
    }

    public String getPaymentPassword() {
        return paymentPassword;
    }

    public void setPaymentPassword(String paymentPassword) {
        this.paymentPassword = paymentPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
