package exercism.mazymice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;

class MazeGeneratorTest {

    @Test
    void generatePerfectMaze() {
        var sut = new MazeGenerator();
        var maze = sut.generatePerfectMaze(6, 18);

        System.out.println(maze);
    }

    @Test
    @DisplayName("Two mazes should not be equal")
    void twoMazesShouldNotBeEqual() {
        var sut = new MazeGenerator();
        var maze1 = sut.generatePerfectMaze(6, 18);
        var maze2 = sut.generatePerfectMaze(6, 18);

        assertThat(maze1)
                .as("Two mazes should not be equal")
                .isNotEqualTo(maze2);
    }

    @Test
    @DisplayName("Two mazes with the same seed should be equal")
    void twoMazesWithSameSeedShouldBeEqual() {
        var sut = new MazeGenerator();
        var maze1 = sut.generatePerfectMaze(6, 18, 42);
        var maze2 = sut.generatePerfectMaze(6, 18, 42);

        assertThat(maze1)
                .as("Two mazes with the same seed should be equal")
                .isEqualTo(maze2);
    }

    @Test
    @DisplayName("Two mazes with different seeds should not be equal")
    void twoMazesWithDifferentSeedsShouldNotBeEqual() {
        var sut = new MazeGenerator();
        var maze1 = sut.generatePerfectMaze(6, 18, 42);
        var maze2 = sut.generatePerfectMaze(6, 18, 43);

        assertThat(maze1)
                .as("Two mazes with different seeds should not be equal")
                .isNotEqualTo(maze2);
    }

    @DisplayName("Small square maze with seed 42")
    @ParameterizedTest(name = "Maze with {0} rows and {1} columns should be perfect")
    @CsvSource(textBlock = """
            5, 5, 42
            """)
    void theMazeShouldBePerfect(int rows, int columns, int seed) {
        var sut = new MazeGenerator();
        var maze = sut.generatePerfectMaze(rows, columns, seed);
        var parameters = new MazeParameters(rows, columns, seed, maze);
        var error = new MazeChecker(parameters).get();

        assertThat(error)
                .as(error.orElse("The maze should be perfect"))
                .isEmpty();

    }

}
