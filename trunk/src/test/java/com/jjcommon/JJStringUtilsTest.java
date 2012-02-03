package com.jjcommon;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for JJStringUtils.
 */
public class JJStringUtilsTest {

    String str1 = "ABC";  // Uppercase
    String str2 = "AbC";  // Mixed case
    String str3 = "abc";  // Lowercase
    String str4 = "ÃBC";  // Uppercase with accents 1
    String str5 = "ÄBC";  // Uppercase with accents 2
    String str6 = "ÃbC";  // Mixed case with accents 1, Accent letter is uppercase
    String str7 = "ãbC";  // Mixed case with accents 1, Accent letter is lowercase

    @Test
    public void compareIgnoreCaseAndAccent_Equal() {
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str1, "ABC"), 0);
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str5, "ÄBC"), 0);
    }

    @Test
    public void compareIgnoreCaseAndAccent_DifferentCase() {
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str1, str2), 0);
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str1, str3), 0);
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str2, str3), 0);
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str4, str6), 0);
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str4, str7), 0);
    }

    @Test
    public void compareIgnoreCaseAndAccent_DifferentAccent() {
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str1, str4), 0);
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str4, str5), 0);
    }

    @Test
    public void compareIgnoreCaseAndAccent_DifferentAccentAndCase() {
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str1, str7), 0);
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str3, str5), 0);
    }

    @Test
    public void compareIgnoreCaseAndAccent_Different() {
        assertTrue(JJStringUtils.compareIgnoreCaseAndAccent(str1, "ABD") != 0);
        assertTrue(JJStringUtils.compareIgnoreCaseAndAccent(str6, "ÃbD") != 0);
    }

    @Test
    public void compareIgnoreCaseAndAccent_Empty() {
        assertTrue(JJStringUtils.compareIgnoreCaseAndAccent(str3, "") != 0);
        assertTrue(JJStringUtils.compareIgnoreCaseAndAccent("", str5) != 0);
        assertTrue(JJStringUtils.compareIgnoreCaseAndAccent("", "") == 0);
    }

    @Test
    public void compareIgnoreCaseAndAccent_Null() {
        assertTrue(JJStringUtils.compareIgnoreCaseAndAccent(str3, null) != 0);
        assertTrue(JJStringUtils.compareIgnoreCaseAndAccent(null, str5) != 0);
        assertTrue(JJStringUtils.compareIgnoreCaseAndAccent(null, null) == 0);
    }

    @Test
    public void compareIgnoreCaseAndAccent_Spaces_Equal() {
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str3, str3 + " "), 0);
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str4, " " + str4), 0);
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str5, " " + str5 + " "), 0);
    }

    @Test
    public void compareIgnoreCaseAndAccent_Spaces_Different() {
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str1, str3 + " "), 0);
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str1, " " + str4), 0);
        assertEquals(JJStringUtils.compareIgnoreCaseAndAccent(str5, " " + str7 + " "), 0);
    }
}
