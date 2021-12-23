package com.java.JAVA_ASSIGNMENT;

import java.sql.*;
import java.util.ArrayList;

public class NotificationDaoImp implements NotificationDao{

    public static ArrayList<Notification> sellerNotificationDatabase = new ArrayList<>();
    private static final String INSERT = "INSERT INTO notification (notificationSellerID ,notificationOrderId,notificationCustomerName,notificationProductName) VALUES (?,?,?,?)";
    private static final String FIND_LIST_OF_NOTIFICATION_BY_SELLER = "SELECT * FROM notification WHERE notificationSellerID=?";
    private static final String UPDATE = "UPDATE notification SET notificationReadOrNot=? WHERE notificationID=?";
    private static final String DELETE = "DELETE FROM notification WHERE notificationID=?";

    @Override
    public void deleteNotification(int notificationID) {

        PreparedStatement stmnt = null;
        Connection conn = null;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(DELETE);
            stmnt.setInt(1, notificationID);

            stmnt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (stmnt != null) stmnt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void addNotification(Notification notification) {
        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            stmnt.setInt(1, notification.getNotificationSellerID());
            stmnt.setInt(2, notification.getNotificationOrderId());
            stmnt.setString(3, notification.getNotificationCustomerName());
            stmnt.setString(4, notification.getNotificationProductName());

            stmnt.executeUpdate(); // Executing the sql query

            rs = stmnt.getGeneratedKeys();

            if (rs.next()) {
                notification.setNotificationID(rs.getInt(1)); //Setting the product ID
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    }

    @Override
    public ArrayList<Notification> getListOfNotificationOfSeller(int sellerID) {


        ArrayList<Notification> listOfNotificationOfThisSeller = new ArrayList<>();

        for (int i = 0; i < sellerNotificationDatabase.size(); i++) {
            if (sellerNotificationDatabase.get(i).getNotificationSellerID() == sellerID) {
                listOfNotificationOfThisSeller.add(sellerNotificationDatabase.get(i));
            }
        }


        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;
        Notification notification = new Notification();

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_LIST_OF_NOTIFICATION_BY_SELLER);

            stmnt.setInt(1, sellerID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                notification.setNotificationSellerID(rs.getInt("notificationSellerID"));
                notification.setNotificationID(rs.getInt("notificationID"));
                notification.setNotificationOrderId(rs.getInt("notificationOrderId"));
                notification.setNotificationProductName(rs.getString("notificationProductName"));
                notification.setNotificationCustomerName(rs.getString("notificationCustomerName"));
                listOfNotificationOfThisSeller.add(notification);
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }



        if(listOfNotificationOfThisSeller.size()==0 ){
            return null;
        }else{
            return listOfNotificationOfThisSeller;
        }


    }


}
