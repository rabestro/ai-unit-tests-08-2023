package exercism.mazymice;

/**
 * Represents the dimensions of a grid.
 * <p>
 * Dimensions of a grid can be represented in cells or characters.
 * Rows and columns are used for cells, while width and height are used for characters.
 */
@SuppressWarnings("java:S109")
public record Dimensions(int rows, int columns) {
    /**
     * Returns the width of the grid.
     *
     * @return the width of the grid
     */
    int width() {
        return 2 * columns + 1;
    }

    /**
     * Returns the height of the grid.
     *
     * @return the height of the grid
     */
    int height() {
        return 2 * rows + 1;
    }
}
