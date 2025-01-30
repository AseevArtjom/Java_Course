package com.game.service.RequestService;

import com.game.dao.DestinationRepository;
import com.game.dao.ProductTypeRepository;
import com.game.dao.RequestRepository;
import com.game.model.Destination;
import com.game.model.ProductType;
import com.game.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RequestRandomizer {

    private Random random = new Random();

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private RequestRepository requestRepository;

    public Destination getRandomDestination() {
        List<Destination> destinations = destinationRepository.findAll();
        if (destinations.isEmpty()) {
            return null;
        }
        return destinations.get(random.nextInt(destinations.size()));
    }

    public Request generateRandomRequest() {
        Destination destination = getRandomDestination();

        if (destination == null) {
            System.out.println("No destinations found in the database.");
            return null;
        }

        double weight = 1 + (70 - 1) * random.nextDouble();
        weight = Math.round(weight * 10.0) / 10.0;

        int requiredExperience = 1 + random.nextInt(8);

        List<ProductType> productTypes = productTypeRepository.findAll();
        if (productTypes.isEmpty()) {
            System.out.println("No product types found in the database.");
            return null;
        }
        ProductType productType = productTypes.get(random.nextInt(productTypes.size()));

        Float distance = destination.getDistance();
        Double baseRatePerKm = 2.0;
        Double weightMultiplier = 0.5;
        Double experienceMultiplier = 1 + (requiredExperience * 0.05);
        Double profit = (baseRatePerKm * (double)distance) + (weight * weightMultiplier);
        profit *= experienceMultiplier;
        profit = Math.round(profit * 100.0) / 100.0;
        int deliveryDays = (int) Math.ceil(distance / 400.0);


        Request request = new Request(weight,deliveryDays,profit,requiredExperience, destination, productType);
        requestRepository.save(request);

        return request;
    }
}