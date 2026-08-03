package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        String URL = "jdbc:mysql://localhost:3306/railway_db";
        String USER = "root";
        String PASSWORD = "Jyoti@2004";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Database connected successfully.");

        } catch (Exception e) {

            System.out.println("Database connection failed.");

            e.printStackTrace();
        }

        return con;
    }

}
