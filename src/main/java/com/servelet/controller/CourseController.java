package com.servelet.controller;

import com.servelet.dao.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/courses")
public class CourseController extends HttpServlet {

    CourseDAO coursedao = new CourseDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Course Controller: Course request received");

        coursedao.getCourses();

        response.getWriter().println("Course Controller Working");
    }
}