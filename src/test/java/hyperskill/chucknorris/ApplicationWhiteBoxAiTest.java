package hyperskill.chucknorris;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationWhiteBoxAiTest {

    @Mock
    private Supplier<String> input;

    @Mock
    private Consumer<String> output;

    @Mock
    private Function<String, String> encoder;

    @Mock
    private Function<String, String> decoder;

    @Test
    @DisplayName("Encode operation scenario")
    void encodeOperationScenario() {
        when(input.get()).thenReturn("encode", "plaintext", "exit");
        when(encoder.apply("plaintext")).thenReturn("encrypted");

        var app = new Application(input, output, encoder, decoder);

        app.run();

        var orderedExecution = inOrder(output, encoder);

        orderedExecution.verify(output).accept("Please input operation (encode/decode/exit):");
        orderedExecution.verify(output).accept("Input string:");
        orderedExecution.verify(output).accept("Encoded string:");
        orderedExecution.verify(output).accept("encrypted");
        orderedExecution.verify(output).accept("Please input operation (encode/decode/exit):");
        orderedExecution.verify(output).accept("Bye!");

        assertThat(app.isEncodedStringInvalid("plaintext")).isTrue();
    }

    @Test
    @DisplayName("Decode operation scenario")
    void decodeOperationScenario() {
        var encoded = "0 0 00 00 0 0 00 000 0 00 00 00 0 0 00 0 0 00000 00 00 0 0 00 0 0 0 00 0000 0 0";
        when(input.get()).thenReturn("decode", encoded, "exit");
        when(decoder.apply(encoded)).thenReturn("Hey!");

        var app = new Application(input, output, encoder, decoder);

        app.run();

        var orderedExecution = inOrder(output, decoder);

        orderedExecution.verify(output).accept("Please input operation (encode/decode/exit):");
        orderedExecution.verify(output).accept("Input encoded string:");
        orderedExecution.verify(output).accept("Decoded string:");
        orderedExecution.verify(output).accept("Hey!");
        orderedExecution.verify(output).accept("Please input operation (encode/decode/exit):");
        orderedExecution.verify(output).accept("Bye!");

        assertThat(app.isEncodedStringInvalid(encoded)).isFalse();
    }

    @Test
    @DisplayName("Invalid operation scenario")
    void invalidOperationScenario() {
        when(input.get()).thenReturn("invalid", "exit");

        var app = new Application(input, output, encoder, decoder);

        app.run();

        var orderedExecution = inOrder(output);

        orderedExecution.verify(output).accept("Please input operation (encode/decode/exit):");
        orderedExecution.verify(output).accept("There is no 'invalid' operation");
        orderedExecution.verify(output).accept("Please input operation (encode/decode/exit):");
        orderedExecution.verify(output).accept("Bye!");
    }

    @Test
    @DisplayName("Invalid encoded string scenario")
    void invalidEncodedStringScenario() {
        when(input.get()).thenReturn("decode", "not-encoded", "exit");

        var app = new Application(input, output, encoder, decoder);

        app.run();

        var orderedExecution = inOrder(output);

        orderedExecution.verify(output).accept("Please input operation (encode/decode/exit):");
        orderedExecution.verify(output).accept("Input encoded string:");
        orderedExecution.verify(output).accept("Encoded string is not valid.");
        orderedExecution.verify(output).accept("Please input operation (encode/decode/exit):");
        orderedExecution.verify(output).accept("Bye!");

        assertThat(app.isEncodedStringInvalid("not-encoded")).isTrue();
    }
}
