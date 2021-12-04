package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;
import java.util.Date;

public class WalletTransaction {

    String transactionID;
    double transactionAmount;
    ArrayList<Orders> ListofOrdersForTransaction = new ArrayList<>();
    String transactionDateTime;

    public WalletTransaction() {
    }

    public WalletTransaction(String transactionID, double transactionAmount, ArrayList<Orders> listofOrdersForTransaction, String transactionDateTime) {
        this.transactionID = transactionID;
        this.transactionAmount = transactionAmount;
        ListofOrdersForTransaction = listofOrdersForTransaction;
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

    public ArrayList<Orders> getListofOrdersForTransaction() {
        return ListofOrdersForTransaction;
    }

    public void setListofOrdersForTransaction(ArrayList<Orders> listofOrdersForTransaction) {
        ListofOrdersForTransaction = listofOrdersForTransaction;
    }

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }
}
