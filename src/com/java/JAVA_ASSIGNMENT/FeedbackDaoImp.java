package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class FeedbackDaoImp implements FeedbackDao{
    public static ArrayList<Feedback> feedbackDataBase = new ArrayList<>();


    @Override
    public Feedback getFeedback(String productID) {

        for (int j = 0; j < feedbackDataBase.size(); j++) {

            if (feedbackDataBase.get(j).getFeedbackProduct().getProductID().equals(productID)) {
                return feedbackDataBase.get(j);
            }

        }
        return null;
    }

    @Override
    public void updateFeedback(Feedback feedback) {

    }

    @Override
    public void deleteFeedback(Feedback feedback) {

    }

    @Override
    public void addFeedback(Feedback feedback) {

    }
}
