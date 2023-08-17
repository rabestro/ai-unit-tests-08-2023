package com.epam.chucknorris.encode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AsciiToBinaryConverterWhiteBoxAiATest {

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
}
