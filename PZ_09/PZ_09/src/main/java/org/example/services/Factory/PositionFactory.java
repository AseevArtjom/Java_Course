package org.example.services.Factory;

import org.example.model.Position;

import java.util.Scanner;

public class PositionFactory
{
    public Position createItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        Position position = new Position(name);
        return position;
    }
}
