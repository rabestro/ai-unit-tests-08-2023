package com.epam.roman.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanToArabicConverterDiffblueTest {
    /**
     * Method under test: {@link RomanToArabicConverter#applyAsInt(String)}
     */
    @Test
    void testApplyAsInt() {
        // Arrange
        RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();
        String value = "42";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> romanToArabicConverter.applyAsInt(value));
    }

    /**
     * Method under test: {@link RomanToArabicConverter#applyAsInt(String)}
     */
    @Test
    void testApplyAsInt2() {
        // Arrange
        RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();
        String value = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> romanToArabicConverter.applyAsInt(value));
    }

    /**
     * Method under test: {@link RomanToArabicConverter#applyAsInt(String)}
     */
    @Test
    void testApplyAsInt3() {
        // Arrange
        RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();
        String value = "MMCMXCIX";

        // Act
        int actualApplyAsIntResult = romanToArabicConverter.applyAsInt(value);

        // Assert
        assertEquals(2999, actualApplyAsIntResult);
    }

    /**
     * Method under test: {@link RomanToArabicConverter#applyAsInt(String)}
     */
    @Test
    void testApplyAsInt4() {
        // Arrange
        RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();
        String value = "";

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> romanToArabicConverter.applyAsInt(value));
    }
}
