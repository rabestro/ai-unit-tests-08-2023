package com.epam.chucknorris.encode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AsciiToBinaryConverterWhiteBoxAiTest {

    @DisplayName("Convert a string to binary using ASCII encoding")
    @ParameterizedTest(name = "Test case: {0} => ASCII string: {1}, Expected Binary: {2}")
    @CsvSource(delimiter = '|', textBlock = """
                Text empty string            | ''  | ''
                Text lower case alphabets    | abc | 110000111000101100011
                Text upper case alphabets    | ABC | 100000110000101000011
                Text numeric values          | 123 | 011000101100100110011
                Text special characters      | @#$ | 100000001000110100100
            """)
    void apply(String scenario, String text, String expectedBinary) {
        var binaryConverter = new AsciiToBinaryConverter();
        var actualBinary = binaryConverter.apply(text);
        assertEquals(expectedBinary, actualBinary);
    }

    @DisplayName("Convert a character to binary using ASCII encoding")
    @ParameterizedTest(name = "Test case: {0} => ASCII character: {1}, Expected Binary: {2}")
    @CsvSource(delimiter = '|', textBlock = """
                Character 0                  | 0  | 0000000
                Character uppercase A        | 65 | 1000001
                Character lowercase a        | 97 | 1100001
                Character @                  | 64 | 1000000
            """)
    void charToBinary(String scenario, int character, String expectedBinary) {
        var binaryConverter = new AsciiToBinaryConverter();
        var actualBinary = binaryConverter.charToBinary(character);
        assertEquals(expectedBinary, actualBinary);
    }
}
