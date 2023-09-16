package exercism.mazymice;

import java.util.OptionalInt;

public record Maze(int rows, int columns, OptionalInt seed, String maze) {
    Maze(int rows, int columns, String maze) {
        this(rows, columns, OptionalInt.empty(), maze);
    }
    Maze(int rows, int columns, int seed, String maze) {
        this(rows, columns, OptionalInt.of(seed), maze);
    }
}
