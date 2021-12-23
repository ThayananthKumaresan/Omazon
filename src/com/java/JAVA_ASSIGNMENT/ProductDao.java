package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public interface ProductDao {

    public Product getProduct(int productID);
    public String getProductSellerUsername(int productID);

    public ArrayList<Product> getListOfProductsOfThisSeller(int sellerID);
    public void updateProduct(Product product);
    public void deleteProduct(Product product);
    public void addProduct(Product product);
    public void addProductStock(Product product, int stockCountToAdd);
    public void reduceProductStock(Product product,int stockCountToReduce);
    public void addProductSalesCount(Product product, int salesCountToAdd);
    public ArrayList<Product>  getListOfAllProduct ();
    public ArrayList<Product> getTop3SellingProduct();
    public ArrayList<Product> getListOfProductsBasedOnCategory(String categoryName);



}
