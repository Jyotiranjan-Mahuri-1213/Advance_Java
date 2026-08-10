package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.example.entity.Student;
import org.example.service.StudentService;

import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private StudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        Student student = new Student(id,name,email,course);
        studentService.registerStudent(student);

        response.setContentType("text/html");

        response.getWriter().println("<h1>Registration Successful</h1>");
    }
}