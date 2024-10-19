package main;

import java.util.Scanner;

public class Task_08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number : ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number : ");
        int num2 = scanner.nextInt();

        int start = Math.min(num1, num2);
        int end = Math.max(num1, num2);

        for (int i = start; i <= end; i++) {
            System.out.println("Multiplication table for " + i + ":");
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
            System.out.println();
        }
    }
}
