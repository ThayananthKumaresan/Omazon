package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;
import java.util.Date;

public class Orders {

    String orderStatus;
    String orderID;
    Date orderDate;
    double orderTotalPaid;
    ArrayList<Cart> orderCart;
    String orderCustomerName;
    String orderReceivedOrNot;
    String orderTrackingID;
    String orderRatedOrNot;
    String orderSellerUsername;

    public Orders() {
    }

    public Orders(String orderStatus, String orderID, Date orderDate, double orderTotalPaid, ArrayList<Cart> orderCart, String orderCustomerName, String orderReceivedOrNot, String orderTrackingID, String orderRatedOrNot, String orderSellerUsername) {
        this.orderStatus = orderStatus;
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderTotalPaid = orderTotalPaid;
        this.orderCart = orderCart;
        this.orderCustomerName = orderCustomerName;
        this.orderReceivedOrNot = orderReceivedOrNot;
        this.orderTrackingID = orderTrackingID;
        this.orderRatedOrNot = orderRatedOrNot;
        this.orderSellerUsername = orderSellerUsername;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderTotalPaid() {
        return orderTotalPaid;
    }

    public void setOrderTotalPaid(double orderTotalPaid) {
        this.orderTotalPaid = orderTotalPaid;
    }

    public ArrayList<Cart> getOrderCart() {
        return orderCart;
    }

    public void setOrderCart(ArrayList<Cart> orderCart) {
        this.orderCart = orderCart;
    }

    public String getOrderCustomerName() {
        return orderCustomerName;
    }

    public void setOrderCustomerName(String orderCustomerName) {
        this.orderCustomerName = orderCustomerName;
    }

    public String getOrderCustomer() {
        return orderCustomerName;
    }

    public void setOrderCustomer(String orderCustomerName) {
        this.orderCustomerName = orderCustomerName;
    }

    public String getOrderReceivedOrNot() {
        return orderReceivedOrNot;
    }

    public void setOrderReceivedOrNot(String orderReceivedOrNot) {
        this.orderReceivedOrNot = orderReceivedOrNot;
    }

    public String getOrderTrackingID() {
        return orderTrackingID;
    }

    public void setOrderTrackingID(String orderTrackingID) {
        this.orderTrackingID = orderTrackingID;
    }

    public String getOrderRatedOrNot() {
        return orderRatedOrNot;
    }

    public void setOrderRatedOrNot(String orderRatedOrNot) {
        this.orderRatedOrNot = orderRatedOrNot;
    }

    public String getOrderSellerUsername() {
        return orderSellerUsername;
    }

    public void setOrderSellerUsername(String orderSellerUsername) {
        this.orderSellerUsername = orderSellerUsername;
    }
}
