package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public interface ProductDao {

    public Product getProduct(String productID);
    public void updateProduct(Product product);
    public void deleteProduct(Product product);
    public void addProduct(Product product);
    public ArrayList<Product> getTop3SellingProduct();



}
