package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public interface OrderDao {

    public ArrayList<Orders> getListOfOrdersOfCustomer (String sessionCustomerUsername);
    public ArrayList<Orders> getListOfOrdersOfSeller (String sessionSellerUsername);
    public Orders getOrders(String orderID);
    public void updateOrders(Orders order);
    public void deleteOrders(Orders order);
    public void addOrders(Orders order);



}
