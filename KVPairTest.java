
import student.TestCase;

/**
 * This class tests the KVPair class so that the member methods work properly
 * and that the expected behavior occurs.
 * 
 * @author CS Staff
 * 
 * @version 2024.1
 */
public class KVPairTest extends TestCase {

    private KVPair<String, Integer> kv;

    /**
     * initializes a KVPair using the KVPair class
     */
    public void setUp() {
        kv = new KVPair<>("key", 10);

    }


    /**
     * tests the getKey method from KVPair
     */
    public void testGetKey() {
        assertEquals("key", kv.getKey());
    }


    /**
     * tests the getValue method from KVPair
     */
    public void testGetValue() {
        assertEquals(10, kv.getValue().intValue());
    }


    /**
     * tests the toString method form KVPair
     */
    public void testToString() {
        assertEquals("(key, 10)", kv.toString());
    }

}
