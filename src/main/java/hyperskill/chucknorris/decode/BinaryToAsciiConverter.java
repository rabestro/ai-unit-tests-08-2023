package hyperskill.chucknorris.decode;

import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class BinaryToAsciiConverter implements UnaryOperator<String> {
    private static final Pattern SEVEN_BITS_PATTERN = Pattern.compile("[01]{7}");

    @Override
    public String apply(String binaryRepresentation) {
        var asciiCharacters = SEVEN_BITS_PATTERN
                .matcher(binaryRepresentation)
                .results()
                .map(MatchResult::group)
                .mapToInt(convertBinaryToAscii())
                .toArray();

        return new String(asciiCharacters, 0, asciiCharacters.length);
    }

    private static ToIntFunction<String> convertBinaryToAscii() {
        return binaryString -> Integer.parseInt(binaryString, 2);
    }
}
