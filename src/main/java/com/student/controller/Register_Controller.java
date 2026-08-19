package com.student.controller;

import java.io.IOException;

import com.student.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register_Controller extends HttpServlet {

  //  private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
       // System.ou
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        StudentService sts = new StudentService();

        if (sts.register(email, name, password)) {

            response.sendRedirect("login.html");

        } else {

            response.getWriter().println("Registration Failed");

        }
    }
}