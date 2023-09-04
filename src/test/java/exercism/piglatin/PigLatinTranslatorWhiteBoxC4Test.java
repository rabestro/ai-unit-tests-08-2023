package exercism.piglatin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class PigLatinTranslatorWhiteBoxC4Test {
    private final PigLatinTranslator translator = new PigLatinTranslator();

    @DisplayName("Translate Pig Latin:")
    @ParameterizedTest(name = "[{index}] {0}: {1} -> {2}")
    @CsvSource(delimiter = '|', textBlock = """
                Empty string                            | ""            | ""
                Single word starting with a vowel       | apple         | appleay
                Single word starting with a consonant   | banana        | ananabay
                Single word starting with xr            | xray          | xrayay
                Single word starting with yt            | yttria        | yttriaay
                Single word starting with qu            | queen         | eenquay
                Single word starting with y + vowel     | yellow        | ellowyay
                Single word starting with y + consonant | yttrium       | yttriumay
                Sentence with multiple words            | hello world   | ellohay orldway
                Single word square                      | square        | aresquay
                Single word qat                         | qat           | atqay
                Single word therapy                     | therapy       | erapythay
            """)
    void translateTest(String description, String input, String expectedOutput) {
        var result = translator.translate(input);
        assertThat(result)
                .as("Translation of '%s' should be '%s'", input, expectedOutput)
                .isEqualTo(expectedOutput);
    }

    @DisplayName("Translate Pig Latin with null input:")
    @ParameterizedTest(name = "[{index}] Null input")
    @NullSource
    void translateNullInputTest(String input) {
        assertThatNullPointerException()
                .as("Translation of null input should throw NullPointerException")
                .isThrownBy(() -> translator.translate(input));
    }
}
