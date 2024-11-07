package Service.Factory;

import Model.Building;
import Model.Education.School;
import Model.House;
import Service.School.SchoolPrintableFullIml;

import java.util.Scanner;

public class SchoolFactory implements BuildingFactory
{
    @Override
    public House createBuilding() {
        return getInputForBuilding();
    }
    private House getInputForBuilding(){
        Scanner scanner = new Scanner(System.in);
        School school = new School(new SchoolPrintableFullIml());
        System.out.println("Address: ");
        school.setAddress(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Students count: ");
        school.setStudentsCount(scanner.nextInt());
        return school;
    }
}
