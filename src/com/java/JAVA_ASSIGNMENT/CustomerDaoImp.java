package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;
import static com.java.JAVA_ASSIGNMENT.Main.sessionCustomer;

public class CustomerDaoImp implements CustomerDao{

    public static ArrayList<Customer> customerDatabase = new ArrayList<>();

    //doesnt have a defined size
    // which means it can grow as we add


    @Override
    public Customer getCustomer(String username) {
        //Read from file
        // haver codes that interact with database
        return null;
    }

    @Override
    public void updateCustomer(Customer cust) {

        // we need to find the customer by username
        // use setter method - coming from the class
        // pass the new or updated value
        // we have updated


    }

    @Override
    public void updateAddress(String custAddress) {

    }

    @Override
    public void updateUsername(String custUsername) {

    }

    @Override
    public void updateEmail(String custEmail) {

    }

    @Override
    public void updatePassword(String custPassword) {

    }

    @Override
    public void deleteCustomer(Customer cust) {
     // todo check this
        customerDatabase.remove(cust);

    }

    @Override
    public void registerCustomer(Customer cust) {

        customerDatabase.add(cust);
        System.out.println("Registered Customer Succesfully" );


    }

    @Override
    public void loginCustomer(Customer cust  ) {


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

    @Override
    public boolean checkPaymentPassword(String paymentPassword) {

        boolean paymentPasswordCheckFlag=false;

        for (int i = 0; i < customerDatabase.size(); i++) {

            if (customerDatabase.get(i).getPaymentPassword().equals(paymentPassword) ){
                paymentPasswordCheckFlag= true;
                break;
            }
        }

        return paymentPasswordCheckFlag;
    }
}
