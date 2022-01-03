package com.java.JAVA_ASSIGNMENT;

import java.sql.*;

import static com.java.JAVA_ASSIGNMENT.Main.sessionSeller;
import static com.java.JAVA_ASSIGNMENT.Main.transactionDAO;

public class SellerDaoImp implements SellerDao {

    private static final String FIND_SELLER_NAME = "SELECT userName FROM seller WHERE sellerID=?";
    private static final String FIND_SELLER_EMAIL = "SELECT email FROM seller WHERE sellerID=?";
    private static final String FIND_SELLERID_BY_EMAIL = "SELECT sellerID FROM seller WHERE email=?";
    private static final String FIND_BY_EMAIL_AND_PASSWORD = "SELECT * FROM seller WHERE email=? and password=?";
    private static final String INSERT = "INSERT INTO seller (" +
            "userName, email, password, firstName, lastName, " +
            "sellerPhoneNumber, sellerBankAccount, sellerAddress, " +
            "sellerIC, sellerBusinessRegistrationNumber, sellerProfit ) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?)";
    private static final String UPDATE_SELLER_PROFILE = "UPDATE seller SET userName=?, email=?, password=?, firstName=?, lastName=?, sellerPhoneNumber=?, sellerBankAccount=?, sellerAddress=?, sellerIC=?, sellerBusinessRegistrationNumber=? WHERE sellerID=?";
    private static final String UPDATE_SELLER_PROFIT = "UPDATE seller " +
            "SET  sellerProfit=?" +
            "WHERE sellerID=?";
    private static final String FIND_EMAIL_SELLER = "SELECT sellerID FROM seller WHERE email=?";

    // TODO : ADD SHOP NAME & RENAME TO SHOP NAME
    @Override
    public String getSellerUsername(int sellerID) {

        String sellerUsername = "";

        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_SELLER_NAME);

            stmnt.setInt(1, sellerID);
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



        return sellerUsername;
    }

    @Override
    public String getSellerEmail(int sellerID){
        String sellerEmail = "";

        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_SELLER_EMAIL);

            stmnt.setInt(1, sellerID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                sellerEmail = rs.getString("email");
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

        return sellerEmail;
    }

    @Override
    public void updateSeller(Seller seller) {
        PreparedStatement stmnt = null;
        Connection conn = null;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(UPDATE_SELLER_PROFILE);

            // ADDING SHOP NAME IN DB AND HERE
            stmnt.setString(1, seller.getUserName());
            stmnt.setString(2, seller.getEmail());
            stmnt.setString(3, seller.getPassword());
            stmnt.setString(4, seller.getFirstName());
            stmnt.setString(5, seller.getLastName());
            stmnt.setString(6, seller.getSellerPhoneNumber());
            stmnt.setString(7, seller.getSellerBankAccount());
            stmnt.setString(8, seller.getSellerAddress());
            stmnt.setString(9, seller.getSellerIC());
            stmnt.setString(10, seller.getSellerBusinessRegistrationNumber());
            stmnt.setString(11, seller.getSellerBusinessRegistrationNumber());
            stmnt.setInt(12, seller.getSellerID());



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
    public void deleteSeller(Seller seller) {




    }

    @Override
    public void registerSeller(Seller seller) {

        ResultSet rs = null;
        Connection conn ;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            stmnt.setString(1, seller.getUserName());
            stmnt.setString(2, seller.getEmail());
            stmnt.setString(3, seller.getPassword());
            stmnt.setString(4, seller.getFirstName());
            stmnt.setString(5, seller.getLastName());
            stmnt.setString(6, seller.getSellerPhoneNumber());
            stmnt.setString(7, seller.getSellerBankAccount());
            stmnt.setString(8, seller.getSellerAddress());
            stmnt.setString(9, seller.getSellerIC());
            stmnt.setString(10, seller.getSellerBusinessRegistrationNumber());
            stmnt.setDouble(11, 0.00);

            stmnt.executeUpdate(); // Executing the sql query
            rs = stmnt.getGeneratedKeys();

            if (rs.next()) {
                seller.setSellerID(rs.getInt(1)); //Setting the seller ID
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

        System.out.println("Registered Seller Successfully" );

    }

    @Override
    public boolean loginSeller(Seller seller) {
        boolean loginSuccessFlag = false;

        ResultSet rs = null;
        PreparedStatement stmnt = null;
        Connection conn = null;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_BY_EMAIL_AND_PASSWORD);
            stmnt.setString(1, seller.getEmail());
            stmnt.setString(2, seller.getPassword());

            rs = stmnt.executeQuery();
            if (rs.next()) {
                sessionSeller.setSellerID(rs.getInt("sellerID"));
                sessionSeller.setUserName(rs.getString("userName"));
                sessionSeller.setEmail(rs.getString("email"));
                sessionSeller.setPassword(rs.getString("password"));
                sessionSeller.setFirstName(rs.getString("firstName"));
                sessionSeller.setLastName(rs.getString("lastName"));
                sessionSeller.setSellerPhoneNumber((rs.getString("sellerPhoneNumber")));
                sessionSeller.setSellerBankAccount(rs.getString("sellerBankAccount"));
                sessionSeller.setSellerAddress(rs.getString("sellerAddress"));
                sessionSeller.setSellerIC(rs.getString("sellerIC"));
                sessionSeller.setSellerBusinessRegistrationNumber(rs.getString("sellerBusinessRegistrationNumber"));
                sessionSeller.setSellerProfit(rs.getDouble("sellerProfit"));

                System.out.println("Successful login , welcome dear " + sessionSeller.getFirstName() + " " + sessionSeller.getLastName());
                loginSuccessFlag = true;
            } else {
                System.out.println("Unsuccessful login , try with correct credentials");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

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

        sessionSeller.setSellerTransactions(transactionDAO.getListOfSellerTransaction(sessionSeller.getSellerID()));
        return loginSuccessFlag;

    }

    @Override
    public void updateSellerProfit(int sellerID , double income){

        PreparedStatement stmnt = null;
        Connection conn = null;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(UPDATE_SELLER_PROFIT);
            stmnt.setDouble(1, sessionSeller.getSellerProfit()+income);
            stmnt.setInt(2, sellerID);

            stmnt.executeUpdate();
            System.out.println("Updated Seller Profit Successfully");

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
    public int getSellerID(String email){
        ResultSet rs = null;
        PreparedStatement stmnt = null;
        Connection conn = null;
        int customerID = -1;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_SELLERID_BY_EMAIL);
            stmnt.setString(1, email);

            rs = stmnt.executeQuery();
            if(rs.next())
                customerID = rs.getInt("customerID");
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) 
                    rs.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return customerID;
    }
}
