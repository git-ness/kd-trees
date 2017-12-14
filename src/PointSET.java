import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.ArrayList;
import java.util.TreeSet;

public class PointSET {
    private TreeSet<Point2D> setOfPointsInTree;

    public PointSET() {                              // construct an empty set of points
//        this.setOfPoints = new SET();
        this.setOfPointsInTree = new TreeSet<>();
    }

    public boolean isEmpty() {                       // is the set empty?
        return setOfPointsInTree.size() == 0;
    }

    public int size() {                              // number of points in the set
        return setOfPointsInTree.size();
    }

    public void insert(Point2D p) {                  // add the point to the set (if it is not already in the set)

        if (p != null) {
            if (!setOfPointsInTree.contains(p)) {
                setOfPointsInTree.add(p);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(Point2D p) {             // does the set contain point p?
        return setOfPointsInTree.contains(p);
    }

    public void draw() {                             // draw all points to standard draw
        for (Point2D point : setOfPointsInTree) {
            point.draw();
        }
    }

    public Iterable<Point2D> range(RectHV rect) {    // all points that are inside the rectangle (or on the boundary)

        ArrayList<Point2D> pointsInRectangle = new ArrayList<>();

        for (Point2D point : setOfPointsInTree) {
            if (rect.contains(point)) {
                pointsInRectangle.add(point);
            }
        }

        return pointsInRectangle;
    }

    public Point2D nearest(Point2D p) {              // a nearest neighbor in the set to point p; null if the set is empty
        if (this.isEmpty()) throw new IllegalArgumentException();
        Point2D nearestPoint = null;

        for (Point2D point : setOfPointsInTree) {
            if (nearestPoint == null) {
                nearestPoint = point;
            } else {
                if (nearestPoint.distanceTo(p) > p.distanceTo(point)) {
                    nearestPoint = point;
                }
            }
        }
        return nearestPoint;
    }

    public static void main(String[] args) {         // unit testing of the methods (optional)

        Point2D point1 = new Point2D(0.5, 0.6);
        Point2D point2 = new Point2D(0.97, 0.06);
//        Point2D point3 = new Point2D(0.21, 0.2);

        PointSET pointSET = new PointSET();

        pointSET.insert(point1);
        pointSET.insert(point2);
//        pointSET.insert(point3);
        Point2D searchPoint = new Point2D(0.2, 0.1);

        Point2D result = pointSET.nearest(searchPoint);
        System.out.println("" + result);
    }
}