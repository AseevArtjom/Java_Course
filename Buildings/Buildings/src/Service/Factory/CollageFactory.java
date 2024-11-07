package Service.Factory;

import Model.Building;
import Model.Education.Collage;
import Model.House;
import Service.Collage.CollagePrintableFullImpl;

import java.util.Scanner;

public class CollageFactory implements BuildingFactory
{
    @Override
    public House createBuilding() {
        return getInputForBuilding();
    }
    private House getInputForBuilding() {
        Scanner scanner = new Scanner(System.in);
        Collage collage = new Collage(new CollagePrintableFullImpl());

        System.out.println("Address: ");
        collage.setAddress(scanner.nextLine());
        System.out.println("Students count: ");
        collage.setStudentsCount(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Specialization: ");
        collage.setSpecialization(scanner.nextLine());
        return collage;
    }
}
