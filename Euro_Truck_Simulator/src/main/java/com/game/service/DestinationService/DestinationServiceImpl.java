package com.game.service.DestinationService;

import com.game.dao.DestinationRepository;
import com.game.dao.DriverRepository;
import com.game.model.Destination;
import com.game.model.Driver;
import com.game.service.TxtFileReader;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DestinationServiceImpl implements DestinationService
{
    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private TxtFileReader txtFileReader;

    @Override
    public void save(Destination destination) { destinationRepository.save(destination); }

    @Override
    public int[] saveDestinationsList(List<Destination> destinations) {
        destinationRepository.saveAll(destinations);
        return new int[0];
    }

    @Override
    public void update(Destination destination) { destinationRepository.save(destination); }

    @Override
    public void delete(Destination destination) { destinationRepository.delete(destination); }

    @Override
    public void deleteAll() { destinationRepository.deleteAll(); }

    @Override
    public List<Destination> findAll() { return destinationRepository.findAll(); }

    @Override
    public boolean existsByName(String name) { return destinationRepository.existsByName(name); }

    @Transactional
    @Override
    public void initializeDestinations() throws IOException{
        List<Destination> existingDestinations = destinationRepository.findAll();
        if (existingDestinations.isEmpty()) {
            List<String> lines = txtFileReader.readFile("src/main/resources/destinations.txt");

            for (String line : lines) {
                String[] parts = line.split(",\\s*");
                String cityName = parts[0].trim();
                Float distance = Float.parseFloat(parts[1].trim());

                if (!destinationRepository.existsByName(cityName)) {
                    Destination destination = new Destination(cityName, distance);
                    destinationRepository.save(destination);
                }
            }
        }
    }
}
