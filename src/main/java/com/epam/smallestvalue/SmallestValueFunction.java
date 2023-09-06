package com.epam.smallestvalue;

import java.util.function.LongToIntFunction;

public class SmallestValueFunction implements LongToIntFunction {

    @Override
    public int applyAsInt(long m) {
        if (m < 1) {
            throw new IllegalArgumentException();
        }

        int n = 0;
        while (m != 0) {
            m /= ++n;
        }
        return n;
    }
}
