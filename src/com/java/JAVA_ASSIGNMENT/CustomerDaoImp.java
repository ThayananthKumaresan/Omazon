package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;
import static com.java.JAVA_ASSIGNMENT.Main.sessionCustomer;

public class CustomerDaoImp implements CustomerDao{

    public static ArrayList<Customer> customerDatabase = new ArrayList<>();

    @Override
    public Customer getCustomer(String username) {
        //Read from file
        return null;
    }

    @Override
    public void updateCustomer(Customer cust) {

    }

    @Override
    public void deleteCustomer(Customer cust) {


    }

    @Override
    public void registerCustomer(Customer cust) {
        customerDatabase.add(cust);
        System.out.println("Registered Customer Succesfully" );


    }

    @Override
    public void loginCustomer(Customer cust  ) {

        System.out.println("At login" +customerDatabase.size() );

        for (int i = 0; i < customerDatabase.size(); i++) {

            if (customerDatabase.get(i).getEmail().equals(cust.getEmail()) && customerDatabase.get(i).getPassword().equals(cust.getPassword()) ){
                //Success Message
                sessionCustomer=customerDatabase.get(i);
                System.out.println("Successful login" +sessionCustomer.getFirstName()+ " " + sessionCustomer.getLastName() );
            }
            else{
                System.out.println("Unsuccesful" );

            }
        }



    }
}
