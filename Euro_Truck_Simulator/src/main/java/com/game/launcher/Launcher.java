package com.game.launcher;

import com.game.model.Driver;
import com.game.model.Request;
import com.game.model.Truck;
import com.game.service.DestinationService.DestinationService;
import com.game.service.DriverService.DriverRandomizer;
import com.game.service.DriverService.DriverService;
import com.game.service.ProductTypeService.ProductTypeService;
import com.game.service.RequestService.RequestService;
import com.game.service.TruckService.TruckRandomizer;
import com.game.service.TruckService.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.game.service.DayManager;

import static com.game.launcher.GamePublisher.*;

@Component
public class Launcher
{
    @Autowired
    private GamePublisher gamePublisher;
    @Autowired
    private DriverRandomizer driverRandomizer;
    @Autowired
    private TruckRandomizer truckRandomizer;
    @Autowired
    private DriverService driverService;
    @Autowired
    private DestinationService destinationService;
    @Autowired
    private RequestService requestService;
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private TruckService truckService;

    @Autowired
    private DayManager dayManager;

    private List<Driver> availableDrivers = new ArrayList<>();
    private List<Driver> hiredDrivers;


    public Launcher(){}

    private void InitializeData() throws IOException {
        driverService.initializeDrivers();
        truckService.initializeTrucks();
        productTypeService.initializeProductTypes();
        destinationService.initializeDestinations();
        requestService.initializeRequests();
        UpdateHiredDrivers();
    }

