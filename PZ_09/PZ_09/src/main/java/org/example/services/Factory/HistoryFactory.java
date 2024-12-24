package org.example.services.Factory;

import org.example.model.History;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class HistoryFactory
{
    public History createItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cost: ");
        Double cost = scanner.nextDouble();
        System.out.print("Total order cost: ");
        Double totalcost = scanner.nextDouble();
        scanner.nextLine();
        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Date created = new java.sql.Date(now.getTime());
        System.out.print("Client Firstname: ");
        String clientFirstname = scanner.nextLine();
        System.out.print("Client Lastname: ");
        String clientLastname = scanner.nextLine();
        System.out.print("Staff FirstName: ");
        String staffFirstname = scanner.nextLine();
        System.out.print("Staff LastName: ");
        String staffLastname = scanner.nextLine();
        History history = new History(cost, totalcost, created, clientFirstname, clientLastname, staffFirstname, staffLastname);
        return history;
    }
}
