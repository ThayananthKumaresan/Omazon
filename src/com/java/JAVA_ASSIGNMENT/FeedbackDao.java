package com.java.JAVA_ASSIGNMENT;

public interface FeedbackDao {

    public Feedback getFeedback(String feedbackID);
    public void updateFeedback(Feedback feedback);
    public void deleteFeedback(Feedback feedback);
    public void addFeedback(Feedback feedback);

}
