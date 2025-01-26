package com.game.service;

import com.game.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
public class DriverRandomizer
{
    private static final Random random = new Random();
    private static TxtFileReader txtFileReader;

    @Autowired
    public DriverRandomizer(TxtFileReader txtFileReader){
        this.txtFileReader = txtFileReader;
    }

    public static Driver generateRandomDriver() throws IOException{
        List<String> names = txtFileReader.readFile("src/main/resources/names.txt");
        List<String> lastNames = txtFileReader.readFile("src/main/resources/lastnames.txt");

        String firstName = names.get(random.nextInt(names.size()));
        String lastName = lastNames.get(random.nextInt(lastNames.size()));

        String fullName = firstName + " " + lastName;
        BigDecimal cash = new BigDecimal(random.nextInt(1000) * 100);
        float experience = random.nextInt(16);

        return new Driver(fullName, cash, experience);
    }
}
