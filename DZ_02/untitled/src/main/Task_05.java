package main;

import java.util.Scanner;

public class Task_05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of month : ");
        int month = scanner.nextInt();
        System.out.print("Season : " + getSeason(month));
    }
    public static String getSeason(int month){
        switch (month){
            case 1:
            case 2:
            case 12:
                return "Winter";
            case 3:
            case 4:
            case 5:
                return "Spring";
            case 6:
            case 7:
            case 8:
                return "Summer";
            case 9:
            case 10:
            case 11:
                return "Autumn";
            default:
                return "Number must be in range 1 to 12";
        }
    }
}
