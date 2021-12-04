package com.java.JAVA_ASSIGNMENT;

public class Notification {

    String notificationSellerUsername;
    String notificationOrderId;
    String notificationCustomerName;
    String notificationProductName;

    public Notification(String notificationSellerUsername, String notificationOrderId, String notificationCustomerName, String notificationProductName) {
        this.notificationSellerUsername = notificationSellerUsername;
        this.notificationOrderId = notificationOrderId;
        this.notificationCustomerName = notificationCustomerName;
        this.notificationProductName = notificationProductName;
    }

    public String getNotificationSellerUsername() {
        return notificationSellerUsername;
    }

    public void setNotificationSellerUsername(String notificationSellerUsername) {
        this.notificationSellerUsername = notificationSellerUsername;
    }

    public String getNotificationOrderId() {
        return notificationOrderId;
    }

    public void setNotificationOrderId(String notificationOrderId) {
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
