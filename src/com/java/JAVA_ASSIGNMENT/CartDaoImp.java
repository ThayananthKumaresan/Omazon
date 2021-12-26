package com.java.JAVA_ASSIGNMENT;

import java.sql.*;
import java.util.ArrayList;

import static com.java.JAVA_ASSIGNMENT.Main.productDAO;


public class CartDaoImp implements CartDao{

    private static final String FIND_LIST_OF_CART_BY_CUSTOMER = "SELECT * FROM cart WHERE cartCustomerID=?";
    private static final String INSERT = "INSERT INTO cart (cartCustomerID ,cartProductID , cartQuantity) VALUES (?,?,?)";
    private static final String INSERT_WHEN_PRODUCT_IS_PRESENT = "UPDATE cart SET  cartQuantity=? WHERE cartCustomerID=? and cartProductID=?";
    private static final String DELETE = "DELETE FROM cart WHERE cartID=?";
    private static final String FIND_PRESENCE_OF_PRODUCT = "SELECT * FROM cart WHERE cartCustomerID=? and cartProductID=?";


    @Override
    public  ArrayList<Cart> getListOfCartOfThisCustomer(int cartCustomerID) {

        ArrayList<Cart> listOfCartOfThisCustomer = new ArrayList<>();

        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_LIST_OF_CART_BY_CUSTOMER);

            stmnt.setInt(1, cartCustomerID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                Cart cart = new Cart();
                cart.setCartCustomerID(rs.getInt("cartCustomerID"));
                cart.setCartID(rs.getInt("cartID"));
                cart.setCartQuantity(rs.getInt("cartQuantity"));
                cart.setCartProductID(rs.getInt("cartProductID"));
                listOfCartOfThisCustomer.add(cart);
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

        if(listOfCartOfThisCustomer.size()==0){
            return null;

        }else {
            return listOfCartOfThisCustomer;
        }
    }

    @Override
    public void updateCart(Cart cart) {

    }

    @Override
    public void deleteCart(int cartID) {

        PreparedStatement stmnt = null;
        Connection conn = null;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(DELETE);
            stmnt.setInt(1, cartID);

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
    public void addCart(Cart cart) {

        boolean foundProductFlag = false;

        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_PRESENCE_OF_PRODUCT);

            stmnt.setInt(1, cart.getCartCustomerID());
            stmnt.setInt(2, cart.getCartProductID());
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                foundProductFlag= true;
            }

            if(foundProductFlag){
                stmnt = conn.prepareStatement(INSERT_WHEN_PRODUCT_IS_PRESENT);

                stmnt.setInt(1, cart.getCartQuantity());
                stmnt.setInt(2, cart.getCartCustomerID());
                stmnt.setInt(3, cart.getCartProductID());

                stmnt.executeUpdate();

            }else{

                stmnt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

                stmnt.setInt(1, cart.getCartCustomerID());
                stmnt.setInt(2, cart.getCartProductID());
                stmnt.setInt(3, cart.getCartQuantity());

                stmnt.executeUpdate(); // Executing the sql query

                rs = stmnt.getGeneratedKeys();

                if (rs.next()) {
                    cart.setCartID(rs.getInt(1)); //Setting the product ID
                }
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


}
