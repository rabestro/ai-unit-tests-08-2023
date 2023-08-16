package com.epam.roman;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RomanToArabicConverterC4Test {
    private final RomanToArabicConverter converter = new RomanToArabicConverter();

    @DisplayName("Converts Roman numerals to Arabic numerals")
    @ParameterizedTest(name = "{index} => converts {0} to {1}")
    @CsvSource(delimiter = '|', textBlock = """
        I          |   1
        V          |   5
        X          |   10
        XX         |   20
        LX         |   60
        IV         |   4
        IX         |   9
        XL         |   40
        XC         |   90
        CD         |   400
        CM         |   900
        MMMCMXCIX  | 3999
        ''         |   0
        ABCD       |   400
        IIX        |   10
    """)
    void convertsRomanToArabic(String roman, int expectedArabic) {
        var actual = converter.applyAsInt(roman);
        assertThat(actual).isEqualTo(expectedArabic);
    }
}
