import student.TestCase;
import student.TestableRandom;

/**
 * This class tests the CommandProcessor class, ensuring that each possible
 * command is tested on its bounds, if applicable, to ensure they work properly.
 * Additionally, it tests passing improper commands to ensure all class
 * functionalities work as intended.
 * 
 * @author ishitagupta jayantd11
 * @version 03-01-2024
 */
public class CommandProcessorTest extends TestCase {

    private CommandProcessor commandProcessor;

    /**
     * Sets up the test environment by creating a new CommandProcessor
     * instance before each test.
     */
    public void setUp() {
        commandProcessor = new CommandProcessor();
    }


    /**
     * Tests the 'insert' command processor method.
     */
    public void testProcessorInsert() {
        String param = "insert r_r 1 20";
        commandProcessor.processor(param);
        String expectedOutput = "Point inserted: (r_r, 1, 20)\n";
        String actualOutput = systemOut().getHistory();
        assertEquals(expectedOutput, actualOutput);
        systemOut().clearHistory();
    }


    /**
     * tests the remove command processor method
     */
    public void testProcessorRemove() {
        String param = "remove r_r";
        commandProcessor.processor(param);
        String expectedOutput = "Point not removed: r_r\n" + "";
        String actualOutput = systemOut().getHistory();
        assertEquals(expectedOutput, actualOutput);
        systemOut().clearHistory();

        param = "remove 1 2";
        commandProcessor.processor(param);
        expectedOutput = "Point not found: (1, 2)\n" + "";
        actualOutput = systemOut().getHistory();
        assertEquals(expectedOutput, actualOutput);
        systemOut().clearHistory();

        param = "remove 1 2 3";
        commandProcessor.processor(param);
        expectedOutput = "";
        actualOutput = systemOut().getHistory();
        assertEquals(expectedOutput, actualOutput);
        systemOut().clearHistory();
    }


    /**
     * Tests the 'regionsearch' command processor method.
     */
    public void testProcessorRegionSearch() {
        commandProcessor.processor("insert r_r 1 20");
        commandProcessor.processor("insert rec 10 30");
        commandProcessor.processor("insert r_42 1 20");
        systemOut().clearHistory();

        commandProcessor.processor("regionsearch 0 0 25 25");
        String expectedOutput = "Points intersecting region (0, 0, 25, 25):\n"
            + "Point found: (r_r, 1, 20)\n" + "Point found: (r_42, 1, 20)\n"
            + "1 quadtree nodes visited\n";
        String actualOutput = systemOut().getHistory();
        assertEquals(expectedOutput, actualOutput);
        systemOut().clearHistory();
    }


    /**
     * Tests the 'search' command processor method.
     */
    public void testProcessorSearch() {
        commandProcessor.processor("insert r_r 1 20");
        systemOut().clearHistory();

        String param = "search r_r";
        commandProcessor.processor(param);
        assertEquals(systemOut().getHistory(), "Point found: (r_r, 1, 20)\n");
        systemOut().clearHistory();
    }


    /**
     * Tests the 'duplicates' command processor method.
     */
    public void testDuplicates() {
        commandProcessor.processor("duplicates");
        assertEquals(systemOut().getHistory(), "Duplicate points:\n");
    }


    /**
     * Tests the 'dump' command processor method.
     */
    public void testProcessorDump() {
        commandProcessor = new CommandProcessor();
        String line = "dump";
        commandProcessor.processor(line);
        String expectedOutput = "SkipList dump:\n"
            + "Node has depth 1, Value null\n" + "SkipList size is: 0\n"
            + "QuadTree dump:\n" + "Node at 0, 0, 1024: Empty\n"
            + "1 quadtree nodes printed\n" + "";
        String actualOutput = systemOut().getHistory();
        assertEquals(expectedOutput, actualOutput);
        systemOut().clearHistory();
        
    }
}
