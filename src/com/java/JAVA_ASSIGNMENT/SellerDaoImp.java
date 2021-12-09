package com.java.JAVA_ASSIGNMENT;

import java.util.ArrayList;

import static com.java.JAVA_ASSIGNMENT.Main.sessionSeller;

public class SellerDaoImp implements SellerDao {

    public static ArrayList<Seller> sellerDatabase = new ArrayList<>();


    @Override
    public Seller getSeller(String username) {
        return null;
    }

    @Override
    public void updateSeller(Seller seller) {
        for (int j = 0; j < sellerDatabase.size(); j++) {

            if (seller.getSellerUsername().equals(sellerDatabase.get(j).getSellerUsername())) {
                sellerDatabase.set(j,seller);
            }
        }
    }

    @Override
    public void deleteSeller(Seller seller) {

    }

    @Override
    public void registerSeller(Seller seller) {

        sellerDatabase.add(seller);
    }

    @Override
    public void loginSeller(Seller seller) {
        for (int i = 0; i < sellerDatabase.size(); i++) {

            if (sellerDatabase.get(i).getEmail().equals(seller.getEmail()) && sellerDatabase.get(i).getPassword().equals(seller.getPassword()) ){
                //Success Message
                sessionSeller=sellerDatabase.get(i);
                System.out.println("Successful login" +sessionSeller.getFirstName()+ " " + sessionSeller.getLastName() );
            }
            else{
                System.out.println("Unsuccesful login" );
            }
        }

    }

    @Override
    public void updateSellerProfit(String sellerUsername , double income){

        for (int j = 0; j < sellerDatabase.size(); j++) {

            if (sellerUsername.equals(sellerDatabase.get(j).getSellerUsername())) {

                Seller sellerObjToUpdateProfit = sellerDatabase.get(j);
                sellerObjToUpdateProfit.setSellerProfit(sellerDatabase.get(j).getSellerProfit()+income);
            }
        }


    }

    @Override
    public void getSellerProfitFromDatabase(Seller seller) {

    }
}
