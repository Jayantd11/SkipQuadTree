import java.util.List;
import java.util.LinkedList;

/**
 * represents an internal node in a PR QuadTree.
 * an internal node contains references to its four children nodes.
 *
 * @author ishitagupta
 * @version 03-01-2024
 */
public class QuadInternalNode implements QuadNode {
    private QuadNode nw;
    private QuadNode ne;
    private QuadNode sw;
    private QuadNode se;

    /**
     * sets up the class
     */
    public QuadInternalNode() {
        nw = new QuadEmptyNode();
        ne = new QuadEmptyNode();
        sw = new QuadEmptyNode();
        se = new QuadEmptyNode();
    }


    /**
     * inserts a point into the QuadTree, creating child nodes as necessary to
     * contain the point.
     *
     * @param point
     *            the point to insert
     * @param region
     *            the region representing the bounds of the QuadTree
     * @return the updated QuadTree with the point inserted
     */
    public QuadNode insertHelper(Point point, Region region) {

        // determine which region the point belongs to
        int midX = (region.getMinX() + region.getMaxX()) / 2;
        int midY = (region.getMinY() + region.getMaxY()) / 2;

        // decide which child node to insert the point into
        if (point.getXCoord() < midX) {
            if (point.getYCoord() < midY) {
                // point belongs to nw quadrant
                nw = nw.insertHelper(point, new Region(region.getMinX(), region
                    .getMinY(), midX, midY));
            }
            else {
                // point belongs to sw quadrant
                sw = sw.insertHelper(point, new Region(region.getMinX(), midY,
                    midX, region.getMaxY()));
            }
        }
        else {
            if (point.getYCoord() < midY) {
                // point belongs to ne quadrant
                ne = ne.insertHelper(point, new Region(midX, region.getMinY(),
                    region.getMaxX(), midY));
            }
            else {
                // point belongs to se quadrant
                se = se.insertHelper(point, new Region(midX, midY, region
                    .getMaxX(), region.getMaxY()));
            }
        }
        return this;
    }


    /**
     * performs a duplicate check on the points within the node.
     * recursively calls duplicateHelper() on all child nodes.
     */
    public void duplicateHelper() {
        nw.duplicateHelper();
        ne.duplicateHelper();
        sw.duplicateHelper();
        se.duplicateHelper();

    }


    /**
     * searches for points within the specified rectangular region.
     * recursively searches child nodes as necessary and returns the total
     * number of nodes visited.
     * S
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
     * @return the total number of nodes visited during the search
     */
    public int regionSearchHelper(int x, int y, int w, int h, Region region) {
        int nodesVisited = 1; // Count the current node itself

        // Create a region representing the search box defined by x, y, w, h
        Region searchBox = new Region(x, y, x + w, y + h);

        int midX = (region.getMinX() + region.getMaxX()) / 2;
        int midY = (region.getMinY() + region.getMaxY()) / 2;

        if (searchBox.intersectsRegion(new Region(region.getMinX(), region
            .getMinY(), midX, midY))) {
            nodesVisited += nw.regionSearchHelper(x, y, w, h, new Region(region
                .getMinX(), region.getMinY(), midX, midY));
        }
        if (searchBox.intersectsRegion(new Region(midX, region.getMinY(), region
            .getMaxX(), midY))) {
            nodesVisited += ne.regionSearchHelper(x, y, w, h, new Region(midX,
                region.getMinY(), region.getMaxX(), midY));
        }
        if (searchBox.intersectsRegion(new Region(region.getMinX(), midY, midX,
            region.getMaxY()))) {
            nodesVisited += sw.regionSearchHelper(x, y, w, h, new Region(region
                .getMinX(), midY, midX, region.getMaxY()));
        }
        if (searchBox.intersectsRegion(new Region(midX, midY, region.getMaxX(),
            region.getMaxY()))) {
            nodesVisited += se.regionSearchHelper(x, y, w, h, new Region(midX,
                midY, region.getMaxX(), region.getMaxY()));
        }

        return nodesVisited;

    }


