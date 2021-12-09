package com.java.JAVA_ASSIGNMENT;

public class SellerTransaction {

    String sellerTransactionID;
    double sellerTransactionAmount;
    String sellerTransactionDateTime;
    String sellerUsername;

    public SellerTransaction(String sellerTransactionID, double sellerTransactionAmount, String sellerTransactionDateTime, String sellerUsername) {
        this.sellerTransactionID = sellerTransactionID;
        this.sellerTransactionAmount = sellerTransactionAmount;
        this.sellerTransactionDateTime = sellerTransactionDateTime;
        this.sellerUsername = sellerUsername;
    }

    public String getSellerTransactionID() {
        return sellerTransactionID;
    }

    public void setSellerTransactionID(String sellerTransactionID) {
        this.sellerTransactionID = sellerTransactionID;
    }

    public double getSellerTransactionAmount() {
        return sellerTransactionAmount;
    }

    public void setSellerTransactionAmount(double sellerTransactionAmount) {
        this.sellerTransactionAmount = sellerTransactionAmount;
    }

    public String getSellerTransactionDateTime() {
        return sellerTransactionDateTime;
    }

    public void setSellerTransactionDateTime(String sellerTransactionDateTime) {
        this.sellerTransactionDateTime = sellerTransactionDateTime;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }
}
