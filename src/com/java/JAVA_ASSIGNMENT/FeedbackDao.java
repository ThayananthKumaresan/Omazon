package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public interface FeedbackDao {

    public ArrayList<Feedback> getListOfFeedbackOfThisProduct(int productID);
    public double getAverageRatingOfThisProduct(int productID);
    public void addFeedback(Feedback feedback);
    public void updateFeedback(Feedback feedback);
    public Feedback getFeedback(int feedbackID);

    public ArrayList<Feedback> getListOfFeedbackOfThisSeller(int sellerID);
}
