package org.example;

import models.*;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class ShapeTest
{
    @Test
    public void TestTriangleArea(){
        Shape triangle = new Triangle(6,3);
        assertEquals(9.0,triangle.calculateArea(),0.01);
    }

    @Test
    public void TestRectangle(){
        Shape rectangle = new Rectangle(10,5);
        assertEquals(50,rectangle.calculateArea(),0.01);
    }

    @Test
    public void TestRhomb(){
        Shape rhomb = new Rhomb(8,4);
        assertEquals(16,rhomb.calculateArea(),0.01);
    }

    @Test
    public void TestSquare(){
        Shape square = new Square(4);
        assertEquals(16,square.calculateArea(),0.01);
    }

}
