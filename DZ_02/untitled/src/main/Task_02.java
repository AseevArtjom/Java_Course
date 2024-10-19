package main;

import java.util.Scanner;

public class Task_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number : " );
        int Number = scanner.nextInt();
        System.out.print("% : ");
        int Procent = scanner.nextInt();

        double result = Number * (Procent * 0.01);
        System.out.print("Result : " + result);
    }
}