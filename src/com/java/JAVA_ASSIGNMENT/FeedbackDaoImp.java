package com.java.JAVA_ASSIGNMENT;

import java.sql.*;
import java.util.ArrayList;

public class FeedbackDaoImp implements FeedbackDao{
    public static ArrayList<Feedback> feedbackDataBase = new ArrayList<>();

    private static final String FIND_BY_ID = "SELECT * FROM product WHERE feedbackID=?";
    private static final String FIND_LIST_OF_FEEDBACK_BY_PRODUCT = "SELECT * FROM feedback WHERE feedbackProductID=?";
    private static final String FIND_LIST_OF_FEEDBACK_BY_SELLER = "SELECT * FROM `feedback` ,`product` " +
            "WHERE feedbackProductID=product.productID and product.productSellerID=?";
    private static final String FIND_LIST_OF_RATING_OF_THIS_PRODUCT = "SELECT feedbackRating FROM feedback WHERE feedbackProductID=?";
    private static final String INSERT = "INSERT INTO feedback (feedbackProductID , " +
            "feedbackRating, feedbackReview, feedbackCommentBySeller,feedbackCustomerUserName) VALUES (?,?,?,?,?)";
    private static final String UPDATE_FEEDBACK = "UPDATE feedback SET feedbackCommentBySeller=? WHERE feedbackID=?";

    @Override
    public ArrayList<Feedback> getListOfFeedbackOfThisProduct(int productID) {


        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;
        ArrayList<Feedback> listOfFeedback = new ArrayList<>();
        Feedback feedback = new Feedback();

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_LIST_OF_FEEDBACK_BY_PRODUCT);

            stmnt.setInt(1, productID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                feedback.setFeedbackProductID(rs.getInt("feedbackProductID"));
                feedback.setFeedbackRating(rs.getInt("feedbackRating"));
                feedback.setFeedbackReview(rs.getString("feedbackReview"));
                feedback.setFeedbackCommentBySeller(rs.getString("feedbackCommentBySeller"));
                feedback.setFeedbackCustomerName(rs.getString("feedbackCustomerName"));
                listOfFeedback.add(feedback);
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

        if (listOfFeedback.size() == 0) {
            return null;

        } else {
            return listOfFeedback;
        }
    }

    public ArrayList<Feedback> getListOfFeedbackOfThisSeller(int sellerID) {


        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;
        ArrayList<Feedback> listOfFeedback = new ArrayList<>();
        Feedback feedback = new Feedback();

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_LIST_OF_FEEDBACK_BY_SELLER);

            stmnt.setInt(1, sellerID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                feedback.setFeedbackProductID(rs.getInt("feedbackProductID"));
                feedback.setFeedbackRating(rs.getInt("feedbackRating"));
                feedback.setFeedbackReview(rs.getString("feedbackReview"));
                feedback.setFeedbackCommentBySeller(rs.getString("feedbackCommentBySeller"));
                feedback.setFeedbackCustomerName(rs.getString("feedbackCustomerName"));
                listOfFeedback.add(feedback);
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

        if (listOfFeedback.size() == 0) {
            return null;

        } else {
            return listOfFeedback;
        }
    }



    @Override
    public double getAverageRatingOfThisProduct(int productID) {

        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;
        ArrayList<Integer> listOfProductRating= new ArrayList<>();

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_LIST_OF_RATING_OF_THIS_PRODUCT);

            stmnt.setInt(1, productID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                listOfProductRating.add(rs.getInt("feedbackRating"));
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


            int totalRating =0;
            for (Integer integer : listOfProductRating) {
                totalRating = totalRating + integer;
            }


            return (double) totalRating/listOfProductRating.size();


    }
    @Override
    public void addFeedback(Feedback feedback) {

        feedbackDataBase.add(feedback);


        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            stmnt.setInt(1, feedback.getFeedbackProductID());
            stmnt.setString(2, feedback.getFeedbackReview());
            stmnt.setString(3, feedback.getFeedbackCustomerName());
            stmnt.setString(4, feedback.getFeedbackCommentBySeller());
            stmnt.setInt(5, feedback.getFeedbackRating());

            stmnt.executeUpdate(); // Executing the sql query

            rs = stmnt.getGeneratedKeys();

            if (rs.next()) {
                feedback.setFeedbackID(rs.getInt(1)); //Setting the product ID

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
    public void updateFeedback(Feedback feedback) {
        PreparedStatement stmnt = null;
        Connection conn = null;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(UPDATE_FEEDBACK);
            stmnt.setString(1, feedback.getFeedbackCommentBySeller());
            stmnt.setInt(2, feedback.getFeedbackID());

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
    public Feedback getFeedback(int feedbackID) {

        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;
        Feedback feedback = new Feedback();

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_BY_ID);

            stmnt.setInt(1, feedbackID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                feedback.setFeedbackProductID(rs.getInt("feedbackProductID"));
                feedback.setFeedbackRating(rs.getInt("feedbackRating"));
                feedback.setFeedbackReview(rs.getString("feedbackReview"));
                feedback.setFeedbackCommentBySeller(rs.getString("feedbackCommentBySeller"));
                feedback.setFeedbackCustomerName(rs.getString("feedbackCustomerName"));

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

        return feedback;
    }
}
