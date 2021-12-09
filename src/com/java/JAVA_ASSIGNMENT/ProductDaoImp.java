package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;
import java.util.UUID;

public class ProductDaoImp implements ProductDao{

    public static ArrayList<Product> productDatabase= new ArrayList<>();



    @Override
    public Product getProduct(String productID) {

        for (int i = 0; i < productDatabase.size(); i++) {
            if (productDatabase.get(i).getProductID().equals(productID)) {
                return productDatabase.get(i);
            }
        }
        return null;

    }

    @Override
    public ArrayList<Product> getListOfProductsOfThisSeller(String sellerUsername) {

        ArrayList<Product> listOfProductOfThisSeller = new ArrayList<>();

        for (int i = 0; i < productDatabase.size(); i++) {
            if (productDatabase.get(i).getProductSellerUsername().equals(sellerUsername)) {
                listOfProductOfThisSeller.add(productDatabase.get(i));
            }
        }

        if(listOfProductOfThisSeller.size()==0 ){
            return null;
        }else{
            return listOfProductOfThisSeller;
        }
    }

    @Override
    public String generateProductID() {

        return UUID.randomUUID().toString().substring(0,4);
    }


    @Override
    public void updateProduct(Product product) {

        for (int j = 0; j < productDatabase.size(); j++) {

            if (product.getProductID().equals(productDatabase.get(j).getProductID())) {
                productDatabase.set(j,product);
            }
        }
    }

    @Override
    public void deleteProduct(Product product) {
        productDatabase.remove(product);

    }

    @Override
    public void addProduct(Product product) {

        productDatabase.add(product);

    }

    @Override
    public void addProductStock(Product product , int stockCountToAdd) {

        for (int j = 0; j < productDatabase.size(); j++) {

            if (product.getProductID().equals(productDatabase.get(j).getProductID())) {
                productDatabase.get(j).setProductStockCount(productDatabase.get(j).getProductStockCount() + stockCountToAdd);
            }
        }

    }

    @Override
    public void reduceProductStock(Product product ,int stockCountToReduce) {

        for (int j = 0; j < productDatabase.size(); j++) {

            if (product.getProductID().equals(productDatabase.get(j).getProductID())) {
                productDatabase.get(j).setProductStockCount(productDatabase.get(j).getProductStockCount() - stockCountToReduce);
            }
        }
    }

    @Override
    public void addProductSalesCount(Product product, int salesCountToAdd) {
        //todo GET PRODUCT KENA IMPLEMENT KE ??
        for (int j = 0; j < productDatabase.size(); j++) {

            if (product.getProductID().equals(productDatabase.get(j).getProductID())) {
                productDatabase.get(j).setProductSalesCount(productDatabase.get(j).getProductSalesCount() + salesCountToAdd);
            }
        }
    }

    @Override
    public ArrayList<Product>  getListOfAllProduct() {

        return productDatabase;
    }


    @Override
    public ArrayList<Product> getTop3SellingProduct() {


        int n = productDatabase.size();
        Product tempProduct;
        for(int i=0; i < n; i++){

            for(int j=1; j < (n-i); j++){
                if(productDatabase.get(j-1).getProductSalesCount() > productDatabase.get(j).getProductSalesCount()) {
                    //swap elements
                    tempProduct = productDatabase.get(j-1);
                    productDatabase.set(j-1,productDatabase.get(j));
                    productDatabase.set(j,tempProduct);
                }

            }
        }
        ArrayList<Product> top3SellingProducts = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            top3SellingProducts.add( productDatabase.get(i));
        }

        return top3SellingProducts;
    }

    @Override
    public ArrayList<Product> getListOfProductsBasedOnCategory(String categoryName) {

        ArrayList<Product> listOfProductsBasedOnCategory = new ArrayList<>();

        for(int i=1; i < productDatabase.size(); i++){
            if(productDatabase.get(i).getProductCategory().equals(categoryName)) {
                listOfProductsBasedOnCategory.add(productDatabase.get(i));
            }
        }

        if(listOfProductsBasedOnCategory.size()==0 ){
            return null;
        }else{
            return listOfProductsBasedOnCategory;
        }
    }
}
