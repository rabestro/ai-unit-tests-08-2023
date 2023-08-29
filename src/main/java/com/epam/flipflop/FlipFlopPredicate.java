package com.epam.flipflop;

import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;


public final class FlipFlopPredicate<T> implements Predicate<T> {
    private final Predicate<? super T> lhs;
    private final Predicate<? super T> rhs;
    boolean state;

    public FlipFlopPredicate(Predicate<? super T> lhs, Predicate<? super T> rhs) {
        this.lhs = requireNonNull(lhs);
        this.rhs = requireNonNull(rhs);
    }

    @Override
    public boolean test(final T value) {
        var result = state || lhs.test(value);
        state = result && !rhs.test(value);
        return result;
    }
}
