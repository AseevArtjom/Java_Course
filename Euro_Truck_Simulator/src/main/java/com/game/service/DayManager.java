package com.game.service;

import com.game.service.TxtFileReader;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DayManager {

    private static final String DAY_FILE = "src/main/resources/game_day.txt";
    private int currentDay;
    private final TxtFileReader txtFileReader;

    public DayManager(TxtFileReader txtFileReader) {
        this.txtFileReader = txtFileReader;
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
        saveDay();
    }
}
