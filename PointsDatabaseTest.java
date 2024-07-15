import student.TestCase;


/**
 * This class tests the PointsDatabase class, ensuring that the main method
 * correctly processes command files, handles invalid files, and prints
 * appropriate error messages.
 * 
 * @author ishitagupta
 * @version 03-16-2024
 */
public class PointsDatabaseTest extends TestCase {

    /**
     * Sets up the test environment by creating a new PointsDatabase
     * instance before each test.
     */
    public void setUp() {
    }


    /**
     * Tests the main method of PointsDatabase.
     */
    public void testMain() {
        // Test valid command file
        String[] args = { "solutionTestData/duplicate_test.txt" };
        PointsDatabase.main(args);
        assertEquals("Point inserted: (A, 1, 1)\r\n"
            + "Point inserted: (B, 2, 2)\r\n" + "Point rejected: (A, 1, 1)\r\n"
            + "Point inserted: (C, 2, 2)\r\n" + "Point rejected: (A, 1, 1)\r\n"
            + "Point rejected: (B, 2, 2)\r\n"
            + "Points intersecting region (0, 0, 15, 15):\r\n"
            + "Point found: (A, 1, 1)\r\n" + "Point found: (B, 2, 2)\r\n"
            + "Point found: (C, 2, 2)\r\n" + "1 quadtree nodes visited\r\n"
            + "", systemOut().getHistory());
        systemOut().clearHistory();

        // Test invalid file
        String[] argsNotFound = { "non_existent_file.txt" };
        PointsDatabase.main(argsNotFound);
        assertEquals("Invalid file\n", systemOut().getHistory());
        systemOut().clearHistory();

        // Test exception
        String[] argsException = {};
        PointsDatabase.main(argsException);
        assertEquals("Invalid file. No filename in command line arguments\n",
            systemOut().getHistory());
    }
}
