import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(System.getProperty("user.dir"));

        System.out.print("Enter file path: ");
        String filepath = "DZ_07/src/";
        filepath += scanner.nextLine();
        System.out.println(filepath);

        try {
            File file = new File(filepath);
            if (!file.exists()) {
                System.out.println("File not found: " + filepath);
                return;
            }


            String longestLine = "";
            int maxLength = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.length() > maxLength) {
                        maxLength = line.length();
                        longestLine = line;
                    }
                }
            }

            System.out.println("Longest line: " + longestLine + " (" + maxLength + " chars)");

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
