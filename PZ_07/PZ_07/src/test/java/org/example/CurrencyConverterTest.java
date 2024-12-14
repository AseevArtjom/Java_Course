package org.example;

import models.CurrencyConverter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrencyConverterTest {

    @Test
    public void testUsdToEur() {
        CurrencyConverter converter = new CurrencyConverter();
        assertEquals(85.0, converter.convertUsdToEur(100), 0.01);
    }

    @Test
    public void testUsdToGbp() {
        CurrencyConverter converter = new CurrencyConverter();
        assertEquals(75.0, converter.convertUsdToGbp(100), 0.01);
    }

    @Test
    public void testUsdToJpy() {
        CurrencyConverter converter = new CurrencyConverter();
        assertEquals(11000.0, converter.convertUsdToJpy(100), 0.01);
    }
}
