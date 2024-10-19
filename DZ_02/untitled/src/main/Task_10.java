package main;

import java.util.ArrayList;
import java.util.Random;

public class Task_10 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[20];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(201) - 100;
        }
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        ArrayList<Integer> positiveNumbers = new ArrayList<>();

        for (int num : array) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }

            if (num < 0) {
                negativeNumbers.add(num);
            } else if (num > 0) {
                positiveNumbers.add(num);
            }
        }

        System.out.println("Original array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("\nEven numbers:");
        for (int num : evenNumbers) {
            System.out.print(num + " ");
        }

        System.out.println("\n\nOdd numbers:");
        for (int num : oddNumbers) {
            System.out.print(num + " ");
        }

        System.out.println("\n\nNegative numbers:");
        for (int num : negativeNumbers) {
            System.out.print(num + " ");
        }

        System.out.println("\n\nPositive numbers:");
        for (int num : positiveNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
