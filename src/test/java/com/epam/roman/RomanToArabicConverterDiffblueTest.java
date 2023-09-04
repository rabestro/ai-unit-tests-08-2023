package com.epam.roman;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RomanToArabicConverterDiffblueTest {
    /**
     * Method under test: {@link RomanToArabicConverter#applyAsInt(String)}
     */
    @Test
    void testApplyAsInt() {
        RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();
        String value = "42";
        int actualApplyAsIntResult = romanToArabicConverter.applyAsInt(value);
        assertEquals(0, actualApplyAsIntResult);
    }
}
