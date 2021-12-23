package com.java.JAVA_ASSIGNMENT;


public class Favorites {

    int favoriteID;
    int favoritesProductID;
    int favoritesCustomerID;


    public Favorites(int favoritesProductID, int favoritesCustomerID) {
        this.favoritesProductID = favoritesProductID;
        this.favoritesCustomerID = favoritesCustomerID;
    }

    public Favorites() {
        this.favoritesProductID = 0;
        this.favoritesCustomerID = 0;
    }

    public int getFavoritesProductID() {
        return favoritesProductID;
    }

    public void setFavoritesProductID(int favoritesProductID) {
        this.favoritesProductID = favoritesProductID;
    }

    public int getFavoritesCustomerID() {
        return favoritesCustomerID;
    }

    public void setFavoritesCustomerID(int favoritesCustomerID) {
        this.favoritesCustomerID = favoritesCustomerID;
    }

    public int getFavoriteID() {
        return favoriteID;
    }

    public void setFavoriteID(int favoriteID) {
        this.favoriteID = favoriteID;
    }
}
