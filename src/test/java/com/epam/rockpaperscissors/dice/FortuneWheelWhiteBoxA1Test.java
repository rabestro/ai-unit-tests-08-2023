package com.epam.rockpaperscissors.dice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("FortuneWheel WhiteBoxAiTest")
class FortuneWheelWhiteBoxA1Test {

    static Stream<Arguments> multiValueEnumClassesProvider() {
        return Stream.of(
                Arguments.of(EnumClassWithFewValues.class, EnumClassWithFewValues.values(), 50),
                Arguments.of(EnumClassWithManyValues.class, EnumClassWithManyValues.values(), 1000)
        );
    }

    @DisplayName("Produces the same single enum value")
    @Test
    void producesTheSameSingleEnumValue() {
        var enumClass = EnumClassWithSingleValue.class;
        var enumValues = EnumClassWithSingleValue.values();
        var calls = 10;

        var fortuneWheel = FortuneWheel.of(enumClass);
        var producedValues = IntStream.range(0, calls)
                .mapToObj(i -> fortuneWheel.get())
                .toArray();

        assertThat(producedValues)
                .as("FortuneWheel of %s should always produce the same single value: %s", enumClass, enumValues[0])
                .allMatch(value -> value.equals(enumValues[0]));
    }

    @DisplayName("Produces all values for multi-value enums")
    @ParameterizedTest(name = "[{index}] ({0}) produces all enum values after {2} calls")
    @MethodSource("multiValueEnumClassesProvider")
    <T extends Enum<T>> void producesAllValuesForMultiValueEnums(Class<T> enumClass, T[] enumValues, int calls) {
        var fortuneWheel = FortuneWheel.of(enumClass);
        var producedValues = IntStream.range(0, calls)
                .mapToObj(i -> fortuneWheel.get())
                .toArray();

        assertThat(producedValues)
                .as("FortuneWheel of %s should produce all enum values after %d calls", enumClass, calls)
                .containsAnyOf(enumValues);
    }

    @DisplayName("Throws exception for empty enum")
    @Test
    void throwsExceptionForEmptyEnum() {
        var enumClass = EmptyEnumClass.class;
        assertThatThrownBy(() -> FortuneWheel.of(enumClass))
                .as("FortuneWheel of %s should throw IllegalArgumentException", enumClass)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Enum " + enumClass + " has no values");
    }

    enum EnumClassWithSingleValue {
        VALUE
    }

    enum EnumClassWithFewValues {
        VALUE1, VALUE2, VALUE3
    }

    enum EnumClassWithManyValues {
        VALUE1, VALUE2, VALUE3, VALUE4, VALUE5, VALUE6, VALUE7, VALUE8, VALUE9, VALUE10
    }

    enum EmptyEnumClass {
    }
}
