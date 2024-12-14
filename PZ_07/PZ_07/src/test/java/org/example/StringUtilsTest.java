package org.example;

import models.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {

    @Test
    public void testIsPalindrome() {
        StringUtils utils = new StringUtils();
        assertTrue(utils.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    public void testCountVowels() {
        StringUtils utils = new StringUtils();
        assertEquals(3, utils.countVowels("Hello World"));
    }

    @Test
    public void testCountConsonants() {
        StringUtils utils = new StringUtils();
        assertEquals(7, utils.countConsonants("Hello World"));
    }

    @Test
    public void testCountOccurrences() {
        StringUtils utils = new StringUtils();
        assertEquals(2, utils.countOccurrences("hello world, hello", "hello"));
    }
}
