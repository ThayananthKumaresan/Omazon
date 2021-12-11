package com.java.JAVA_ASSIGNMENT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {
    public static void main(String[] args) {





        String url ="jdbc:mysql://localhost:3306/sakila";
        String username ="root";
        String password = "admin";

        Connection connection = null;
        try {
            connection= DriverManager.getConnection(url, username, password);
            String sql ="SELECT table donkey"; //querying
            //execute(sql)
            // it might return some dage
            System.out.println("Yes , fine");

        } catch (SQLException e) {
            System.out.println("Ooops , error");
            e.printStackTrace();
        }finally {
            try{
                if(connection != null)
                    connection.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }

    }
}
