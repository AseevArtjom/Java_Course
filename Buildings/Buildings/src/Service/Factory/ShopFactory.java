package Service.Factory;

import Model.Building;
import Model.House;
import Model.Shop.Shop;
import Model.Shop.ShopDepartment;
import Service.Shop.ShopPrintableFullImpl;

import java.util.Scanner;

public class ShopFactory implements BuildingFactory
{
    @Override
    public House createBuilding() {
        return getInputForBuilding();
    }

    private House getInputForBuilding() {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop(new ShopPrintableFullImpl());
        System.out.print("Address: ");
        shop.setAddress(scanner.nextLine());

        System.out.println("Choose departments for the shop:");
        int choice;
        do {
            for (int i = 0; i < ShopDepartment.values().length; i++) {
                System.out.println((i + 1) + ". " + ShopDepartment.values()[i]);
            }
            System.out.println("0 to finish selecting departments");

            System.out.print("Department number: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                break;
            }
            if (choice >= 1 && choice <= ShopDepartment.values().length) {
                ShopDepartment department = ShopDepartment.values()[choice - 1];
                shop.addDepartment(department);
                System.out.println("Department " + department + " added");
            } else {
                System.out.println("Invalid choice");
            }

        } while (choice != 0);

        return shop;
    }
}
