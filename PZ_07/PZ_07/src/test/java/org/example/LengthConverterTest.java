package org.example;

import models.LengthConverter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthConverterTest {

    @Test
    public void testMmToCm() {
        LengthConverter converter = new LengthConverter();
        assertEquals(1.0, converter.mmToCm(10), 0.01);
    }

    @Test
    public void testCmToDm() {
        LengthConverter converter = new LengthConverter();
        assertEquals(1.0, converter.cmToDm(10), 0.01);
    }

    @Test
    public void testDmToM() {
        LengthConverter converter = new LengthConverter();
        assertEquals(1.0, converter.dmToM(10), 0.01);
    }

    @Test
    public void testMToKm() {
        LengthConverter converter = new LengthConverter();
        assertEquals(1.0, converter.mToKm(1000), 0.01);
    }
}
