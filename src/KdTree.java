import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.ArrayList;
import java.util.TreeSet;

public class KdTree {

    // Write a mutable data type Kdtree that uses a 2D tree to implement "the same API" as PointSET,
    // but replace PointSET with KdTree. A 2D-tree is a generalization of a BST to two dem-keys. The
    // idea is to build a BST with points in the nodes, using the x- and y- coordinates of the point
    // as keys in strictly alternating sequence.

    private int size;
    private Node root;

    public KdTree() {                              // construct an empty set of points
//        this.setOfPoints = new SET();
    }

    public void setThePointsInTree(TreeSet<Point2D> newTreeSet) {
    }

    public boolean isEmpty() {
        return root == null;   // is the set empty?

    }

    public int size() {                              // number of points in the set
        return size;
    }

    private static class Node {
        private Point2D p;          // the point
        private boolean horizontal;
        private RectHV rect;        // the axis-aligned rectangle corresponding to this node
        private Node lb;            // the left/bottom subtree
        private Node rt;            // the right/top subtree

    }
    // Not sure how we'd utilize the left/bottom and right/top subtree?
    //

    public void insert(Point2D p) {                  // add the point to the set (if it is not already in the set)
        // "write a simplified version of insert() which does everything except set up the RectHV for each node"

        if (p == null) throw new IllegalArgumentException();
        else {
            size++;
            insertNextFreeSubTree(p, root);
        }
    }

    private void insertNextFreeSubTree(Point2D p, Node node) {
        if (node == null) {
            throw new IllegalArgumentException();
        } else {
            if (node.horizontal) {
                if (p.x() > node.p.x()) {
                    // Right tree
                    if (node.rt == null) {
                        node.rt = new Node();
                        node.rt.p = p;
                        node.rt.horizontal = !(node.horizontal);
                    } else {
                        // If not null, call itself recursively to get to the next node in the tree.
                        insertNextFreeSubTree(p, node.rt);
                    }


                } else {
                    // TODO: Left


                }


            } else {

                // TODO: Top


                // TODO: Bottom
            }
        }
    }

    public boolean contains(Point2D p) {             // does the set contain point p?
        return false;
    }

    public void draw() {                             // draw all points to standard draw

    }

    public Iterable<Point2D> range(RectHV rect) {    // all points that are inside the rectangle (or on the boundary)
        if (rect == null) throw new IllegalArgumentException();

        ArrayList<Point2D> pointsInRectangle = new ArrayList<>();

        if (rect.intersects(root.rect)) {
            rect.contains(root.lb.p);


        }

        return null;
    }

    public Point2D nearest(Point2D p) {              // a nearest neighbor in the set to point p; null if the set is empty
        if (this.isEmpty()) throw new IllegalArgumentException();
        Point2D nearestPoint = null;

        for (Point2D point : setOfPointsInTree) {
            if (nearestPoint == null) {
                nearestPoint = point;
            } else {
                if (nearestPoint.distanceTo(p) < p.distanceTo(point)) {
                    nearestPoint = point;
                }
            }
        }
        return nearestPoint;
    }

    public static void main(String[] args) {         // unit testing of the methods (optional)

    }
}