    public void Start() throws IOException,InterruptedException {
        InitializeData();

        System.out.println("\n" +
                "███████╗██╗░░░██╗██████╗░░█████╗░  ████████╗██████╗░██╗░░░██╗░█████╗░██╗░░██╗\n" +
                "██╔════╝██║░░░██║██╔══██╗██╔══██╗  ╚══██╔══╝██╔══██╗██║░░░██║██╔══██╗██║░██╔╝\n" +
                "█████╗░░██║░░░██║██████╔╝██║░░██║  ░░░██║░░░██████╔╝██║░░░██║██║░░╚═╝█████═╝░\n" +
                "██╔══╝░░██║░░░██║██╔══██╗██║░░██║  ░░░██║░░░██╔══██╗██║░░░██║██║░░██╗██╔═██╗░\n" +
                "███████╗╚██████╔╝██║░░██║╚█████╔╝  ░░░██║░░░██║░░██║╚██████╔╝╚█████╔╝██║░╚██╗\n" +
                "╚══════╝░╚═════╝░╚═╝░░╚═╝░╚════╝░  ░░░╚═╝░░░╚═╝░░╚═╝░╚═════╝░░╚════╝░╚═╝░░╚═╝\n" +
                "\n" +
                "░██████╗██╗███╗░░░███╗██╗░░░██╗██╗░░░░░░█████╗░████████╗░█████╗░██████╗░\n" +
                "██╔════╝██║████╗░████║██║░░░██║██║░░░░░██╔══██╗╚══██╔══╝██╔══██╗██╔══██╗\n" +
                "╚█████╗░██║██╔████╔██║██║░░░██║██║░░░░░███████║░░░██║░░░██║░░██║██████╔╝\n" +
                "░╚═══██╗██║██║╚██╔╝██║██║░░░██║██║░░░░░██╔══██║░░░██║░░░██║░░██║██╔══██╗\n" +
                "██████╔╝██║██║░╚═╝░██║╚██████╔╝███████╗██║░░██║░░░██║░░░╚█████╔╝██║░░██║\n" +
                "╚═════╝░╚═╝╚═╝░░░░░╚═╝░╚═════╝░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░░╚════╝░╚═╝░░╚═╝");

        Thread.sleep(500);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("_".repeat(20) + "DAY " + dayManager.getCurrentDay() + "_".repeat(20));
            gamePublisher.showMenu();
            System.out.print("Action: ");
            choice = scanner.nextInt();
            if(choice == 1){
                gamePublisher.showHiredDrivers();
            }
            else if(choice == 2){
                gamePublisher.showBoughtTrucks();
            }
            else if(choice == 3){
                RequestsMenu(scanner);
            }
            else if(choice == 4){
                gamePublisher.showAvailableDriversToHire();
                hireDriver(scanner);
            }
            else if(choice == 5){
                gamePublisher.showHiredDrivers();
                fireDriver(scanner);
            }
            else if(choice == 6)
            {
                gamePublisher.showTrucksAvailableForBuying();
                BuyNewTruck(scanner);
            }
            else if(choice == 7){
                gamePublisher.showBoughtTrucks();
                SellTruck(scanner);
            }
            else if(choice == 8){
                dayManager.nextDay();
            }
        }while (choice != 0);
    }

    private void RequestsMenu(Scanner scanner){
        int choice;
        do {
            gamePublisher.showRequestsMenu();
            System.out.print("Action: ");
            choice = scanner.nextInt();

            if (choice == 1){
                gamePublisher.showOnGoingRequests();
            }
            else if(choice == 2)
            {
                gamePublisher.showAvailableRequests();
            }
            else if(choice == 3)
            {
                TakeRequest(scanner);
            }
        }
        while (choice != 0);
    }

    private void TakeRequest(Scanner scanner) {
        List<Request> AvailableRequests = requestService.findByProgressFalse();
        gamePublisher.printMap();
        int RequestChoice;

        do {
            gamePublisher.showAvailableRequests();
            System.out.print("Request: ");
            RequestChoice = scanner.nextInt();
        } while (RequestChoice < 1 || RequestChoice > AvailableRequests.size());

        Request selectedRequest = AvailableRequests.get(RequestChoice - 1);
        float requiredDriverExperience = selectedRequest.getRequired_experience();

        List<Driver> availableDrivers = driverService.findDriverByIsInTripFalseAndIsHiredTrue();
        if(availableDrivers.isEmpty()){
            System.out.println(ANSI_RED + "There are no available drivers" + ANSI_RESET);
            return;
        }

        int DriverChoice;
        Driver selectedDriver;
        do {
            gamePublisher.showAvailableDriversToTrip(requiredDriverExperience);
            System.out.print("Selected driver: ");
            DriverChoice = scanner.nextInt();
            if (DriverChoice < 1 || DriverChoice > availableDrivers.size()) {
                System.out.println(ANSI_RED + "Invalid driver selection" + ANSI_RESET);
            } else {
                selectedDriver = availableDrivers.get(DriverChoice - 1);
                if (selectedDriver.getExperience() < requiredDriverExperience) {
                    System.out.println(ANSI_RED + "The selected driver does not have enough experience for this request" + ANSI_RESET);
                } else {
                    break;
                }
            }
        } while (true);

        Double requiredMaxWeight = selectedRequest.getWeight();
        List<Truck> BoughtTrucks = truckService.findByBoughtTrue();
        int TruckChoice;

        if(BoughtTrucks.isEmpty()){
            System.out.println(ANSI_RED + "There are no available trucks" + ANSI_RESET);
            return;
        }
        Truck selectedTruck;
        do {
            gamePublisher.showAvailableTrucksToTrip(requiredMaxWeight);
            System.out.print("Selected truck: ");
            TruckChoice = scanner.nextInt();
            if(TruckChoice < 1 || TruckChoice > BoughtTrucks.size()){
                System.out.println(ANSI_RED + "Invalid truck selection" + ANSI_RESET);
            }
            else{
                selectedTruck = BoughtTrucks.get(TruckChoice - 1);
                if(selectedTruck.getMaxWeight() < requiredMaxWeight){
                    System.out.println(ANSI_RED + "The selected truck has insufficient tonnage" + ANSI_RESET);
                }
                else {
                    break;
                }
            }
        }while (true);

        selectedRequest.setProgress(true);
        selectedRequest.setDriver(selectedDriver);
        selectedRequest.setTruck(selectedTruck);
        selectedRequest.setRemainingDays(selectedRequest.getDeliveryDays());

        requestService.update(selectedRequest);
        selectedDriver.setIsInTrip(true);
        driverService.update(selectedDriver);
        selectedTruck.setIsInTrip(true);
        truckService.update(selectedTruck);
    }



    private void BuyNewTruck(Scanner scanner) throws IOException{
        List<Truck> AvailableTrucks = truckService.findByBoughtFalse();
        int choice;
        do {
            System.out.print("Truck: ");
            choice = scanner.nextInt();
        }while (choice < 1 || choice > AvailableTrucks.size());
        Truck SelectedTruck = AvailableTrucks.get(choice - 1);
        SelectedTruck.setBought(true);
        truckService.update(SelectedTruck);
        truckService.save(truckRandomizer.generateRandomTruck());
    }

    private void SellTruck(Scanner scanner){
        List<Truck> BoughtTrucks = truckService.findByBoughtTrue();
        if(BoughtTrucks.isEmpty()){
            System.out.println(ANSI_RED + "There are no available trucks for selling" + ANSI_RESET);
            return;
        }
        int choice;
        do {
            System.out.print("Truck for selling: ");
            choice = scanner.nextInt();
        }while (choice < 1 || choice > BoughtTrucks.size());
        Truck SelectedTruck = BoughtTrucks.get(choice - 1);
        truckService.delete(SelectedTruck);
    }

    private void hireDriver(Scanner scanner) throws IOException {
        if (availableDrivers.isEmpty()) {
            generateDriversIfNeeded();
        }

        int choice;
        do{
            System.out.print("Choose driver to hire: ");
            choice = scanner.nextInt() - 1;
        }while (choice < 0 || choice > availableDrivers.size());

        Driver hiredDriver = availableDrivers.remove(choice);
        hiredDriver.setIsHired(true);
        driverService.save(hiredDriver);
        UpdateHiredDrivers();

        System.out.println("Hired driver: " + hiredDriver.getName());

        generateDriversIfNeeded();
    }

    private void fireDriver(Scanner scanner) {
        if (hiredDrivers.isEmpty()) {
            System.out.println(ANSI_RED + "There's no one to fire" + ANSI_RESET);
            return;
        }

        int choice;
        do {
            System.out.print("Choose driver to fire: ");
            choice = scanner.nextInt() - 1;
        } while (choice < 0 || choice >= hiredDrivers.size());
        Driver firedDriver = hiredDrivers.remove(choice);
        driverService.delete(firedDriver);

        UpdateHiredDrivers();

        System.out.println("Fired and removed driver: " + firedDriver.getName());
    }


    private void generateDriversIfNeeded() throws IOException {
        List<Driver> availableFromDb = driverService.findByIsHiredFalse();

        int currentCount = availableFromDb.size();
        if (currentCount < 5) {
            int missingDrivers = 5 - currentCount;

            for (int i = 0; i < missingDrivers; i++) {
                Driver newDriver = driverRandomizer.generateRandomDriver();
                availableFromDb.add(newDriver);
                driverService.save(newDriver);
            }
        }

        availableDrivers = availableFromDb;
    }

    private void UpdateHiredDrivers(){
        hiredDrivers = driverService.findByIsHiredTrue();
    }
}
