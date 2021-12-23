package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class Product {


    private int productID;
    private String productName;
    private String productDescription;
    private String productCategory;
    private double productPrice;
    private int productStockCount;
    private int productSalesCount;
    private int productSellerID;

    public Product() {
    }

    public Product(int productID,String productName, String productDescription, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;

    }

    public Product(int productSellerID, int productID,String productName, String productDescription, String productCategory ,double productPrice, int productStockCount, int productSalesCount) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productStockCount = productStockCount;
        this.productSalesCount = productSalesCount;
        this.productCategory = productCategory;
        this.productSellerID = productSellerID;

    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
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

    public int getProductSellerID() {
        return productSellerID;
    }

    public void setProductSellerID(int productSellerID) {
        this.productSellerID = productSellerID;
    }



}


