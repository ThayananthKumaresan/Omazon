package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public interface FavoritesDao {

    public Favorites getFavorites(String favoritesUser);
    public void updateFavorites(Favorites favorite);
    public void deleteFavorites(Favorites favorite);
    public void addFavorites(Favorites favorite);
    public ArrayList<Favorites> getListOfFavorites(String customerUsername);



}
