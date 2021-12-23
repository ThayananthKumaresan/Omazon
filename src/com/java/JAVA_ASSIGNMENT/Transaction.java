package com.java.JAVA_ASSIGNMENT;

public class Transaction {

    int transactionID;
    double transactionAmount;
    String transactionDateTime;
    int userID;

    public Transaction(double transactionAmount, String transactionDateTime, int userID) {
        this.transactionAmount = transactionAmount;
        this.transactionDateTime = transactionDateTime;
        this.userID = userID;
    }

    public Transaction() {
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
