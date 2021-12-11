package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class Cart {

    String cartProductID;
    int cartQuantity;
    String cartUser;


    public Cart() {
    }

    public Cart(String cartProductID, int cartQuantity, String cartUser) {
        this.cartProductID = cartProductID;
        this.cartQuantity = cartQuantity;
        this.cartUser = cartUser;
    }

    public String getCartProductID() {
        return cartProductID;
    }

    public void setCartProductID(String cartProduct) {
        this.cartProductID = cartProductID;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public String getCartUser() {
        return cartUser;
    }

    public void setCartUser(String cartUser) {
        this.cartUser = cartUser;
    }
}
