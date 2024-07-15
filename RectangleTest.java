
import student.TestCase;

/**
 * This class tests the methods of Rectangle class,
 * ensuring that they work as they should.
 * 
 * @author <i>
 * @version <version_no>
 */
public class RectangleTest extends TestCase {

    private Rectangle rect1;
    private Rectangle rect2;
    private Rectangle duplicateofrect1;
    private Rectangle invalidrect;

    /**
     * Initializes a rectangle object to be used for the tests.
     */
    public void setUp() {
        rect1 = new Rectangle(0, 0, 10, 10);
        rect2 = new Rectangle(5, 5, 10, 10);
        duplicateofrect1 = new Rectangle(0, 0, 10, 10);
        invalidrect = new Rectangle(-1, -1, 10, 10);
    }


    /**
     * tests x Coordinate
     */
    public void testGetxCoordinate() {
        assertEquals(0, rect1.getxCoordinate());
        assertEquals(5, rect2.getxCoordinate());
    }


    /**
     * test y Coordinate
     */
    public void testGetyCoordinate() {
        assertEquals(0, rect1.getyCoordinate());
        assertEquals(5, rect2.getyCoordinate());
    }


    /**
     * test width
     */
    public void testGetWidth() {
        assertEquals(10, rect1.getWidth());
    }


    /**
     * test height
     */
    public void testGetHeigth() {
        assertEquals(10, rect1.getHeight());
    }


    /**
     * tests the intersect method for every possibility based on the line by
     * line analysis of the intersect method
     */
    public void testIntersect() {
        Rectangle baseRect = new Rectangle(0, 0, 20, 40);

        Rectangle rect3 = new Rectangle(0, 0, 15, 5);
        Rectangle rect4 = new Rectangle(10, 10, 5, 5);
        assertFalse(rect3.intersect(rect4));

        Rectangle rect5 = new Rectangle(0, 0, 5, 15);
        Rectangle rect6 = new Rectangle(10, 10, 5, 5);
        assertFalse(rect5.intersect(rect6));

        Rectangle rect7 = new Rectangle(5, 5, 10, 10);
        Rectangle rect8 = new Rectangle(0, 0, 10, 10);
        assertTrue(rect7.intersect(rect8));

        Rectangle rect9 = new Rectangle(0, 0, 20, 20);
        Rectangle rect10 = new Rectangle(5, 5, 10, 10);
        assertTrue(rect9.intersect(rect10));

        Rectangle rect11 = new Rectangle(0, 20, 5, 5);
        Rectangle rect12 = new Rectangle(10, 10, 5, 5);
        assertFalse(rect11.intersect(rect12));

        Rectangle rect13 = new Rectangle(20, 0, 5, 5);
        Rectangle rect14 = new Rectangle(10, 10, 5, 5);
        assertFalse(rect13.intersect(rect14));

        Rectangle rect15 = new Rectangle(10, 0, 5, 5);
        Rectangle rect16 = new Rectangle(0, 0, 5, 5);
        assertFalse(rect15.intersect(rect16));

        Rectangle rect17 = new Rectangle(-20, 0, 5, 5);
        Rectangle rect18 = new Rectangle(0, 0, 5, 5);
        assertFalse(rect17.intersect(rect18));

        Rectangle rect19 = new Rectangle(0, 10, 5, 5);
        Rectangle rect20 = new Rectangle(0, 0, 5, 5);
        assertFalse(rect19.intersect(rect20));

        Rectangle rect21 = new Rectangle(0, -10, 5, 5);
        Rectangle rect22 = new Rectangle(0, 0, 5, 5);
        assertFalse(rect21.intersect(rect22));

        Rectangle rect23 = new Rectangle(10, -10, 5, 5);
        Rectangle rect24 = new Rectangle(0, 0, 5, 5);
        assertFalse(rect23.intersect(rect24));

        Rectangle rect25 = new Rectangle(0, 0, 5, 5);
        Rectangle rect26 = new Rectangle(10, 10, 5, 5);
        assertFalse(rect25.intersect(rect26));

        assertTrue(baseRect.intersect(baseRect));

        Rectangle inside = new Rectangle(10, 10, 20, 5);
        assertTrue(baseRect.intersect(inside));

        Rectangle baseRect3 = new Rectangle(0, 0, 511, 512);
        Rectangle rect27 = new Rectangle(512, 512, 512, 512);
        Rectangle rect28 = new Rectangle(400, 600, 112, 200);
        Rectangle rect29 = new Rectangle(300, 700, 400, 100);
        Rectangle rect30 = new Rectangle(512, 312, 200, 300);
        assertFalse(baseRect3.intersect(rect27));
        assertFalse(baseRect3.intersect(rect28));
        assertFalse(baseRect3.intersect(rect29));
        assertFalse(baseRect3.intersect(rect30));
        assertFalse(rect27.intersect(rect28));
        assertTrue(rect27.intersect(rect29));
        assertTrue(rect27.intersect(rect30));
        assertTrue(rect28.intersect(rect29));
        assertFalse(rect28.intersect(rect30));
        assertFalse(rect29.intersect(rect30));

        Rectangle rect31 = new Rectangle(0, 40, 20, 30);
        assertFalse(baseRect.intersect(rect31));

        Rectangle rect32 = new Rectangle(20, 0, 20, 40);
        assertFalse(baseRect.intersect(rect32));

        Rectangle rect33 = new Rectangle(20, 40, 20, 40);
        assertFalse(baseRect.intersect(rect33));

        Rectangle rect34 = new Rectangle(30, 45, 20, 20);
        assertFalse(baseRect.intersect(rect34));

    }


