package com.java.JAVA_ASSIGNMENT;

import static com.java.JAVA_ASSIGNMENT.Main.sessionCustomer;

public class WalletDaoImp implements WalletDao{
    @Override
    public void updateWalletBalance(double paidAmount) {
        sessionCustomer.getUserWallet().setWalletBalance(sessionCustomer.getUserWallet().getWalletBalance() -paidAmount );

    }

    @Override
    public void topUpWalletBalance(double topUpAmount) {

    }
}
