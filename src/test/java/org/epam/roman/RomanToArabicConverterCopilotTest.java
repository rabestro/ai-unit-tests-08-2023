package org.epam.roman;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RomanToArabicConverterCopilotTest {

    @ParameterizedTest(name = "{0} should be converted to {1}")
    @MethodSource("romanToArabicProvider")
    void testRomanToArabicConversion(String roman, int arabic) {
        RomanToArabicConverter converter = new RomanToArabicConverter();
        assertEquals(arabic, converter.applyAsInt(roman));
    }

    static Stream<Arguments> romanToArabicProvider() {
        return Stream.of(
                Arguments.of("I", 1),
                Arguments.of("II", 2),
                Arguments.of("III", 3),
                Arguments.of("IV", 4),
                Arguments.of("V", 5),
                Arguments.of("VI", 6),
                Arguments.of("VII", 7),
                Arguments.of("VIII", 8),
                Arguments.of("IX", 9),
                Arguments.of("X", 10),
                Arguments.of("XI", 11),
                Arguments.of("XII", 12),
                Arguments.of("XIII", 13),
                Arguments.of("XIV", 14),
                Arguments.of("XV", 15),
                Arguments.of("XVI", 16),
                Arguments.of("XVII", 17),
                Arguments.of("XVIII", 18),
                Arguments.of("XIX", 19),
                Arguments.of("XX", 20),
                Arguments.of("XXXIX", 39),
                Arguments.of("XL", 40),
                Arguments.of("L", 50),
                Arguments.of("XC", 90),
                Arguments.of("C", 100),
                Arguments.of("CD", 400),
                Arguments.of("D", 500),
                Arguments.of("CM", 900),
                Arguments.of("M", 1000),
                Arguments.of("MMXIX", 2019),
                Arguments.of("MMMCMXCIX", 3999)
        );
    }
}
