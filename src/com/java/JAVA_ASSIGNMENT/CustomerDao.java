package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

public interface CustomerDao {

    public Customer getCustomer(String username);
    public void updateCustomer(Customer cust);
    public void deleteCustomer(Customer cust);
    public void registerCustomer(Customer cust);
    public void loginCustomer(Customer cust);


}
