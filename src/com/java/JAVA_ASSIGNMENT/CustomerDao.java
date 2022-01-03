package com.java.JAVA_ASSIGNMENT;

public interface CustomerDao {

    public void updateCustomer(Customer cust);
    public void deleteCustomer(Customer cust);
    public void registerCustomer(Customer cust);
    public boolean loginCustomer(Customer cust);
    public boolean checkPaymentPassword(String paymentPassword);
    public String getCustomerUsername(int customerID);
    public String getCustomerFullName(int customerID);
    public String getCustomerAddress(int customerID);
    public int getCustomerID(String email);
}
