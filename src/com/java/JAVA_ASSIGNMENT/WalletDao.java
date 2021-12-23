package com.java.JAVA_ASSIGNMENT;

public interface WalletDao {

    public void reduceWalletBalance(Wallet customerWallet,double paidAmount);
    public void topUpWalletBalance(Wallet customerWallet,double topUpAmount);
    public Wallet  getCustomerWallet (int customerID);
    public void  createWallet (int customerID);



}
