package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class NotificationDaoImp implements NotificationDao{

    public static ArrayList<Notification> sellerNotificationDatabase = new ArrayList<>();

    @Override
    public void deleteNotification(Notification notification) {

    }

    @Override
    public void addNotification(Notification notification) {



    }

    @Override
    public ArrayList<Notification> getListOfNotificationOfSeller(String sellerUsername) {


        ArrayList<Notification> listOfNotificationOfThisSeller = new ArrayList<>();

        for (int i = 0; i < sellerNotificationDatabase.size(); i++) {
            if (sellerNotificationDatabase.get(i).getNotificationSellerUsername().equals(sellerUsername)) {
                listOfNotificationOfThisSeller.add(sellerNotificationDatabase.get(i));
            }
        }

        if(listOfNotificationOfThisSeller.size()==0 ){
            return null;
        }else{
            return listOfNotificationOfThisSeller;
        }


    }

    @Override
    public void updateNotification(Notification notification) {

        for (int j = 0; j < sellerNotificationDatabase.size(); j++) {

            if (notification.getNotificationOrderId().equals(sellerNotificationDatabase.get(j).getNotificationOrderId())) {
                sellerNotificationDatabase.set(j,notification);
            }
        }
    }
}
