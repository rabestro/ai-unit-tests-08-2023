package leetcode.p54.a;

record Point(int x, int y) {
    Point add(Point delta) {
        return new Point(this.x + delta.x, this.y + delta.y);
    }

    Point move(Direction direction) {
        return this.add(direction.delta());
    }

    boolean isInside(Point topLeft, Point downRight) {
        return false;
    }
}
