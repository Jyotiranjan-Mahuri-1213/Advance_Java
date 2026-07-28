package org.example;

import java.sql.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String URL ="jdbc:mysql://localhost:3306/advance_java";
        String USER = "root";
        String PASSWORD = "Jyoti@2004";
        try {

            Connection con = DriverManager.getConnection(URL,USER,PASSWORD);

//            PreparedStatement pr=con.prepareStatement("insert into student_data values (?,?,?)");
//
//            System.out.println("Enter id  : ");
//            Scanner sc = new Scanner(System.in);
//            pr.setInt(1,sc.nextInt());
//            System.out.println("Enter Name  : ");
//            sc = new Scanner(System.in);
//            pr.setString(2,sc.nextLine());
//            System.out.println("Enter Domain  : ");
//            sc = new Scanner(System.in);
//            pr.setString(3,sc.nextLine());

            //4th Step(Execute Query)
//            int rowsaffect = pr.executeUpdate();
//            System.out.println(rowsaffect);
//            if(rowsaffect>0){
//                System.out.println("Data inserted");
//            }

                Statement st= con.createStatement();
                ResultSet rs = st.executeQuery("select*from student_data");

                while(rs.next()){
                    System.out.println(rs.getInt("st_id") + " " + rs.getString("st_name") +" "+ rs.getString("st_domain"));
                }
            con.close();



        } catch ( SQLException e) {
            throw new RuntimeException(e);
        }


    }
}