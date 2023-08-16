package com.epam.chucknorris.decode;

import java.util.function.UnaryOperator;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class UnaryToBinaryConverter implements UnaryOperator<String> {
    private static final Pattern GROUP_PATTERN = Pattern.compile("00? 0+");

    @Override
    public String apply(String unaryRepresentation) {
        return GROUP_PATTERN.matcher(unaryRepresentation)
                .results()
                .map(MatchResult::group)
                .map(this::convertUnaryToBinary)
                .collect(Collectors.joining());
    }

    String convertUnaryToBinary(String block) {
        var unit = block.startsWith("00") ? "0" : "1";
        var length = block.length() - (unit.equals("0") ? 3 : 2);
        return unit.repeat(length);
    }
}
