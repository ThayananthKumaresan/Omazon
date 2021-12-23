package com.java.JAVA_ASSIGNMENT;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import static com.java.JAVA_ASSIGNMENT.Main.sessionCustomer;
import static com.java.JAVA_ASSIGNMENT.Main.walletDAO;

public class CustomerDaoImp implements CustomerDao{

    private static final String DELETE = "DELETE FROM customer WHERE customerID=?";
    private static final String FIND_BY_EMAIL_AND_PASSWORD = "SELECT * FROM customer WHERE email=? and password=?";
    private static final String INSERT = "INSERT INTO customer (userName, email, password, firstName, lastName, paymentPassword, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE customer SET userName=?, email=?, password=?, firstName=?, lastName=?, paymentPassword=?, address=? WHERE customerID=?";
    private static final String FIND_CUSTOMER_NAME = "SELECT userName FROM seller WHERE customerID=?";

    public static ArrayList<Customer> customerDatabase = new ArrayList<>();


    @Override
    public void updateCustomer(Customer cust) {

        for (int i = 0; i < customerDatabase.size(); i++) {

            if(cust.getCustomerID() == customerDatabase.get(i).getCustomerID())
            {
                customerDatabase.set(i,cust);
            }
        }

        PreparedStatement stmnt = null;
        Connection conn = null;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(UPDATE);
            stmnt.setString(1, cust.getUserName());
            stmnt.setString(2, cust.getEmail());
            stmnt.setString(3, cust.getPassword());
            stmnt.setString(4, cust.getFirstName());
            stmnt.setString(5, cust.getLastName());
            stmnt.setString(6, cust.getPaymentPassword());
            stmnt.setString(7, cust.getAddress());
            stmnt.setInt(8, cust.getCustomerID());

            stmnt.executeUpdate();
           System.out.println("Updated Successfully");

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
    public void deleteCustomer(Customer cust) {
     // todo check this
        customerDatabase.remove(cust);


        PreparedStatement stmnt = null;
        Connection conn = null;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(DELETE);
            stmnt.setInt(1, cust.getCustomerID());

            stmnt.executeUpdate();
            System.out.println("Deleted your account Successfully");

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


        sessionCustomer = null;
    }

    @Override
    public void registerCustomer(Customer cust) {

        ResultSet rs = null;
        Connection conn ;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            stmnt.setString(1, cust.getUserName());
            stmnt.setString(2, cust.getEmail());
            stmnt.setString(3, cust.getPassword());
            stmnt.setString(4, cust.getFirstName());
            stmnt.setString(5, cust.getLastName());
            stmnt.setString(6, cust.getPaymentPassword());
            stmnt.setString(7, cust.getAddress());

            stmnt.executeUpdate(); // Executing the sql query
            rs = stmnt.getGeneratedKeys();

            if (rs.next()) {
                cust.setCustomerID(rs.getInt(1)); //Setting the customer ID
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


        walletDAO.createWallet(cust.getCustomerID());
        customerDatabase.add(cust);
        System.out.println("Registered Customer Successfully" );


    }

    @Override
    public boolean loginCustomer(Customer cust  ) {

        boolean loginSuccessFlag = false;

        ResultSet rs = null;
        PreparedStatement stmnt = null;
        Connection conn = null;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_BY_EMAIL_AND_PASSWORD);
            stmnt.setString(1, cust.getEmail());
            stmnt.setString(2, cust.getPassword());

            rs = stmnt.executeQuery();
            if (rs.next()) {

                sessionCustomer.setCustomerID(rs.getInt("customerID"));
                sessionCustomer.setUserName(rs.getString("userName"));
                sessionCustomer.setEmail(rs.getString("email"));
                sessionCustomer.setPassword(rs.getString("password"));
                sessionCustomer.setFirstName(rs.getString("firstName"));
                sessionCustomer.setLastName(rs.getString("lastName"));
                sessionCustomer.setPaymentPassword((rs.getString("paymentPassword")));
                sessionCustomer.setAddress(rs.getString("address"));

                System.out.println("Successful login , welcome dear " + sessionCustomer.getFirstName() + " " + sessionCustomer.getLastName());

                loginSuccessFlag = true;
            } else {
                System.out.println("Unsuccessful login , try with correct credentials");
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

        sessionCustomer.setUserWallet(walletDAO.getCustomerWallet(sessionCustomer.getCustomerID()));

        return loginSuccessFlag;

    }

    @Override
    public boolean checkPaymentPassword(String paymentPassword) {

        return sessionCustomer.getPaymentPassword().equals(paymentPassword);
    }

    @Override
    public String getCustomerUsername(int customerID) {
        String sellerUsername = "";

        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_CUSTOMER_NAME);

            stmnt.setInt(1, customerID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                sellerUsername = rs.getString("userName");
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



        return sellerUsername;    }


}
