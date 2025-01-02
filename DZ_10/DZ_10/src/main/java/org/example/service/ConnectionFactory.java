package org.example.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.example.exception.ConnectionDBException;

import static java.lang.Class.forName;

public class ConnectionFactory
{
    private static final String DRIVER;
    private static final String DBURL;
    private static final String USER;
    private static final String PASSWORD;

    private static ConnectionFactory factory;

    private Connection connection;

    static {
        Properties prop = PropertyFactory.getInstance().getProperty();
        DRIVER = prop.getProperty("db.driver");
        DBURL = prop.getProperty("db.dburl");
        USER = prop.getProperty("db.user");
        PASSWORD = prop.getProperty("db.password");
    }

    public Connection makeConnection() throws ConnectionDBException {
        try {
            forName(DRIVER);
            connection = DriverManager.getConnection(DBURL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new ConnectionDBException("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            throw new ConnectionDBException("Error with connect to DB: " + e.getMessage());
        }
        return connection;
    }


    public static ConnectionFactory getInstance(){
        if(factory == null){
            factory = new ConnectionFactory();
        }
        return factory;
    }
    private ConnectionFactory(){}
}
