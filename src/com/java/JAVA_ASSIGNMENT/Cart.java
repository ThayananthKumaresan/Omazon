package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class Cart {

    Product cartProduct;
    int cartQuantity;
    String cartUser;


    public Cart() {
    }

    public Cart(Product cartProduct, int cartQuantity, String cartUser) {
        this.cartProduct = cartProduct;
        this.cartQuantity = cartQuantity;
        this.cartUser = cartUser;
    }

    public Product getCartProduct() {
        return cartProduct;
    }

    public void setCartProduct(Product cartProduct) {
        this.cartProduct = cartProduct;
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
