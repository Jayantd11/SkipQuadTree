/**
 * a region defined by its minimum and maximum coordinates.
 * <p>
 * 
 * @author Ishita Gupta
 * @version 2/26/2024
 */
public class Region {
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    /**
     * Constructs a new region with the specified minimum and maximum
     * coordinates.
     * 
     * @param minX
     *            the minimum x-coordinate of the region
     * @param minY
     *            the minimum y-coordinate of the region
     * @param maxX
     *            the maximum x-coordinate of the region
     * @param maxY
     *            the maximum y-coordinate of the region
     */
    public Region(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }


    /**
     * Returns the minimum x-coordinate of the region.
     * 
     * @return the minimum x-coordinate
     */
    public int getMinX() {
        return minX;
    }


    /**
     * Sets the minimum x-coordinate of the region.
     * 
     * @param minX
     *            the new minimum x-coordinate
     */
    public void setMinX(int minX) {
        this.minX = minX;
    }


    /**
     * Returns the minimum y-coordinate of the region.
     * 
     * @return the minimum y-coordinate
     */
    public int getMinY() {
        return minY;
    }


    /**
     * Sets the minimum y-coordinate of the region.
     * 
     * @param minY
     *            the new minimum y-coordinate
     */
    public void setMinY(int minY) {
        this.minY = minY;
    }


    /**
     * Returns the maximum x-coordinate of the region.
     * 
     * @return the maximum x-coordinate
     */
    public int getMaxX() {
        return maxX;
    }


    /**
     * Sets the maximum x-coordinate of the region.
     * 
     * @param maxX
     *            the new maximum x-coordinate
     */
    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }


    /**
     * Returns the maximum y-coordinate of the region.
     * 
     * @return the maximum y-coordinate
     */
    public int getMaxY() {
        return maxY;
    }


    /**
     * Sets the maximum y-coordinate of the region.
     * 
     * @param maxY
     *            the new maximum y-coordinate
     */
    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }


    /**
     * Returns the size of the region along the x-axis.
     * 
     * @return the size of the region
     */
    public int getSize() {
        return maxX - minX;
    }


    /**
     * checks if the point with the name is there
     * 
     * @param name
     *            is the name
     * @param x
     *            is the xCoord
     * @param y
     *            is the y Coord
     * @return
     *         the point with the name
     */
    public boolean containsPointWithName(String name, int x, int y) {
        return x >= minX && x <= maxX && y >= minY && y <= maxY;
    }


    /**
     * tests the intersection
     * 
     * @param other
     *            is the name of the region
     * @return the true or false
     */
    public boolean intersectsRegion(Region other) {
        // check if the regions intersect along the x-axis
        boolean xOverlap = (this.getMinX() <= other.getMaxX() && this
            .getMaxX() >= other.getMinX());

        // check if the regions intersect along the y-axis
        boolean yOverlap = (this.getMinY() <= other.getMaxY() && this
            .getMaxY() >= other.getMinY());

        // if both x-axis and y-axis overlap, the regions intersect
        return xOverlap && yOverlap;
    }


    /**
     * Returns a string representation of the Region object.
     * The string includes the minimum x-coordinate, minimum y-coordinate,
     * and the size of the region.
     *
     * @return a string representation of the Region object in the format "minX,
     *         minY, size"
     */
    public String toString() {
        return +minX + ", " + minY + ", " + getSize();
    }

}
