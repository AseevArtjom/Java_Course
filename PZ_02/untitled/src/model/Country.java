package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Country {
    private String Name;
    private String Continent;
    private long Population;
    private int PhoneCode;
    private String Capital;
    private ArrayList<String> Cities;

    public Country(){
        Cities = new ArrayList<String>();
    }

    public void InputData(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name : ");
        this.Name = scanner.nextLine();

        System.out.print("Continent : ");
        this.Continent = scanner.nextLine();

        System.out.print("Capital : ");
        this.Capital = scanner.nextLine();

        System.out.print("Population : ");
        this.Population = scanner.nextLong();

        System.out.print("PhoneCode : ");
        this.PhoneCode = scanner.nextInt();
        scanner.nextLine();

        String input;
        System.out.println("Cities : (0 - to exit) : ");
        while (true) {
            System.out.print("City: ");
            input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            Cities.add(input);
        }
    }

    public void printData() {
        System.out.print(
                "{"
                        + "Name - " + Name + ", "
                        + "Continent - " + Continent + ", "
                        + "Capital - " + Capital + ", "
                        + "Population - " + Population + ", "
                        + "PhoneCode - " + PhoneCode + ", "
                        + "Cities - ["
        );
        for (int i = 0; i < Cities.size(); i++) {
            System.out.print(Cities.get(i));
            if (i < Cities.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]}");
    }

    public String getName() {
        return Name;
    }

    public int getPhoneCode() {
        return PhoneCode;
    }

    public ArrayList<String> getCities() {
        return Cities;
    }

    public long getPopulation() {
        return Population;
    }

    public String getCapital() {
        return Capital;
    }

    public String getContinent() {
        return Continent;
    }


    public void setCapital(String capital) {
        Capital = capital;
    }

    public void setCities(ArrayList<String> cities) {
        Cities = cities;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhoneCode(int phoneCode) {
        PhoneCode = phoneCode;
    }

    public void setPopulation(long population) {
        Population = population;
    }
}
