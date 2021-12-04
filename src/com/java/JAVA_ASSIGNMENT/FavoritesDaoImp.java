package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class FavoritesDaoImp implements FavoritesDao{

    public static ArrayList<Favorites> userFavoritesDatabase= new ArrayList<>();


    @Override
    public Favorites getFavorites(String favoritesUser) {
        return null;
    }

    @Override
    public void updateFavorites(Favorites favorite) {

    }

    @Override
    public void deleteFavorites(Favorites favorite) {

    }

    @Override
    public void addFavorites(Favorites favorite) {
        userFavoritesDatabase.add(favorite);

    }
}
