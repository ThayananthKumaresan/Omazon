package com.java.JAVA_ASSIGNMENT;

import java.sql.*;

import static com.java.JAVA_ASSIGNMENT.Main.sessionCustomer;
import static com.java.JAVA_ASSIGNMENT.Main.transactionDAO;

public class WalletDaoImp implements WalletDao{

    private static final String FIND_BY_ID = "SELECT * FROM wallet WHERE walletCustomerID=?";
    private static final String UPDATE = "UPDATE wallet SET walletBalance=? WHERE walletID=?";
    private static final String INSERT = "INSERT INTO wallet (walletBalance,walletCustomerID) VALUES (?,?)";
    private static final String DELETE = "DELETE FROM wallet WHERE walletID=?";


    @Override
    public void reduceWalletBalance(Wallet customerWallet ,double paidAmount) {

        PreparedStatement stmnt = null;
        Connection conn = null;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(UPDATE);
            stmnt.setDouble(1, customerWallet.getWalletBalance()-paidAmount);
            stmnt.setInt(2, customerWallet.getWalletID());

            stmnt.executeUpdate();
            System.out.println("Updated Wallet Successfully");
            sessionCustomer.getUserWallet().setWalletBalance(customerWallet.getWalletBalance()-paidAmount);

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
    public void topUpWalletBalance(Wallet customerWallet ,double topUpAmount) {
        PreparedStatement stmnt = null;
        Connection conn = null;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(UPDATE);
            stmnt.setDouble(1, customerWallet.getWalletBalance()+topUpAmount);
            stmnt.setInt(2, customerWallet.getWalletID());

            stmnt.executeUpdate();
            sessionCustomer.getUserWallet().setWalletBalance(customerWallet.getWalletBalance()+topUpAmount);


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
    public Wallet getCustomerWallet(int customerID) {

        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;
        Wallet wallet = new Wallet();

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_BY_ID);

            stmnt.setInt(1, customerID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                wallet.setWalletID(rs.getInt("walletID"));
                wallet.setWalletBalance(rs.getInt("walletBalance"));

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

        wallet.setWalletTransaction(transactionDAO.getListOfCustomerTransaction(customerID));

        return wallet;
    }

    @Override
    public void createWallet(int customerID) {

        Wallet wallet = new Wallet();
        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            stmnt.setDouble(1, 0.0);
            stmnt.setInt(2,customerID);


            stmnt.executeUpdate(); // Executing the sql query

            rs = stmnt.getGeneratedKeys();

            if (rs.next()) {
                wallet.setWalletID(rs.getInt(1));
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
    public void deleteWallet(Wallet customerWallet) {
        PreparedStatement stmnt = null;
        Connection conn = null;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(DELETE);
            stmnt.setInt(1, customerWallet.getWalletID());

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
    }
}
