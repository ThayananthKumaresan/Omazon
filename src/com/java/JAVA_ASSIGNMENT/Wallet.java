package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class Wallet {

    double walletBalance;
    ArrayList<WalletTransaction> userWalletTransaction ;

    public Wallet() {
        this.walletBalance = 0.0;
        this.userWalletTransaction = new ArrayList<>();
    }

    //TODO : Note to Thaya - Later think of how you can retrive the initial data. Can be either file or database.
//    public Wallet(String username) { // Ignore this
//        this.walletBalance = 88.00; // retrieve from database or file
//        userWalletTransaction = null; // // retrieve from database or file
//    }


    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public ArrayList<com.java.JAVA_ASSIGNMENT.WalletTransaction> getWalletTransaction() {
        return userWalletTransaction;
    }

    public void addWalletTransaction(WalletTransaction addWalletTransaction) {
        userWalletTransaction.add(addWalletTransaction);
    }




}
