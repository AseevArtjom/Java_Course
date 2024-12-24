package org.example.services.menu;

import org.example.dao.clientDAO.ClientDao;
import org.example.dao.clientDAO.ClientDaoImpl;
import org.example.dao.historyDAO.HistoryDao;
import org.example.dao.historyDAO.HistoryDaoImpl;
import org.example.dao.menuItemDAO.MenuItemDao;
import org.example.dao.menuItemDAO.MenuItemDaoImpl;
import org.example.dao.menuItemTypeDAO.MenuItemTypeDao;
import org.example.dao.menuItemTypeDAO.MenuItemTypeDaoImpl;
import org.example.dao.orderDAO.OrderDao;
import org.example.dao.orderDAO.OrderDaoImpl;
import org.example.dao.positionDAO.PositionDao;
import org.example.dao.positionDAO.PositionDaoImpl;
import org.example.dao.staffDAO.StaffDao;
import org.example.dao.staffDAO.StaffDaoImpl;
import org.example.model.Client;
import org.example.model.Position;
import org.example.model.Staff;
import org.example.services.Factory.*;

import java.util.Scanner;

import static org.example.services.menu.MenuPublisher.*;

public class MenuExecutor
{
    public static final Scanner scanner =new Scanner(System.in);
    private static ClientDao clientDao = new ClientDaoImpl();
    private static PositionDao positionDao = new PositionDaoImpl();
    private static StaffDao staffDao = new StaffDaoImpl();
    private static MenuItemTypeDao menuItemTypeDao = new MenuItemTypeDaoImpl();
    private static MenuItemDao menuItemDao = new MenuItemDaoImpl();
    private static OrderDao orderDao = new OrderDaoImpl();
    private static HistoryDao historyDao = new HistoryDaoImpl();

    public MenuExecutor(){}

    public static void startMenu(){
        int choice;
        do
        {
            showMenu();
            System.out.print("Action: ");
            choice = scanner.nextInt();

            if(choice == 1){
                menuClientExecute();
            }
            else if(choice == 2){
                menuStaffExecute();
            }
            else if(choice == 3){
                menuPositionExecute();
            }
            else if(choice == 4){
                menuItemTypesExecute();
            }
            else if(choice == 5){
                menuItemsExecute();
            }
            else if(choice == 6){
                menuOrderExecute();
            }
            else if(choice == 7){
                menuHistoryExecute();
            }
            else if(choice == 0){
                return;
            }
            else{
                System.out.println("Invalid choice!");
            }
        }
        while (choice != 0);
    }

    public static void menuClientExecute(){
        int choice;
        do {
            showClientMenu();
            System.out.print("Action: ");
            choice = scanner.nextInt();

            if(choice == 1){
                showClients();
            }
            else if(choice == 2){
                ClientFactory factory = new ClientFactory();
                clientDao.save(factory.createItem());
            }
            else if(choice == 3){
                showClients();
                System.out.print("Client to deletion: ");
                choice = scanner.nextInt() - 1;
                clientDao.delete(clientDao.findAll().get(choice));
            }
        }while (choice != 0);
    }

    public static void menuPositionExecute(){
        int choice;
        do{
            showPositionMenu();
            System.out.print("Action: ");
            choice = scanner.nextInt();
            if(choice == 1){
                showPositions();
            }
            else if(choice == 2){
                PositionFactory factory = new PositionFactory();
                positionDao.save(factory.createItem());
            }
            else if(choice == 3){
                showPositions();
                System.out.print("Position for deletion: ");
                choice = scanner.nextInt() - 1;
                positionDao.delete(positionDao.findAll().get(choice));
            }
        }while (choice != 0);
    }

    public static void menuStaffExecute(){
        int choice;
        do{
            showStaffMenu();
            System.out.print("Action: ");
            choice = scanner.nextInt();
            if(choice == 1){
                showStaff();
            }
            else if(choice == 2){
                StaffFactory factory = new StaffFactory();
                staffDao.save(factory.createItem());
            }
            else if(choice == 3){
                showStaff();
                System.out.print("Staff for deletion: ");
                choice = scanner.nextInt() - 1;
                staffDao.delete(staffDao.findAll().get(choice));
            }
        }while (choice != 0);
    }

    public static void menuItemTypesExecute(){
        int choice;
        do{
            showMenuItemTypesMenu();
            System.out.print("Action: ");
            choice = scanner.nextInt();
            if(choice == 1){
                showMenuItemTypes();
            }
            else if(choice == 2){
                MenuItemTypeFactory factory = new MenuItemTypeFactory();
                menuItemTypeDao.save(factory.createItem());
            }
            else if(choice == 3){
                showMenuItemTypes();
                System.out.print("Menu item type for deletion: ");
                choice = scanner.nextInt() - 1;
                menuItemTypeDao.delete(menuItemTypeDao.findAll().get(choice));
            }
        }while (choice != 0);
    }

    public static void menuItemsExecute(){
        int choice;
        do{
            showMenuItemsMenu();
            System.out.print("Action: ");
            choice = scanner.nextInt();
            if(choice == 1){
                showMenuItems();
            }
            else if(choice == 2){
                MenuItemFactory factory = new MenuItemFactory();
                menuItemDao.save(factory.createItem());
            }
            else if(choice == 3){
                showMenuItems();
                System.out.print("Menu item for deletion: ");
                choice = scanner.nextInt() - 1;
                menuItemDao.save(menuItemDao.findAll().get(choice));
            }
        }while (choice != 0);
    }

    public static void menuOrderExecute(){
        int choice;
        do{
            showOrderMenu();
            System.out.print("Action: ");
            choice = scanner.nextInt();
            if(choice == 1){
                showOrders();
            }
            else if(choice == 2){
                OrderFactory factory = new OrderFactory();
                orderDao.save(factory.createItem());
            }
            else if(choice == 3){
                showOrders();
                System.out.print("Order for deletion: ");
                choice = scanner.nextInt() - 1;
                orderDao.save(orderDao.findAll().get(choice));
            }
        }while (choice != 0);
    }

    public static void menuHistoryExecute(){
        int choice;
        do{
            showHistoryMenu();
            System.out.print("Action: ");
            choice = scanner.nextInt();
            if(choice == 1){
                showHistory();
            }
            else if(choice == 2){
                HistoryFactory factory = new HistoryFactory();
                historyDao.save(factory.createItem());
            }
            else if(choice == 3){
                showHistory();
                System.out.print("History for deletion: ");
                choice = scanner.nextInt() - 1;
                historyDao.delete(historyDao.findAll().get(choice));
            }
        }while (choice != 0);
    }
}
