package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public interface OrdersDao {

    public ArrayList<Orders> getListOfOrdersOfCustomer (int sessionCustomerID);
    public ArrayList<Orders> getListOfOrdersOfSeller (int sessionSellerID);
    public Orders getOrders(int orderID);
    public void updateOrders(Orders order);
    public void deleteOrders(Orders order);
    public void addOrders(Orders order);



}
