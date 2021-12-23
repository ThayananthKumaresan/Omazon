package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class Customer extends User{

    private String paymentPassword;
    private String address ;
    private int customerID;
    private Wallet userWallet;

// For new user when register
    public Customer( ) {
        this.customerID = 0;
        this.paymentPassword = "";
        this.address =  "";
        this.userWallet =  new Wallet();
    }

    // For user to login
    public Customer( String email, String password) {
        super.setEmail(email);
        super.setPassword(password);
    }


    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCustomerID() {
        return customerID;
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
