/**
 * Represents a node in a PR QuadTree.
 * 
 * @author ishitagupta jayantd11
 * @version 03-01-2024
 */
public interface QuadNode {

    /**
     * Inserts a point into the QuadTree.
     *
     * @param point
     *            the point to insert
     * @param region
     *            the region representing the bounds of the QuadTree
     * @return the resulting node after insertion, which may be an updated leaf
     *         node or a new internal node
     */
    QuadNode insertHelper(Point point, Region region);


    /**
     * Checks for and handles duplicate points within the QuadTree.
     */
    void duplicateHelper();


    /**
     * Searches for points within the specified rectangular region in the
     * QuadTree.
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
    int regionSearchHelper(int x, int y, int w, int h, Region region);


    /**
     * Recursively dumps the contents of the QuadTree starting from this node.
     *
     * @param level
     *            the current level of the node in the QuadTree
     * @param region
     *            the region covered by this node
     * @return the total number of nodes printed, including the current node and
     *         its children
     */
    public int dumpHelper(int level, Region region);


    /**
     * Removes a point from the QuadTree based on its name.
     * 
     * @param point
     *            the point to remove
     * @param region
     *            the region representing the bounds of the QuadTree
     * @return the resulting node after removal
     */
    public QuadNode removeNameHelper(Point point, Region region);


    /**
     * Removes a point from the QuadTree based on its coordinates.
     * 
     * @param x
     *            the x-coordinate of the point
     * @param y
     *            the y-coordinate of the point
     * @param region
     *            the region representing the bounds of the QuadTree
     * @return the resulting node after removal
     */
    public QuadNode removeCoordHelper(int x, int y, Region region);

}
