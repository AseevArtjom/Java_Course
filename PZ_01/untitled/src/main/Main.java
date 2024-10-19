package main;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.print("Fall seven times\nand\nstand up eight\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Num 1 : ");
        int number_1 = scanner.nextInt();
        System.out.print("Num 2 : ");
        int number_2 = scanner.nextInt();
        Calculate(number_1,number_2);

        System.out.print("Number 3 : ");
        int number_3 = scanner.nextInt();
        ReverseNumber(number_3);
    }

    static void Calculate(int x,int y){
        System.out.println("Сумма : " + (x + y));
        System.out.println("Разница : " + (x - y));
        System.out.println("Произведение :" + (x * y));
    }
    static void ReverseNumber(int x) {
        String numberStr = String.valueOf(x);
        if(numberStr.length() >= 4){
            for (int i = numberStr.length() - 1; i >= 0; i--) {
                System.out.print(numberStr.charAt(i));
            }
            System.out.println();
        }
        else{
            System.out.println("In number must be 4 digit");
        }
    }

}