package com.epam.roman.two;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("RomanToArabicConverter Tests")
class RomanToArabicConverterC4Test {
    private final RomanToArabicConverter converter = new RomanToArabicConverter();

    @DisplayName("Valid single-character Roman numerals")
    @ParameterizedTest(name = "[{index}] {0} should be {1}")
    @CsvSource(delimiter = '|', textBlock = """
        I | 1
        V | 5
        X | 10
        L | 50
        C | 100
        D | 500
        M | 1000
    """)
    void validSingleCharacterRomanNumerals(String roman, int arabic) {
        var result = converter.applyAsInt(roman);
        assertThat(result).as("%s should be %d", roman, arabic).isEqualTo(arabic);
    }

    @DisplayName("Valid multi-character Roman numerals")
    @ParameterizedTest(name = "[{index}] {0} should be {1}")
    @CsvSource(delimiter = '|', textBlock = """
        IV | 4
        IX | 9
        XL | 40
        XC | 90
        CD | 400
        CM | 900
    """)
    void validMultiCharacterRomanNumerals(String roman, int arabic) {
        var result = converter.applyAsInt(roman);
        assertThat(result).as("%s should be %d", roman, arabic).isEqualTo(arabic);
    }

    @DisplayName("Valid complex Roman numerals")
    @ParameterizedTest(name = "[{index}] {0} should be {1}")
    @CsvSource(delimiter = '|', textBlock = """
        MMXXI     | 2021
        MCMLXXXIV | 1984
        DCCVII    | 707
    """)
    void validComplexRomanNumerals(String roman, int arabic) {
        var result = converter.applyAsInt(roman);
        assertThat(result).as("%s should be %d", roman, arabic).isEqualTo(arabic);
    }

    @DisplayName("Invalid Roman numerals")
    @ParameterizedTest(name = "[{index}] {0} should throw IllegalArgumentException")
    @CsvSource(delimiter = '|', textBlock = """
        ''        | Empty string
        A         | Invalid character
        IIII      | Invalid repetition
        VV        | Invalid repetition
        MCMXCIIII | Invalid numeral
    """)
    void invalidRomanNumerals(String roman, String description) {
        assertThatThrownBy(() -> converter.applyAsInt(roman))
                .as("Invalid Roman numeral: %s (%s)", roman, description)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid Roman numeral");
    }
}
