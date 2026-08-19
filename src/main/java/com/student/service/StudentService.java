package com.student.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentService {

    private static final String url = "jdbc:mysql://localhost:3306/advance_java";

    private static final String user = "root";

    private static final String Password = "Jyoti@2004";

    public boolean register(String email, String name, String password) {

        String sql = "insert into student_details " + "(email, name, password) " + "VALUES (?, ?, ?)";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, Password);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, name);
            ps.setString(3, password);

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}