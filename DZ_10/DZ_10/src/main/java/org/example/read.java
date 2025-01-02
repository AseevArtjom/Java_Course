package org.example;

import org.example.exception.ConnectionDBException;
import org.example.service.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.setProperty;

public class read {
    public static void main(String[] args) throws InterruptedException {
        setProperty("test", "false");
        while (true) {
            try (Connection connection = ConnectionFactory.getInstance().makeConnection()) {

                PreparedStatement ps = connection.prepareStatement("SELECT id, message FROM notice WHERE type = 'INFO' AND processed = false");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String message = rs.getString("message");
                    System.out.println("Message: " + message);
                    PreparedStatement deletePs = connection.prepareStatement("DELETE FROM notice WHERE id = ?");
                    deletePs.setInt(1, id);
                    deletePs.executeUpdate();
                    System.out.println("Message with ID " + id + " has been deleted.");
                }

            } catch (ConnectionDBException | SQLException ex) {
                ex.printStackTrace();
            }
            Thread.sleep(1000);
        }
    }
}
