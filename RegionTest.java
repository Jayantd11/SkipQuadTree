import student.TestCase;

/**
 * This class tests the methods of the Region class.
 * It ensures that each method of the Region class works
 * as expected under various scenarios.
 * 
 * @author ishitagupta jayantd11
 * @version 2024-01-22
 */
public class RegionTest extends TestCase {

    private Region region;

    /**
     * Sets up the test environment by creating a new Region
     * instance before each test.
     */
    public void setUp() {
        region = new Region(0, 0, 10, 10);
    }


    /**
     * Tests the getMinX method of the Region class.
     */
    public void testGetMinX() {
        assertEquals(0, region.getMinX());
    }


    /**
     * Tests the setMinX method of the Region class.
     */
    public void testSetMinX() {
        region.setMinX(5);
        assertEquals(5, region.getMinX());
    }


    /**
     * Tests the getMinY method of the Region class.
     */
    public void testGetMinY() {
        assertEquals(0, region.getMinY());
    }


    /**
     * Tests the setMinY method of the Region class.
     */
    public void testSetMinY() {
        region.setMinY(5);
        assertEquals(5, region.getMinY());
    }


    /**
     * Tests the getMaxX method of the Region class.
     */
    public void testGetMaxX() {
        assertEquals(10, region.getMaxX());
    }


    /**
     * Tests the setMaxX method of the Region class.
     */
    public void testSetMaxX() {
        region.setMaxX(15);
        assertEquals(15, region.getMaxX());
    }


    /**
     * Tests the getMaxY method of the Region class.
     */
    public void testGetMaxY() {
        assertEquals(10, region.getMaxY());
    }


    /**
     * Tests the setMaxY method of the Region class.
     */
    public void testSetMaxY() {
        region.setMaxY(15);
        assertEquals(15, region.getMaxY());
    }


    /**
     * Tests the getSize method of the Region class.
     */
    public void testGetSize() {
        assertEquals(10, region.getSize());
    }


    /**
     * Tests the containsPointWithName method of the Region class.
     */
    public void testContainsPointWithName() {
        // Inside region
        assertTrue(region.containsPointWithName("test", 5, 5));

        // Outside region along x-axis
        assertFalse(region.containsPointWithName("test", -5, 5)); // x < minX
        assertFalse(region.containsPointWithName("test", 15, 5)); // x > maxX

        // Outside region along y-axis
        assertFalse(region.containsPointWithName("test", 5, -5)); // y < minY
        assertFalse(region.containsPointWithName("test", 5, 15)); // y > maxY

        // Outside region along both x-axis and y-axis
        assertFalse(region.containsPointWithName("test", -5, -5)); // x < minX,
                                                                   // y < minY
        assertFalse(region.containsPointWithName("test", 15, 15)); // x > maxX,
                                                                   // y > maxY
    }


    /**
     * Tests the intersectsRegion method of the Region class.
     */
    public void testIntersectsRegion() {
        Region separateRegion = new Region(15, 15, 20, 20);
        Region xOverlapRegion = new Region(5, -5, 15, 5);
        Region yOverlapRegion = new Region(-5, 5, 5, 15);
        Region cornerOverlapRegion = new Region(5, 10, 15, 20);
        Region fullOverlapRegion = new Region(0, 0, 10, 10);

        // Regions completely separate
        assertFalse(region.intersectsRegion(separateRegion));

        // Regions intersect along x-axis
        assertTrue(region.intersectsRegion(xOverlapRegion));
        assertTrue(region.intersectsRegion(new Region(-5, -5, 5, 5)));

        // Regions intersect along y-axis
        assertTrue(region.intersectsRegion(yOverlapRegion));
        assertTrue(region.intersectsRegion(new Region(5, 5, 15, 15)));

        // Regions intersect at one corner
        assertTrue(region.intersectsRegion(cornerOverlapRegion));
        assertTrue(region.intersectsRegion(new Region(10, 10, 20, 20)));

        // Regions completely overlap
        assertTrue(region.intersectsRegion(fullOverlapRegion));

        Region leftRegion = new Region(-5, -5, -1, 5);
        assertFalse(region.intersectsRegion(leftRegion));

        Region aboveRegion = new Region(5, -5, 15, -1);
        assertFalse(region.intersectsRegion(aboveRegion));
    }
}
