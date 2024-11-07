package Service.Factory;

import Model.Building;
import Model.House;
import Model.Residential;
import Service.Residential.ResidentialPrintableFullImpl;

import java.util.Scanner;

public class ResidentialFactory implements BuildingFactory
{
    @Override
    public House createBuilding() {
        return getInputForBuilding();
    }

    private House getInputForBuilding(){
        Scanner scanner = new Scanner(System.in);
        Residential residential = new Residential(new ResidentialPrintableFullImpl());
        System.out.println("Address: ");
        residential.setAddress(scanner.nextLine());
        System.out.println("Residents count: ");
        residential.setResidentsCount(scanner.nextInt());
        return residential;
    }
}
