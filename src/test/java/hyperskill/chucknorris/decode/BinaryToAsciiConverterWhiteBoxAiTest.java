package hyperskill.chucknorris.decode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Test BinaryToAsciiConverter")
class BinaryToAsciiConverterWhiteBoxAiTest {

    private final BinaryToAsciiConverter converter = new BinaryToAsciiConverter();

    @DisplayName("Test apply method")
    @ParameterizedTest(name = "{index} => for binary input: {0}, expect ascii output: {1}")
    @MethodSource("binaryToAsciiDataProvider")
    void testApply(String binaryInput, String expectedAsciiOutput) {
        var actualAsciiOutput = converter.apply(binaryInput);
        assertThat(actualAsciiOutput).isEqualTo(expectedAsciiOutput);
    }

    private static Stream<Object[]> binaryToAsciiDataProvider() {
        return Stream.of(
                new Object[]{"110000111000101100011", "abc"},
                new Object[]{"1101001110111111011101101001", "ioni"},
                new Object[]{"110111111011101101001", "oni"},
                new Object[]{"0111001", "9"},
                new Object[]{"0000000", "\u0000"}
        );
    }
}
