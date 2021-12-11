package com.java.JAVA_ASSIGNMENT;

public class Orders {

    String orderStatus;
    String orderID;
    String orderDate;
    String orderCustomerUserName;
    boolean orderReceivedOrNot;
    String orderTrackingID;
    boolean orderRatedOrNot;
    String orderSellerUsername;
    Product orderProduct;
    int orderQuantity;

    public Orders() {
    }

    public Orders(String orderStatus, String orderID, String orderDate, String orderCustomerUserName, boolean orderReceivedOrNot, String orderTrackingID, boolean orderRatedOrNot, String orderSellerUsername, Product orderProduct, int orderQuantity) {
        this.orderStatus = orderStatus;
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderCustomerUserName = orderCustomerUserName;
        this.orderReceivedOrNot = orderReceivedOrNot;
        this.orderTrackingID = orderTrackingID;
        this.orderRatedOrNot = orderRatedOrNot;
        this.orderSellerUsername = orderSellerUsername;
        this.orderProduct = orderProduct;
        this.orderQuantity = orderQuantity;

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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }


    public String getOrderCustomerUserName() {
        return orderCustomerUserName;
    }

    public void setOrderCustomerUserName(String orderCustomerUserName) {
        this.orderCustomerUserName = orderCustomerUserName;
    }

    public boolean isOrderReceivedOrNot() {
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

    public boolean isOrderRatedOrNot() {
        return orderRatedOrNot;
    }

    public void setOrderRatedOrNot(boolean orderRatedOrNot) {
        this.orderRatedOrNot = orderRatedOrNot;
    }

    public String getOrderSellerUsername() {
        return orderSellerUsername;
    }

    public void setOrderSellerUsername(String orderSellerUsername) {
        this.orderSellerUsername = orderSellerUsername;
    }

    public Product getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(Product orderProduct) {
        this.orderProduct = orderProduct;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}
