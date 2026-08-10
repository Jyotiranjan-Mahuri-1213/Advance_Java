package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainDAO {

    public void addTrain(Train train) {

        String sql = """
            insert into trains
            ( train_number, train_name, source, destination, total_seats,
                available_seats,ticket_price)
            values (?, ?, ?, ?, ?, ?, ?)""";

        try {

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, train.trainNumber);
            ps.setString(2, train.trainName);
            ps.setString(3, train.source);
            ps.setString(4, train.destination);
            ps.setInt(5, train.totalSeats);
            ps.setInt(6, train.availableSeats);
            ps.setDouble(7, train.ticketPrice);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Train added successfully.");

            } else
            {
                System.out.println("Failed");
            }
            ps.close();
            con.close();

        } catch (SQLException e) {

            System.out.println("Connection Error ");

            e.printStackTrace();
        }
    }

    public void viewTrains() {

        String sql = "select * from trains";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            System.out.println(
                    "\n========== train lists =========="
            );

            while (rs.next()) {

                found = true;

                System.out.println("\nTrain ID: " + rs.getInt("train_id"));
                System.out.println("Train Number: " + rs.getString("train_number"));
                System.out.println("Train Name: " + rs.getString("train_name"));
                System.out.println("Source: " + rs.getString("source"));
                System.out.println("Destination: " + rs.getString("destination"));
                System.out.println("Total Seats: " + rs.getInt("total_seats"));
                System.out.println("Available Seats: " + rs.getInt("available_seats"));
                System.out.println("Ticket Price: " + rs.getDouble("ticket_price"));
                System.out.println("------------------------------");
            }

            if (!found) {

                System.out.println("No trains found.");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {

            System.out.println("Error while viewing trains.");
            e.printStackTrace();
        }
    }

    public void updateTrain(Train train) {
        String sql = """ 
            update trains set train_number = ?, train_name = ?, source = ?, destination = ?,
             total_seats = ?,available_seats = ?,ticket_price = ? where train_id = ? """;

        try {

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, train.trainNumber);
            ps.setString(2, train.trainName);
            ps.setString(3, train.source);
            ps.setString(4, train.destination);
            ps.setInt(5, train.totalSeats);
            ps.setInt(6, train.availableSeats);
            ps.setDouble(7, train.ticketPrice);
            ps.setInt(8, train.trainId);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Train updated successfully.");

            } else
            {
                System.out.println("Train ID not found.");
            }
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error while updating train.");

            e.printStackTrace();
        }

    }

    public void deleteTrain(int trainId) {

        String sql = "delete from trains where train_id = ?";

        try {

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, trainId);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Train deleted successfully.");

            } else
            {
                System.out.println(" not found.");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {

            System.out.println("Error in deletion.");

            e.printStackTrace();
        }


    }


    public void searchTrain(
            String source,
            String destination
    ) {

        String sql = """
        select * from trains where source = ?
        and destination = ? """;

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, source);
            ps.setString(2, destination);
            ResultSet rs = ps.executeQuery();

            boolean found = false;

            System.out.println("\n===== Available trains =====");

            while (rs.next()) {

                found = true;

                System.out.println("\nTrain id: " + rs.getInt("train_id"));

                System.out.println(
                        "Train number: " + rs.getString("train_number"));

                System.out.println("Train Name: " + rs.getString("train_name"));

                System.out.println("Source: " + rs.getString("source"));

                System.out.println("Destination: " + rs.getString("destination"));

                System.out.println("Available Seats: " + rs.getInt("available_seats"));
                System.out.println("Ticket Price: " + rs.getDouble("ticket_price"));

                System.out.println("--------------------------");
            }

            if (!found) {

                System.out.println(
                        "No matching train found."
                );
            }

            rs.close();

            ps.close();

            con.close();

        } catch (SQLException e) {

            System.out.println(
                    "Error while searching train."
            );

            e.printStackTrace();
        }


    }

}
