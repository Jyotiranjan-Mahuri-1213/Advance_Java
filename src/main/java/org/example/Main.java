package org.example;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection con=DBConnection.getConnection();
        TrainDAO trainDAO = new TrainDAO();

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("================================");
            System.out.println(" Select what you want to do");
            System.out.println("================================\n");

            System.out.println("1. Add Train");
            System.out.println("2. View All Trains");
            System.out.println("3. Update Train");
            System.out.println("4. Delete Train");
            System.out.println("5. Search Train");
            System.out.println("6. Book Ticket");
            System.out.println("7. View All Bookings");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:

                    Train train = new Train();

                    System.out.print("Enter train id: ");
                    train.trainId = sc.nextInt();

                    System.out.print("Enter train number: ");
                    train.trainNumber = sc.next();

                    sc.nextLine();

                    System.out.print("Enter train name: ");
                    train.trainName = sc.nextLine();

                    System.out.print("Enter source: ");
                    train.source = sc.nextLine();

                    System.out.print("Enter destination: ");
                    train.destination = sc.nextLine();

                    System.out.print("Enter total seats: ");
                    train.totalSeats = sc.nextInt();

                    train.availableSeats = train.totalSeats;

                    System.out.print("Enter ticket price: ");
                    train.ticketPrice = sc.nextDouble();

                    trainDAO.addTrain(train);

                    break;
                case 2:
                    System.out.println("View All Trains");
                    break;
                case 3:
                    System.out.println("Update Train");
                    break;

                case 4:
                    System.out.println("Delete Train");
                    break;

                case 5:
                    System.out.println("Search Train");
                    break;
                case 6:
                    System.out.println("Book Ticket ");
                    break;
                case 7:
                    System.out.println("View All Bookings");
                    break;
                case 8:
                    System.out.println("!!!! Thank you. Exiting !!!!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
        while (choice != 8);

    }
}