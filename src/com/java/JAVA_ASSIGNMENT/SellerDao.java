package com.java.JAVA_ASSIGNMENT;

public interface SellerDao {


    public String getSellerUsername(int sellerID);
    public void updateSeller(Seller seller);
    public void deleteSeller(Seller seller);
    public void registerSeller(Seller seller);
    public boolean loginSeller(Seller seller);
    public void updateSellerProfit(int sellerID , double income);


}
