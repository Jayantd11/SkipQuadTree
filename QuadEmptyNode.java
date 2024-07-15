/**
 * represents an empty node in a PR QuadTree.
 * an empty node does not contain any points.
 *
 * @author ishitagupta
 * @version 03-01-2024
 */
public class QuadEmptyNode implements QuadNode {

    /**
     * Constructs a new empty node.
     */
    public QuadEmptyNode() {
    }


    /**
     * inserts a point into the QuadTree, creating a leaf node to contain the
     * point.
     *
     * @param point
     *            the point to insert
     * @param region
     *            the region representing the bounds of the QuadTree
     * @return a leaf node containing the inserted point
     */
    public QuadNode insertHelper(Point point, Region region) {
        // Create a leaf node and insert the point into it
        QuadLeafNode leafNode = new QuadLeafNode();
        leafNode.insertHelper(point, region);
        return leafNode;
    }


    /**
     * performs a duplicate check on the points within the node.
     * since the node is empty, there are no points to check for duplicates.
     */
    public void duplicateHelper() {
        // No action needed for an empty node
    }


    /**
     * searches for points within the specified rectangular region.
     * since an empty node contains no points, it always returns 1 to indicate
     * that the node itself was visited.
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
     * @return 1 to indicate that the node itself was visited
     */
    @Override
    public int regionSearchHelper(int x, int y, int w, int h, Region region) {
        // An empty node has no points, so it should return 1 to indicate that
        // the node itself was visited
        return 1;
    }


    /**
     * Recursively dumps the contents of the QuadTree starting from the
     * specified node.
     * This method is used internally by the QuadTree to print its structure.
     *
     * @param level
     *            the level of the current node in the QuadTree hierarchy
     * @param region
     *            the region represented by the current node
     * @return the total number of nodes printed, including the current node
     */
    public int dumpHelper(int level, Region region) {
        // Print empty node information

        StringBuilder indent = new StringBuilder();

        for (int i = 0; i < level * 2; i++) {
            indent.append(" ");
        }

        System.out.println(indent + "Node at " + region.toString() + ": Empty");

        return 1;
    }


    /**
     * Returns this empty node as it cannot contain the specified point.
     *
     * @param point
     *            the point to remove (ignored as this node is empty)
     * @param region
     *            the region representing the bounds of the QuadTree
     * @return this empty node
     */
    @Override
    public QuadNode removeNameHelper(Point point, Region region) {
        return this;
    }


    /**
     * Returns this empty node as it cannot contain any points at the specified
     * coordinates.
     *
     * @param x
     *            the x-coordinate of the point to remove (ignored as this node
     *            is empty)
     * @param y
     *            the y-coordinate of the point to remove (ignored as this node
     *            is empty)
     * @param region
     *            the region representing the bounds of the QuadTree
     * @return this empty node
     */
    @Override
    public QuadNode removeCoordHelper(int x, int y, Region region) {
        return this;
    }

}
