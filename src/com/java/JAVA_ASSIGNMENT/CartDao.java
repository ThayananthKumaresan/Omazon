package com.java.JAVA_ASSIGNMENT;

public interface CartDao {

    public Cart getCart(String orderID);
    public void updateCart(Cart cart);
    public void deleteCart(Cart cart);
    public void addCart(Cart cart);



}
