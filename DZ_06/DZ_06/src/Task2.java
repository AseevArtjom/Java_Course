import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task2
{
    public static void main(String[] args){
        List<String> products = Arrays.asList("Milk","Bread","Juice","Orange","Cheese","Bread","Apples","Bananas","123","test","Milk","Milk");
        System.out.println("Products : " + products);

        List<String> shortproducts = products.stream()
                .filter(name -> name.length() < 5)
                .toList();
        System.out.println("Product name < 5 chars : " + shortproducts);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name for counting : ");
        String prodName = scanner.nextLine();
        long count = products.stream().filter(p -> p.equalsIgnoreCase(prodName)).count();
        System.out.println("Product " + prodName + " was " + count + " times in array");

        System.out.print("Enter letter : ");
        char letter = scanner.nextLine().charAt(0);
        List<String> productsByLetter = products.
                stream().
                filter(prod -> prod.toLowerCase().startsWith(String.valueOf(letter).toLowerCase()))
                .toList();
        System.out.println("Products start with \"" + letter + "\"" + " letter : " + productsByLetter );
    }
}
