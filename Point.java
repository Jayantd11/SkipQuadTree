/**
 * This class represents a point in the PR QuadTree.
 * It has x and y coordinates.
 * 
 * @author ishitagupta jayantd11
 * @version 02-25-2024
 */
public class Point {
    private String name;
    private int xCoord;
    private int yCoord;

    /**
     * Constructor to initialize the Point with x and y coordinates.
     * 
     * @param name
     *            the name of the point
     * 
     * @param xCoord
     *            the x coordinate of the point
     * @param yCoord
     *            the y coordinate of the point
     */
    public Point(String name, int xCoord, int yCoord) {
        this.name = name;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }


    /**
     * Constructor to initialize the Point with x and y coordinates.
     * 
     * @param xCoord
     *            the x coordinate of the point
     * @param yCoord
     *            the y coordinate of the point
     */
    public Point(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }


    /**
     * Getter for the x coordinate of the point.
     * 
     * @return the x coordinate of the point
     */
    public int getXCoord() {
        return xCoord;
    }


    /**
     * Getter for the y coordinate of the point.
     * 
     * @return the y coordinate of the point
     */
    public int getYCoord() {
        return yCoord;
    }


    /**
     * getter for the name of the point
     * 
     * @return the name of the point
     */
    public String getName() {
        return name;
    }


    /**
     * checks if the point is invalid
     * used in Database class
     * 
     * @return true if the point's xCoord or YCoord is a negative number or
     *         greater than 1024
     */
    public boolean isInvalid() {
        return (xCoord < 0 || xCoord > 1024 || yCoord < 0 || yCoord > 1024);
    }


    /**
     * this is the toString of this method
     * 
     * @return the string of the point
     */
    public String toString() {
        return name + ", " + xCoord + ", " + yCoord;
    }


    /**
     * Compares this Point to the specified object. The result is true if and
     * only
     * if the argument is not null and is a Point object that has the same x and
     * y
     * coordinates as this Point.
     * 
     * @param obj
     *            the object to compare this Point against
     * @return true if the given object represents a Point with the same
     *         coordinates
     *         as this Point, false otherwise
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Point other = (Point)obj;
        return xCoord == other.xCoord && yCoord == other.yCoord;
    }

}
