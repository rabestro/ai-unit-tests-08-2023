package com.epam.roman;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToArabicConverterMZTest {
    private final RomanToArabicConverter converter = new RomanToArabicConverter();

    @Nested
    class Convertion {
        @Test
        void shouldConvertIto1() {
            int actual = converter.applyAsInt("I");
            assertEquals(1, actual);
        }

        @Test
        void shouldConvertVto5() {
            int actual = converter.applyAsInt("V");
            assertEquals(5, actual);
        }

        @Test
        void shouldConvertXto10() {
            int actual = converter.applyAsInt("X");
            assertEquals(10, actual);
        }

        // define more tests for each other literals
    }

    @Nested
    class ComposedNumber {
        @Test
        void shouldConvertIVto4() {
            int actual = converter.applyAsInt("IV");
            assertEquals(4, actual);
        }

        @Test
        void shouldConvertMMXXIto2021() {
            int actual = converter.applyAsInt("MMXXI");
            assertEquals(2021, actual);
        }

        // define more tests for other combinations
    }
}
