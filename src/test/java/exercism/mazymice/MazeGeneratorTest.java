package exercism.mazymice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MazeGeneratorTest {
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
}
