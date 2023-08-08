package com.epam.forth;

import java.util.List;

public interface ForthStack {
    void push(int value);

    int pop();

    int peek();

    void ensureSize(int requiredSize, String errorMessage);

    List<Integer> asList();
}
