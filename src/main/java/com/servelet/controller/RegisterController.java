//package com.example.controller;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/register")
//public class RegisterController extends HttpServlet {
//
//    private static final String URL = "jdbc:mysql://localhost:3306/student";
//    private static final String USER = "root";
//    private static final String PASSWORD = "root";
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        String sql = "INSERT INTO users (email, password) VALUES (?, ?)";
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            Connection con = DriverManager.getConnection(
//                    URL, USER, PASSWORD
//            );
//
//            PreparedStatement ps = con.prepareStatement(sql);
//
//            ps.setString(1, email);
//            ps.setString(2, password);
//
//            int result = ps.executeUpdate();
//
//            if (result > 0) {
//                // Registration successful
//                response.sendRedirect("login.html");
//            }
//
//            ps.close();
//            con.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.getWriter().println("Registration Failed");
//        }
//    }
//}