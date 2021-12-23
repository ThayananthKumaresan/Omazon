package com.java.JAVA_ASSIGNMENT;

public class Notification {

    int notificationID ;
    int notificationSellerID;
    int notificationOrderId;
    String notificationCustomerName;
    String notificationProductName;


    public Notification(int notificationSellerID, int notificationOrderId, String notificationCustomerName, String notificationProductName) {

        this.notificationSellerID = notificationSellerID;
        this.notificationOrderId = notificationOrderId;
        this.notificationCustomerName = notificationCustomerName;
        this.notificationProductName = notificationProductName;
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

    public String getNotificationCustomerName() {
        return notificationCustomerName;
    }

    public void setNotificationCustomerName(String notificationCustomerName) {
        this.notificationCustomerName = notificationCustomerName;
    }

    public String getNotificationProductName() {
        return notificationProductName;
    }

    public void setNotificationProductName(String notificationProductName) {
        this.notificationProductName = notificationProductName;
    }
}
