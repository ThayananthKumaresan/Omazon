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

    @Override
    public ArrayList<Favorites> getListOfFavorites(String customerUsername) {

        ArrayList<Favorites> listOfFavoritesOfThisSeller = new ArrayList<>();

        for (int i = 0; i < userFavoritesDatabase.size(); i++) {
            if (userFavoritesDatabase.get(i).getFavoritesUser().equals(customerUsername)) {
                listOfFavoritesOfThisSeller.add(userFavoritesDatabase.get(i));
            }
        }

        if(listOfFavoritesOfThisSeller.size()==0 ){
            return null;
        }else{
            return listOfFavoritesOfThisSeller;
        }
    }


}
