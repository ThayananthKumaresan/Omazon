package com.java.JAVA_ASSIGNMENT;


import java.util.ArrayList;

public class Favorites {

    Product favoritesProduct;
    String favoritesUser;

    public Favorites() {
    }

    public Favorites(Product favoritesProduct, String favoritesUser) {
        this.favoritesProduct = favoritesProduct;
        this.favoritesUser = favoritesUser;
    }

    public Product getFavoritesProduct() {
        return favoritesProduct;
    }

    public void setFavoritesProduct(Product favoritesProduct) {
        this.favoritesProduct = favoritesProduct;
    }

    public String getFavoritesUser() {
        return favoritesUser;
    }

    public void setFavoritesUser(String favoritesUser) {
        this.favoritesUser = favoritesUser;
    }
}
