package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public interface CartDao {

    public ArrayList<Cart> getListOfCartOfThisCustomer(int cartCustomerID);
    public void updateCart(Cart cart);
    public void deleteCart(int cartID);
    public void addCart(Cart cart);


}
