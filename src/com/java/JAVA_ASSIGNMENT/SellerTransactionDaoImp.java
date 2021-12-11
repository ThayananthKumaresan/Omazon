package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class SellerTransactionDaoImp implements SellerTransactionDao{

    public static ArrayList<SellerTransaction> sellerTransactionDatabase= new ArrayList<>();


    @Override
    public void addSellerTransaction(SellerTransaction transaction) {

        sellerTransactionDatabase.add(transaction);
    }

    @Override
    public ArrayList<SellerTransaction>  getListOfSellerTransaction(String sellerUsername) {

        ArrayList<SellerTransaction> listOfSellerTransaction = new ArrayList<>();

        for (int i = 0; i < sellerTransactionDatabase.size(); i++) {
            if (sellerTransactionDatabase.get(i).getSellerUsername().equals(sellerUsername)) {

                listOfSellerTransaction.add(sellerTransactionDatabase.get(i));
            }
        }

        if(listOfSellerTransaction.size()==0 ){
            return null;
        }else{
            return listOfSellerTransaction;
        }


    }
}
