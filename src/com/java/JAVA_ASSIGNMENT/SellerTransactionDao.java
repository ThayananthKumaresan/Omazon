package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public interface SellerTransactionDao {


    public void addSellerTransaction(SellerTransaction transaction);
    public ArrayList<SellerTransaction>  getListOfSellerTransaction(String sellerUsername);

}
