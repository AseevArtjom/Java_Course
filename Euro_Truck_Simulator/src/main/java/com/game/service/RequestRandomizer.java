package com.game.service;

import com.game.dao.DestinationRepository;
import com.game.model.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RequestRandomizer
{
    /*
    private static final Random random = new Random();
    private static TxtFileReader txtFileReader;
    @Autowired
    private static DestinationRepository destinationRepository;

    @Autowired
    public RequestRandomizer(TxtFileReader txtFileReader) throws IOException {
        this.txtFileReader = txtFileReader;
        if(destinationRepository.findAll() == null){
            List<Destination> destinations = new ArrayList<>();
            for (int i = 0; i < txtFileReader.readFile("src/main/resources/cities.txt").size(); i++) {

            }
        }
    }

     */
}
