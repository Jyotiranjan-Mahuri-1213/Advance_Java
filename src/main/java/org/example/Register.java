//package org.example;
//
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebServlet("/register")
//public class Register extends HttpServlet {
//    @Override
//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String course = request.getParameter("course");
//
//        response.setContentType("text/html");
//
//        response.getWriter().println("<html>");
//        response.getWriter().println("<head><title>Registration Details</title></head>");
//        response.getWriter().println("<body>");
//
//        response.getWriter().println("<h1>Registration Successful</h1>");
//
//        response.getWriter().println("<p>ID: " + id + "</p>");
//        response.getWriter().println("<p>Name: " + name + "</p>");
//        response.getWriter().println("<p>Email: " + email + "</p>");
//        response.getWriter().println("<p>Course: " + course + "</p>");
//
//        response.getWriter().println("</body>");
//        response.getWriter().println("</html>");
//    }
//
//
//
//}
