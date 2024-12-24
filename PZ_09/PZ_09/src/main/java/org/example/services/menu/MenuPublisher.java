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
import org.example.model.*;

import java.util.List;

public class MenuPublisher
{
    private static final String ACTION_STRING = "Press the number to do action";
    private static final String EMPTY = "Empty";
    private static final String END_LINE = "\n";
    private static final String SEPARATOR = "-";
    private static final String DOT = ". ";
    private static final String EXIT = "0. Exit";
    private static final String BACK = "0. Back";

    private static final String SECTIONS_STRING = "Choose section";

    private static final String CLIENTS = "Clients";
    private static final String SHOW_CLIENTS = "Show all clients";
    private static final String ADD_CLIENT = "Add a new client";
    private static final String DELETE_CLIENT = "Delete client";
    private static final String UPDATE_CLIENT = "Update information about client";

    private static final String STAFF = "Staff";
    private static final String SHOW_STAFF = "Show all staff";
    private static final String ADD_STAFF = "Add a new staff";
    private static final String DELETE_STAFF = "Delete staff";
    private static final String UPDATE_STAFF = "Update information about staff";

    private static final String POSITIONS = "Positions";
    private static final String SHOW_POSITIONS = "Show all positions";
    private static final String ADD_POSITION = "Add a new position";
    private static final String DELETE_POSITION = "Delete position";
    private static final String UPDATE_POSITION = "Update information about position";

    private static final String MENU_ITEM_TYPES = "Menu item types";
    private static final String SHOW_MENU_ITEM_TYPES = "Show all menu item types";
    private static final String ADD_MENU_ITEM_TYPE = "Add a new menu item type";
    private static final String DELETE_MENU_ITEM_TYPE = "Delete menu item type";
    private static final String UPDATE_MENU_ITEM_TYPE = "Update information about menu item type";

    private static final String MENU_ITEMS = "Menu items";
    private static final String SHOW_MENU_ITEMS = "Show menu items";
    private static final String ADD_MENU_ITEM = "Add a new menu item";
    private static final String DELETE_MENU_ITEM = "Delete menu item";
    private static final String UPDATE_MENU_ITEM = "Update information about menu item";

    private static final String ORDERS = "Orders";
    private static final String SHOW_ORDERS = "Show orders";
    private static final String ADD_ORDER = "Add a new order";
    private static final String DELETE_ORDER = "Delete order";
    private static final String UPDATE_ORDER = "Update information about order";

    private static final String HISTORY = "History";
    private static final String SHOW_HISTORY = "Show history";
    private static final String ADD_HISTORY = "Add a new history";
    private static final String DELETE_HISTORY = "Delete history";
    private static final String UPDATE_HISTORY = "Update information about history";

    public static void showMenu(){
        int menuLine = 1;
        StringBuilder resultStr = new StringBuilder();
        resultStr.append(SEPARATOR.repeat(80))
                .append(END_LINE)
                .append(SECTIONS_STRING)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(CLIENTS)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(STAFF)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(POSITIONS)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(MENU_ITEM_TYPES)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(MENU_ITEMS)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(ORDERS)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(HISTORY)
                .append(END_LINE)
                .append(EXIT);
        System.out.println(resultStr.toString());
    }

    public static void showClients(){
        ClientDao clientDao = new ClientDaoImpl();
        List<Client> clients = clientDao.findAll();
        if(clients != null){
            int i = 0;
            for (Client client : clients){
                System.out.print(i++ + 1 + ".");
                client.ToString();
            }
        }
        else{
            System.out.println(EMPTY);
        }
    }

    public static void showPositions(){
        PositionDao positionDao = new PositionDaoImpl();
        List<Position> positions = positionDao.findAll();
        if(positions != null){
            int i = 0;
            for(Position position : positions){
                System.out.print(i++ + 1 + ".");
                position.ToString();
            }
        }
        else{
            System.out.println(EMPTY);
        }
    }

    public static void showMenuItemTypes(){
        MenuItemTypeDao menuItemTypeDao = new MenuItemTypeDaoImpl();
        List<MenuItemType> menuItemTypes = menuItemTypeDao.findAll();
        if(menuItemTypes != null){
            int i = 0;
            for(MenuItemType menuItemType : menuItemTypes){
                System.out.print(i++ + 1 + ".");
                menuItemType.ToString();
            }
        }
    }

