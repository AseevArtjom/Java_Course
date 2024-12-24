package org.example.services.Factory;

import org.example.model.Client;

import java.sql.Date;
import java.util.Scanner;

public class ClientFactory
{
    public Client createItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Firstname: ");
        String firstname = scanner.nextLine();
        System.out.print("Lastname: ");
        String lastname = scanner.nextLine();
        System.out.print("Birth(yyyy/MM/dd/): ");
        String birthStr = scanner.nextLine();
        Date birth = null;
        try {
            Long birthLong = Date.parse(birthStr);
            birth = new Date(birthLong);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            createItem();
        }

        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Mail: ");
        String mail = scanner.nextLine();
        System.out.print("Discount: ");
        Integer discount = scanner.nextInt();
        Client client = new Client(firstname,lastname, birth,phone,mail,discount);
        return client;
    }
}
