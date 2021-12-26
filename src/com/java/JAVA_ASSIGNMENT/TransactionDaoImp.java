package com.java.JAVA_ASSIGNMENT;

import java.sql.*;
import java.util.ArrayList;

public class TransactionDaoImp implements TransactionDao {

    private static final String FIND_BY_ID= "SELECT * FROM transaction WHERE userID=?";
    private static final String INSERT = "INSERT INTO transaction (transactionAmount,transactionDateTime, userID) VALUES (?,?,?)";

    @Override
    public void addTransaction(Transaction transaction) {


        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            stmnt.setDouble(1, transaction.getTransactionAmount());
            stmnt.setString(2, transaction.getTransactionDateTime());
            stmnt.setInt(3, transaction.getUserID());

            stmnt.executeUpdate(); // Executing the sql query

            rs = stmnt.getGeneratedKeys();

            if (rs.next()) {
                transaction.setTransactionID(rs.getInt(1)); //Setting the product ID

            }
            System.out.println("Successfully add product");

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
    public ArrayList<Transaction> getListOfSellerTransaction(int sellerID) {

        ArrayList<Transaction> listOfTransactionOfThisSeller = new ArrayList<>();

        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_BY_ID);

            stmnt.setInt(1, sellerID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionID(rs.getInt("transactionID"));
                transaction.setTransactionAmount(rs.getDouble("transactionAmount"));
                transaction.setTransactionDateTime(rs.getString("transactionDateTime"));
                transaction.setUserID(rs.getInt("userID"));
                listOfTransactionOfThisSeller.add(transaction);
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


        if(listOfTransactionOfThisSeller.size()==0 ){
            return null;
        }else{
            return listOfTransactionOfThisSeller;
        }


    }

    @Override
    public ArrayList<Transaction> getListOfCustomerTransaction(int customerID) {
        ArrayList<Transaction> listOfTransactionOfThisCustomer = new ArrayList<>();

        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_BY_ID);

            stmnt.setInt(1, customerID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionID(rs.getInt("transactionID"));
                transaction.setTransactionAmount(rs.getDouble("transactionAmount"));
                transaction.setTransactionDateTime(rs.getString("transactionDateTime"));
                transaction.setUserID(rs.getInt("userID"));
                listOfTransactionOfThisCustomer.add(transaction);
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


        if(listOfTransactionOfThisCustomer.size()==0 ){
            return null;
        }else{
            return listOfTransactionOfThisCustomer;
        }

    }
}
