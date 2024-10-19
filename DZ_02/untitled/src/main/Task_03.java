package main;

import java.util.Scanner;

public class Task_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number : ");
        int digit1 = scanner.nextInt();
        System.out.print("Enter the second number : ");
        int digit2 = scanner.nextInt();
        System.out.print("Enter the third number : ");
        int digit3 = scanner.nextInt();
        int result = digit1 * 100 + digit2 * 10 + digit3;
        System.out.println("Result : " + result);
    }
}
