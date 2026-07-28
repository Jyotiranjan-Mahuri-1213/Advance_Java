package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {

     static final String URL = "jdbc:mysql://localhost:3306/advance_java";
     static final String USER = "root";
     static final String PASSWORD = "Jyoti@2004";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            while (true) {

                System.out.println("===== Choose The Option =====");
                System.out.println("1. Insert");
                System.out.println("2. Display");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {


                    case 1:

                        PreparedStatement insert = con.prepareStatement(
                                "insert into student_data values (?,?,?)");

                        System.out.print("Enter ID: ");
                        insert.setInt(1, sc.nextInt());

                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        insert.setString(2, sc.nextLine());

                        System.out.print("Enter Domain: ");
                        insert.setString(3, sc.nextLine());

                        int row = insert.executeUpdate();

                        if (row > 0)
                            System.out.println("Data Inserted Successfully.");
                        else
                            System.out.println("Insertion Failed.");

                        break;


                    case 2:

                        Statement st = con.createStatement();

                        ResultSet rs = st.executeQuery("select * from student_data");

                        System.out.println("\nID\tName\tDomain");

                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("st_id") + "\t"
                                            + rs.getString("st_name") + "\t"
                                            + rs.getString("st_domain"));
                        }

                        break;


                    case 3:

                        PreparedStatement update = con.prepareStatement(
                                "update student_data set st_name=?, st_domain=? where st_id=?");

                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        update.setString(1, sc.nextLine());

                        System.out.print("Enter New Domain: ");
                        update.setString(2, sc.nextLine());

                        System.out.print("Enter Student ID: ");
                        update.setInt(3, sc.nextInt());

                        int updateRow = update.executeUpdate();

                        if (updateRow > 0)
                            System.out.println("Data Updated Successfully.");
                        else
                            System.out.println("Student ID Not Found.");

                        break;


                    case 4:

                        PreparedStatement delete = con.prepareStatement(
                                "delete from student_data where st_id=?");

                        System.out.print("Enter Student ID to Delete: ");
                        delete.setInt(1, sc.nextInt());

                        int deleteRow = delete.executeUpdate();

                        if (deleteRow > 0)
                            System.out.println("Data Deleted Successfully.");
                        else
                            System.out.println("Student ID Not Found.");

                        break;


                    case 5:
                        con.close();
                        System.out.println("Connection Closed.");
                       System.exit(0);

                    default:
                        System.out.println("Invalid Choice.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}