    /**
     * Recursively dumps the contents of the QuadTree starting from the
     * specified internal node.
     * This method prints the structure of the QuadTree, including internal
     * nodes and their children.
     *
     * @param level
     *            the level of the current node in the QuadTree hierarchy
     * @param region
     *            the region represented by the current internal node
     * @return the total number of nodes printed, including the current internal
     *         node and its children
     */
    public int dumpHelper(int level, Region region) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level * 2; i++) {
            indent.append(" ");
        }

        System.out.println(indent + "Node at " + region.toString()
            + ": Internal");

        int nodesPrinted = 1;

        int midX = (region.getMinX() + region.getMaxX()) / 2;
        int midY = (region.getMinY() + region.getMaxY()) / 2;

        nodesPrinted = nodesPrinted + nw.dumpHelper(level + 1, new Region(region
            .getMinX(), region.getMinY(), midX, midY));

        nodesPrinted = nodesPrinted + ne.dumpHelper(level + 1, new Region(midX,
            region.getMinY(), region.getMaxX(), midY));

        nodesPrinted = nodesPrinted + sw.dumpHelper(level + 1, new Region(region
            .getMinX(), midY, midX, region.getMaxY()));

        nodesPrinted = nodesPrinted + se.dumpHelper(level + 1, new Region(midX,
            midY, region.getMaxX(), region.getMaxY()));

        return nodesPrinted;

    }


    /**
     * Removes a point from the QuadTree based on its name.
     * 
     * @param point
     *            the point to remove
     * @param region
     *            the region representing the bounds of the QuadTree
     * @return the resulting node after removal
     */
    public QuadNode removeNameHelper(Point point, Region region) {
        int midX = (region.getMinX() + region.getMaxX()) / 2;
        int midY = (region.getMinY() + region.getMaxY()) / 2;

        if (point.getXCoord() < midX) {
            if (point.getYCoord() < midY) {
                // point belongs to nw quadrant
                nw = nw.removeNameHelper(point, new Region(region.getMinX(),
                    region.getMinY(), midX, midY));
            }
            else {
                // point belongs to sw quadrant
                sw = sw.removeNameHelper(point, new Region(region.getMinX(),
                    midY, midX, region.getMaxY()));
            }
        }
        else {
            if (point.getYCoord() < midY) {
                // point belongs to ne quadrant
                ne = ne.removeNameHelper(point, new Region(midX, region
                    .getMinY(), region.getMaxX(), midY));
            }
            else {
                // point belongs to se quadrant
                se = se.removeNameHelper(point, new Region(midX, midY, region
                    .getMaxX(), region.getMaxY()));
            }
        }

        if (countEmptyQuadrants() == 3) {
            if (nw instanceof QuadLeafNode)
                return nw;
            if (ne instanceof QuadLeafNode)
                return ne;
            if (sw instanceof QuadLeafNode)
                return sw;
            if (se instanceof QuadLeafNode)
                return se;
        }

        // if children have <=3 points in total then they combine to a leaf node

        // check to make sure each quadrant isn't internal
        if (!(nw instanceof QuadInternalNode)
            && !(ne instanceof QuadInternalNode)
            && !(sw instanceof QuadInternalNode)
            && !(se instanceof QuadInternalNode)) {

            List<Point> things = new LinkedList<>();

            // seperately check that they are leafnodes to make sure not empty
            // create a list to store the points and add them by using your
            // getter
            if (nw instanceof QuadLeafNode) {
                things.addAll(((QuadLeafNode)nw).getPoints());
            }

            if (ne instanceof QuadLeafNode) {
                things.addAll(((QuadLeafNode)ne).getPoints());
            }

            if (sw instanceof QuadLeafNode) {
                things.addAll(((QuadLeafNode)sw).getPoints());
            }

            if (se instanceof QuadLeafNode) {
                things.addAll(((QuadLeafNode)se).getPoints());
            }

            if (things.size() <= 3) {
                QuadLeafNode leaf = new QuadLeafNode();
                for (Point p : things) {
                    leaf.insertHelper(p, region);
                }
                return leaf;
            }

        }

        return this;
    }


    /**
     * Counts the number of empty quadrants among the children nodes.
     * 
     * @return the number of empty quadrants
     */
    private int countEmptyQuadrants() {
        int count = 0;
        if (nw instanceof QuadEmptyNode)
            count++;
        if (ne instanceof QuadEmptyNode)
            count++;
        if (sw instanceof QuadEmptyNode)
            count++;
        if (se instanceof QuadEmptyNode)
            count++;
        return count;
    }


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
    public QuadNode removeCoordHelper(int x, int y, Region region) {
        int midX = (region.getMinX() + region.getMaxX()) / 2;
        int midY = (region.getMinY() + region.getMaxY()) / 2;

        if (x < midX) {
            if (y < midY) {
                // point belongs to nw quadrant
                nw = nw.removeCoordHelper(x, y, new Region(region.getMinX(),
                    region.getMinY(), midX, midY));
            }
            else {
                // point belongs to sw quadrant
                sw = sw.removeCoordHelper(x, y, new Region(region.getMinX(),
                    midY, midX, region.getMaxY()));
            }
        }
        else {
            if (y < midY) {
                // point belongs to ne quadrant
                ne = ne.removeCoordHelper(x, y, new Region(midX, region
                    .getMinY(), region.getMaxX(), midY));
            }
            else {
                // point belongs to se quadrant
                se = se.removeCoordHelper(x, y, new Region(midX, midY, region
                    .getMaxX(), region.getMaxY()));
            }
        }

        if (countEmptyQuadrants() == 3) {
            if (nw instanceof QuadLeafNode)
                return nw;
            if (ne instanceof QuadLeafNode)
                return ne;
            if (sw instanceof QuadLeafNode)
                return sw;
            if (se instanceof QuadLeafNode)
                return se;
        }

        if (!(nw instanceof QuadInternalNode)
            && !(ne instanceof QuadInternalNode)
            && !(sw instanceof QuadInternalNode)
            && !(se instanceof QuadInternalNode)) {

            List<Point> things = new LinkedList<>();

            // seperately check that they are leafnodes to make sure not empty
            // create a list to store the points and add them by using your
            // getter
            if (nw instanceof QuadLeafNode) {
                things.addAll(((QuadLeafNode)nw).getPoints());
            }

            if (ne instanceof QuadLeafNode) {
                things.addAll(((QuadLeafNode)ne).getPoints());
            }

            if (sw instanceof QuadLeafNode) {
                things.addAll(((QuadLeafNode)sw).getPoints());
            }

            if (se instanceof QuadLeafNode) {
                things.addAll(((QuadLeafNode)se).getPoints());
            }

            // or if all points in thing are identical
            if (things.size() < 4) {
                QuadLeafNode leaf = new QuadLeafNode();
                for (Point p : things) {
                    leaf.insertHelper(p, region);
                }
                return leaf;
            }

        }

        return this;
    }

}
