package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   public static void main(String[] args) {
       String URL="jdbc:mysql://localhost:3306/advance_java";
       String USER="root";
       String PASSWORD="Jyoti@2004";
       try{
           Class .forName("com.mysql.cj.jdbc.Driver");
           DriverManager .getConnection(URL,USER,PASSWORD);
       } catch (ClassNotFoundException | SQLException e) {
           throw new RuntimeException(e);
       }
    System.out.println("now jdbc is connected");
   }
    }

