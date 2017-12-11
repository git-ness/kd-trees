
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.ArrayList;

public class KdTree {

    // Write a mutable data type Kdtree that uses a 2D tree to implement "the same API" as PointSET,
    // but replace PointSET with KdTree. A 2D-tree is a generalization of a BST to two dem-keys. The
    // idea is to build a BST with points in the nodes, using the x- and y- coordinates of the point
    // as keys in strictly alternating sequence.

    private int size;
    private Node root;
    private ArrayList<Point2D> pointsInRectangle = new ArrayList<>();

    public KdTree() {                              // construct an empty set of points
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
        private Node lb;            // the left | bottom subtree
        private Node rt;            // the right | top subtree

    }
    // Not sure how we'd utilize the left/bottom and right/top subtree?
    //

    public void insert(Point2D p) {                  // add the point to the set (if it is not already in the set)
        // "write a simplified version of insert() which does everything except set up the RectHV for each node"

        if (p == null) throw new IllegalArgumentException();
        size++;

        insertNextFreeSubTree(p, root);
    }

    private void insertNextFreeSubTree(Point2D p, Node node) {

        if (root == null && size == 1) {
            node = new Node();
            node.p = p;
            root = node;
            return;
        }

        if (node.horizontal || size == 2) { // When solely root is set, child-node will not be horizontal; we set root subtree to be horizontal.
            if (node.p.x() < p.x()) {
                    /* -------------
                       Right tree and left side
                      -------------- */
                if (node.rt == null) {
                    node.rt = new Node();
                    node.rt.p = p;
                    node.horizontal = true;

                    // The next layer in the tree will be opposite thus we invert the horizontal state.
                    node.rt.horizontal = !(node.horizontal);
                } else {
                    insertNextFreeSubTree(p, node.rt);
                }

            } else {
                    /* -------------
                       Left side and left tree
                      ------------- */
                // The point is the left side of the parent node. Represented by lb although bottom doesn't
                // apply because it can be above the parent point.
                // See 8:15 at https://www.coursera.org/learn/algorithms-part1/lecture/Yionu/kd-trees it is on the "right-top"

                if (node.lb == null) {
                    node.lb = new Node();
                    node.lb.p = p;

                    // The next layer in the tree will be opposite thus we invert the horizontal state.
                    node.lb.horizontal = !(node.horizontal);
                } else {
                    // If not null, call itself recursively to get to the next node in the tree.
                    insertNextFreeSubTree(p, node.lb);
                }
            }

        } else { // Top - The point p is above the parent node so we go right, represented by right-top (rt).

                /* -------------
                   Top of horizontal parent node
                 ------------- */

            // TODO: Top - !node.horizontal .. but top what? I think the point is physically above the parent node.
            if (node.p.y() > p.y()) {
                if (node.rt == null) {
                    node.rt = new Node();
                    node.rt.p = p;

                    // Next layer in the tree will always be horizontal.
                    node.rt.horizontal = node.horizontal;
                } else {
                    // If not null, call itself recursively to get to the next node in the tree.
                    insertNextFreeSubTree(p, node.rt);
                }

            } else { // TODO: Bottom
                 /* -------------
                   Bottom of horizontal parent node
                 ------------- */
                if (node.p.y() < p.y()) {
                    if (node.lb == null) {
                        node.lb = new Node();
                        node.lb.p = p;

                        node.lb.horizontal = node.horizontal;

                    } else {
                        insertNextFreeSubTree(p, node.lb);
                    }
                }
            }
        }
    }


    public boolean contains(Point2D p) {             // does the set contain point p?

    }


    public void draw() {                             // draw all points to standard draw


    }

    public Iterable<Point2D> range(RectHV rect) {    // all points that are inside the rectangle (or on the boundary)
        if (rect == null) throw new IllegalArgumentException();
        if (root == null) return null;

        ArrayList<Point2D> pointsInRectangle = new ArrayList<>();

        // Check to see if the root point is within the rectangle. If so, add it to the arraylist.
        if (rect.xmin() <= root.p.x() && rect.xmax() >= root.p.x()
                && rect.ymax() <= root.p.y() && rect.ymax() >= root.p.y()) {
            pointsInRectangle.add(root.p);
        }

        // Check if rectangle is to the left of the point in the tree.
        if (isRectToLeftOfPoint(root, rect)) {
            if (isPointWithinRectangle(root.lb, rect)) {
                pointsInRectangle.add(root.lb.p);
            } else {

            }

        // Since the rectangle is not to the left of the point, it is to the right.
        } else {
            if (isPointWithinRectangle(root.rt, rect)) {
                pointsInRectangle.add(root.rt.p);
            } else { // go to next level in tree : how do I do this recursively?

            }
        }


        return null;
    }

    private boolean isPointWithinRectangle(Node node, RectHV rect) {
        return rect.xmin() <= node.p.x() && rect.xmax() >= node.p.x()
                && rect.ymax() <= node.p.y() && rect.ymax() >= node.p.y();
    }

    private boolean isRectToLeftOfPoint(Node node, RectHV rect) {
        return node.p.x() < rect.xmin();
    }

    private boolean isRectToRightOfPoint(Node node, RectHV rect) {
        return node.p.x() > rect.xmax();
    }

    private boolean isRectAbovePoint(Node node, RectHV rect) {
        return node.p.y() > rect.ymax();
    }

    private boolean isRectBelowPoint(Node node, RectHV rect) {
        return node.p.y() < rect.ymin();
    }


    public Point2D nearest(Point2D p) {              // a nearest neighbor in the set to point p; null if the set is empty


//        if (this.isEmpty()) throw new IllegalArgumentException();
//        Point2D nearestPoint = null;
//
//        for (Point2D point : setOfPointsInTree) {
//            if (nearestPoint == null) {
//                nearestPoint = point;
//            } else {
//                if (nearestPoint.distanceTo(p) < p.distanceTo(point)) {
//                    nearestPoint = point;
//                }
//            }
//        }
        return null;
    }

    public static void main(String[] args) {         // unit testing of the methods (optional)

    }
}


