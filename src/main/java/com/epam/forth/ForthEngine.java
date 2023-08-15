package com.epam.forth;

import java.util.function.Consumer;

public interface ForthEngine extends ForthStack, Consumer<String> {
}