    /**
     * tests the equal method
     */
    public void testEquals() {
        assertFalse(rect1.equals(null));

        assertFalse(rect1.equals(new Object()));
        assertFalse(rect1.equals("Hello"));

        assertTrue(rect1.equals(rect1));

        Rectangle diffX = new Rectangle(5, 0, 10, 10);
        assertFalse(rect1.equals(diffX));

        Rectangle diffY = new Rectangle(0, 5, 10, 10);
        assertFalse(rect1.equals(diffY));

        Rectangle diffWidth = new Rectangle(0, 0, 5, 10);
        assertFalse(rect1.equals(diffWidth));

        Rectangle diffHeight = new Rectangle(0, 0, 10, 5);
        assertFalse(rect1.equals(diffHeight));

        Rectangle diffEverything = new Rectangle(100, 100, 100, 100);
        assertFalse(rect1.equals(diffEverything));

        assertTrue(rect1.equals(duplicateofrect1));

    }

    /**
     * tests the tostring method
     */
// public void testToString() {
// assertEquals("x coordinate: 0, y coordinate: 0, width: 10, height: 10",
// rect1.toString());
// }


    /**
     * tests the isinvalid method
     */
    public void testIsInvalid() {
        assertFalse(rect1.isInvalid());

        assertTrue(invalidrect.isInvalid());

        Rectangle negativeX = new Rectangle(-1, 0, 10, 10);
        assertTrue(negativeX.isInvalid());

        Rectangle negativeY = new Rectangle(0, -1, 10, 10);
        assertTrue(negativeY.isInvalid());

        Rectangle zeroWidth = new Rectangle(0, 0, 0, 10);
        assertTrue(zeroWidth.isInvalid());

        Rectangle zeroHeight = new Rectangle(0, 0, 10, 0);
        assertTrue(zeroHeight.isInvalid());

        assertTrue(new Rectangle(0, 0, -20, 40).isInvalid());
        assertTrue(new Rectangle(0, 0, 20, -40).isInvalid());

        Rectangle maxX = new Rectangle(1023, 0, 2, 2);
        assertTrue(maxX.isInvalid());

        Rectangle maxY = new Rectangle(0, 1023, 2, 2);
        assertTrue(maxY.isInvalid());

        Rectangle validRect = new Rectangle(0, 0, 10, 10);
        assertFalse(validRect.isInvalid());

        Rectangle wideRectangle1 = new Rectangle(0, 0, 1025, 40);
        assertTrue(wideRectangle1.isInvalid());

        Rectangle wideRectangle2 = new Rectangle(3, 12, 1025, 40);
        assertTrue(wideRectangle2.isInvalid());

        Rectangle wideRectangle3 = new Rectangle(1001, 0, 24, 10);
        assertTrue(wideRectangle3.isInvalid());

        Rectangle maxWideRectangle = new Rectangle(1000, 0, 24, 10);
        assertFalse(maxWideRectangle.isInvalid());

        Rectangle noWidthRectangle = new Rectangle(1001, 1000, 0, 10);
        assertTrue(noWidthRectangle.isInvalid());

        Rectangle tallRectangle1 = new Rectangle(0, 0, 20, 1026);
        assertTrue(tallRectangle1.isInvalid());

        Rectangle tallRectangle2 = new Rectangle(10, 4, 20, 1026);
        assertTrue(tallRectangle2.isInvalid());

        Rectangle tallRectangle3 = new Rectangle(0, 1000, 10, 1014);
        assertTrue(tallRectangle3.isInvalid());

        Rectangle noHeightRectangle = new Rectangle(1001, 1000, 10, 0);
        assertTrue(noHeightRectangle.isInvalid());

        Rectangle nullAreaRectangle = new Rectangle(1001, 1000, 0, 0);
        assertTrue(nullAreaRectangle.isInvalid());

        Rectangle hugeRectangle = new Rectangle(12, 12, 1025, 1025);
        assertTrue(hugeRectangle.isInvalid());

        Rectangle minRectangle = new Rectangle(0, 0, 0, 0);
        assertTrue(minRectangle.isInvalid());

        Rectangle maxValidRectangle = new Rectangle(0, 0, 1024, 1024);
        assertFalse(maxValidRectangle.isInvalid());

        Rectangle negativeCoordinateRectangle = new Rectangle(-5, -10, 15, 25);
        assertTrue(negativeCoordinateRectangle.isInvalid());

        Rectangle extremeRectangle = new Rectangle(-1, -1, -10, -15);
        assertTrue(extremeRectangle.isInvalid());

        Rectangle negativeXRectangle = new Rectangle(-1, 0, 10, 10);
        assertTrue(negativeXRectangle.isInvalid());
        Rectangle negativeYRectangle = new Rectangle(0, -1, 10, 10);
        assertTrue(negativeYRectangle.isInvalid());
        Rectangle zeroWidthRectangle = new Rectangle(10, 10, -1, 10);
        assertTrue(zeroWidthRectangle.isInvalid());
        Rectangle zeroHeightRectangle = new Rectangle(10, 10, 10, 0);
        assertTrue(zeroHeightRectangle.isInvalid());
        Rectangle overMaxXRectangle = new Rectangle(1024, 10, 10, 10);
        assertTrue(overMaxXRectangle.isInvalid());
        Rectangle overMaxYRectangle = new Rectangle(1, 1024, 10, 100);
        assertTrue(overMaxYRectangle.isInvalid());
        Rectangle zeroWidth2Rectangle = new Rectangle(10, 10, 0, 10);
        assertTrue(zeroWidth2Rectangle.isInvalid());
        Rectangle normalRectangle = new Rectangle(10, 10, 10, 10);
        assertFalse(normalRectangle.isInvalid());

    }

}
