package Service.Factory;

import Model.Building;
import Model.Hospital;
import Model.House;
import Model.Residential;
import Service.Hospital.HospitalPrintableFullImpl;

import java.util.Scanner;

public class HospitalFactory implements BuildingFactory
{
    @Override
    public House createBuilding() {
        return getInputForBuilding();
    }

    private House getInputForBuilding(){
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital(new HospitalPrintableFullImpl());
        System.out.println("Address: ");
        hospital.setAddress(scanner.nextLine());
        return hospital;
    }
}
