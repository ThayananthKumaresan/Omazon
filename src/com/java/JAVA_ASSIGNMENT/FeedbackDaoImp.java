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
        for (int j = 0; j < userFeedbackDatabase.size(); j++) {
            if (feedback.getUserUsername().equals(userFeedbackDatabase.get(j).getUserUsername())) {
                serFeedbackDatabase.set(j,user);
            }
        }
    }

    public boolean deleteFeedback(Feedback feedback) {
        for (int i = 0; i <  userFeedbackDatabase.size(); i++) {
            if(feedback.getUserUsername().equals(userFeedbackDatabase.get(j).getUserUsername())) {
                userFeedbackDatabase[i] = userFeedbackDatabase[size- 1];
                userFeedbackDatabase[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }
    public boolean addFeedback(Feedback feedback){
        for(int i = 0; i<feedbackDataBase.size() ; i++){
            feedbackDataBase[size] = feedback;
            size++;
            return true;
        }
        return false;
    }
}
