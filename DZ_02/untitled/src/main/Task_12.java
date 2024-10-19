package main;

import java.util.Arrays;
import java.util.Scanner;

public class Task_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of array : ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter elements of array : ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int choice;
        do {
            System.out.print("1 - upper\t2 - lower\n");
            choice = scanner.nextInt();
        }while (choice < 1 || choice > 2);

        switch (choice){
            case 1:
                sortArray(array, true);
                System.out.println("Array sorted upper : " + Arrays.toString(array));
                break;
            case 2:
                sortArray(array, false);
                System.out.println("Array sorted in lower : " + Arrays.toString(array));
                break;
        }
    }

    public static void sortArray(int[] array, boolean upper) {
        Arrays.sort(array);
        if (!upper) {
            for (int i = 0; i < array.length / 2; i++) {
                int tmp = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = tmp;
            }
        }
    }
}
