import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.RectHV;

public class Point2D implements Comparable<Point2D> {
    private final double x;
    private final double y;

    public Point2D(double x, double y) {                // construct the point (x, y)
        this.x = x;
        this.y = y;
    }

    public double x() {                                 // x-coordinate
        return this.x;
    }

    public double y() {                                 // y-coordinate
        return this.y;
    }

    public double distanceTo(Point2D that) {            // Euclidean distance between two points
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public double distanceSquaredTo(Point2D that) {     // square of Euclidean distance between two points
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return dx*dx + dy*dy;
    }

    public int compareTo(Point2D that) {                // for use in an ordered symbol table
        if (this.y < that.y) return -1;
        if (this.y > that.y) return +1;
        if (this.x < that.x) return -1;
        if (this.x > that.x) return +1;
        return 0;
    }

    public boolean equals(Object that) {                // does this point equal that object?
        if (this == that) return true;
        if (this == null) return false;
        if (that.getClass() != this.getClass()) return false;
        Point2D thatPoint2D = (Point2D) that;
        return this.x ==  thatPoint2D.x && this.y == thatPoint2D.y;
    }

    public void draw() {                                // draw to standard draw
        StdDraw.point(x, y);
    }

    public String toString() {                          // string representation
        return "(" + x + ", " + y + ")";
    }
}