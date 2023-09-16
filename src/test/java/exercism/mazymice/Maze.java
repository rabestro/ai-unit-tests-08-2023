package exercism.mazymice;

import java.util.OptionalInt;

public record Maze(Dimension dimension, char[][] grid, OptionalInt seed) {

    public Maze(Dimension dimension, char[][] maze) {
        this(dimension, maze, OptionalInt.empty());
    }

    public Maze(Dimension dimension, char[][] maze, int seed) {
        this(dimension, maze, OptionalInt.of(seed));
    }

    String print() {
        var sb = new StringBuilder();
        for (var row : grid) {
            sb.append(row);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
