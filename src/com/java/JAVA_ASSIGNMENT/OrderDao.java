package com.java.JAVA_ASSIGNMENT;

public interface OrderDao {

    public Orders getOrders(String orderID);
    public void updateOrders(Orders order);
    public void deleteOrders(Orders order);
    public void addOrders(Orders order);



}
