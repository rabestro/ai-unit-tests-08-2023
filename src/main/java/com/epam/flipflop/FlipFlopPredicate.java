package com.epam.flipflop;

import java.util.function.Predicate;


public final class FlipFlopPredicate<T> implements Predicate<T> {
    private final Predicate<? super T> lhs;
    private final Predicate<? super T> rhs;
    private boolean state;

    public FlipFlopPredicate(Predicate<? super T> lhs, Predicate<? super T> rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public boolean test(final T value) {
        var result = state || lhs.test(value);
        state = result && !rhs.test(value);
        return result;
    }
}
