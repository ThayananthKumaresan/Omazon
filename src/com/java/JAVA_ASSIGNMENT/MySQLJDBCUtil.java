package com.java.JAVA_ASSIGNMENT;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author mysqltutorial.org
 */
public class MySQLJDBCUtil {

    /**
     * Get database connection
     *
     * @return a Connection object
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;

        try (FileInputStream f = new FileInputStream("C:/Users/DELL/IdeaProjects/Omazon/src/com/java/JAVA_ASSIGNMENT/db.properties")) {

            // load the properties file
            Properties pros = new Properties();
            pros.load(f);

            // assign db parameters
            String url = pros.getProperty("url");
            String username = pros.getProperty("username");
            String password = pros.getProperty("password");

            // create a connection to the database
            conn = DriverManager.getConnection(url, username, password);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}