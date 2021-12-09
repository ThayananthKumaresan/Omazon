package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class Seller  extends User{

    private double sellerProfit;
    public String sellerUsername;
    public String sellerEmail;
    public String sellerPhoneNumber;
    public String sellerBankAccount;
    public String sellerAddress;
    public String sellerPassword;
    public String sellerIC;
    public String sellerBusinessRegistrationNumber;


    // For user to login
    public Seller( String email, String password) {
        super.setEmail(email);
        super.setPassword(password);
    }


    public Seller() {


    }

    public Seller(double sellerProfit, String sellerUsername, String sellerEmail, String sellerPhoneNumber, String sellerBankAccount, String sellerAddress, String sellerPassword, String sellerIC, String sellerBusinessRegistrationNumber) {
        this.sellerProfit = sellerProfit;
        this.sellerUsername = sellerUsername;
        this.sellerEmail = sellerEmail;
        this.sellerPhoneNumber = sellerPhoneNumber;
        this.sellerBankAccount = sellerBankAccount;
        this.sellerAddress = sellerAddress;
        this.sellerPassword = sellerPassword;
        this.sellerIC = sellerIC;
        this.sellerBusinessRegistrationNumber = sellerBusinessRegistrationNumber;
    }

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

    public String getSellerPhoneNumber() {
        return sellerPhoneNumber;
    }

    public void setSellerPhoneNumber(String sellerPhoneNumber) {
        this.sellerPhoneNumber = sellerPhoneNumber;
    }

    public String getSellerBankAccount() {
        return sellerBankAccount;
    }

    public void setSellerBankAccount(String sellerBankAccount) {
        this.sellerBankAccount = sellerBankAccount;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public String getSellerPassword() {
        return sellerPassword;
    }

    public void setSellerPassword(String sellerPassword) {
        this.sellerPassword = sellerPassword;
    }

    public String getSellerIC() {
        return sellerIC;
    }

    public void setSellerIC(String sellerIC) {
        this.sellerIC = sellerIC;
    }

    public String getSellerBusinessRegistrationNumber() {
        return sellerBusinessRegistrationNumber;
    }

    public void setSellerBusinessRegistrationNumber(String sellerBusinessRegistrationNumber) {
        this.sellerBusinessRegistrationNumber = sellerBusinessRegistrationNumber;
    }
}
