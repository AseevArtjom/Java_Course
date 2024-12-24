package org.example.services.Factory;

import org.example.model.MenuItemType;

import java.util.Scanner;

public class MenuItemTypeFactory
{
    public MenuItemType createItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        MenuItemType menuItemType = new MenuItemType(name);
        return menuItemType;
    }
}
