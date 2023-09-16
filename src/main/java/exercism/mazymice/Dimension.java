package exercism.mazymice;

/**
 * Represents the dimensions of a maze.
 * <p>
 * Dimensions of a maze can be represented in cells or characters.
 * Rows and columns are used for cells, while width and height are used for characters.
 */
@SuppressWarnings("java:S109")
public record Dimension(int rows, int columns) {
    /**
     * Returns the width of the maze.
     *
     * @return the width of the maze
     */
    int width() {
        return 2 * columns + 1;
    }

    /**
     * Returns the height of the maze.
     *
     * @return the height of the maze
     */
    int height() {
        return 2 * rows + 1;
    }
}
