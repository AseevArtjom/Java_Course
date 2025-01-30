package com.game.service.TruckService;

import com.game.dao.TruckRepository;
import com.game.model.Truck;
import com.game.service.TxtFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class TruckRandomizer
{
    private static final Random random = new Random();
    @Autowired
    private TruckRepository truckRepository;

    @Autowired
    private TxtFileReader txtFileReader;

    public Truck generateRandomTruck() throws IOException {
        List<String> TruckBrands = txtFileReader.readFile("src/main/resources/Truck_Brands.txt");
        List<String> TruckModels = txtFileReader.readFile("src/main/resources/Truck_Models.txt");

        String TruckBrand = TruckBrands.get(random.nextInt(TruckBrands.size()));
        String TruckModel = TruckModels.get(random.nextInt(TruckModels.size()));

        String TruckName = TruckBrand + " " + TruckModel;

        double max_weight = 3 + (int)(random.nextDouble() * 98);

        return new Truck(TruckName,max_weight);
    }
}

