//package com.servelet.controller;
//
//import java.io.IOException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//
//@WebServlet("/login")
//public class StudentLoginController extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//
//        System.out.println("Email: " + email);
//        System.out.println("Password: " + password);
//
//        response.getWriter().println("Login Successful");
//    }
//}