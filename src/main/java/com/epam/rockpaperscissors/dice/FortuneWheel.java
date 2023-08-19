package com.epam.rockpaperscissors.dice;

import java.util.function.Supplier;

/**
 * A FortuneWheel is a supplier of values chosen randomly from an enum.
 *
 * @param <T> the type parameter representing the enum
 */
@FunctionalInterface
public interface FortuneWheel<T extends Enum<T>> extends Supplier<T> {

    static <T extends Enum<T>> FortuneWheel<T> of(Class<T> enumClass) {
        var values = enumValues(enumClass);
        var dice = Dice.of(values.length);
        return () -> values[dice.roll() - 1];
    }

    private static <T> T[] enumValues(Class<? extends T> enumClass) {
        var values = enumClass.getEnumConstants();
        if (values.length == 0) {
            throw new IllegalArgumentException("Enum " + enumClass + " has no values");
        }
        return values;
    }
}
