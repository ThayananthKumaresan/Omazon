package com.java.JAVA_ASSIGNMENT;

public class Orders {

    int orderID;
    String orderStatus;
    String orderDate;
    int orderQuantity;
    String orderTrackingID;

    boolean orderReceivedOrNot;
    boolean orderRatedOrNot;

    int orderSellerID;
    int orderProductID;
    int orderCustomerID;

    public Orders() {
    }

    public Orders(String orderStatus, String orderDate,
                  int orderCustomerID, boolean orderReceivedOrNot,
                  String orderTrackingID, boolean orderRatedOrNot,
                  int orderSellerID, int orderProductID,
                  int orderQuantity) {
        this.orderStatus = orderStatus;
        this.orderID = 0;
        this.orderDate = orderDate;
        this.orderCustomerID = orderCustomerID;
        this.orderReceivedOrNot = orderReceivedOrNot;
        this.orderTrackingID = orderTrackingID;
        this.orderRatedOrNot = orderRatedOrNot;
        this.orderSellerID = orderSellerID;
        this.orderProductID = orderProductID;
        this.orderQuantity = orderQuantity;

    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }


    public int getOrderCustomerID() {
        return orderCustomerID;
    }

    public void setOrderCustomerID(int orderCustomerID) {
        this.orderCustomerID = orderCustomerID;
    }

    public boolean getOrderReceivedOrNot() {
        return orderReceivedOrNot;
    }

    public void setOrderReceivedOrNot(boolean orderReceivedOrNot) {
        this.orderReceivedOrNot = orderReceivedOrNot;
    }

    public String getOrderTrackingID() {
        return orderTrackingID;
    }

    public void setOrderTrackingID(String orderTrackingID) {
        this.orderTrackingID = orderTrackingID;
    }

    public boolean getOrderRatedOrNot() {
        return orderRatedOrNot;
    }

    public void setOrderRatedOrNot(boolean orderRatedOrNot) {
        this.orderRatedOrNot = orderRatedOrNot;
    }

    public int getOrderSellerID() {
        return orderSellerID;
    }

    public void setOrderSellerID(int orderSellerID) {
        this.orderSellerID = orderSellerID;
    }

    public int getOrderProductID() {
        return orderProductID;
    }

    public void setOrderProductID(int orderProductID) {
        this.orderProductID = orderProductID;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}
