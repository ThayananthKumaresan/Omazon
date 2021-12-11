package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public interface CartDao {

    public ArrayList<Cart> getCart(String cartUser);
    public void updateCart(Cart cart);
    public void deleteCart(Cart cart);
    public void addCart(Cart cart);



}
