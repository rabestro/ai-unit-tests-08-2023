package exercism.piglatin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PigLatinTranslator WhiteBoxC4Test")
class PigLatinTranslatorWhiteBoxC4ATest {

    private final PigLatinTranslator translator = new PigLatinTranslator();

    @DisplayName("Translate words to Pig Latin:")
    @ParameterizedTest(name = "[{index}] {0}: {1} -> {2}")
    @CsvSource(delimiter = '|', textBlock = """
            Single word starting with a vowel            | apple    | appleay
            Single word starting with a consonant        | banana   | ananabay
            Single word starting with xr                 | xray     | xrayay
            Single word starting with yt                 | yttria   | yttriaay
            Single word starting with consonant + qu     | square   | aresquay
            Single word containing y after consonants    | rhythm   | ythmrhay
            Two-letter word with y as the second letter  | my       | ymay
            Sentence with multiple words                 | hello world | ellohay orldway
            Empty input                                  | ''       | ''
            Single word starting with qu                 | queen    | eenquay
            Single word starting with q                  | qat      | atqay
            Single word with th followed by a vowel      | therapy  | erapythay
            Single word with sch followed by a vowel     | school   | oolschay
            Single word starting with y                  | yellow   | ellowyay
    """)
    void testTranslate(String description, String input, String expectedOutput) {
        var result = translator.translate(input);
        assertThat(result)
                .as("Translation of '%s' should be '%s'", input, expectedOutput)
                .isEqualTo(expectedOutput);
    }
}
