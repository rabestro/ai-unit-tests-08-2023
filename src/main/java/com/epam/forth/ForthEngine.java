package com.epam.forth;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface ForthEngine extends ForthStack, Consumer<String>, BiConsumer<String, List<String>> {
}
