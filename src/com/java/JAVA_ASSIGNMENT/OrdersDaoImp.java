package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class OrdersDaoImp implements OrderDao{

    public static ArrayList<Orders> orderDatabase= new ArrayList<>();


    @Override
    public ArrayList<Orders> getListOfOrdersOfCustomer(String sessionCustomerUsername) {

        ArrayList<Orders> listOfOrdersOfCustomer = new ArrayList<>();

        for (int i = 0; i < orderDatabase.size(); i++) {
            if (orderDatabase.get(i).getOrderCustomerUserName().equals(sessionCustomerUsername)) {
                listOfOrdersOfCustomer.add(orderDatabase.get(i));
            }
        }

        if(listOfOrdersOfCustomer.size()==0 ){
            return null;
        }else{
            return listOfOrdersOfCustomer;
        }
    }

    @Override
    public ArrayList<Orders> getListOfOrdersOfSeller(String sessionSellerUsername) {
        return null;
    }

    @Override
    public Orders getOrders(String orderID) {
        return null;
    }

    @Override
    public void updateOrders(Orders order) {

        for (int i = 0; i <orderDatabase.size() ; i++) {
            if(order.getOrderID().equals(orderDatabase.get(i).getOrderID())){
                orderDatabase.set(i,order);
            }
        }

    }

    @Override
    public void deleteOrders(Orders order) {

    }

    @Override
    public void addOrders(Orders order) {

    }
}
