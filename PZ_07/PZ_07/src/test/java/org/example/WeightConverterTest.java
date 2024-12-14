package org.example;

import models.WeightConverter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeightConverterTest {

    @Test
    public void testMgToG() {
        WeightConverter converter = new WeightConverter();
        assertEquals(1.0, converter.mgToG(1000), 0.01);
    }

    @Test
    public void testGToKg() {
        WeightConverter converter = new WeightConverter();
        assertEquals(1.0, converter.gToKg(1000), 0.01);
    }

    @Test
    public void testKgToT() {
        WeightConverter converter = new WeightConverter();
        assertEquals(1.0, converter.kgToT(1000), 0.01);
    }

    @Test
    public void testTToCentner() {
        WeightConverter converter = new WeightConverter();
        assertEquals(10.0, converter.tToCentner(1), 0.01);
    }
}
