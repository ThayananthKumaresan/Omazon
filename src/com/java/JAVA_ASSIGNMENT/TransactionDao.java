package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public interface TransactionDao {


    public void addTransaction(Transaction transaction);
    public ArrayList<Transaction>  getListOfSellerTransactionOfThisSeller(int sellerID);
    public ArrayList<Transaction>  getListOfSellerTransactionOfThisCustomer(int customerID);

}
