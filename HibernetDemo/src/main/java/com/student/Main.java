package com.student;

import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Main {

    private  static EntityManagerFactory emf ;
    private static EntityManager em;
    private static EntityTransaction et;


    public static void main(String[] args) {

         emf = Persistence.createEntityManagerFactory("HND");
         em = emf.createEntityManager();
         et = em.getTransaction();

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("..............................");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Find Student by Id");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("..............................");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    add();
                    break;

                case 2:
                    update();
                    break;

                case 3:
                    System.out.println("Find Student by Id selected");
                    break;

                case 4:
                    System.out.println("Delete Student selected");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        em.close();
        emf.close();
        sc.close();
    }

    public static void add() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Id: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Course: ");
        String course = sc.nextLine();

        Student st = new Student(id, name, course);

            et.begin();
            em.persist(st);
            et.commit();
            System.out.println("Student added successfully!");

        em.close();
        emf.close();
    }

    public static void update() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Id: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter New Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Student Course: ");
        String course = sc.nextLine();

        et.begin();
        Student st = em.find(Student.class, id);
        if (st != null) {

            st.setName(name);
            st.setCourse(course);
            em.merge(st);

            et.commit();

            System.out.println("Student updated successfully!");

        } else {

            System.out.println("Student not found!");
        }

        em.close();
        emf.close();
    }

}