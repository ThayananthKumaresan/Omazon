package com.java.JAVA_ASSIGNMENT;

public class Notification {

   boolean notificationReadOrNot;
   String notificationSellerUsername;
    String notificationOrderId;
    String notificationCustomerName;
    String notificationProductName;

    public Notification(boolean notificationReadOrNot,String notificationSellerUsername, String notificationOrderId, String notificationCustomerName, String notificationProductName) {

        this.notificationReadOrNot = notificationReadOrNot;
        this.notificationSellerUsername = notificationSellerUsername;
        this.notificationOrderId = notificationOrderId;
        this.notificationCustomerName = notificationCustomerName;
        this.notificationProductName = notificationProductName;
    }

    public boolean isNotificationReadOrNot() {
        return notificationReadOrNot;
    }

    public void setNotificationReadOrNot(boolean notificationReadOrNot) {
        this.notificationReadOrNot = notificationReadOrNot;
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
