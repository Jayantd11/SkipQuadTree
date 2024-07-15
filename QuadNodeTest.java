import student.TestCase;

/**
 * This class tests the methods of QuadNode class,
 * ensuring that they work as they should.
 * 
 * @author ishitagupta
 * @version 03-01-2024
 */
public class QuadNodeTest extends TestCase {
    private QuadNode quad1;

    /**
     * this sets up the skip list class which has string and point
     */
    public void setUp() {
        quad1 = new QuadEmptyNode();

    }


    /**
     * Tests the insertion of points into the QuadNode.
     */
    public void testInsertHelper() {
        Region region = new Region(0, 0, 1024, 1024);
        // Insert points into the leaf node
        quad1 = quad1.insertHelper(new Point("r2", 2, 30), region);
        quad1 = quad1.insertHelper(new Point("a", 5, 5), region);
        quad1 = quad1.insertHelper(new Point("b", 517, 517), region);
        quad1 = quad1.insertHelper(new Point("b1", 517, 517), region);
        quad1 = quad1.insertHelper(new Point("c", 5, 517), region);
        quad1 = quad1.insertHelper(new Point("d", 517, 1000), region);
        quad1 = quad1.insertHelper(new Point("e", 517, 51), region);
        quad1 = quad1.insertHelper(new Point("f", 200, 200), region);
        quad1 = quad1.insertHelper(new Point("g", 800, 800), region);
        quad1 = quad1.insertHelper(new Point("h", 300, 700), region);
        quad1 = quad1.insertHelper(new Point("i", 900, 100), region);
        quad1 = quad1.insertHelper(new Point("j", 600, 500), region);
        quad1 = quad1.insertHelper(new Point("k", 100, 300), region);
        quad1 = quad1.insertHelper(new Point("l", 700, 900), region);
        quad1 = quad1.insertHelper(new Point("m", 400, 600), region);
        quad1 = quad1.insertHelper(new Point("n", 200, 800), region);
        quad1 = quad1.insertHelper(new Point("o", 600, 200), region);
        quad1 = quad1.insertHelper(new Point("p", 150, 450), region);
        quad1 = quad1.insertHelper(new Point("q", 750, 750), region);
        quad1 = quad1.insertHelper(new Point("r", 250, 650), region);
        quad1 = quad1.insertHelper(new Point("s", 850, 250), region);
        quad1 = quad1.insertHelper(new Point("t", 450, 150), region);
        quad1 = quad1.insertHelper(new Point("u", 300, 550), region);
        quad1 = quad1.insertHelper(new Point("v", 900, 350), region);
        quad1 = quad1.insertHelper(new Point("w", 550, 300), region);
        quad1 = quad1.insertHelper(new Point("x", 350, 900), region);
        quad1 = quad1.insertHelper(new Point("y", 700, 700), region);
        quad1 = quad1.insertHelper(new Point("z", 450, 750), region);
        quad1 = quad1.insertHelper(new Point("aa", 250, 850), region);
        quad1 = quad1.insertHelper(new Point("bb", 850, 150), region);
        quad1 = quad1.insertHelper(new Point("cc", 150, 250), region);
        quad1 = quad1.insertHelper(new Point("dd", 550, 550), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024: Internal\r\n"
            + "  Node at 0, 0, 512: Internal\r\n"
            + "    Node at 0, 0, 256: Internal\r\n"
            + "      Node at 0, 0, 128:\r\n" + "      (r2, 2, 30)\r\n"
            + "      (a, 5, 5)\r\n" + "      Node at 128, 0, 128: Empty\r\n"
            + "      Node at 0, 128, 128: Empty\r\n"
            + "      Node at 128, 128, 128:\r\n" + "      (f, 200, 200)\r\n"
            + "      (cc, 150, 250)\r\n" + "    Node at 256, 0, 256:\r\n"
            + "    (t, 450, 150)\r\n" + "    Node at 0, 256, 256:\r\n"
            + "    (k, 100, 300)\r\n" + "    (p, 150, 450)\r\n"
            + "    Node at 256, 256, 256: Empty\r\n"
            + "  Node at 512, 0, 512: Internal\r\n"
            + "    Node at 512, 0, 256:\r\n" + "    (e, 517, 51)\r\n"
            + "    (o, 600, 200)\r\n" + "    Node at 768, 0, 256:\r\n"
            + "    (i, 900, 100)\r\n" + "    (s, 850, 250)\r\n"
            + "    (bb, 850, 150)\r\n" + "    Node at 512, 256, 256:\r\n"
            + "    (j, 600, 500)\r\n" + "    (w, 550, 300)\r\n"
            + "    Node at 768, 256, 256:\r\n" + "    (v, 900, 350)\r\n"
            + "  Node at 0, 512, 512: Internal\r\n"
            + "    Node at 0, 512, 256:\r\n" + "    (c, 5, 517)\r\n"
            + "    (r, 250, 650)\r\n"
            + "    Node at 256, 512, 256: Internal\r\n"
            + "      Node at 256, 512, 128:\r\n" + "      (u, 300, 550)\r\n"
            + "      Node at 384, 512, 128:\r\n" + "      (m, 400, 600)\r\n"
            + "      Node at 256, 640, 128:\r\n" + "      (h, 300, 700)\r\n"
            + "      Node at 384, 640, 128:\r\n" + "      (z, 450, 750)\r\n"
            + "    Node at 0, 768, 256:\r\n" + "    (n, 200, 800)\r\n"
            + "    (aa, 250, 850)\r\n" + "    Node at 256, 768, 256:\r\n"
            + "    (x, 350, 900)\r\n" + "  Node at 512, 512, 512: Internal\r\n"
            + "    Node at 512, 512, 256: Internal\r\n"
            + "      Node at 512, 512, 128:\r\n" + "      (b, 517, 517)\r\n"
            + "      (b1, 517, 517)\r\n" + "      (dd, 550, 550)\r\n"
            + "      Node at 640, 512, 128: Empty\r\n"
            + "      Node at 512, 640, 128: Empty\r\n"
            + "      Node at 640, 640, 128:\r\n" + "      (q, 750, 750)\r\n"
            + "      (y, 700, 700)\r\n" + "    Node at 768, 512, 256: Empty\r\n"
            + "    Node at 512, 768, 256:\r\n" + "    (d, 517, 1000)\r\n"
            + "    (l, 700, 900)\r\n" + "    Node at 768, 768, 256:\r\n"
            + "    (g, 800, 800)\r\n" + "", systemOut().getHistory());
        systemOut().clearHistory();
        QuadNode quad2 = new QuadEmptyNode(); // Reset quad1 to an empty node
        quad2 = quad2.insertHelper(new Point("a", 5, 5), region);
        quad2 = quad2.insertHelper(new Point("b", 5, 5), region);
        quad2 = quad2.insertHelper(new Point("c", 5, 5), region);
        quad2 = quad2.insertHelper(new Point("d", 6, 5), region);
        systemOut().clearHistory();
        quad2.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(a, 5, 5)\r\n"
            + "(b, 5, 5)\r\n" + "(c, 5, 5)\r\n" + "(d, 6, 5)\r\n" + "",
            systemOut().getHistory());
    }


    /**
     * Tests the region search functionality of the QuadNode.
     */
    public void testRegionSearchHelper() {
        // checking count
        // make quadtree and check
        Region region = new Region(0, 0, 1024, 1024);
        assertEquals(1, quad1.regionSearchHelper(0, 0, 1000000, 100000000,
            region));
        quad1 = quad1.insertHelper(new Point("a", 5, 5), region);
        assertEquals(1, quad1.regionSearchHelper(0, 0, 10, 10, region));
        systemOut().clearHistory();

        quad1 = quad1.insertHelper(new Point("b", 517, 517), region);
        assertEquals(1, quad1.regionSearchHelper(500, 500, 1000, 1000, region));
        systemOut().clearHistory();

        quad1 = quad1.insertHelper(new Point("c", 5, 517), region);
        assertEquals(1, quad1.regionSearchHelper(0, 500, 10, 1000, region));
        systemOut().clearHistory();

        quad1 = quad1.insertHelper(new Point("d", 517, 1000), region);
        assertEquals(3, quad1.regionSearchHelper(500, 800, 1000, 1024, region));
        systemOut().clearHistory();

        quad1 = quad1.insertHelper(new Point("e", 517, 51), region);
        quad1 = quad1.insertHelper(new Point("f", 5, 6), region);
        quad1 = quad1.insertHelper(new Point("g", 123, 517), region);
        quad1 = quad1.insertHelper(new Point("h", 265, 517), region);
        quad1 = quad1.insertHelper(new Point("i", 782, 1000), region);
        quad1 = quad1.insertHelper(new Point("j", 1000, 51), region);
        quad1 = quad1.insertHelper(new Point("k", 1111, 5), region);
        quad1 = quad1.insertHelper(new Point("l", 515, 123), region);
        quad1 = quad1.insertHelper(new Point("m", 500, 517), region);
        quad1 = quad1.insertHelper(new Point("n", 890, 1000), region);
        quad1 = quad1.insertHelper(new Point("o", 912, 951), region);
        assertEquals(2, quad1.regionSearchHelper(0, 0, 6, 6, region));
        String expectedOutput = "Point found: (a, 5, 5)\r\n"
            + "Point found: (f, 5, 6)\n";
        String acutalOutput = systemOut().getHistory();
        assertEquals(expectedOutput, acutalOutput);
        systemOut().clearHistory();
        assertEquals(13, quad1.regionSearchHelper(0, 0, 1024, 1024, region));
        assertEquals(7, quad1.regionSearchHelper(512, 512, 0, 0, region));
        assertEquals(8, quad1.regionSearchHelper(0, 0, 512, 512, region));
        assertEquals(11, quad1.regionSearchHelper(512, 512, 700, 700, region));
        assertEquals(13, quad1.regionSearchHelper(0, 0, 1024, 1024, region));
        assertEquals(5, quad1.regionSearchHelper(512, 51, 778, 129, region));
        assertEquals(8, quad1.regionSearchHelper(0, 0, 512, 512, region));
        assertEquals(11, quad1.regionSearchHelper(512, 512, 700, 700, region));
        assertEquals(1, quad1.regionSearchHelper(2000, 2000, 100, 100, region));
        assertEquals(2, quad1.regionSearchHelper(200, 200, 100, 100, region));
        System.out.print("HELLO\n");
        int totaln = quad1.regionSearchHelper(512, 512, 700, 700, region);

        System.out.print(totaln + "\n");

        systemOut().clearHistory();
        quad1 = new QuadEmptyNode();

    }


    /**
     * Tests the duplicate detection functionality of the QuadNode.
     */
    /**
     * Tests the duplicate detection functionality of the QuadNode.
     */
    public void testDuplicateHelper() {
        Region region = new Region(0, 0, 1024, 1024);
        // no points
        quad1.duplicateHelper();
        assertEquals("", systemOut().getHistory());
        systemOut().clearHistory();

        // one point
        quad1 = quad1.insertHelper(new Point("a", 5, 5), region);
        quad1.duplicateHelper();
        assertEquals("", systemOut().getHistory());
        systemOut().clearHistory();

        // two unique points
        quad1 = quad1.insertHelper(new Point("c", 65, 5), region);
        quad1.duplicateHelper();
        assertEquals("", systemOut().getHistory());
        systemOut().clearHistory();

        // two duplicate points
        quad1 = quad1.insertHelper(new Point("d", 5, 5), region);
        quad1.duplicateHelper();
        assertEquals("(5, 5)\n", systemOut().getHistory());
        systemOut().clearHistory();

        quad1 = quad1.insertHelper(new Point("a", 75, 65), region);
        quad1.duplicateHelper();
        assertEquals("(5, 5)\n", systemOut().getHistory());
        systemOut().clearHistory();

        quad1 = quad1.insertHelper(new Point("e", 5, 65), region);
        quad1.duplicateHelper();
        assertEquals("(5, 5)\n", systemOut().getHistory());
        systemOut().clearHistory();

        quad1 = quad1.insertHelper(new Point("b", 5, 5), region);
        quad1 = quad1.insertHelper(new Point("e", 5, 65), region);
        quad1.duplicateHelper();
        assertEquals("(5, 5)\r\n" + "(5, 65)\n", systemOut().getHistory());
        systemOut().clearHistory();

        QuadNode quad2 = new QuadEmptyNode(); // Reset quad1 to an empty node
        quad2 = quad2.insertHelper(new Point("a", 5, 5), region);
        quad2 = quad2.insertHelper(new Point("b", 5, 10), region);
        quad2.duplicateHelper();
        assertEquals("", systemOut().getHistory());
        systemOut().clearHistory();

        quad2 = new QuadEmptyNode();
        quad2 = quad2.insertHelper(new Point("a", 5, 5), region);
        quad2 = quad2.insertHelper(new Point("b", 5, 5), region);
        quad2 = quad2.insertHelper(new Point("c", 5, 6), region);
        quad2 = quad2.insertHelper(new Point("d", 6, 5), region);
        quad2 = quad2.insertHelper(new Point("e", 6, 6), region);
        quad2.duplicateHelper();
        assertEquals("(5, 5)\r\n" + "", systemOut().getHistory());
        systemOut().clearHistory();

    }


    /**
     * this tests the dump method
     */
    public void testDump() {
        Region region = new Region(0, 0, 1024, 1024);

        quad1 = quad1.insertHelper(new Point("r_r", 1, 20), region);
        quad1 = quad1.insertHelper(new Point("rec", 10, 30), region);
        quad1 = quad1.insertHelper(new Point("r_42", 1, 20), region);
        quad1 = quad1.insertHelper(new Point("far", 200, 200), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024: Internal\r\n"
            + "  Node at 0, 0, 512: Internal\r\n"
            + "    Node at 0, 0, 256: Internal\r\n"
            + "      Node at 0, 0, 128:\r\n" + "      (r_r, 1, 20)\r\n"
            + "      (rec, 10, 30)\r\n" + "      (r_42, 1, 20)\r\n"
            + "      Node at 128, 0, 128: Empty\r\n"
            + "      Node at 0, 128, 128: Empty\r\n"
            + "      Node at 128, 128, 128:\r\n" + "      (far, 200, 200)\r\n"
            + "    Node at 256, 0, 256: Empty\r\n"
            + "    Node at 0, 256, 256: Empty\r\n"
            + "    Node at 256, 256, 256: Empty\r\n"
            + "  Node at 512, 0, 512: Empty\r\n"
            + "  Node at 0, 512, 512: Empty\r\n"
            + "  Node at 512, 512, 512: Empty\n", systemOut().getHistory());
    }


    /**
     * Tests the removal of points from the PR QuadTree based on their names.
     * It inserts points into the QuadTree, removes them by name, and checks if
     * the removal was successful.
     */
    public void testRemoveName() {
        Region region = new Region(0, 0, 1024, 1024);

        // Test removing a point from an empty tree
        quad1 = new QuadEmptyNode();
        quad1 = quad1.removeNameHelper(new Point("empty", 0, 2), region);
        assertTrue(quad1 instanceof QuadEmptyNode);

        // Test removing a non-existent point from a tree with existing points
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("r1", 1, 20), region);
        quad1 = quad1.insertHelper(new Point("r2", 2, 30), region);
        quad1 = quad1.removeNameHelper(new Point("r1", 17, 20), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(r1, 1, 20)\r\n"
            + "(r2, 2, 30)\r\n" + "", systemOut().getHistory());
        systemOut().clearHistory();

        // Test removing points from a tree with multiple points
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("r1", 126, 1023), region);
        quad1 = quad1.insertHelper(new Point("a1", 400, 1023), region);
        quad1 = quad1.insertHelper(new Point("a2", 126, 700), region);
        quad1 = quad1.insertHelper(new Point("a3", 400, 700), region);
        quad1 = quad1.insertHelper(new Point("r2", 600, 700), region);
        quad1 = quad1.insertHelper(new Point("r3", 23, 100), region);
        quad1 = quad1.insertHelper(new Point("r4", 700, 100), region);
        quad1 = quad1.removeNameHelper(new Point("r3", 23, 100), region);
        quad1 = quad1.removeNameHelper(new Point("a3", 400, 700), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024: Internal\r\n"
            + "  Node at 0, 0, 512: Empty\r\n" + "  Node at 512, 0, 512:\r\n"
            + "  (r4, 700, 100)\r\n" + "  Node at 0, 512, 512:\r\n"
            + "  (a2, 126, 700)\r\n" + "  (r1, 126, 1023)\r\n"
            + "  (a1, 400, 1023)\r\n" + "  Node at 512, 512, 512:\r\n"
            + "  (r2, 600, 700)\r\n" + "", systemOut().getHistory());
        systemOut().clearHistory();

        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("r1", 1023, 126), region);
        quad1 = quad1.insertHelper(new Point("a1", 1023, 400), region);
        quad1 = quad1.insertHelper(new Point("a2", 700, 126), region);
        quad1 = quad1.insertHelper(new Point("a3", 700, 400), region);
        quad1 = quad1.insertHelper(new Point("r2", 700, 600), region);
        quad1 = quad1.insertHelper(new Point("r3", 100, 23), region);
        quad1 = quad1.insertHelper(new Point("r4", 100, 700), region);
        quad1 = quad1.removeNameHelper(new Point("r3", 100, 23), region);
        quad1 = quad1.removeNameHelper(new Point("a3", 700, 400), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024: Internal\r\n"
            + "  Node at 0, 0, 512: Empty\r\n" + "  Node at 512, 0, 512:\r\n"
            + "  (a2, 700, 126)\r\n" + "  (r1, 1023, 126)\r\n"
            + "  (a1, 1023, 400)\r\n" + "  Node at 0, 512, 512:\r\n"
            + "  (r4, 100, 700)\r\n" + "  Node at 512, 512, 512:\r\n"
            + "  (r2, 700, 600)\r\n" + "", systemOut().getHistory());
        systemOut().clearHistory();

        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("r1", 1023, 1023), region);
        quad1 = quad1.insertHelper(new Point("a1", 1022, 1023), region);
        quad1 = quad1.insertHelper(new Point("a2", 750, 700), region);
        quad1 = quad1.insertHelper(new Point("a3", 770, 700), region);
        quad1 = quad1.insertHelper(new Point("r2", 780, 700), region);
        quad1 = quad1.insertHelper(new Point("r3", 100, 100), region);
        quad1 = quad1.insertHelper(new Point("r4", 103, 100), region);
        quad1 = quad1.removeNameHelper(new Point("r3", 100, 100), region);
        quad1 = quad1.removeNameHelper(new Point("a2", 750, 700), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024: Internal\r\n"
            + "  Node at 0, 0, 512:\r\n" + "  (r4, 103, 100)\r\n"
            + "  Node at 512, 0, 512: Empty\r\n"
            + "  Node at 0, 512, 512: Empty\r\n"
            + "  Node at 512, 512, 512: Internal\r\n"
            + "    Node at 512, 512, 256: Empty\r\n"
            + "    Node at 768, 512, 256:\r\n" + "    (a3, 770, 700)\r\n"
            + "    (r2, 780, 700)\r\n" + "    Node at 512, 768, 256: Empty\r\n"
            + "    Node at 768, 768, 256:\r\n" + "    (r1, 1023, 1023)\r\n"
            + "    (a1, 1022, 1023)\r\n" + "", systemOut().getHistory());
        systemOut().clearHistory();

        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("r1", 126, 126), region);
        quad1 = quad1.insertHelper(new Point("a1", 450, 400), region);
        quad1 = quad1.insertHelper(new Point("a2", 120, 126), region);
        quad1 = quad1.insertHelper(new Point("a3", 470, 400), region);
        quad1 = quad1.insertHelper(new Point("r2", 600, 600), region);
        quad1 = quad1.insertHelper(new Point("r3", 23, 23), region);
        quad1 = quad1.insertHelper(new Point("r4", 100, 100), region);
        quad1 = quad1.removeNameHelper(new Point("r3", 23, 23), region);
        quad1 = quad1.removeNameHelper(new Point("a3", 470, 400), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024: Internal\r\n"
            + "  Node at 0, 0, 512: Internal\r\n" + "    Node at 0, 0, 256:\r\n"
            + "    (r1, 126, 126)\r\n" + "    (a2, 120, 126)\r\n"
            + "    (r4, 100, 100)\r\n" + "    Node at 256, 0, 256: Empty\r\n"
            + "    Node at 0, 256, 256: Empty\r\n"
            + "    Node at 256, 256, 256:\r\n" + "    (a1, 450, 400)\r\n"
            + "  Node at 512, 0, 512: Empty\r\n"
            + "  Node at 0, 512, 512: Empty\r\n"
            + "  Node at 512, 512, 512:\r\n" + "  (r2, 600, 600)\r\n" + "",
            systemOut().getHistory());
        systemOut().clearHistory();

        // Test removing points from different quadrants
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("r1", 100, 100), region);
        quad1 = quad1.insertHelper(new Point("r2", 500, 100), region);
        quad1 = quad1.insertHelper(new Point("r3", 100, 500), region);
        quad1 = quad1.insertHelper(new Point("r4", 500, 500), region);
        quad1 = quad1.removeNameHelper(new Point("r1", 100, 100), region);
        quad1 = quad1.removeNameHelper(new Point("r4", 500, 500), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(r2, 500, 100)\r\n"
            + "(r3, 100, 500)\r\n" + "", systemOut().getHistory());
        systemOut().clearHistory();

        // Test when at least three quadrants are empty
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("r1", 100, 100), region);
        quad1 = quad1.insertHelper(new Point("r2", 500, 100), region);
        quad1 = quad1.insertHelper(new Point("r3", 100, 500), region);
        quad1 = quad1.insertHelper(new Point("r4", 500, 500), region);
        quad1 = quad1.removeNameHelper(new Point("r1", 100, 100), region);
        quad1 = quad1.removeNameHelper(new Point("r2", 500, 100), region);
        quad1 = quad1.removeNameHelper(new Point("r3", 100, 500), region);
        quad1 = quad1.removeNameHelper(new Point("r4", 500, 500), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024: Empty\r\n" + "", systemOut()
            .getHistory());
        systemOut().clearHistory();

        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("nw1", 100, 100), region);
        quad1 = quad1.insertHelper(new Point("se1", 500, 500), region);
        quad1 = quad1.insertHelper(new Point("se1", 200, 400), region);
        quad1 = quad1.insertHelper(new Point("se1", 400, 600), region);
        quad1 = quad1.removeNameHelper(new Point("se1", 500, 500), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(nw1, 100, 100)\r\n"
            + "(se1, 200, 400)\r\n" + "(se1, 400, 600)\r\n" + "", systemOut()
                .getHistory());
        systemOut().clearHistory();

        // Test when only the NW quadrant has three points and others are empty
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("ne1", 200, 900), region);
        quad1 = quad1.insertHelper(new Point("ne2", 100, 901), region);
        quad1 = quad1.insertHelper(new Point("ne3", 150, 902), region);
        quad1 = quad1.insertHelper(new Point("ne1", 400, 1000), region);
        quad1 = quad1.removeNameHelper(new Point("ne1", 200, 900), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(ne2, 100, 901)\r\n"
            + "(ne3, 150, 902)\r\n" + "(ne1, 400, 1000)\r\n" + "", systemOut()
                .getHistory());
        systemOut().clearHistory();

        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("ne1", 200, 900), region);
        quad1 = quad1.insertHelper(new Point("ne2", 100, 901), region);
        quad1 = quad1.insertHelper(new Point("ne3", 150, 902), region);
        quad1 = quad1.insertHelper(new Point("ne1", 400, 1000), region);
        quad1 = quad1.removeNameHelper(new Point("ne1", 200, 800), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024: Internal\r\n"
            + "  Node at 0, 0, 512: Empty\r\n"
            + "  Node at 512, 0, 512: Empty\r\n"
            + "  Node at 0, 512, 512: Internal\r\n"
            + "    Node at 0, 512, 256: Empty\r\n"
            + "    Node at 256, 512, 256: Empty\r\n"
            + "    Node at 0, 768, 256:\r\n" + "    (ne1, 200, 900)\r\n"
            + "    (ne2, 100, 901)\r\n" + "    (ne3, 150, 902)\r\n"
            + "    Node at 256, 768, 256:\r\n" + "    (ne1, 400, 1000)\r\n"
            + "  Node at 512, 512, 512: Empty\r\n" + "", systemOut()
                .getHistory());
        systemOut().clearHistory();

        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("ne1", 200, 900), region);
        quad1 = quad1.insertHelper(new Point("ne2", 100, 901), region);
        quad1 = quad1.insertHelper(new Point("ne3", 150, 902), region);
        quad1 = quad1.insertHelper(new Point("ne1", 400, 1000), region);
        quad1 = quad1.removeNameHelper(new Point("ne1", 200, 900), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(ne2, 100, 901)\r\n"
            + "(ne3, 150, 902)\r\n" + "(ne1, 400, 1000)\r\n" + "", systemOut()
                .getHistory());
        systemOut().clearHistory();

        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("ne1", 900, 200), region);
        quad1 = quad1.insertHelper(new Point("ne2", 900, 101), region);
        quad1 = quad1.insertHelper(new Point("ne3", 950, 102), region);
        quad1 = quad1.insertHelper(new Point("ne1", 1000, 400), region);
        quad1 = quad1.removeNameHelper(new Point("ne2", 900, 101), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(ne1, 900, 200)\r\n"
            + "(ne3, 950, 102)\r\n" + "(ne1, 1000, 400)\r\n" + "", systemOut()
                .getHistory());
        systemOut().clearHistory();

        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("ne1", 1000, 1000), region);
        quad1 = quad1.insertHelper(new Point("ne2", 1000, 1001), region);
        quad1 = quad1.insertHelper(new Point("ne3", 1001, 102), region);
        quad1 = quad1.insertHelper(new Point("ne1", 1000, 100), region);
        quad1 = quad1.removeNameHelper(new Point("ne3", 1001, 102), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(ne1, 1000, 100)\r\n"
            + "(ne1, 1000, 1000)\r\n" + "(ne2, 1000, 1001)\r\n" + "",
            systemOut().getHistory());
        systemOut().clearHistory();

        // Insert points into the QuadInternalNode
        quad1 = quad1.insertHelper(new Point("ne1", 200, 200), region);
        quad1 = quad1.insertHelper(new Point("ne2", 100, 100), region);
        quad1 = quad1.insertHelper(new Point("ne3", 150, 150), region);
        quad1 = quad1.insertHelper(new Point("ne4", 400, 400), region);
        quad1 = quad1.insertHelper(new Point("ne5", 1000, 1000), region);
        quad1 = quad1.removeNameHelper(new Point("ne3", 150, 150), region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024: Internal\r\n"
            + "  Node at 0, 0, 512:\r\n" + "  (ne1, 200, 200)\r\n"
            + "  (ne2, 100, 100)\r\n" + "  (ne4, 400, 400)\r\n"
            + "  Node at 512, 0, 512:\r\n" + "  (ne1, 1000, 100)\r\n"
            + "  Node at 0, 512, 512: Empty\r\n"
            + "  Node at 512, 512, 512:\r\n" + "  (ne1, 1000, 1000)\r\n"
            + "  (ne2, 1000, 1001)\r\n" + "  (ne5, 1000, 1000)\r\n" + "",
            systemOut().getHistory());
        systemOut().clearHistory();
    }


    /**
     * Tests the removal of points from the PR QuadTree based on their
     * coordinates.
     * It inserts points into the QuadTree, removes them by coordinates, and
     * checks if
     * the removal was successful.
     */
    public void testRemoveCoordinates() {
        Region region = new Region(0, 0, 1024, 1024);

        // Test removing a point from an empty tree
        quad1 = new QuadEmptyNode();
        quad1 = quad1.removeCoordHelper(0, 2, region);
        assertTrue(quad1 instanceof QuadEmptyNode);

        // Test removing a non-existent point from a tree with existing points
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("r1", 1, 20), region);
        quad1 = quad1.insertHelper(new Point("r2", 2, 30), region);
        quad1 = quad1.removeCoordHelper(17, 20, region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(r1, 1, 20)\r\n"
            + "(r2, 2, 30)\r\n" + "", systemOut().getHistory());
        systemOut().clearHistory();

        // Test removing points from a tree with multiple points
        // SW
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("r1", 126, 1023), region);
        quad1 = quad1.insertHelper(new Point("a1", 400, 1023), region);
        quad1 = quad1.insertHelper(new Point("a2", 126, 700), region);
        quad1 = quad1.insertHelper(new Point("a3", 400, 700), region);
        quad1 = quad1.insertHelper(new Point("r2", 600, 700), region);
        quad1 = quad1.insertHelper(new Point("r3", 23, 100), region);
        quad1 = quad1.insertHelper(new Point("r4", 700, 100), region);
        quad1 = quad1.removeCoordHelper(23, 100, region);
        quad1 = quad1.removeCoordHelper(400, 700, region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024: Internal\r\n"
            + "  Node at 0, 0, 512: Empty\r\n" + "  Node at 512, 0, 512:\r\n"
            + "  (r4, 700, 100)\r\n" + "  Node at 0, 512, 512:\r\n"
            + "  (a2, 126, 700)\r\n" + "  (r1, 126, 1023)\r\n"
            + "  (a1, 400, 1023)\r\n" + "  Node at 512, 512, 512:\r\n"
            + "  (r2, 600, 700)\r\n" + "", systemOut().getHistory());
        systemOut().clearHistory();
        // NE
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("r1", 1023, 126), region);
        quad1 = quad1.insertHelper(new Point("a1", 1023, 400), region);
        quad1 = quad1.insertHelper(new Point("a2", 700, 126), region);
        quad1 = quad1.insertHelper(new Point("a3", 700, 400), region);
        quad1 = quad1.insertHelper(new Point("r2", 700, 600), region);
        quad1 = quad1.insertHelper(new Point("r3", 100, 23), region);
        quad1 = quad1.insertHelper(new Point("r4", 100, 700), region);
        quad1 = quad1.removeCoordHelper(100, 23, region);
        quad1 = quad1.removeCoordHelper(700, 400, region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024: Internal\r\n"
            + "  Node at 0, 0, 512: Empty\r\n" + "  Node at 512, 0, 512:\r\n"
            + "  (a2, 700, 126)\r\n" + "  (r1, 1023, 126)\r\n"
            + "  (a1, 1023, 400)\r\n" + "  Node at 0, 512, 512:\r\n"
            + "  (r4, 100, 700)\r\n" + "  Node at 512, 512, 512:\r\n"
            + "  (r2, 700, 600)\r\n" + "", systemOut().getHistory());
        systemOut().clearHistory();

        // SE
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("r1", 1023, 1023), region);
        quad1 = quad1.insertHelper(new Point("a1", 1022, 1023), region);
        quad1 = quad1.insertHelper(new Point("a2", 750, 700), region);
        quad1 = quad1.insertHelper(new Point("a3", 770, 700), region);
        quad1 = quad1.insertHelper(new Point("r2", 780, 700), region);
        quad1 = quad1.insertHelper(new Point("r3", 100, 100), region);
        quad1 = quad1.insertHelper(new Point("r4", 103, 100), region);
        quad1 = quad1.removeCoordHelper(100, 100, region);
        quad1 = quad1.removeCoordHelper(750, 700, region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024: Internal\r\n"
            + "  Node at 0, 0, 512:\r\n" + "  (r4, 103, 100)\r\n"
            + "  Node at 512, 0, 512: Empty\r\n"
            + "  Node at 0, 512, 512: Empty\r\n"
            + "  Node at 512, 512, 512: Internal\r\n"
            + "    Node at 512, 512, 256: Empty\r\n"
            + "    Node at 768, 512, 256:\r\n" + "    (a3, 770, 700)\r\n"
            + "    (r2, 780, 700)\r\n" + "    Node at 512, 768, 256: Empty\r\n"
            + "    Node at 768, 768, 256:\r\n" + "    (r1, 1023, 1023)\r\n"
            + "    (a1, 1022, 1023)\r\n" + "", systemOut().getHistory());
        systemOut().clearHistory();

        // NW
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("r1", 126, 126), region);
        quad1 = quad1.insertHelper(new Point("a1", 450, 400), region);
        quad1 = quad1.insertHelper(new Point("a2", 120, 126), region);
        quad1 = quad1.insertHelper(new Point("a3", 470, 400), region);
        quad1 = quad1.insertHelper(new Point("r2", 600, 600), region);
        quad1 = quad1.insertHelper(new Point("r3", 23, 23), region);
        quad1 = quad1.insertHelper(new Point("r4", 100, 100), region);
        quad1 = quad1.removeCoordHelper(100, 100, region);
        quad1 = quad1.removeCoordHelper(470, 400, region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024: Internal\r\n"
            + "  Node at 0, 0, 512: Internal\r\n" + "    Node at 0, 0, 256:\r\n"
            + "    (r3, 23, 23)\r\n" + "    (r1, 126, 126)\r\n"
            + "    (a2, 120, 126)\r\n" + "    Node at 256, 0, 256: Empty\r\n"
            + "    Node at 0, 256, 256: Empty\r\n"
            + "    Node at 256, 256, 256:\r\n" + "    (a1, 450, 400)\r\n"
            + "  Node at 512, 0, 512: Empty\r\n"
            + "  Node at 0, 512, 512: Empty\r\n"
            + "  Node at 512, 512, 512:\r\n" + "  (r2, 600, 600)\r\n" + "",
            systemOut().getHistory());
        systemOut().clearHistory();

        // Test removing points from different quadrants
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("r1", 100, 100), region);
        quad1 = quad1.insertHelper(new Point("r2", 500, 100), region);
        quad1 = quad1.insertHelper(new Point("r3", 100, 500), region);
        quad1 = quad1.insertHelper(new Point("r4", 500, 500), region);
        quad1 = quad1.removeCoordHelper(100, 100, region);
        quad1 = quad1.removeCoordHelper(500, 500, region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(r2, 500, 100)\r\n"
            + "(r3, 100, 500)\r\n" + "", systemOut().getHistory());
        systemOut().clearHistory();

        // Test when at least three quadrants are empty
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("r1", 100, 100), region);
        quad1 = quad1.insertHelper(new Point("r2", 500, 100), region);
        quad1 = quad1.insertHelper(new Point("r3", 100, 500), region);
        quad1 = quad1.insertHelper(new Point("r4", 500, 500), region);
        quad1 = quad1.removeCoordHelper(100, 100, region);
        quad1 = quad1.removeCoordHelper(500, 100, region);
        quad1 = quad1.removeCoordHelper(100, 500, region);
        quad1 = quad1.removeCoordHelper(500, 500, region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024: Empty\r\n" + "", systemOut()
            .getHistory());
        systemOut().clearHistory();

        // Test removing a point from the SE quadrant
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("nw1", 100, 100), region);
        quad1 = quad1.insertHelper(new Point("se1", 500, 500), region);
        quad1 = quad1.insertHelper(new Point("se1", 700, 550), region);
        quad1 = quad1.insertHelper(new Point("se1", 500, 600), region);
        quad1 = quad1.removeCoordHelper(500, 500, region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(nw1, 100, 100)\r\n"
            + "(se1, 500, 600)\r\n" + "(se1, 700, 550)\r\n" + "", systemOut()
                .getHistory());
        systemOut().clearHistory();

        // Test when only the NW quadrant has three points and others are empty
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("nw1", 1000, 1200), region);
        quad1 = quad1.insertHelper(new Point("nw2", 1200, 800), region);
        quad1 = quad1.insertHelper(new Point("nw3", 800, 1200), region);
        quad1 = quad1.insertHelper(new Point("sw1", 1000, 750), region);
        quad1 = quad1.removeCoordHelper(1000, 1200, region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(sw1, 1000, 750)\r\n"
            + "(nw2, 1200, 800)\r\n" + "(nw3, 800, 1200)\r\n" + "", systemOut()
                .getHistory());
        systemOut().clearHistory();

        // Test removing a point from the NE quadrant
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("ne1", 200, 900), region);
        quad1 = quad1.insertHelper(new Point("ne2", 100, 901), region);
        quad1 = quad1.insertHelper(new Point("ne3", 150, 902), region);
        quad1 = quad1.insertHelper(new Point("ne1", 400, 1000), region);
        quad1 = quad1.removeCoordHelper(200, 900, region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(ne2, 100, 901)\r\n"
            + "(ne3, 150, 902)\r\n" + "(ne1, 400, 1000)\r\n" + "", systemOut()
                .getHistory());
        systemOut().clearHistory();

        // Test removing a point from the NW quadrant
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("nw1", 1000, 1200), region);
        quad1 = quad1.insertHelper(new Point("nw2", 1200, 800), region);
        quad1 = quad1.insertHelper(new Point("nw3", 800, 1200), region);
        quad1 = quad1.insertHelper(new Point("sw1", 1000, 750), region);
        quad1 = quad1.removeCoordHelper(1000, 1200, region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(sw1, 1000, 750)\r\n"
            + "(nw2, 1200, 800)\r\n" + "(nw3, 800, 1200)\r\n" + "", systemOut()
                .getHistory());
        systemOut().clearHistory();

        // Test removing points using coordinates instead of names
        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("ne1", 200, 900), region);
        quad1 = quad1.insertHelper(new Point("ne2", 100, 901), region);
        quad1 = quad1.insertHelper(new Point("ne3", 150, 902), region);
        quad1 = quad1.insertHelper(new Point("ne1", 400, 1000), region);
        quad1 = quad1.removeCoordHelper(200, 900, region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(ne2, 100, 901)\r\n"
            + "(ne3, 150, 902)\r\n" + "(ne1, 400, 1000)\r\n" + "", systemOut()
                .getHistory());
        systemOut().clearHistory();

        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("ne1", 900, 200), region);
        quad1 = quad1.insertHelper(new Point("ne2", 900, 101), region);
        quad1 = quad1.insertHelper(new Point("ne3", 950, 102), region);
        quad1 = quad1.insertHelper(new Point("ne1", 1000, 400), region);
        quad1 = quad1.removeCoordHelper(900, 101, region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(ne1, 900, 200)\r\n"
            + "(ne3, 950, 102)\r\n" + "(ne1, 1000, 400)\r\n" + "", systemOut()
                .getHistory());
        systemOut().clearHistory();

        quad1 = new QuadEmptyNode();
        quad1 = quad1.insertHelper(new Point("ne1", 1000, 1000), region);
        quad1 = quad1.insertHelper(new Point("ne2", 1000, 1001), region);
        quad1 = quad1.insertHelper(new Point("ne3", 1001, 102), region);
        quad1 = quad1.insertHelper(new Point("ne1", 1000, 100), region);
        quad1 = quad1.removeCoordHelper(1001, 102, region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024:\r\n" + "(ne1, 1000, 100)\r\n"
            + "(ne1, 1000, 1000)\r\n" + "(ne2, 1000, 1001)\r\n" + "",
            systemOut().getHistory());
        systemOut().clearHistory();

        // Insert points into the QuadInternalNode
        quad1 = quad1.insertHelper(new Point("ne1", 200, 200), region);
        quad1 = quad1.insertHelper(new Point("ne2", 100, 100), region);
        quad1 = quad1.insertHelper(new Point("ne3", 150, 150), region);
        quad1 = quad1.insertHelper(new Point("ne4", 400, 400), region);
        quad1 = quad1.insertHelper(new Point("ne5", 1000, 1000), region);
        quad1 = quad1.removeCoordHelper(150, 150, region);
        quad1.dumpHelper(0, region);
        assertEquals("Node at 0, 0, 1024: Internal\r\n"
            + "  Node at 0, 0, 512:\r\n" + "  (ne1, 200, 200)\r\n"
            + "  (ne2, 100, 100)\r\n" + "  (ne4, 400, 400)\r\n"
            + "  Node at 512, 0, 512:\r\n" + "  (ne1, 1000, 100)\r\n"
            + "  Node at 0, 512, 512: Empty\r\n"
            + "  Node at 512, 512, 512:\r\n" + "  (ne1, 1000, 1000)\r\n"
            + "  (ne2, 1000, 1001)\r\n" + "  (ne5, 1000, 1000)\r\n" + "",
            systemOut().getHistory());
        systemOut().clearHistory();
    }

}
