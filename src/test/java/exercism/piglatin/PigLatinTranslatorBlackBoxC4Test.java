package exercism.piglatin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PigLatinTranslator BlackBoxC4Test")
class PigLatinTranslatorBlackBoxC4Test {

    private final PigLatinTranslator translator = new PigLatinTranslator();

    @DisplayName("Translate words and sentences to Pig Latin:")
    @ParameterizedTest(name = "[{index}] {0}: {1} -> {2}")
    @CsvSource(delimiter = '|', textBlock = """
        Single word starting with a vowel sound          | apple               | appleay
        Single word starting with 'xr'                   | xray                | xrayay
        Single word starting with 'yt'                   | yttria              | yttriaay
        Single word starting with a consonant sound      | chair               | airchay
        Single word starting with consonant sound + 'qu' | square              | aresquay
        Single word with 'y' after a consonant cluster   | rhythm              | ythmrhay
        Two-letter word with 'y' as the second letter    | my                  | ymay
        Empty string                                     | ''                  | ''
        Sentence with three words                        | quick fast run      | ickquay astfay unray
        Single word starting with 'y'                    |                    | ellowyay
        Single word with 'ch' as the second letter       | school              | oolschay
        Single word with 'th' as the second letter       | thrush              | ushthray
        Single word with 'th' as the second letter       | therapy             | erapythay
        Single word starting with consonant sound + 'qu' | square              | aresquay
        Single word starting with 'qu'                   | queen               | eenquay
        Single word starting with 'q'                    | qat                 | atqay
        Sentence with multiple words                     | apple chair square rhythm my | appleay airchay aresquay ythmrhay ymay
    """)
    void translate(String description, String input, String expectedOutput) {
        var actualOutput = translator.translate(input);
        assertThat(actualOutput)
                .as("Translation of '%s' should be '%s'", input, expectedOutput)
                .isEqualTo(expectedOutput);
    }
}
