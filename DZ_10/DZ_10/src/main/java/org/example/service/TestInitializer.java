package org.example.service;

import static java.lang.System.setProperty;

public class TestInitializer
{
    public void testInitializer(){
        setProperty("test","false");
        try {
            MyDbInitializer.createTables();
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}
