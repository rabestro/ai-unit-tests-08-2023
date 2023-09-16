package exercism.mazymice;

import java.util.Random;
import java.util.random.RandomGenerator;

public final class MazeGenerator {

    public String generatePerfectMaze(int rows, int columns) {
        return new Grid(rows, columns, RandomGenerator.getDefault())
                .generateMaze()
                .placeDoors()
                .print();
    }

    public String generatePerfectMaze(int rows, int columns, int seed) {
        return new Grid(rows, columns, new Random(seed))
                .generateMaze()
                .placeDoors()
                .print();
    }
}
