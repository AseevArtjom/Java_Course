package org.example;

import org.example.dao.clientDAO.ClientDao;
import org.example.dao.clientDAO.ClientDaoImpl;
import org.example.model.Client;
import org.example.services.TestDbInitializer;
import org.example.services.TestInitializer;

import java.sql.Date;


public class App
{
    public static void main( String[] args )
    {
        System.setProperty("test","false");
        TestInitializer test = new TestInitializer();
        test.testInitializer();

        ClientDao clientDao = new ClientDaoImpl();
        clientDao.save(new Client("1234","1234","1234@gmail.com","+123456789",new Date(0),0));
    }
}
