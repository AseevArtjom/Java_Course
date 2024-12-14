package org.example.services;

import org.example.exceptions.PropertyFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.lang.System.getProperty;
import static java.lang.System.in;

public class PropertyReader
{
    public Properties readProperties() throws PropertyFileException{
        Properties property = new Properties();
        String result = getProperty("test");

        if(result.equals("false")){
            try(FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties"))
            {
                property.load(fileInputStream);
                return property;
            }
            catch (IOException ex){
                throw new PropertyFileException("Error open file property");
            }
        }
        else{
            try(FileInputStream inputStream = new FileInputStream("src/test/resources/application-test.properties"))
            {
                property.load(inputStream);
                return property;
            }
            catch (IOException ex){
                throw new PropertyFileException("Error open file property");
            }
        }
    }
}
