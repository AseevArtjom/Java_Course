package org.example.services;
import org.example.exceptions.FileException;

import static java.lang.System.setProperty;

public class TestInitializer
{
    public void testInitializer(){
        setProperty("test","false");
        try {
            TestDbInitializer.createTables();
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}
