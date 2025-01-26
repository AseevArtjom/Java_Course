package com.game.launcher;

import com.game.dao.DriverRepository;
import com.game.model.Driver;
import com.game.service.DriverRandomizer;
import com.game.service.DriverService.DriverService;
import com.game.service.TxtFileReader;
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
    private final GamePublisher gamePublisher;
    private final DriverRandomizer driverRandomizer;
    private DriverService driverService;

    private List<Driver> availableDrivers = new ArrayList<>();
    private List<Driver> hiredDrivers;

    private DayManager dayManager;

    @Autowired
    public Launcher(DriverRandomizer driverRandomizer, DriverService driverService, GamePublisher gamePublisher, TxtFileReader txtFileReader) {
        this.driverRandomizer = driverRandomizer;
        this.driverService = driverService;
        this.gamePublisher = gamePublisher;
        this.hiredDrivers = driverService.findByIsHiredTrue();
        this.dayManager = new DayManager(txtFileReader);
    }

    public void Start() throws IOException, InterruptedException {
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
            System.out.print("Action : ");
            choice = scanner.nextInt();
            if(choice == 1){
                gamePublisher.showHiredDrivers();
            }
            else if(choice == 2){

            }
            else if(choice == 3){
                gamePublisher.showAvailableDriversToHire();
                hireDriver(scanner);
            }
            else if(choice == 4){
                gamePublisher.showHiredDrivers();
                fireDriver(scanner);
            }
            else if(choice == 5){
                dayManager.nextDay();
            }
        }while (choice != 0);
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
            System.out.println("No hired drivers to fire.");
            return;
        }
        int choice;
        do {
            System.out.print("Choose driver to fire: ");
            choice = scanner.nextInt() - 1;
        }while (choice < 0 || choice > hiredDrivers.size());

        Driver firedDriver = hiredDrivers.remove(choice);
        firedDriver.setIsHired(false);
        driverService.update(firedDriver);

        UpdateHiredDrivers();

        System.out.println("Fired driver: " + firedDriver.getName());
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
