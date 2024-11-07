package Model.Menu;

import Model.Building;
import Model.House;
import Model.Residential;
import Model.Shop.Shop;
import Model.Shop.ShopDepartment;
import Model.Street;
import Service.Factory.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static Model.Menu.MenuPublisher.*;

public class MenuExecutor
{
    public static Street street = new Street();
    public static final Scanner scanner = new Scanner(System.in);

    public MenuExecutor(Street street1){
        street = street1;
    }

    public MenuExecutor(){}

    public static void startMenu() {
        int choice;
        do {
            showMenu();
            System.out.print("Action: ");
            choice = scanner.nextInt();

            if (choice == 1) {
                menuItem1Execute();
            } else if (choice == 2) {
                menuItem2Execute();
            } else if(choice == 3){
                menuItem3Execute();
            }
            else if(choice == 4){
                menuItem4Execute();
            }
            else {
                System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        scanner.close();
    }


    public static void menuItem1Execute(){
        showBuildingTypes();
        System.out.print("Building: ");
        int choice = scanner.nextInt();
        BuildingFactory buildingFactory = null;
        do {
            switch (choice){
                case 1:
                    buildingFactory = new ResidentialFactory();
                    break;
                case 2:
                    buildingFactory = new ShopFactory();
                    break;
                case 3:
                    buildingFactory = new HospitalFactory();
                    break;
                case 4:
                    buildingFactory = new SchoolFactory();
                    break;
                case 5:
                    buildingFactory = new CollageFactory();
                    break;
                case 6:
                    buildingFactory = new UniversityFactory();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }while (choice < 1 || choice > ListBuildingTypes.size());

        House building = buildingFactory.createBuilding();
        street.addBuilding(building);
    }

    public static void menuItem2Execute(){
        showBuilding(street);
        System.out.print("Building: ");
        int choice = scanner.nextInt();
        street.removeBuilding(street.getBuildingList().get(choice - 1));
    }

    public static void menuItem3Execute(){
        showBuilding(street);
    }

    public static void menuItem4Execute() {
        List<House> buildings = street.getBuildingList();
        List<House> residentials = buildings.stream().filter(r -> r instanceof Residential).toList();
        if (residentials.isEmpty()) {
            System.out.println("No residential buildings available");
            return;
        }
        Random random = new Random();
        Residential randResidential = (Residential) residentials.get(random.nextInt(residentials.size()));
        System.out.println("Selected residential: " + randResidential.getAddress());

        System.out.print("Enter range: ");
        int range = scanner.nextInt();

        ShopDepartment[] departments = ShopDepartment.values();
        int departmentChoice = -1;
        do {
            System.out.println("Available departments:");
            for (int i = 0; i < departments.length; i++) {
                System.out.println((i + 1) + ". " + departments[i]);
            }
            System.out.print("Select department number: ");
            departmentChoice = scanner.nextInt();
        } while (departmentChoice < 1 || departmentChoice > departments.length);

        ShopDepartment selectedDepartment = departments[departmentChoice - 1];

        int selectedIndex = buildings.indexOf(randResidential);
        List<String> foundShops = new ArrayList<>();

        for (int i = Math.max(0, selectedIndex - range); i <= Math.min(buildings.size() - 1, selectedIndex + range); i++) {
            House house = buildings.get(i);
            if (house instanceof Shop) {
                Shop shop = (Shop) house;
                if (shop.getDepartments().contains(selectedDepartment)) {
                    foundShops.add("Shop at address: " + shop.getAddress());
                }
            }
        }

        if (!foundShops.isEmpty()) {
            System.out.println("Shops with " + selectedDepartment + " department in the neighborhood: ");
            foundShops.forEach(System.out::println);
        } else {
            System.out.println("No shops with the specified department found in the neighborhood");
        }
    }
}