    public static void showMenuItems(){
        MenuItemDao menuItemDao = new MenuItemDaoImpl();
        List<MenuItem> menuItems = menuItemDao.findAll();
        if(menuItems != null){
            int i = 0;
            for(MenuItem menuItem : menuItems){
                System.out.print(i++ + 1 + ".");
                menuItem.ToString();
            }
        }
    }

    public static void showStaff(){
        StaffDao staffDao = new StaffDaoImpl();
        List<Staff> staff = staffDao.findAll();
        if(staff != null){
            int i = 0;
            for(Staff current_position : staff){
                System.out.print(i++ + 1 + ".");
                current_position.ToString();
            }
        }
        else{
            System.out.println(EMPTY);
        }
    }

    public static void showOrders(){
        OrderDao orderDao = new OrderDaoImpl();
        List<Order> orders = orderDao.findAll();
        if(orders != null){
            int i = 0;
            for(Order order : orders){
                System.out.print(i++ + 1 + ".");
                order.ToString();
            }
        }
    }

    public static void showHistory(){
        HistoryDao historyDao = new HistoryDaoImpl();
        List<History> histories = historyDao.findAll();
        if(histories != null){
            int i = 0;
            for(History history : histories){
                System.out.print(i++ + 1 + ".");
                history.ToString();
            }
        }
    }

    public static void showClientMenu(){
        StringBuilder resultStr = new StringBuilder();
        int menuLine = 1;
        resultStr.append(SEPARATOR.repeat(80))
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(SHOW_CLIENTS)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(ADD_CLIENT)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(DELETE_CLIENT)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(UPDATE_CLIENT)
                .append(END_LINE)
                .append(BACK);
        System.out.println(resultStr);
    }

    public static void showPositionMenu(){
        StringBuilder resultStr = new StringBuilder();
        int menuLine = 1;
        resultStr.append(SEPARATOR.repeat(80))
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(SHOW_POSITIONS)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(ADD_POSITION)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(DELETE_POSITION)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(UPDATE_POSITION)
                .append(END_LINE)
                .append(BACK);
        System.out.println(resultStr);
    }

    public static void showStaffMenu(){
        StringBuilder resultStr = new StringBuilder();
        int menuLine = 1;
        resultStr.append(SEPARATOR.repeat(80))
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(SHOW_STAFF)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(ADD_STAFF)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(DELETE_STAFF)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(UPDATE_STAFF)
                .append(END_LINE)
                .append(BACK);
        System.out.println(resultStr);
    }

    public static void showMenuItemTypesMenu(){
        StringBuilder resultStr = new StringBuilder();
        int menuLine = 1;
        resultStr.append(SEPARATOR.repeat(80))
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(SHOW_MENU_ITEM_TYPES)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(ADD_MENU_ITEM_TYPE)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(DELETE_MENU_ITEM_TYPE)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(UPDATE_MENU_ITEM_TYPE)
                .append(END_LINE)
                .append(BACK);
        System.out.println(resultStr);
    }

    public static void showMenuItemsMenu(){
        StringBuilder resultStr = new StringBuilder();
        int menuLine = 1;
        resultStr.append(SEPARATOR.repeat(80))
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(SHOW_MENU_ITEMS)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(ADD_MENU_ITEM)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(DELETE_MENU_ITEM)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(UPDATE_MENU_ITEM)
                .append(END_LINE)
                .append(BACK);
        System.out.println(resultStr);
    }

    public static void showOrderMenu(){
        StringBuilder resultStr = new StringBuilder();
        int menuLine = 1;
        resultStr.append(SEPARATOR.repeat(80))
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(SHOW_ORDERS)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(ADD_ORDER)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(DELETE_ORDER)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(UPDATE_ORDER)
                .append(END_LINE)
                .append(BACK);
        System.out.println(resultStr);
    }

    public static void showHistoryMenu(){
        StringBuilder resultStr = new StringBuilder();
        int menuLine = 1;
        resultStr.append(SEPARATOR.repeat(80))
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(SHOW_HISTORY)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(ADD_HISTORY)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(DELETE_HISTORY)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(UPDATE_HISTORY)
                .append(END_LINE)
                .append(BACK);
        System.out.println(resultStr);
    }
}
