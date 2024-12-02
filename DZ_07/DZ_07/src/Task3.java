import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Task3
{
    public static void main(String[] args) {
        String filePath = "DZ_07/src/Task3.txt";
        createFiles(4, 20, 150, filePath);

        List<int[]> arrays = readArraysFromFile(filePath);

        int globalMin = Integer.MAX_VALUE;
        int globalMax = Integer.MIN_VALUE;
        int globalSum = 0;

        for (int i = 0; i < arrays.size(); i++) {
            int[] array = arrays.get(i);
            System.out.println("Array " + (i + 1) + ": " + arrayToString(array));

            int localMin = Integer.MAX_VALUE;
            int localMax = Integer.MIN_VALUE;
            int localSum = 0;

            for (int num : array) {
                if (num < localMin) {
                    localMin = num;
                }
                if (num > localMax) {
                    localMax = num;
                }
                localSum += num;
            }

            System.out.println("  Local Min: " + localMin);
            System.out.println("  Local Max: " + localMax);
            System.out.println("  Local Sum: " + localSum);

            globalMin = Math.min(globalMin, localMin);
            globalMax = Math.max(globalMax, localMax);
            globalSum += localSum;
        }

        System.out.println("\nGlobal Results:");
        System.out.println("  Global Min: " + globalMin);
        System.out.println("  Global Max: " + globalMax);
        System.out.println("  Global Sum: " + globalSum);
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private static void createFiles(int ArraysCount,int maxArraySize,int maxValue,String filePath){
        Random random = new Random();
        try {
            File file = new File(filePath);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (int i = 0; i < ArraysCount; i++) {
                    int arraySize = random.nextInt(maxArraySize) + 1;
                    for (int j = 0; j < arraySize; j++) {
                        writer.write(random.nextInt(maxValue) + 1 + " ");
                    }
                    writer.newLine();
                }
            }
            System.out.println("File created with random data: " + file.getAbsolutePath());
        } catch (Exception ex) {
            System.out.println("Error creating file: " + ex);
        }
    }
    private static List<int[]> readArraysFromFile(String path){
        List<int[]> arrays = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                int[] array = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
                arrays.add(array);
            }
            return arrays;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
        return arrays;
    }
}