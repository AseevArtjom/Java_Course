package main;

import java.util.Random;
import java.util.Scanner;

public class Task_09 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[20];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(201) - 100;
        }

        int min = array[0];
        int max = array[0];
        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;

        for (int num : array) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }

            if (num < 0) {
                negativeCount++;
            } else if (num > 0) {
                positiveCount++;
            } else {
                zeroCount++;
            }
        }

        System.out.println("Array: ");
        for (int num : array) {
            System.out.print(num + ",");
        }

        System.out.println("\nResults:");
        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
        System.out.println("Negative elements: " + negativeCount);
        System.out.println("Positive elements: " + positiveCount);
        System.out.println("Zeros: " + zeroCount);
    }
}
