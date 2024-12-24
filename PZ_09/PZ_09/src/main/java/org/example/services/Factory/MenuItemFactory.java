package org.example.services.Factory;

import org.example.model.MenuItem;

import java.util.Scanner;

import static org.example.services.menu.MenuPublisher.showMenuItemTypes;

public class MenuItemFactory
{
    public MenuItem createItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name(eng): ");
        String name_eng = scanner.nextLine();
        System.out.println("Name(ru): ");
        String name_ru = scanner.nextLine();
        showMenuItemTypes();
        System.out.print("TypeId: ");
        Long typeId = scanner.nextLong();
        System.out.println("Cost: ");
        Double cost = scanner.nextDouble();
        MenuItem menuItem = new MenuItem(name_eng,name_ru,typeId,cost);
        return menuItem;
    }
}
