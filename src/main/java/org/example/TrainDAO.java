package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

                System.out.println(
                        "Train added successfully."
                );

            } else {

                System.out.println("Failed");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {

            System.out.println("Connection Error ");

            e.printStackTrace();
        }
    }

}
