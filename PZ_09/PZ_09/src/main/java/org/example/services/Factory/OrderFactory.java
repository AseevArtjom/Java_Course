package org.example.services.Factory;

import org.example.model.Order;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static org.example.services.menu.MenuPublisher.showClients;
import static org.example.services.menu.MenuPublisher.showStaff;

public class OrderFactory
{
    public Order createItem(){
        Scanner scanner = new Scanner(System.in);
        showClients();
        System.out.print("ClientId: ");
        Long clientdId = scanner.nextLong();
        showStaff();
        System.out.print("StaffId: ");
        Long staffId = scanner.nextLong();
        System.out.print("Total cost: ");
        Double totalcost = scanner.nextDouble();
        Date created = Calendar.getInstance().getTime();
        Order order = new Order(clientdId,staffId,totalcost,created);
        return order;
    }
}
