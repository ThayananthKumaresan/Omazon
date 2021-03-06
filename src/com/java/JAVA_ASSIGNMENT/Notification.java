package com.java.JAVA_ASSIGNMENT;

public class Notification {

    int notificationID ;
    int notificationSellerID;
    int notificationOrderId;
    int notificationCustomerID;
    int notificationProductID;


    public Notification(int notificationSellerID, int notificationOrderId, int notificationCustomerID, int notificationProductID) {

        this.notificationSellerID = notificationSellerID;
        this.notificationOrderId = notificationOrderId;
        this.notificationCustomerID = notificationCustomerID;
        this.notificationProductID = notificationProductID;
    }

    public Notification() {
    }


    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public int getNotificationSellerID() {
        return notificationSellerID;
    }

    public void setNotificationSellerID(int notificationSellerID) {
        this.notificationSellerID = notificationSellerID;
    }

    public int getNotificationOrderId() {
        return notificationOrderId;
    }

    public void setNotificationOrderId(int notificationOrderId) {
        this.notificationOrderId = notificationOrderId;
    }

    public int getNotificationCustomerID() {
        return notificationCustomerID;
    }

    public void setNotificationCustomerID(int notificationCustomerID) {
        this.notificationCustomerID = notificationCustomerID;
    }

    public int getNotificationProductID() {
        return notificationProductID;
    }

    public void setNotificationProductID(int notificationProductID) {
        this.notificationProductID = notificationProductID;
    }
}
