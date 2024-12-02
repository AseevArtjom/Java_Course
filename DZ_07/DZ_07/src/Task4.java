import java.io.*;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String filePath = "DZ_07/src/" + scanner.nextLine();

        System.out.print("Enter array elements : ");
        String[] input = scanner.nextLine().split("\\s+");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(arrayToString(array));
            writer.newLine();

            writer.write(arrayToString(filterArray(array, true)));
            writer.newLine();

            writer.write(arrayToString(filterArray(array, false)));
            writer.newLine();

            writer.write(arrayToString(reverseArray(array)));
            writer.newLine();

            System.out.println("Data array was written to file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static int[] filterArray(int[] array, boolean even) {
        return java.util.Arrays.stream(array)
                .filter(num -> even ? num % 2 == 0 : num % 2 != 0)
                .toArray();
    }

    private static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }
}
