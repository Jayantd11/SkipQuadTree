import java.util.LinkedList;
import java.util.List;

/**
 * Represents a leaf node in a PR QuadTree.
 * A leaf node contains a linked list of points.
 *
 * @author ishitagupta jayantd11
 * @version 03-01-2024
 */
public class QuadLeafNode implements QuadNode {

    /** linked list of points stored in the leaf node. */
    private LinkedList<Point> points;

    /**
     * constructs a new leaf node with an empty list of points.
     */
    public QuadLeafNode() {
        points = new LinkedList<>();
    }


    /**
     * inserts a point into the leaf node.
     * if the number of points exceeds a threshold (4), the leaf node is split
     * into an internal node.
     *
     * @param point
     *            the point to insert
     * @param region
     *            the region representing the bounds of the QuadTree
     * @return the resulting node after insertion, which may be the same leaf
     *         node or a new internal node
     */
    @Override
    public QuadNode insertHelper(Point point, Region region) {
        int count = diffCount();
        points.add(point);
        // Check if the leaf node needs to split
        if (points.size() > 3 && count > 0) {
            return splitLeaf(region);
        }
        return this;

    }


    /**
     * splits the leaf node into an internal node.
     *
     * @param region
     *            the region representing the bounds of the QuadTree
     * @return the newly created internal node containing the points
     */
    private QuadInternalNode splitLeaf(Region region) {
        QuadInternalNode internalNode = new QuadInternalNode();
        // Insert each point into the internal node
        for (Point p : points) {

            internalNode.insertHelper(p, region);

        }
        return internalNode;
    }


    private int diffCount() {
        int count = 0;
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (points.get(i).getXCoord() != points.get(j).getXCoord()
                    && points.get(i).getYCoord() != points.get(j).getYCoord()) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * checks for duplicate points within the leaf node and prints them.
     */
    @Override
    public void duplicateHelper() {
        LinkedList<Point> printedPoints = new LinkedList<>();

        for (int i = 0; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            // Keep a track of the ll
            boolean isDuplicate = false;
            for (Point printedPoint : printedPoints) {
                if (currentPoint.getYCoord() == printedPoint.getYCoord()
                    && currentPoint.getXCoord() == printedPoint.getXCoord()) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                for (int j = i + 1; j < points.size(); j++) {
                    Point nextPoint = points.get(j);
                    if (currentPoint.getYCoord() == nextPoint.getYCoord()
                        && currentPoint.getXCoord() == nextPoint.getXCoord()) {
                        System.out.println("(" + currentPoint.getXCoord() + ", "
                            + currentPoint.getYCoord() + ")");
                        printedPoints.add(currentPoint);
                        break;
                    }
                }
            }
        }
    }


    /**
     * searches for points within the specified rectangular region and prints
     * them.
     *
     * @param x
     *            the x-coordinate of the region's top-left corner
     * @param y
     *            the y-coordinate of the region's top-left corner
     * @param w
     *            the width of the region
     * @param h
     *            the height of the region
     * @param region
     *            the region representing the bounds of the QuadTree
     * @return the number of nodes visited during the search
     */
    @Override
    public int regionSearchHelper(int x, int y, int w, int h, Region region) {
        for (Point point : points) {
            if (point.getXCoord() >= x && point.getXCoord() <= x + w && point
                .getYCoord() >= y && point.getYCoord() <= y + h) {
                System.out.println("Point found: (" + point.getName() + ", "
                    + point.getXCoord() + ", " + point.getYCoord() + ")");
            }
        }

        return 1;
    }


    /**
     * Recursively dumps the contents of the QuadTree starting from this leaf
     * node.
     * 
     * @param level
     *            the current level of the node in the QuadTree
     * @param region
     *            the region covered by this node
     * @return the total number of nodes printed, including the current leaf
     *         node and its points
     */
    public int dumpHelper(int level, Region region) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level * 2; i++) {
            indent.append(" ");
        }

        System.out.println(indent + "Node at " + region.toString() + ":");
        for (Point point : points) {
            System.out.println(indent + "(" + point.toString() + ")");
        }
        return 1;
    }


    /**
     * Removes the specified point from this leaf node based on its name.
     * If the point is found and removed, the resulting node may remain a leaf
     * node or
     * become an empty node if all points are removed.
     *
     * @param point
     *            the point to remove
     * @param region
     *            the region representing the bounds of the QuadTree
     * @return the resulting node after removal, which may be the same leaf
     *         node, an
     *         empty node, or null if the point was not found
     */
    public QuadNode removeNameHelper(Point point, Region region) {
        for (Point p : points) {
            if (p.getName().equals(point.getName()) && point.getXCoord() == p
                .getXCoord() && point.getYCoord() == p.getYCoord()) {
                points.remove(p);
                if (points.isEmpty()) {
                    // Convert to an empty node if the list is empty
                    return new QuadEmptyNode();
                }
                else {
                    return this;
                }
            }
        }
        return this;
    }


    /**
     * Removes the point at the specified coordinates from this leaf node.
     * If the point is found and removed, the resulting node may remain a leaf
     * node or
     * become an empty node if all points are removed.
     *
     * @param x
     *            the x-coordinate of the point to remove
     * @param y
     *            the y-coordinate of the point to remove
     * @param region
     *            the region representing the bounds of the QuadTree
     * @return the resulting node after removal, which may be the same leaf
     *         node, an
     *         empty node, or null if the point was not found
     */
    public QuadNode removeCoordHelper(int x, int y, Region region) {
        for (Point p : points) {
            if (p.getXCoord() == x && p.getYCoord() == y) {
                points.remove(p);

                if (points.isEmpty()) {
                    return new QuadEmptyNode();
                }
                else {
                    return this;
                }
            }
        }
        return this;
    }


    /**
     * give us a linked list of points we need
     * 
     * @return points
     */
    public LinkedList<Point> getPoints() {
        return points;
    }

}
