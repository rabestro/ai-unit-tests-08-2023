package org.epam.roman;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToArabicConverterChatGptTest {
    private final RomanToArabicConverter converter = new RomanToArabicConverter();

    @DisplayName("Roman to Arabic conversion")
    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource({
            "'I', 1",
            "'II', 2",
            "'IV', 4",
            "'V', 5",
            "'VI', 6",
            "'IX', 9",
            "'X', 10",
            "'XIII', 13",
            "'XV', 15",
            "'XL', 40",
            "'L', 50",
            "'LXXX', 80",
            "'XC', 90",
            "'C', 100",
            "'CD', 400",
            "'D', 500",
            "'CM', 900",
            "'M', 1000",
            "'MMMCMXCIX', 3999"
    })
    void testRomanToArabicConversion(String roman, int expectedArabic) {
        int result = converter.applyAsInt(roman);
        assertEquals(expectedArabic, result, "The conversion result should be correct");
    }
}
