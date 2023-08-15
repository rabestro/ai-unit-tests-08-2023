package com.epam.chucknorris.decode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("UnaryToBinaryConverter:")
class UnaryToBinaryConverterWhiteBoxAiTest {

    private final UnaryToBinaryConverter converter = new UnaryToBinaryConverter();

    @DisplayName("Should convert unary to binary:")
    @ParameterizedTest(name = "{index} => should convert {0} to {1}")
    @CsvSource(delimiter = '|', textBlock = """
        00 0  | 0
        0 0   | 1
        00 00 | 00
        0 000 | 111
    """)
    void shouldConvertUnaryToBinary(String unary, String expectedBinary) {
        var actualBinary = converter.apply(unary);
        assertThat(actualBinary).isEqualTo(expectedBinary);
    }

    @DisplayName("Should convert unary blocks to binary parts correctly:")
    @ParameterizedTest(name = "{index} => should convert {0} to {1}")
    @CsvSource(delimiter = '|', textBlock = """
        00 0     | 0
        0 0      | 1
    """ )
    void shouldConvertUnaryBlockToBinaryPartCorrectly(String block, String expectedBinary) {
        var actualBinary = converter.convertUnaryToBinary(block);
        assertThat(actualBinary).isEqualTo(expectedBinary);
    }
}
