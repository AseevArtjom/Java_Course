package main;

import java.util.Scanner;

public class Task_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter six-digit number : ");
        String input = scanner.nextLine();

        if (input.length() == 6) {
            char[] digits = input.toCharArray();

            char tmp = digits[0];
            digits[0] = digits[5];
            digits[5] = tmp;

            tmp = digits[1];
            digits[1] = digits[4];
            digits[4] = tmp;
            String result = new String(digits);
            System.out.println("Result : " + result);
        } else {
            System.out.println("You must enter a six-digit number.");
        }
    }
}
