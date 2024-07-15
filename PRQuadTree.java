/**
 * represents a PR QuadTree data structure for efficient spatial indexing.
 * points are inserted into the QuadTree based on their 2D coordinates.
 * 
 * @author ishitagupta jayantd11
 * @version 03-01-2024
 */
public class PRQuadTree {

    private QuadNode root;
    private Region region;

    /**
     * constructs a PRQuadTree with the default region (0, 0, 1024, 1024).
     */
    public PRQuadTree() {
        this.root = new QuadEmptyNode();
        region = new Region(0, 0, 1024, 1024);
    }


    /**
     * inserts a point into the PRQuadTree at the specified coordinates.
     *
     * @param point
     *            the point to insert
     */
    public void insert(Point point) {
        root = root.insertHelper(point, region);
    }


    /**
     * Performs a duplicate check on the points in the PRQuadTree.
     * Prints any duplicate points found.
     */
    public void duplicate() {
        root.duplicateHelper();
    }


    /**
     * searches for points within the specified rectangular region.
     * returns the number of QuadTree nodes visited during the search.
     *
     * @param x
     *            the x-coordinate of the region's top-left corner
     * @param y
     *            the y-coordinate of the region's top-left corner
     * @param w
     *            the width of the region
     * @param h
     *            the height of the region
     * @return the number of QuadTree nodes visited
     */
    public int regionsearch(int x, int y, int w, int h) {
        return root.regionSearchHelper(x, y, w, h, region);
    }


    /**
     * Removes a point from the PR QuadTree based on its name.
     * 
     * @param point
     *            the point to remove
     */
    public void removeName(Point point) {
        root = root.removeNameHelper(point, region);
    }


    /**
     * Removes a point from the PR QuadTree based on its coordinates.
     * 
     * @param x
     *            the x-coordinate of the point to remove
     * @param y
     *            the y-coordinate of the point to remove
     */
    public void removeCoord(int x, int y) {
        root = root.removeCoordHelper(x, y, region);
    }


    /**
     * Prints the nodes of the QuadTree in preorder traversal, with each node
     * indented according to its level in the tree.
     */
    public void dump() {
        System.out.println("QuadTree dump:");
        int totalNodesPrinted = root.dumpHelper(0, region);
        System.out.println(totalNodesPrinted + " quadtree nodes printed");

    }

}
