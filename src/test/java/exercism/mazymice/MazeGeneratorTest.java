package exercism.mazymice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeGeneratorTest {

    @Test
    void generatePerfectMaze() {
        var sut = new MazeGenerator();
        var maze = sut.generatePerfectMaze(5, 10);

        System.out.println(maze);
    }
}