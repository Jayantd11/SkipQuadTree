import java.util.ArrayList;

// On my honor:
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or unmodified.
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
// - I have not discussed coding details about this project with
// anyone other than the my partner, instructor, ACM/UPE tutors
// or the TAs assigned to this course.
// I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.

/**
 * This class is responsible for interfacing between the command processor and
 * the SkipList. The responsibility of this class is to further interpret
 * variations of commands and do some error checking of those commands. This
 * class further interpreting the command means that the two types of remove
 * will be overloaded methods for if we are removing by name or by coordinates.
 * Many of these methods will simply call the appropriate version of the
 * SkipList method after some preparation.
 * 
 * Also note that the Database class will have a clearer role in Project2,
 * where we will have two data structures. The Database class will then
 * determine which command should be directed to which data structure.
 * 
 * @author CS Staff
 * @version 2024-01-22
 */
public class Database {

    private SkipList<String, Point> list;
    private PRQuadTree prquad;

    /**
     * Constructs a new Database object with an empty SkipList and PRQuadTree.
     */
    public Database() {
        list = new SkipList<String, Point>();
        prquad = new PRQuadTree();
    }


    /**
     * Inserts a point into the database.
     * 
     * @param point
     *            the point to be inserted
     */
    public void insert(Point point) {
        ArrayList<KVPair<String, Point>> searchResult = list.search(point
            .getName());
        for (KVPair<String, Point> pair : searchResult) {
            Point existingPoint = pair.getValue();
            if (existingPoint.getXCoord() == point.getXCoord() && existingPoint
                .getYCoord() == point.getYCoord()) {
                System.out.println("Point rejected: (" + point.getName() + ", "
                    + point.getXCoord() + ", " + point.getYCoord() + ")");
                return;
            }
        }

        KVPair<String, Point> temp = new KVPair<>(point.getName(), new Point(
            point.getName(), point.getXCoord(), point.getYCoord()));
        if (point.isInvalid()) {
            System.out.println("Point rejected: (" + point.getName() + ", "
                + point.getXCoord() + ", " + point.getYCoord() + ")");
        }

        else {
            prquad.insert(point);
            list.insert(temp);
            System.out.println("Point inserted: (" + point.getName() + ", "
                + point.getXCoord() + ", " + point.getYCoord() + ")");
        }
    }


    /**
     * Performs a region search in the PRQuadTree based on the provided
     * coordinates.
     * 
     * @param x
     *            the x-coordinate of the region
     * @param y
     *            the y-coordinate of the region
     * @param w
     *            the width of the region
     * @param h
     *            the height of the region
     */
    public void regionsearch(int x, int y, int w, int h) {
        if (w > 0 && h > 0) {
            System.out.println("Points intersecting region (" + x + ", " + y
                + ", " + w + ", " + h + "):");
            int nodestotal = prquad.regionsearch(x, y, w, h);
            System.out.println(nodestotal + " quadtree nodes visited");
        }
        else {
            System.out.println("Rectangle rejected: (" + x + ", " + y + ", " + w
                + ", " + h + ")");
        }
    }


    /**
     * Prints out all the duplicate points found in the PRQuadTree.
     */
    public void duplicates() {
        System.out.println("Duplicate points:");
        prquad.duplicate();
    }


    /**
     * Removes a point from the database by its name.
     * 
     * @param name
     *            the name of the point to be removed
     */
    public void remove(String name) {
        ArrayList<KVPair<String, Point>> x = list.search(name);

        if (x.size() >= 1) {
            Point removeTemp = x.get(0).getValue();
            list.remove(name);
            prquad.removeName(removeTemp);
            System.out.println("Point removed: (" + name + ", " + removeTemp
                .getXCoord() + ", " + removeTemp.getYCoord() + ")");
        }
        else {
            System.out.println("Point not removed: " + name);
        }
    }


    /**
     * Removes a point from the database by its coordinates.
     * 
     * @param x
     *            the x-coordinate of the point to be removed
     * @param y
     *            the y-coordinate of the point to be removed
     */
    public void remove(int x, int y) {
        Point point = new Point(null, x, y);
        if (point.isInvalid()) {
            System.out.println("Point rejected: (" + point.getXCoord() + ", "
                + point.getYCoord() + ")");
        }
        else {
            KVPair<String, Point> removeTemp = list.removeByValue(new Point(x,
                y));
            if (removeTemp != null) {
                prquad.removeCoord(x, y);
                System.out.println("Point removed: (" + removeTemp.getValue()
                    .toString() + ")");

            }
            else {
                System.out.println("Point not found: (" + point.getXCoord()
                    + ", " + point.getYCoord() + ")");
            }

        }
    }


    /**
     * Searches for a point by its name in the SkipList and prints out its
     * information if found.
     * 
     * @param name
     *            the name of the point to search for
     */
    public void search(String name) {
        ArrayList<KVPair<String, Point>> searched = list.search(name);
        if (searched.size() == 0) {
            System.out.println("Point not found: " + name.toString());
        }
        else {
            for (KVPair<String, Point> pair : searched) {
                System.out.println("Point found: (" + pair.getValue().getName()
                    + ", " + pair.getValue().getXCoord() + ", " + +pair
                        .getValue().getYCoord() + ")");
            }
        }
    }


    /**
     * Dumps the contents of the SkipList.
     */
    public void dump() {
        list.dump();
        prquad.dump();
    }

}
