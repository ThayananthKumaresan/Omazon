package com.java.JAVA_ASSIGNMENT;

public interface SellerDao {


    public Seller getSeller(String sellerUsername);
    public void updateSeller(Seller seller);
    public void deleteSeller(Seller seller);
    public void registerSeller(Seller seller);
    public void loginSeller(Seller seller);
    public void updateSellerProfit(String sellerUsername , double income);
    public void getSellerProfitFromDatabase(Seller seller);


}
