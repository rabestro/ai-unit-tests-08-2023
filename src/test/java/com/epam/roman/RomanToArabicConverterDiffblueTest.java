package com.epam.roman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanToArabicConverterDiffblueTest {
    /**
     * Method under test: {@link RomanToArabicConverter#applyAsInt(String)}
     */
    @Test
    void testApplyAsInt() {
        // Arrange
        RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();
        String value = "42";

        // Act
        int actualApplyAsIntResult = romanToArabicConverter.applyAsInt(value);

        // Assert
        assertEquals(0, actualApplyAsIntResult);
    }
}
