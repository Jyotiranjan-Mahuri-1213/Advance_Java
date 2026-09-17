package com.student.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.student.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import static java.lang.IO.println;

@WebServlet("/login")
public class LoginController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email =req.getParameter("email");
        String password=req.getParameter("password");
        StudentService svc=new StudentService();

        if (svc.login(email,password)){
            resp.getWriter().println("Login successful");

        }
        else {
            resp.getWriter()
                    .println("invalid");
        }

    }
}