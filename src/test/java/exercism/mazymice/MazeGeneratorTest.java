package exercism.mazymice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MazeGeneratorTest {
    public static final Set<Character> ALLOWED_SYMBOLS = Set.of(
            ' ', // space
            '┌', // box drawings light down and right
            '─', // box drawings light horizontal
            '┬', // box drawings light down and horizontal
            '┐', // box drawings light down and left
            '│', // box drawings light vertical
            '└', // box drawings light up and right
            '┴', // box drawings light up and horizontal
            '┘', // box drawings light up and left
            '├', // box drawings light vertical and right
            '┤', // box drawings light vertical and left
            '┼', // box drawings light vertical and horizontal
            '⇨'  // rightwards white arrow
    );
    private static final Dimensions SMALL_SQUARE = new Dimensions(5, 5);
    private static final Dimensions RECTANGLE = new Dimensions(6, 18);
    private MazeGenerator sut;

    @BeforeEach
    void SetUp() {
        sut = new MazeGenerator();
    }

    @Test
    @DisplayName("The maze is not null.")
    void generatePerfectMaze() {
        var maze = sut.generatePerfectMaze(RECTANGLE);

        assertThat(maze)
                .as("The maze is not null.")
                .isNotNull();

        Arrays.stream(maze)
                .map(String::new)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("The dimensions of the maze are correct.")
    void the_number_of_lines_is_correct() {
        var maze = sut.generatePerfectMaze(RECTANGLE);

        assertThat(maze)
                .as("The dimensions of the maze are correct.")
                .hasDimensions(RECTANGLE.height(), RECTANGLE.width());
    }

    @Test
    @DisplayName("Two mazes should not be equal")
    void twoMazesShouldNotBeEqual() {
        var maze1 = sut.generatePerfectMaze(RECTANGLE);
        var maze2 = sut.generatePerfectMaze(RECTANGLE);

        assertThat(maze1)
                .as("Two mazes should not be equal")
                .isNotEqualTo(maze2);
    }

    @Test
    @DisplayName("Two mazes with the same seed should be equal")
    void twoMazesWithSameSeedShouldBeEqual() {
        var maze1 = sut.generatePerfectMaze(RECTANGLE, 42);
        var maze2 = sut.generatePerfectMaze(RECTANGLE, 42);

        assertThat(maze1)
                .as("Two mazes with the same seed should be equal")
                .isEqualTo(maze2);
    }

    @Test
    @DisplayName("Two mazes with different seeds should not be equal")
    void twoMazesWithDifferentSeedsShouldNotBeEqual() {
        var maze1 = sut.generatePerfectMaze(RECTANGLE, 42);
        var maze2 = sut.generatePerfectMaze(RECTANGLE, 43);

        assertThat(maze1)
                .as("Two mazes with different seeds should not be equal")
                .isNotEqualTo(maze2);
    }

    @Test
    @DisplayName("The maze contains only valid characters")
    void theMazeContainsOnlyValidCharacters() {
        var maze = sut.generatePerfectMaze(RECTANGLE);

        for (var row : maze) {
            for (var cell : row) {
                assertThat(cell)
                        .as("The maze contains only valid characters")
                        .isIn(ALLOWED_SYMBOLS);
            }
        }
    }

    @Test
    @DisplayName("The maze has only one entrance on the left side")
    void theMazeHasOnlyOneEntranceOnTheLeftSide() {
        var maze = sut.generatePerfectMaze(RECTANGLE);
        int entranceCount = countEntrances(maze);

        assertThat(entranceCount)
                .as("The maze has only one entrance on the left side")
                .isOne();
    }

    @Test
    @DisplayName("The maze has a single exit on the right side of the maze")
    void theMazeHasASingleExitOnTheRightSideOfTheMaze() {
        var maze = sut.generatePerfectMaze(RECTANGLE);
        int exitCount = countExits(maze);

        assertThat(exitCount)
                .as("The maze has a single exit on the right side of the maze")
                .isOne();
    }

    private int countExits(char[][] maze) {
        int exitCount = 0;
        for (char[] row : maze) {
            if (row[row.length - 1] == '⇨') {
                exitCount++;
            }
        }
        return exitCount;
    }

    private int countEntrances(char[][] maze) {
        int entranceCount = 0;
        for (char[] row : maze) {
            if (row[0] == '⇨') {
                entranceCount++;
            }
        }
        return entranceCount;
    }
}
