package Model.Menu;

import Model.Street;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuPublisher
{
    private static final String ACTION_STRING = "Press the number to do action";
    private static final String ADD_BUILDING = "Add a new building";
    private static final String SHOW_BUILDINGS = "Show buildings";
    private static final String DELETE_BUILDING = "Delete building";
    private static final String FIND_SHOP_IN_RANGE_FOR_RANDOM_RESIDENTIAL = "Find shop for random residential";
    private static final String BUILDING_LIST = "Building list: ";
    private static final String BUILDING_TYPES = "Building types: ";
    private static final String EMPTY = "Empty";
    private static final String END_LINE = "\n";
    private static final String SEPARATOR = "-";
    private static final String DOT = ". ";
    public static final List<String> ListBuildingTypes = new ArrayList<>(Arrays.asList(
        "Residential",
        "Shop",
        "Hospital",
        "School",
        "Collage",
        "University"
    ));

    public static void showMenu(){
        int menuLine = 1;
        StringBuilder resultStr = new StringBuilder();
        resultStr.append(SEPARATOR.repeat(40))
                .append(END_LINE)
                .append(ACTION_STRING)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(ADD_BUILDING)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(DELETE_BUILDING)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(SHOW_BUILDINGS)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(FIND_SHOP_IN_RANGE_FOR_RANDOM_RESIDENTIAL);
        System.out.println(resultStr.toString());
    }

    public static void showBuilding(Street street){
        if (street != null) {
            StringBuilder resultStr = new StringBuilder();
            resultStr.append(BUILDING_LIST)
                    .append(END_LINE)
                    .append(SEPARATOR.repeat(40))
                    .append(END_LINE);

            System.out.print(resultStr.toString());
            int i = 0;
            for (var currentBuilding : street.getBuildingList()) {
                System.out.print(i++ + 1 + ".");
                currentBuilding.printInfo();
                System.out.print(END_LINE);
            }
            System.out.println(SEPARATOR.repeat(40));
        } else {
            System.out.println(EMPTY);
        }
    }

    public static void showBuildingTypes() {
        StringBuilder resultStr = new StringBuilder();
        int menuLine = 1;
        resultStr.append(BUILDING_TYPES)
                .append(END_LINE)
                .append(SEPARATOR.repeat(40))
                .append(END_LINE);
        for (int i = 0; i < ListBuildingTypes.size(); i++) {
            resultStr.append(menuLine++)
                    .append(DOT)
                    .append(ListBuildingTypes.get(i))
                    .append(END_LINE);
        }
        resultStr.append(SEPARATOR.repeat(40)).append(END_LINE);
        System.out.print(resultStr.toString());
    }


    private MenuPublisher(){}
}
