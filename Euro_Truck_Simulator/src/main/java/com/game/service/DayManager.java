package com.game.service;

import com.game.model.Driver;
import com.game.model.Request;
import com.game.model.Truck;
import com.game.service.DriverService.DriverService;
import com.game.service.RequestService.RequestService;
import com.game.service.TruckService.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DayManager {

    private static final String DAY_FILE = "src/main/resources/game_day.txt";
    private int currentDay;

    private final TxtFileReader txtFileReader;
    private final RequestService requestService;
    private final TruckService truckService;
    private final DriverService driverService;

    @Autowired
    public DayManager(TxtFileReader txtFileReader, RequestService requestService,
                      TruckService truckService, DriverService driverService) {
        this.txtFileReader = txtFileReader;
        this.requestService = requestService;
        this.truckService = truckService;
        this.driverService = driverService;
        this.currentDay = loadDay();
    }

    private int loadDay() {
        try {
            if (Files.exists(Paths.get(DAY_FILE))) {
                return Integer.parseInt(txtFileReader.readFile(DAY_FILE).get(0).trim());
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return 1;
    }

    public void saveDay() {
        try {
            Files.write(Paths.get(DAY_FILE), (String.valueOf(currentDay) + System.lineSeparator()).getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void nextDay() {
        currentDay++;
        updateRequestsForNextDay();
        saveDay();
    }

    private void updateRequestsForNextDay() {
        List<Request> ongoingRequests = requestService.findByProgressTrue();
        for (Request request : ongoingRequests) {
            request.decrementRemainingDays();
            if (request.getRemainingDays() <= 0) {
                request.setProgress(false);
                request.setRemainingDays(0);
                requestService.update(request);

                Driver driver = request.getDriver();
                if (driver != null) {
                    driver.setIsInTrip(false);
                    driverService.update(driver);
                }

                Truck truck = request.getTruck();
                if (truck != null) {
                    truck.setIsInTrip(false);
                    truckService.update(truck);
                }

                if(driver != null){
                    Double profit = request.getProfit();
                    driver.addProfit(profit);
                    driverService.update(driver);
                }
            } else {
                requestService.update(request);
            }
        }
    }

}
