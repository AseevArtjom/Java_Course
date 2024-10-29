package model;

import java.util.Scanner;

public class Fraction {
    private int Numerator;
    private int Denominator;

    public Fraction(int numerator,int denominator){
        this.Numerator = numerator;
        setDenominator(denominator);
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Numerator : ");
        this.Numerator = scanner.nextInt();

        System.out.print("Denominator : ");
        int denom = scanner.nextInt();
        setDenominator(denom);
    }

    public void print() {
        int numLength = String.valueOf(Numerator).length();
        int denomLength = String.valueOf(Denominator).length();
        int lineLength = Math.max(numLength, denomLength);

        System.out.println(Numerator);

        for (int i = 0; i < lineLength; i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.println(Denominator);
    }


    public void setDenominator(int denominator){
        if(denominator == 0){
            throw new IllegalArgumentException("Denominator must not be equal 0!!!");
        }else {this.Denominator = denominator;}
    }

    public int FindHighestCommonDivisor(int a,int b){
        if(b == 0){
            return a;
        }
        return FindHighestCommonDivisor(b,a % b);
    }

    public void Simplify(){
        int CommonDivisor = FindHighestCommonDivisor(Numerator,Denominator);
        Numerator /= CommonDivisor;
        Denominator /= CommonDivisor;
    }

    public int getNumerator() {
        return Numerator;
    }

    public int getDenominator() {
        return Denominator;
    }

    public void setNumerator(int numerator) {
        Numerator = numerator;
    }

    public Fraction Plus(Fraction other){
        int newNumerator = this.Numerator * other.Denominator + other.Numerator * this.Denominator;
        int newDenominator = this.Denominator * other.Denominator;
        Fraction res = new Fraction(newNumerator,newDenominator);
        res.Simplify();
        return res;
    }

    public Fraction Substract(Fraction other){
        int newNumerator = this.Numerator * other.Denominator - other.Numerator * this.Denominator;
        int newDenominator = this.Denominator * other.Denominator;
        Fraction res = new Fraction(newNumerator,newDenominator);
        res.Simplify();
        return res;
    }

    public Fraction Multiply(Fraction other){
        int newNumerator = this.Numerator * other.Numerator;
        int newDonominator = this.Denominator * other.Denominator;
        Fraction res = new Fraction(newNumerator,newDonominator);
        res.Simplify();
        return res;
    }

    public Fraction Divide(Fraction other){
        int newNumerator = this.Numerator * other.Denominator;
        int newDenominator = this.Denominator * other.Numerator;
        if(newDenominator == 0){
            throw new ArithmeticException("Dividing on 0");
        }
        Fraction res = new Fraction(newNumerator,newDenominator);
        res.Simplify();
        return res;
    }
}
