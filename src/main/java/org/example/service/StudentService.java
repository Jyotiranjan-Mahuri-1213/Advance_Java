package org.example.service;

import org.example.dao.StudentDAO;
import org.example.entity.Student;

public class StudentService {

    private StudentDAO studentDAO = new StudentDAO();

    public void registerStudent(Student student) {

        System.out.println("----- Student Details -----");

        System.out.println("ID     : " + student.getId());
        System.out.println("Name   : " + student.getName());
        System.out.println("Email  : " + student.getEmail());
        System.out.println("Course : " + student.getCourse());

        System.out.println("---------------------------");

        // Send data to DAO
        studentDAO.saveData(student);
    }
}