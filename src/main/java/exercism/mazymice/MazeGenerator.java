package exercism.mazymice;

public final class MazeGenerator {

    public String generatePerfectMaze(int rows, int columns) {
        return new Grid(rows, columns)
                .generateMaze()
                .placeDoors()
                .toString();
    }
}

