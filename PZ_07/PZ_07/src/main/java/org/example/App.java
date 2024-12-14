package org.example;

import models.*;

public class App
{
    public static void main( String[] args )
    {
        Shape triangle = new Triangle(12,5);
        Shape rectangle = new Rectangle(8, 4);
        Shape square = new Square(6);
        Shape rhomb = new Rhomb(7, 10);

        System.out.println("Area of : triangle: " + triangle.calculateArea());
        System.out.println("Area rectangle: " + rectangle.calculateArea());
        System.out.println("Area square: " + square.calculateArea());
        System.out.println("Area rhomb: " + rhomb.calculateArea());
    }
}
