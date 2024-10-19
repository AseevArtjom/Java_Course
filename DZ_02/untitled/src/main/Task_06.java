package main;

import java.util.Scanner;

public class Task_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter meters : ");
        double meters = scanner.nextDouble();
        int choice;
        do {
            System.out.print("1 - miles\t2 - inches\t3 - yards\n");
            choice = scanner.nextInt();
        }while (choice < 1 || choice > 3);
        System.out.print("Result : " + Convert(choice,meters));
    }
    public  static double Convert(int choice,double meters){
        double result = 0;
        switch (choice){
            case 1:
                result = meters * 0.000621;
                break;
            case 2:
                result = meters * 39.37;
                break;
            case 3:
                result = meters * 1.09;
                break;
        }
        return result;
    }
}
