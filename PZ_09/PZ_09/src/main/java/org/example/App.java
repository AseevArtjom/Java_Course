package org.example;

import org.example.dao.clientDAO.ClientDao;
import org.example.dao.clientDAO.ClientDaoImpl;
import org.example.model.Client;
import org.example.services.TestDbInitializer;
import org.example.services.TestInitializer;
import org.example.services.menu.MenuExecutor;

import java.sql.Date;


public class App
{
    public static void main( String[] args )
    {
        System.setProperty("test","false");
        TestInitializer test = new TestInitializer();
        test.testInitializer();

        MenuExecutor.startMenu();
    }
}
