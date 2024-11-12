package StringTest;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class StringTest
{
    public static void main(String[] args) {
        String a1 = "test";
        String a2 = new String("test2");
        String a3 = new String(new char[]{'t','e','s','t','3'});

        byte[] byteArray = {116, 101, 115, 116, 52};
        String a4 = new String(byteArray, StandardCharsets.US_ASCII);

        StringBuilder a5 = new StringBuilder("test5");

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);

        String b1 = "Apple,Banana,Lemon,Pear";
        String[] fruits = b1.split(",");

        String longest = "";
        String ShortFruit = "";
        for (String fruit : fruits){
            if(fruit.length() > longest.length()){
                longest = fruit;
                ShortFruit = fruit.substring(0,3);
            }
        }
        System.out.println(longest.toLowerCase());
        System.out.println(ShortFruit);

        String c1 = "  I_new_string  ";
        c1 = c1.trim();
        c1 = c1.replace('_',' ');
        System.out.println(c1);

        Scanner scanner = new Scanner(System.in);
        String d1 = scanner.nextLine();
        System.out.println("You entered: " + d1);

        if(d1.toLowerCase().startsWith("run")){
            System.out.println("Running process");
        }
        if(d1.toLowerCase().endsWith("end")){
            System.out.println("Process ended");
        }
        if(d1.toLowerCase().contains("error")){
            System.out.println("error!!!");
        }

        StringBuilder result = new StringBuilder();
        String[] allStrigns = {a1,a2,a3,a4,a5.toString(),longest,ShortFruit,c1};
        for (int i = 0; i < allStrigns.length; i++) {
            result.append(allStrigns[i]);
            if((i + 1) % 3 == 0){
                result.append("\n");
            }
            else{
                result.append(" ");
            }
        }
        result.reverse();
        System.out.println(result);
    }
}
