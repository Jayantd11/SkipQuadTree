/**
 * 
 * This class holds the coordinates and dimensions of a rectangle and methods to
 * 
 * check if it intersects or has the same coordinates as an other rectangle.
 * 
 * 
 * 
 * @author CS Staff
 * 
 * 
 * 
 * @version 2024-01-22
 * 
 */

public class Rectangle {

    // the x coordinate of the rectangle

    private int xCoordinate;

    // the y coordinate of the rectangle

    private int yCoordinate;

    // the distance from the x coordinate the rectangle spans

    private int width;

    // the distance from the y coordinate the rectangle spans

    private int height;

    /**
     * 
     * Creates an object with the values to the parameters given in the
     * 
     * xCoordinate, yCoordinate, width, height
     * 
     * 
     * 
     * @param x
     * 
     *            x-coordinate of the rectangle
     * 
     * @param y
     * 
     *            y-coordinate of the rectangle
     * 
     * @param w
     * 
     *            width of the rectangle
     * 
     * @param h
     * 
     *            height of the rectangle
     * 
     */

    public Rectangle(int x, int y, int w, int h) {

        xCoordinate = x;

        yCoordinate = y;

        width = w;

        height = h;

    }


    /**
     * 
     * Getter for the x coordinate
     *
     * 
     * 
     * @return the x coordinate
     * 
     */

    public int getxCoordinate() {

        return xCoordinate;

    }


    /**
     * 
     * Getter for the y coordinate
     *
     * 
     * 
     * @return the y coordinate
     * 
     */

    public int getyCoordinate() {

        return yCoordinate;

    }


    /**
     * 
     * Getter for the width
     *
     * 
     * 
     * @return the width
     * 
     */

    public int getWidth() {

        return width;

    }


    /**
     * 
     * Getter for the height
     *
     * 
     * 
     * @return the height
     * 
     */

    public int getHeight() {

        return height;

    }


    /**
     * 
     * Checks if the invoking rectangle intersects with rec.
     * 
     * 
     * 
     * @param r2
     * 
     *            Rectangle parameter
     * 
     * @return true if the rectangle intersects with rec, false if not
     * 
     */

    public boolean intersect(Rectangle r2) {
        return getxCoordinate() < r2.getxCoordinate() + r2.getWidth()
            && getxCoordinate() + getWidth() > r2.getxCoordinate()
            && getyCoordinate() < r2.getyCoordinate() + r2.getHeight()
            && getyCoordinate() + getHeight() > r2.getyCoordinate();
    }


    /**
     * 
     * Checks, if the invoking rectangle has the same coordinates as rec.
     * 
     * 
     * 
     * @param rec
     * 
     *            the rectangle parameter
     * 
     * @return true if the rectangle has the same coordinates as rec, false if
     * 
     *         not
     * 
     */

    public boolean equals(Object rec) {
        if (rec == null || rec.getClass() != this.getClass()) {
            return false;
        }
        Rectangle rect = (Rectangle)rec;
        return rect.getxCoordinate() == getxCoordinate() && rect
            .getyCoordinate() == getyCoordinate() && rect
                .getWidth() == getWidth() && rect.getHeight() == getHeight();
    }


    /**
     * 
     * Outputs a human readable string with information about the rectangle
     * 
     * which includes the x and y coordinate and its height and width
     * 
     * 
     * 
     * @return a human readable string containing information about the
     * 
     *         rectangle
     * 
     */

    public String toString() {
        String string = getxCoordinate() + ", " + getyCoordinate() + ", "
            + getWidth() + ", " + getHeight();
        return string;

    }


    /**
     * 
     * Checks if the rectangle has invalid parameters
     * 
     * 
     * 
     * @return true if the rectangle has invalid parameters, false if not
     * 
     */

    public boolean isInvalid() {
        return getWidth() <= 0 || getHeight() <= 0 || getxCoordinate() < 0
            || getyCoordinate() < 0 || getxCoordinate() + getWidth() > 1024
            || getyCoordinate() + getHeight() > 1024;

    }
}
