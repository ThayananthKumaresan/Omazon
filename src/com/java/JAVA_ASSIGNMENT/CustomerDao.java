package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public interface CustomerDao {

    public Customer getCustomer(String username);
    public void updateCustomer(Customer cust);
    public void updateAddress(String custAddress );
    public void updateUsername(String custUsername);
    public void updateEmail(String custEmail);
    public void updatePassword(String custPassword);


    public void deleteCustomer(Customer cust);
    public void registerCustomer(Customer cust);
    public void loginCustomer(Customer cust);
    public boolean checkPaymentPassword(String paymentPassword);


}
