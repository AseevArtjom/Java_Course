package org.example;

import org.example.exception.ConnectionDBException;
import org.example.service.ConnectionFactory;
import org.example.service.TestInitializer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.System.setProperty;
import static java.lang.Thread.sleep;

public class write {
    public static void main(String[] args) throws InterruptedException {
        setProperty("test", "false");
        List<String> names = Arrays.asList("Ivan", "Mike", "Vasiliy", "Petya", "Masha", "123");
        List<String> types = Arrays.asList("INFO", "WARN");
        TestInitializer test = new TestInitializer();
        test.testInitializer();

        while (true) {
            try (Connection connection = ConnectionFactory.getInstance().makeConnection();
                 PreparedStatement ps = connection.prepareStatement("INSERT INTO notice(Message, Type, Processed) VALUES(?, ?, ?)")) {

                Random rand = new Random();
                String random_name = names.get(rand.nextInt(names.size()));
                String random_type = types.get(rand.nextInt(types.size()));
                String message = "Новое сообщение от " + LocalDateTime.now();
                ps.setString(1, message);
                ps.setString(2, random_type);
                ps.setBoolean(3, false);

                ps.executeUpdate();
            } catch (ConnectionDBException | SQLException ex) {
                ex.printStackTrace();
            }
            System.out.print(".");
            Thread.sleep(1000);
        }
    }
}
