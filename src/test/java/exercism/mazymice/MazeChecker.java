package exercism.mazymice;

import java.util.Optional;
import java.util.function.Supplier;

public record MazeChecker(Dimension dimension, String maze) implements Supplier<Optional<String>> {

    private Optional<String> dimensions() {
        return Optional.empty();
    }

    private Optional<String> walls() {
        return Optional.empty();
    }

    private Optional<String> doors() {
        return Optional.empty();
    }

    private Optional<String> symbols() {
        return Optional.empty();
    }

    @Override
    public Optional<String> get() {
        return dimensions()
                .or(this::doors)
                .or(this::symbols)
                .or(this::walls);
    }
}
