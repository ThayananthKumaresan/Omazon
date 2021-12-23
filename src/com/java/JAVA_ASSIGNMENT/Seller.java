package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class Seller  extends User{

    private int sellerID;
    private double sellerProfit;
    public String sellerPhoneNumber;
    public String sellerBankAccount;
    public String sellerAddress;
    public String sellerIC;
    public String sellerBusinessRegistrationNumber;
    public ArrayList<Transaction> sellerTransactions;


    // For user to login
    public Seller( String email, String password) {
        super.setEmail(email);
        super.setPassword(password);
    }


    public Seller() {

    }

    public Seller(int sellerID, double sellerProfit, String sellerPhoneNumber, String sellerBankAccount, String sellerAddress, String sellerIC, String sellerBusinessRegistrationNumber) {
        this.sellerID = sellerID;
        this.sellerProfit = sellerProfit;
        this.sellerPhoneNumber = sellerPhoneNumber;
        this.sellerBankAccount = sellerBankAccount;
        this.sellerAddress = sellerAddress;
        this.sellerIC = sellerIC;
        this.sellerBusinessRegistrationNumber = sellerBusinessRegistrationNumber;
    }

    public Seller(double sellerProfit, String sellerUsername, String sellerEmail, String sellerPhoneNumber, String sellerBankAccount, String sellerAddress, String sellerPassword, String sellerIC, String sellerBusinessRegistrationNumber) {
        this.sellerProfit = sellerProfit;
        this.sellerPhoneNumber = sellerPhoneNumber;
        this.sellerBankAccount = sellerBankAccount;
        this.sellerAddress = sellerAddress;
        this.sellerIC = sellerIC;
        this.sellerBusinessRegistrationNumber = sellerBusinessRegistrationNumber;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public double getSellerProfit() {
        return sellerProfit;
    }

    public void setSellerProfit(double sellerProfit) {
        this.sellerProfit = sellerProfit;
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

    public ArrayList<Transaction> getSellerTransaction() {
        return this.sellerTransactions;
    }

    public void setSellerTransaction(ArrayList<Transaction> sellerTransactions) {
        this.sellerTransactions = sellerTransactions;
    }
}
