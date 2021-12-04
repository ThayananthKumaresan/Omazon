package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

import static com.java.JAVA_ASSIGNMENT.Main.sessionCustomer;

public class CartDaoImp implements CartDao{

    public static ArrayList<Cart> userCartDatabase = new ArrayList<>();


    @Override
    public  ArrayList<Cart> getCart(String cartUser) {

        ArrayList<Cart> cartDetailsOfThisUser = new ArrayList<>();
        for (Cart cart : userCartDatabase) {
            if (cart.getCartUser().equals(sessionCustomer.getUsername())) {
                cartDetailsOfThisUser.add(cart);
            }
        }
        return cartDetailsOfThisUser;
    }

    @Override
    public void updateCart(Cart cart) {

    }

    @Override
    public void deleteCart(Cart cart) {

        userCartDatabase.remove(cart);

    }

    @Override
    public void addCart(Cart cart) {

        userCartDatabase.add(cart);

    }
}
