import edu.princeton.cs.algs4.StdDraw;

public class RectHV {


    private final double xmin;
    private final double ymin;
    private final double xmax;
    private final double ymax;

    public RectHV(double xmin, double ymin,       // construct the rectangle [xmin, xmax] x [ymin, ymax]
                  double xmax, double ymax) {     // throw a java.lang.IllegalArgumentException if (xmin > xmax) or (ymin > ymax)

        this.xmin = xmin;
        this.ymin = ymin;
        this.xmax = xmax;
        this.ymax = ymax;

    }

    public double xmin() {                          // minimum x-coordinate of rectangle
        return this.xmin;
    }

    public double ymin() {                          // minimum y-coordinate of rectangle
        return this.ymin;
    }

    public double xmax() {                          // maximum x-coordinate of rectangle
        return this.xmax;
    }

    public double ymax() {                          // maximum y-coordinate of rectangle
        return this.ymax;
    }

    public boolean contains(Point2D p) {            // does this rectangle contain the point p (either inside or on boundary)?
        return (p.x() >= xmin && p.x() <= xmax)
                && (p.y() >= ymin && p.y() <= ymax);
    }

    public boolean intersects(RectHV that) {        // does this rectangle intersect that rectangle (at one or more points)?
        return this.xmax >= that.xmin && this.ymax >= that.ymin
            && that.xmax >= this.xmin && that.ymax >= this.ymin;
    }

    public double distanceTo(Point2D p) {           // Euclidean distance from point p to closest point in rectangle
        return Math.sqrt(this.distanceSquaredTo(p));
    }

    public double distanceSquaredTo(Point2D p) {    // square of Euclidean distance from point p to closest point in rectangle
        double dx = 0.0, dy = 0.0;
        if (p.x() < xmin) dx = p.x() - xmin;
        else if (p.x() > xmax) dx = p.x() - xmax;
        if (p.y() < ymin) dy = p.y() - ymin;
        else if (p.y() > ymax) dy = p.y() - ymax;
        return dx*dx + dy*dy;
    }

    public boolean equals(Object that) {            // does this rectangle equal that object?
        return false;
    }

    public void draw() {                            // draw to standard draw
        StdDraw.line(xmin, ymin, xmax, ymin);
        StdDraw.line(xmax, ymin, xmax, ymax);
        StdDraw.line(xmax, ymax, xmin, ymax);
        StdDraw.line(xmin, ymax, xmin, ymin);
    }

    public String toString() {                      // string representation
    return "[" + xmin + ", " + xmax + "] x [" + ymin + ", " + ymax + "]";}
}