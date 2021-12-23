package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

import static com.java.JAVA_ASSIGNMENT.Main.sessionCustomer;
import static com.java.JAVA_ASSIGNMENT.Main.transactionDAO;

public class Wallet {

    int walletID ;
    double walletBalance;
    ArrayList<Transaction> walletTransaction ;

    public Wallet() {
        this.walletBalance = 0.0;
        this.walletTransaction = new ArrayList<>();
    }

    public int getWalletID() {
        return walletID;
    }

    public void setWalletID(int walletID) {
        this.walletID = walletID;
    }

    public void setWalletTransaction(ArrayList<Transaction> walletTransaction) {
        this.walletTransaction = walletTransaction;
    }

    public ArrayList<Transaction> getWalletTransaction() {

        return this.walletTransaction;
    }


    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }




}
