package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public class Feedback {


    Product feedbackProduct;
    String feedbackReview;
    int feedbackRating;
    String feedbackCommentBySeller;
    String feedbackCustomerName;


    public Feedback() {
    }

    public Feedback(Product feedbackProduct, String feedbackReview, String feedbackCommentBySeller, String feedbackCustomerName,int feedbackRating) {
        this.feedbackProduct = feedbackProduct;
        this.feedbackReview = feedbackReview;
        this.feedbackCommentBySeller = feedbackCommentBySeller;
        this.feedbackCustomerName = feedbackCustomerName;
        this.feedbackRating = feedbackRating;

    }

    public Product getFeedbackProduct() {
        return feedbackProduct;
    }

    public void setFeedbackProduct(Product feedbackProduct) {
        this.feedbackProduct = feedbackProduct;
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
        return feedbackCustomerName;
    }

    public void setFeedbackCustomerName(String feedbackCustomerName) {
        this.feedbackCustomerName = feedbackCustomerName;
    }

    public int getFeedbackRating() {
        return feedbackRating;
    }

    public void setFeedbackRating(int feedbackRating) {
        this.feedbackRating = feedbackRating;
    }
}
