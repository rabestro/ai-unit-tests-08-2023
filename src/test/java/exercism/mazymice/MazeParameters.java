package exercism.mazymice;

import java.util.OptionalInt;

public record MazeParameters(int rows, int columns, OptionalInt seed, String maze) {
    MazeParameters(int rows, int columns, String maze) {
        this(rows, columns, OptionalInt.empty(), maze);
    }
    MazeParameters(int rows, int columns, int seed, String maze) {
        this(rows, columns, OptionalInt.of(seed), maze);
    }
}
