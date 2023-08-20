package hyperskill.chucknorris.encode;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("AsciiToBinaryConverter tests - WhiteBoxAiTest")
class AsciiToBinaryConverterWhiteBoxAiTest {
    private final AsciiToBinaryConverter converter = new AsciiToBinaryConverter();

    private static Stream<TestCase> provideTestCases() {
        return Stream.of(
                new TestCase("lower case chars", "hello", "11010001100101110110011011001101111"),
                new TestCase("upper case chars", "HELLO", "10010001000101100110010011001001111"),
                new TestCase("numeric chars", "1234", "0110001011001001100110110100"),
                new TestCase("special chars", "!@#$%^", "010000110000000100011010010001001011011110"),
                new TestCase("space char", " ", "0100000"),
                new TestCase("empty string", "", ""),
                new TestCase("mix of chars", "H3llo W@rld!", "100100001100111101100110110011011110100000101011110000001110010110110011001000100001")
        );
    }

    @MethodSource("provideTestCases")
    @ParameterizedTest(name = "[{index}] - {0}")
    @DisplayName("Should give correct binary conversion")
    void shouldGiveCorrectBinaryConversion(TestCase testCase) {
        var result = converter.apply(testCase.input());
        assertThat(result)
                .as("The conversion of %s should be %s", testCase.input(), testCase.expectedResult())
                .isEqualTo(testCase.expectedResult());
    }

    @Test
    @DisplayName("Should throw NullPointerException when input is null")
    void shouldThrowNullPointerExceptionWhenInputIsNull() {
        ThrowableAssert.ThrowingCallable codeToTest = () -> converter.apply(null);
        assertThatThrownBy(codeToTest)
                .as("Calling apply with null should throw NullPointerException")
                .isInstanceOf(NullPointerException.class);
    }

    record TestCase(String description, String input, String expectedResult) {
        @Override
        public String toString() {
            return description;
        }
    }
}
