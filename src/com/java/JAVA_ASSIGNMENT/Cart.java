package com.java.JAVA_ASSIGNMENT;

public class Cart {

    int cartID;
    int cartProductID;
    int cartCustomerID;
    int cartQuantity;

    public Cart() {
    }

    public Cart(int cartProductID, int cartQuantity, int cartCustomerID) {
        this.cartProductID = cartProductID;
        this.cartQuantity = cartQuantity;
        this.cartCustomerID = cartCustomerID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getCartCustomerID() {
        return cartCustomerID;
    }

    public void setCartCustomerID(int cartCustomerID) {
        this.cartCustomerID = cartCustomerID;
    }

    public int getCartProductID() {
        return cartProductID;
    }

    public void setCartProductID(int cartProductID) {
        this.cartProductID = cartProductID;
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

}
