package com.epam.roman.two;

import java.util.Map;
import java.util.function.ToIntFunction;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;


public final class RomanToArabicConverter implements ToIntFunction<String> {
    private static final Pattern VALID_ROMAN_NUMERAL_PATTERN = Pattern.compile(
            "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"
    );
    private static final Map<String, Integer> ROMAN_TO_ARABIC = Map.ofEntries(
            Map.entry("CM", 900),
            Map.entry("M", 1000),
            Map.entry("CD", 400),
            Map.entry("D", 500),
            Map.entry("XC", 90),
            Map.entry("C", 100),
            Map.entry("XL", 40),
            Map.entry("L", 50),
            Map.entry("IX", 9),
            Map.entry("X", 10),
            Map.entry("IV", 4),
            Map.entry("V", 5),
            Map.entry("I", 1)
    );
    private static final Pattern TOKEN_PATTERN = Pattern.compile("C?M|C?D|X?C|X?L|I?X|I?V|I");

    @Override
    public int applyAsInt(String value) {
        if (!isValidRomanNumeral(value)) {
            throw new IllegalArgumentException("Invalid Roman numeral: " + value);
        }

        return TOKEN_PATTERN.matcher(value).results()
                .map(MatchResult::group)
                .mapToInt(ROMAN_TO_ARABIC::get)
                .sum();
    }

    private boolean isValidRomanNumeral(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return VALID_ROMAN_NUMERAL_PATTERN.matcher(value).matches();
    }
}
