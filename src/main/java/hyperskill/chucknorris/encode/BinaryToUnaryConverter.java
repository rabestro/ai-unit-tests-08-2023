package hyperskill.chucknorris.encode;

import java.util.function.UnaryOperator;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public final class BinaryToUnaryConverter implements UnaryOperator<String> {
    private static final Pattern PATTERN = Pattern.compile("0+|1+");

    @Override
    public java.lang.String apply(String binaryRepresentation) {
        return PATTERN.matcher(binaryRepresentation)
                .results()
                .map(MatchResult::group)
                .map(this::convertBinaryToUnary)
                .collect(Collectors.joining(" "));
    }

    String convertBinaryToUnary(String sequence) {
        var prefix = sequence.startsWith("0") ? "00" : "0";
        return prefix + " " + "0".repeat(sequence.length());
    }
}
