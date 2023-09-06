package com.epam.smallestvalue;

import java.util.function.LongToIntFunction;

public class SmallestValueFunction implements LongToIntFunction {

    @Override
    public int applyAsInt(long m) {
        if (m < 1) {
            throw new IllegalArgumentException();
        }

        int n = 1;
        long factorial = 1;

        while (factorial <= m) {
            n++;
            factorial *= n;
        }
        return n;
    }
}
