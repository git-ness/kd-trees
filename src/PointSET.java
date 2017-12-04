import edu.princeton.cs.algs4.SET;

public class PointSET {
    private SET set;

    public PointSET() {                              // construct an empty set of points
        this.set = new SET();
    }

    public boolean isEmpty() {                       // is the set empty?
        return set.size() == 0;
    }

    public int size() {                              // number of points in the set
        return set.size();
    }

    public void insert(Point2D p) {                  // add the point to the set (if it is not already in the set)

    }

    public boolean contains(Point2D p) {             // does the set contain point p?
        return false;
    }

    public void draw() {                             // draw all points to standard draw
    }

    public Iterable<Point2D> range(RectHV rect) {    // all points that are inside the rectangle (or on the boundary)
        return null;
    }

    public Point2D nearest(Point2D p) {              // a nearest neighbor in the set to point p; null if the set is empty
        return null;
    }

    public static void main(String[] args) {         // unit testing of the methods (optional)
    }
}