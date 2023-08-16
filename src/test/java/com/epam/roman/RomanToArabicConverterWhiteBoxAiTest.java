package com.epam.roman;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("RomanToArabicConverter class tests")
class RomanToArabicConverterWhiteBoxAiTest {
    private final RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();

    @DisplayName("Converting valid Roman numerals to Arabic:")
    @ParameterizedTest(name = "{index}: Converting {0} to Arabic should give {1}")
    @CsvSource(delimiter = '=', textBlock = """
        'I'           = 1
        'IV'          = 4
        'V'           = 5
        'IX'          = 9
        'X'           = 10
        'XL'          = 40
        'L'           = 50
        'XC'          = 90
        'C'           = 100
        'CD'          = 400
        'D'           = 500
        'CM'          = 900
        'M'           = 1000
        'MMCCCXLIV'   = 2344
        'MCMXCIX'     = 1999
        ''            = 0
        'BDFHJ@#'     = 500
    """)
    void testValidRomanConversions(String romanNumeral, int expectedArabicValue) {
        var actual = romanToArabicConverter.applyAsInt(romanNumeral);
        assertThat(actual)
                .as("The roman numeral %s should be converted to %d", romanNumeral, expectedArabicValue)
                .isEqualTo(expectedArabicValue);
    }
}
