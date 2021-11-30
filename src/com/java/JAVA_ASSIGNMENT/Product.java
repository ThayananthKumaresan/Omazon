package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class Product {


    private String productID;
    private String productName;
    private String productDescription;
    private String productCategory;
    private String productSellerUsername;
    private double productPrice;
    private int productStockCount;
    private int productSalesCount;


    public Product() {
    }

    public Product(String productID,String productName, String productDescription, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;

    }

    public Product(String productID,String productName, String productDescription, String productCategory ,String productSellerUsername, double productPrice, int productStockCount, int productSalesCount) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productStockCount = productStockCount;
        this.productSalesCount = productSalesCount;
        this.productCategory = productCategory;
        this.productSellerUsername = productSellerUsername;

    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStockCount() {
        return productStockCount;
    }

    public void setProductStockCount(int productStockCount) {
        this.productStockCount = productStockCount;
    }

    public int getProductSalesCount() {
        return productSalesCount;
    }

    public void setProductSalesCount(int productSalesCount) {
        this.productSalesCount = productSalesCount;
    }

    public String getProductSellerUsername() {
        return productSellerUsername;
    }

    public void setProductSellerUsername(String productSellerUsername) {
        this.productSellerUsername = productSellerUsername;
    }
}


