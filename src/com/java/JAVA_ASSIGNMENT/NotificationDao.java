package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public interface NotificationDao {

    public void deleteNotification(Notification notification);
    public void addNotification (Notification  notification);
    public ArrayList<Notification> getListOfNotificationOfSeller ( String sellerUsername);
    public void updateNotification (Notification  notification);


}
