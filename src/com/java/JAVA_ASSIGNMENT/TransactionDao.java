package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public interface TransactionDao {


    public void addTransaction(Transaction transaction);
    public ArrayList<Transaction> getListOfSellerTransaction(int sellerID);
    public ArrayList<Transaction> getListOfCustomerTransaction(int customerID);

}
