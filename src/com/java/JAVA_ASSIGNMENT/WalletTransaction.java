package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class WalletTransaction {

    String transactionID;
    double transactionAmount;
    String transactionDateTime;
    String customerName;

    public WalletTransaction() {
    }

    public WalletTransaction(String transactionID, double transactionAmount, String transactionDateTime, String customerName) {
        this.transactionID = transactionID;
        this.transactionAmount = transactionAmount;
        this.transactionDateTime = transactionDateTime;
        this.customerName = customerName;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }
}
