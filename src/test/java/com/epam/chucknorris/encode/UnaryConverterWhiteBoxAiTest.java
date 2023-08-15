package com.epam.chucknorris.encode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Unary Converter Test class")
class UnaryConverterWhiteBoxAiTest {

    UnaryConverter unaryConverter = new UnaryConverter();

    @DisplayName("Tests Unary Converter apply method.")
    @ParameterizedTest(name = "{index} => the binary sequence {0}:{1}")
    @CsvSource(delimiter = '|', textBlock = """
        empty string                                  |    ''        |  ''
        string with space                             |    ' '       |  ''
        single binary digit 0                         |    0         |  '00 0'
        single binary digit 1                         |    1         |  '0 0'
        single binary sequence with 0's only          |    00000     |  '00 00000'
        single binary sequence with 1's only          |    1111      |  '0 0000'
        binary sequence with 0's and 1's              |    11110000  |  '0 0000 00 0000'
        more complex binary sequence                  |    110011001 |  '0 00 00 00 0 00 00 00 0 0'
    """)
    void applyTest(String scenario, String binarySequence, String expectedUnarySequence) {
        var result = unaryConverter.apply(binarySequence);
        assertThat(result).isEqualTo(expectedUnarySequence);
    }
    
    @DisplayName("Tests Unary Converter convertBinaryToUnary method.")
    @ParameterizedTest(name = "{index} => the binary sequence {0}:{1}")
    @CsvSource(delimiter = '|', textBlock = """
        single binary digit 0                       |    0         |  '00 0'
        single binary digit 1                       |    1         |  '0 0'
        single binary sequence with 0's only        |    00000     |  '00 00000'
        single binary sequence with 1's only        |    1111      |  '0 0000'
    """)
    void convertBinaryToUnaryTest(String scenario, String binarySequence, String expectedUnarySequence) {
        var result = unaryConverter.convertBinaryToUnary(binarySequence);
        assertThat(result).isEqualTo(expectedUnarySequence);
    }
}
