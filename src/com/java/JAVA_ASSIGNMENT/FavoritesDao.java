package com.java.JAVA_ASSIGNMENT;

public interface FavoritesDao {

    public Favorites getFavorites(String favoritesUser);
    public void updateFavorites(Favorites favorite);
    public void deleteFavorites(Favorites favorite);
    public void addFavorites(Favorites favorite);



}
