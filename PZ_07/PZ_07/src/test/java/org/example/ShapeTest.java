package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import models.Shape;
import models.Triangle;
import static junit.framework.Assert.assertEquals;


public class ShapeTest
{
    @Test
    public void TestTriangleArea(){
        Shape triangle = new Triangle(12,5);
        assertEquals(25.0,triangle.calculateArea(),0.01);
    }
}
