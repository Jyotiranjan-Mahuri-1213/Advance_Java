package com.student;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   public static void main(String[] args) {
       EntityManagerFactory emf= Persistence.createEntityManagerFactory("HND");
       EntityManager em = emf.createEntityManager();
       EntityTransaction et= em.getTransaction();
       Student st=new Student(101, "jyoti","MCA");

       et.begin();
       em.persist(st);
       et.commit();

    }
}
