package com.epam.roman;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanToArabicConverterJetBrainsTest {

    RomanToArabicConverter converter = new RomanToArabicConverter();

    @ParameterizedTest(name = "Test case #{index}: {0} should convert to {1}")
    @CsvSource({
            "CM, 900", "M, 1000", "CD, 400", "D, 500", "XC, 90", "C, 100",
            "XL, 40", "L, 50", "IX, 9", "X, 10", "IV, 4", "V, 5", "I, 1",
            "LXXXVI, 86", "MCMLXXXIV, 1984", "MM, 2000", "MMMCMXCIX, 3999",
            "DLV, 555", "MDCCLXXVI, 1776"
    })
    @DisplayName("Test conversion from Roman to Arabic numerals")
    void applyAsInt(String roman, int arabic) {
        assertEquals(arabic, converter.applyAsInt(roman));
    }

}
