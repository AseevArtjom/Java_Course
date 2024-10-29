package main;

import model.Country;
import model.Fraction;

public class Task_04 {
    public static void main(String[] args) {
        Fraction fraction = new Fraction(20,5);
        Fraction otherFraction = new Fraction(5,2);
        Fraction plus = fraction.Plus(otherFraction);
        plus.print();
        System.out.println();
        Fraction minus = fraction.Substract(otherFraction);
        minus.print();
        System.out.println();
        Fraction multiply = fraction.Multiply(otherFraction);
        multiply.print();
        System.out.println();
        Fraction divide = fraction.Divide(otherFraction);
        divide.print();
        System.out.println();
    }
}