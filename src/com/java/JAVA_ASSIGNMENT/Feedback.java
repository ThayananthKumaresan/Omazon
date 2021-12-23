package com.java.JAVA_ASSIGNMENT;

public class Feedback {

    int feedbackID;
    int feedbackProductID;
    String feedbackReview;
    int feedbackRating;
    String feedbackCommentBySeller;
    String feedbackCustomerUserName;


    public Feedback() {
    }

    public Feedback(int feedbackProductID, String feedbackReview, String feedbackCommentBySeller, String feedbackCustomerUserName, int feedbackRating) {
        this.feedbackProductID = feedbackProductID;
        this.feedbackReview = feedbackReview;
        this.feedbackCommentBySeller = feedbackCommentBySeller;
        this.feedbackCustomerUserName = feedbackCustomerUserName;
        this.feedbackRating = feedbackRating;

    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public int getFeedbackProductID() {
        return feedbackProductID;
    }

    public void setFeedbackProductID(int feedbackProductID) {
        this.feedbackProductID = feedbackProductID;
    }

    public String getFeedbackReview() {
        return feedbackReview;
    }

    public void setFeedbackReview(String feedbackReview) {
        this.feedbackReview = feedbackReview;
    }

    public String getFeedbackCommentBySeller() {
        return feedbackCommentBySeller;
    }

    public void setFeedbackCommentBySeller(String feedbackCommentBySeller) {
        this.feedbackCommentBySeller = feedbackCommentBySeller;
    }

    public String getFeedbackCustomerName() {
        return feedbackCustomerUserName;
    }

    public void setFeedbackCustomerName(String feedbackCustomerUserName) {
        this.feedbackCustomerUserName = feedbackCustomerUserName;
    }

    public int getFeedbackRating() {
        return feedbackRating;
    }

    public void setFeedbackRating(int feedbackRating) {
        this.feedbackRating = feedbackRating;
    }
}
