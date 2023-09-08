package leetcode.p54.a;

enum Direction {
    NORTH, EAST, SOUTH, WEST;

    Direction rotateClockwise() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    Point delta() {
        return switch (this) {
            case NORTH -> new Point(0, 1);
            case EAST -> new Point(1, 0);
            case SOUTH -> new Point(0, -1);
            case WEST -> new Point(-1, 0);
        };
    }
}
