import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String filePath1 = "./src/file1.txt";
            String filePath2 = "./src/file2.txt";

            File file1 = new File(filePath1);
            File file2 = new File(filePath2);

            if(!file1.exists()){
                createFile(filePath1,Arrays.asList("Hello World!","Test","Milk","Apple","Test"));
                createFile(filePath2, Arrays.asList("Test","123","Test123","Milk"));
            }
            else{
                System.out.println("Already exists");
            }

        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    private static void createFile(String filepath, List<String> lines){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath)))
        {
            for (String line : lines){
                writer.write(line);
                writer.newLine();
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        System.out.println("File created : " + filepath);
    }
}