package com.java.JAVA_ASSIGNMENT;

import java.util.Date;

public class WalletTransaction {

    String transactionID;
    double transactionAmount;
    String transactionSellerName;
    String transactionOrderID;
    Date transactionDateTime;

    public WalletTransaction(String transactionID, double transactionAmount, String transactionSellerName, String transactionOrderID, Date transactionDateTime) {
        this.transactionID = transactionID;
        this.transactionAmount = transactionAmount;
        this.transactionSellerName = transactionSellerName;
        this.transactionOrderID = transactionOrderID;
        this.transactionDateTime = transactionDateTime;
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

    public String getTransactionSellerName() {
        return transactionSellerName;
    }

    public void setTransactionSellerName(String transactionSellerName) {
        this.transactionSellerName = transactionSellerName;
    }

    public String getTransactionOrderID() {
        return transactionOrderID;
    }

    public void setTransactionOrderID(String transactionOrderID) {
        this.transactionOrderID = transactionOrderID;
    }

    public Date getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(Date transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public WalletTransaction() {

    }
}
