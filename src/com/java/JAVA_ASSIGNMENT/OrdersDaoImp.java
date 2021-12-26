package com.java.JAVA_ASSIGNMENT;

import java.sql.*;
import java.util.ArrayList;

public class OrdersDaoImp implements OrdersDao {

    public static ArrayList<Orders> orderDatabase= new ArrayList<>();
    private static final String FIND_LIST_OF_ORDERS_BY_CUSTOMER = "SELECT * FROM orders WHERE orderCustomerID=?";
    private static final String FIND_LIST_OF_ORDERS_BY_SELLER = "SELECT * FROM orders WHERE orderSellerID=?";
    private static final String FIND_BY_ID = "SELECT * FROM orders WHERE orderID =?";
    private static final String INSERT = "INSERT INTO orders (orderDate, " +
            "orderCustomerID, orderReceivedOrNot, orderTrackingID, orderRatedOrNot, " +
            "orderSellerID ,orderProductID ,orderQuantity,orderStatus) VALUES (?,?,?,?,?,?,?,?,?)";

    private static final String UPDATE = "UPDATE orders SET orderStatus=?,orderTrackingID=?,orderReceivedOrNot=?,orderRatedOrNot=? WHERE orderID=?";


    @Override
    public ArrayList<Orders> getListOfOrdersOfCustomer(int sessionCustomerID) {

        ArrayList<Orders> listOfOrdersOfCustomer = new ArrayList<>();

        for (int i = 0; i < orderDatabase.size(); i++) {
            if (orderDatabase.get(i).getOrderCustomerID() == sessionCustomerID) {
                listOfOrdersOfCustomer.add(orderDatabase.get(i));
            }
        }
        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_LIST_OF_ORDERS_BY_CUSTOMER);

            stmnt.setInt(1, sessionCustomerID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                Orders orders = new Orders();
                orders.setOrderID(rs.getInt("orderID"));
                orders.setOrderProductID(rs.getInt("orderProductID"));
                orders.setOrderDate(rs.getString("orderDate"));
                orders.setOrderTrackingID(rs.getString("orderTrackingID"));
                orders.setOrderSellerID(rs.getInt("orderSellerID"));
                orders.setOrderRatedOrNot(rs.getBoolean("orderRatedOrNot"));
                orders.setOrderReceivedOrNot(rs.getBoolean("orderReceivedOrNot"));
                orders.setOrderQuantity(rs.getInt("orderQuantity"));
                orders.setOrderCustomerID(rs.getInt("orderCustomerID"));
                orders.setOrderStatus(rs.getString("orderStatus"));
                listOfOrdersOfCustomer.add(orders);
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


        if(listOfOrdersOfCustomer.size()==0 ){
            return null;
        }else{
            return listOfOrdersOfCustomer;
        }
    }

    @Override
    public ArrayList<Orders> getListOfOrdersOfSeller(int sessionSellerID) {

        ArrayList<Orders> listOfOrdersOfSeller = new ArrayList<>();


        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;
        Orders orders = new Orders();

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_LIST_OF_ORDERS_BY_SELLER);

            stmnt.setInt(1, sessionSellerID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                orders.setOrderID(rs.getInt("orderID"));
                orders.setOrderProductID(rs.getInt("orderProductID"));
                orders.setOrderDate(rs.getString("orderDate"));
                orders.setOrderTrackingID(rs.getString("orderTrackingID"));
                orders.setOrderSellerID(rs.getInt("orderSellerID"));
                orders.setOrderRatedOrNot(rs.getBoolean("orderRatedOrNot"));
                orders.setOrderReceivedOrNot(rs.getBoolean("orderReceivedOrNot"));
                orders.setOrderQuantity(rs.getInt("orderQuantity"));
                orders.setOrderCustomerID(rs.getInt("orderCustomerID"));
                orders.setOrderStatus(rs.getString("orderStatus"));
                listOfOrdersOfSeller.add(orders);
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


        if(listOfOrdersOfSeller.size()==0 ){
            return null;
        }else{
            return listOfOrdersOfSeller;
        }    }

    @Override
    public Orders getOrders(int orderID) {

        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;
        Orders orders = new Orders();

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_BY_ID);
            stmnt.setInt(1, orderID );

            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                orders.setOrderID(rs.getInt("orderID"));
                orders.setOrderProductID(rs.getInt("orderProductID"));
                orders.setOrderDate(rs.getString("orderDate"));
                orders.setOrderTrackingID(rs.getString("orderTrackingID"));
                orders.setOrderSellerID(rs.getInt("orderSellerID"));
                orders.setOrderRatedOrNot(rs.getBoolean("orderRatedOrNot"));
                orders.setOrderReceivedOrNot(rs.getBoolean("orderReceivedOrNot"));
                orders.setOrderQuantity(rs.getInt("orderQuantity"));
                orders.setOrderCustomerID(rs.getInt("orderCustomerID"));
                orders.setOrderStatus(rs.getString("orderStatus"));

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

        if(orders.getOrderDate()==null)
            return  null;
        else
            return orders;


    }

    @Override
    public void updateOrders(Orders order) {

        PreparedStatement stmnt = null;
        Connection conn = null;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(UPDATE);
            stmnt.setString(1, order.getOrderStatus());
            stmnt.setString(2, order.getOrderTrackingID());
            stmnt.setBoolean(3, order.getOrderReceivedOrNot());
            stmnt.setBoolean(4, order.getOrderRatedOrNot());
            stmnt.setInt(5, order.getOrderID());

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
    public void deleteOrders(Orders order) {

    }

    @Override
    public void addOrders(Orders order) {
        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            stmnt.setString(1, order.getOrderDate());
            stmnt.setInt(2, order.getOrderCustomerID());
            stmnt.setBoolean(3, order.getOrderReceivedOrNot());
            stmnt.setString(4, order.getOrderTrackingID());
            stmnt.setBoolean(5, order.getOrderRatedOrNot());
            stmnt.setInt(6, order.getOrderSellerID());
            stmnt.setInt(7, order.getOrderProductID());
            stmnt.setInt(8, order.getOrderQuantity());
            stmnt.setString(9, order.getOrderStatus());

            stmnt.executeUpdate(); // Executing the sql query

            rs = stmnt.getGeneratedKeys();

            if (rs.next()) {
                order.setOrderID(rs.getInt(1)); //Setting the product ID

            }
            System.out.println("Successfully added orders");

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
}
