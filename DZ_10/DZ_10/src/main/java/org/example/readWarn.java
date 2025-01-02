package org.example;

import org.example.exception.ConnectionDBException;
import org.example.service.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.setProperty;

public class readWarn {
    public static void main(String[] args) throws InterruptedException {
        setProperty("test", "false");
        while (true) {
            try (Connection connection = ConnectionFactory.getInstance().makeConnection()) {
                PreparedStatement ps = connection.prepareStatement("SELECT id, message FROM notice WHERE type = 'WARN' AND processed = false");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String message = rs.getString("message");
                    System.out.println("Message: " + message);

                    PreparedStatement updatePs = connection.prepareStatement("UPDATE notice SET processed = true WHERE id = ?");
                    updatePs.setInt(1, id);
                    updatePs.executeUpdate();
                    System.out.println("Message with ID " + id + " has been updated.");
                }

            } catch (ConnectionDBException | SQLException ex) {
                ex.printStackTrace();
            }
            Thread.sleep(1000);
        }
    }
}
