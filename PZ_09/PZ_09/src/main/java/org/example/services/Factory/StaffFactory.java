package org.example.services.Factory;

import org.example.model.Client;
import org.example.model.Staff;

import java.sql.Date;
import java.util.Scanner;

import static org.example.services.menu.MenuPublisher.*;

public class StaffFactory
{
    public Staff createItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Firstname: ");
        String firstname = scanner.nextLine();
        System.out.print("Lastname: ");
        String lastname = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Mail: ");
        String mail = scanner.nextLine();
        showPositions();
        Long positionId = scanner.nextLong();
        Staff staff = new Staff(firstname,lastname,phone,mail,positionId);
        return staff;
    }
}
