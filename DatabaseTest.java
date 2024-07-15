import student.TestCase;

/**
 * This class tests the Database class functionalities
 * 
 * @author ishita and jayant
 * @version 2024-02-16
 */
public class DatabaseTest extends TestCase {

    // private field declared
    private Database data;

    /**
     * Sets up the test case.
     */
    public void setUp() {
        data = new Database();
    }


    /**
     * this method tests insertion of rectangles into the database.
     */
    public void testInsert() {
        // invalid point
        data.insert(new Point("r_r", -1, -20));
        assertEquals(systemOut().getHistory(),
            "Point rejected: (r_r, -1, -20)\r\n" + "");
        systemOut().clearHistory();

        // insert quad and list
        data.insert(new Point("r_r", 1, 20));
        assertEquals(systemOut().getHistory(),
            "Point inserted: (r_r, 1, 20)\r\n" + "");
        systemOut().clearHistory();

        data.insert(new Point("r_r", 1, 20));
        assertEquals(systemOut().getHistory(),
            "Point rejected: (r_r, 1, 20)\r\n" + "");
        systemOut().clearHistory();

        data.insert(new Point("r_r", 2, 34));
        assertEquals(systemOut().getHistory(),
            "Point inserted: (r_r, 2, 34)\r\n" + "");
        systemOut().clearHistory();

        data.insert(new Point("r_r", 1, 34));
        assertEquals(systemOut().getHistory(),
            "Point inserted: (r_r, 1, 34)\r\n" + "");

    }


    /**
     * this method tests region search functionality of the database.
     */
    public void testRegionSearch() {

        data.insert(new Point("r_r", 1, 20));
        data.insert(new Point("rec", 10, 30));
        data.insert(new Point("r_42", 1, 20));
        data.insert(new Point("far", 200, 200));

        // data.insert(new Point("far", 200, 200));
        systemOut().clearHistory();

        data.regionsearch(0, 0, -1, 25);
        assertEquals(systemOut().getHistory(),
            "Rectangle rejected: (0, 0, -1, 25)\n");
        systemOut().clearHistory();

        data.regionsearch(0, 0, 25, -1);
        assertEquals(systemOut().getHistory(),
            "Rectangle rejected: (0, 0, 25, -1)\n");
        systemOut().clearHistory();

        data.regionsearch(0, 0, -1, -1);
        assertEquals(systemOut().getHistory(),
            "Rectangle rejected: (0, 0, -1, -1)\n");
        systemOut().clearHistory();

        data.regionsearch(0, 0, 25, 25);
        assertEquals(systemOut().getHistory(),
            "Points intersecting region (0, 0, 25, 25):\r\n"
                + "Point found: (r_r, 1, 20)\r\n"
                + "Point found: (r_42, 1, 20)\r\n"
                + "4 quadtree nodes visited\n");
        systemOut().clearHistory();

    }


    /**
     * this method is responsible for testing duplicates
     */
    public void testDuplicates() {
        data.insert(new Point("r_r", 1, 20));
        data.insert(new Point("rec", 10, 30));
        data.insert(new Point("r_7r", 1, 20));
        data.insert(new Point("r3ec", 10, 30));

        systemOut().clearHistory();

        data.duplicates();
        assertEquals(systemOut().getHistory(), "Duplicate points:\n"
            + "(1, 20)\n" + "(10, 30)\n");
    }


    /**
     * this method tests searching functionality of the database.
     */
    public void testSearch() {
        data.insert(new Point("r_r", 1, 20));
        systemOut().clearHistory();

        data.search("r_r");
        assertEquals(systemOut().getHistory(), "Point found: (r_r, 1, 20)\n");
        systemOut().clearHistory();

        data.search("a");
        assertEquals(systemOut().getHistory(), "Point not found: a\n");
        systemOut().clearHistory();

    }


    /**
     * tests the remove method for the name
     */
    public void testRemoveName() {
        data.insert(new Point("r_r", 1, 20));
        data.insert(new Point("r0", 1, 20));
        data.insert(new Point("r1", 2, 20));
        systemOut().clearHistory();

        data.remove("r_r");
        assertEquals(systemOut().getHistory(), "Point removed: (r_r, 1, 20)\n");
        systemOut().clearHistory();

        data.remove("r4");
        assertEquals(systemOut().getHistory(), "Point not removed: r4\n");
        systemOut().clearHistory();

        data.remove("r0");
        assertEquals(systemOut().getHistory(), "Point removed: (r0, 1, 20)\n");
        systemOut().clearHistory();

    }


    /**
     * testing the removed method for a coordinate pair
     */
    public void testRemovecoord() {
        data.insert(new Point("r_r", 1, 20));
        data.insert(new Point("rec", 10, 30));
        data.insert(new Point("r_42", 1, 20));
        data.insert(new Point("far", 200, 200));
        systemOut().clearHistory();
        data.remove(1, 20);
        assertEquals(systemOut().getHistory(),
            "Point removed: (r_42, 1, 20)\r\n");
        systemOut().clearHistory();
        data.remove(1, 20);
        assertEquals(systemOut().getHistory(),
            "Point removed: (r_r, 1, 20)\r\n");
        systemOut().clearHistory();
        data.remove(1, 20);
        assertEquals(systemOut().getHistory(), "Point not found: (1, 20)\r\n");
        systemOut().clearHistory();
        data.remove(1, -20);
        assertEquals(systemOut().getHistory(), "Point rejected: (1, -20)\r\n");
    }


    /**
     * this method tests the dump functionality of the database.
     */
    public void testDump() {
        data.dump();
        assertEquals(systemOut().getHistory(), "SkipList dump:\r\n"
            + "Node has depth 1, Value null\r\n" + "SkipList size is: 0\r\n"
            + "QuadTree dump:\r\n" + "Node at 0, 0, 1024: Empty\r\n"
            + "1 quadtree nodes printed\r\n" + "");

    }

}
