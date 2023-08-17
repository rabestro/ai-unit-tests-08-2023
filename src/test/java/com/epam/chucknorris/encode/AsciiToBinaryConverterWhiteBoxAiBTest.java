package com.epam.chucknorris.encode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class AsciiToBinaryConverterWhiteBoxAiBTest {
    private final AsciiToBinaryConverter target = new AsciiToBinaryConverter();

    @DisplayName("Converts to binary string:")
    @ParameterizedTest(name = "when '{0}' converts to binary, result should be '{1}'")
    @CsvSource(delimiter = '|', textBlock = """
            Empty String       |         ''      |   ''
            Single Character   |         'A'     |   '1000001'
            Special Character  |         '@'     |   '1000000'
            Single Digit       |         '4'     |   '0110100'
            Lower Case letter  |         'a'     |   '1100001'
            Word               |       'Test'    |   '1010100110010111100111110100'
            Sentence           | 'Hello, World!' |   '1001000110010111011001101100110111101011000100000101011111011111110010110110011001000100001'
             """)
    void convertsToBinaryString(String scenario, String input, String expected) {
        var actual = target.apply(input);

        assertThat(actual)
                .as("The result of converting %s to binary should be %s", input, expected)
                .isEqualTo(expected);
    }

}
