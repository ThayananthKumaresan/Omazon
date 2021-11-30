package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public interface WalletTransactionDao {

    public void addWalletTransaction(WalletTransaction transaction);
    public ArrayList<WalletTransaction> getWalletTransaction();

}
