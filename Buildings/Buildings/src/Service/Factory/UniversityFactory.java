package Service.Factory;

import Model.Building;
import Model.Education.University;
import Model.House;
import Service.University.UniversityPrintableFullImpl;

import java.util.Scanner;

public class UniversityFactory implements BuildingFactory
{
    @Override
    public House createBuilding() {
        return getInputForBuilding();
    }

    private House getInputForBuilding(){
        Scanner scanner = new Scanner(System.in);
        University university = new University(new UniversityPrintableFullImpl());
        System.out.println("Address: ");
        university.setAddress(scanner.nextLine());
        System.out.println("Students count: ");
        university.setStudentsCount(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Specialization: ");
        university.setSpecialization(scanner.nextLine());
        return university;
    }
}
