package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BookingDAO {
    public void bookTicket(int trainId, List<Passenger> passengers) {
        Connection con = null;
        try {

            con = DBConnection.getConnection();

            con.setAutoCommit(false);

            String checkSeatSql = """
                select available_seats,ticket_price from trains where train_id = ?""";
            PreparedStatement checkSeat = con.prepareStatement(checkSeatSql);

            checkSeat.setInt(1, trainId);

            ResultSet rs = checkSeat.executeQuery();

            if (!rs.next()) {

                System.out.println("Train ID not found.");

                con.rollback();

                return;
            }

            int availableSeats = rs.getInt("available_seats");

            double ticketPrice = rs.getDouble("ticket_price");

            int passengerCount = passengers.size();

            if (availableSeats < passengerCount) {

                System.out.println("no seats available.");

                System.out.println("Available seats: " + availableSeats);

                con.rollback();

                return;
            }

            double totalAmount = ticketPrice * passengerCount;

            String bookingSql = """
                insert into bookings (train_id,  passenger_count, total_amount) values (?, ?, ?)""";

            PreparedStatement bookingPs = con.prepareStatement(bookingSql, Statement.RETURN_GENERATED_KEYS);

            bookingPs.setInt(1, trainId);

            bookingPs.setInt(2, passengerCount);

            bookingPs.setDouble(3, totalAmount);

            int bookingRows = bookingPs.executeUpdate();

            if (bookingRows == 0) {

                throw new SQLException(
                        "can not book."
                );
            }

            ResultSet generatedKeys = bookingPs.getGeneratedKeys();

            int bookingId;

            if (generatedKeys.next()) {

                bookingId =
                        generatedKeys.getInt(1);

            } else {

                throw new SQLException(
                        "Booking ID was not generated."
                );
            }

            String passengerSql = """
                INSERT INTO passengers
                (
                    passenger_name,
                    age,
                    gender,
                    phone_number,
                    booking_id
                )
                VALUES (?, ?, ?, ?, ?)
                """;

            PreparedStatement passengerPs =
                    con.prepareStatement(
                            passengerSql
                    );

            for (
                    Passenger passenger
                    : passengers
            ) {

                passengerPs.setString(
                        1,
                        passenger.passengerName
                );

                passengerPs.setInt(
                        2,
                        passenger.age
                );

                passengerPs.setString(
                        3,
                        passenger.gender
                );

                passengerPs.setString(
                        4,
                        passenger.phoneNumber
                );

                passengerPs.setInt(
                        5,
                        bookingId
                );

                passengerPs.addBatch();
            }

            passengerPs.executeBatch();

            String updateSeatSql = """
                UPDATE trains
                SET available_seats =
                    available_seats - ?
                WHERE train_id = ?
                """;

            PreparedStatement updateSeat =
                    con.prepareStatement(
                            updateSeatSql
                    );

            updateSeat.setInt(
                    1,
                    passengerCount
            );

            updateSeat.setInt(
                    2,
                    trainId
            );

            updateSeat.executeUpdate();

            con.commit();

            System.out.println(
                    "\nTicket booked successfully."
            );

            System.out.println(
                    "Booking ID: "
                            + bookingId
            );

            System.out.println(
                    "Number of passengers: "
                            + passengerCount
            );

            System.out.println(
                    "Total amount: "
                            + totalAmount
            );

            System.out.println(
                    "Remaining seats: "
                            + (
                            availableSeats
                                    - passengerCount
                    )
            );

            generatedKeys.close();

            bookingPs.close();

            passengerPs.close();

            updateSeat.close();

            rs.close();

            checkSeat.close();

        } catch (Exception e) {

            try {

                if (con != null) {

                    con.rollback();
                }

            } catch (SQLException ex) {

                ex.printStackTrace();
            }

            System.out.println(
                    "Booking failed."
            );

            e.printStackTrace();

        } finally {

            try {

                if (con != null) {

                    con.setAutoCommit(true);

                    con.close();
                }

            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }


}
