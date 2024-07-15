import student.TestCase;

/**
 * This class tests the Point class functionalities
 * 
 * @author ishita and jayant
 * @version 2024-02-26
 */
public class PointTest extends TestCase {

    /**
     * tests the setters and getters of the point class to ensure that the data
     * comes through
     */
    public void testPointCoordinates() {
        Point point = new Point("A", 10, 20);
        assertEquals("A", point.getName());
        assertEquals(10, point.getXCoord());
        assertEquals(20, point.getYCoord());
    }


    /**
     * tests all potential possibilties of the is
     */
    public void testInvalidPoint() {
        // Test with a point having x coordinate less than 0
        Point invalidPoint1 = new Point("B", -5, 20);
        assertTrue(invalidPoint1.isInvalid());

        // Test with a point having y coordinate less than 0
        Point invalidPoint2 = new Point("B", 20, -5);
        assertTrue(invalidPoint2.isInvalid());

        // Test with a point having y coordinate greater than 1024
        Point invalidPoint3 = new Point("C", 1050, 100);
        assertTrue(invalidPoint3.isInvalid());

        // Test with a point having x coordinate greater than 1024
        Point invalidPoint4 = new Point("C", 100, 1050);
        assertTrue(invalidPoint4.isInvalid());

        // Test with a point having both x and y coordinates invalid
        Point invalidPoint5 = new Point("D", -10, -5);
        assertTrue(invalidPoint5.isInvalid());

        // Test with a valid point
        Point validPoint = new Point("E", 500, 500);
        assertFalse(validPoint.isInvalid());
    }

    /**
     * tests the equals method of the point class
     */
    public void testEquals() {
        // Test with two equal points
        Point point1 = new Point("A", 10, 20);
        Point point2 = new Point("B", 10, 20);
        assertTrue(point1.equals(point2));

        // Test with two points having different coordinates
        Point point3 = new Point("C", 30, 40);
        assertFalse(point1.equals(point3));

        // Test with two points having different coordinates
        point3 = new Point("C", 10, 40);
        assertFalse(point1.equals(point3));

        // Test with two points having the same coordinates but different names
        Point point4 = new Point("A", 10, 20);
        assertTrue(point1.equals(point4));

        // Test with the same point
        assertTrue(point1.equals(point1));

        // Test with a null object
        assertFalse(point1.equals(null));

        // Test with a different type of object
        assertFalse(point1.equals("Point"));
    }

    /**
     * tests the toString() method
     */
    public void testToString() {
        Point point1 = new Point("A", 10, 20);
        String str = point1.toString();
        assertEquals(str, "A, 10, 20");
    }

}
