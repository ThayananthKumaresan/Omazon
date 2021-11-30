package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

import static com.java.JAVA_ASSIGNMENT.Main.sessionCustomer;

public class WalletTransactionDaoImp implements WalletTransactionDao {
    @Override
    public void addWalletTransaction(WalletTransaction transaction) {
        sessionCustomer.getUserWallet().addWalletTransaction(transaction);

    }

    @Override
    public ArrayList<WalletTransaction> getWalletTransaction() {

        ArrayList<WalletTransaction> listOfTransaction = sessionCustomer.getUserWallet().getWalletTransaction();
        return listOfTransaction;
    }
}
