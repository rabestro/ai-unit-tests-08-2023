package com.epam.rockpaperscissors.dice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("FortuneWheel White Box AI Test")
class FortuneWheelWhiteBoxAiTest {
    enum EmptyEnum {}

    @DisplayName("Creating FortuneWheel for an enum with values, expecting a non-null object:")
    @Test
    void creatingFortuneWheelWithEnumDayOfWeekExpectingNotNull() {
        var wheel = FortuneWheel.of(DayOfWeek.class);
        assertThat(wheel)
                .as("FortuneWheel should not be null for enum with values")
                .isNotNull();
    }

    @DisplayName("Creating FortuneWheel for an empty enum, expecting IllegalArgumentException:")
    @Test
    void creatingFortuneWheelWithEmptyEnumExpectingException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .as("Expected IllegalArgumentException for empty enum")
                .isThrownBy(() -> FortuneWheel.of(EmptyEnum.class))
                .withMessageContaining("EmptyEnum has no values");
    }

    @DisplayName("Calling get() on a FortuneWheel of an enum with values, expecting one of the enum's values:")
    @Test
    void callingGetOnFortuneWheelOfEnumWithValuesExpectingValue() {
        var wheel = FortuneWheel.of(DayOfWeek.class);
        var value = wheel.get();
        assertThat(value)
                .as("Wheel roll must be a valid DayOfWeek value")
                .isNotNull()
                .isInstanceOf(DayOfWeek.class);
    }
}
