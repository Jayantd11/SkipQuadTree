import java.util.Iterator;
import java.util.ArrayList;

import org.junit.Test;

import student.TestCase;
import student.TestableRandom;

/**
 * This class tests the methods of SkipList class
 * 
 * @author CS Staff
 * 
 * @version 2024-01-22
 */

public class SkipListTest extends TestCase {

    private SkipList<String, Rectangle> sl;
    private SkipList<Integer, String> sl2;

    /**
     * this sets up the sl object of the SkipList
     */
    public void setUp() {
        sl = new SkipList<String, Rectangle>();
        sl2 = new SkipList<Integer, String>();
    }


    /***
     * Example 1: Test `randomLevel` method with
     * predetermined random values using `TestableRandom`
     */
    public void testRandomLevelOne() {
        TestableRandom.setNextBooleans(false);
        sl = new SkipList<String, Rectangle>();
        int randomLevelValue = sl.randomLevel();

        // This returns 1 because the first preset
        // random boolean is `false` which breaks
        // the `while condition inside the `randomLevel` method
        int expectedLevelValue = 1;

        // Compare the values
        assertEquals(expectedLevelValue, randomLevelValue);
    }


    /***
     * Example 2: Test `randomLevel` method with
     * predetermined random values using `TestableRandom`
     */
    public void testRandomLevelFour() {
        TestableRandom.setNextBooleans(true, true, true, false, true, false);
        sl = new SkipList<String, Rectangle>();
        int randomLevelValue = sl.randomLevel();

        // This returns 4 because the fourth preset
        // random boolean is `false` which breaks
        // the `while condition inside the `randomLevel` method
        int expectedLevelValue = 4;

        // Compare the values
        assertEquals(expectedLevelValue, randomLevelValue);
    }


    /**
     * tests the search method from skiplist
     */
    public void testSearch() {
        sl2.insert(new KVPair<Integer, String>(1, "a"));
        sl2.insert(new KVPair<Integer, String>(2, "b"));
        sl2.insert(new KVPair<Integer, String>(3, "c"));
        sl2.insert(new KVPair<Integer, String>(4, "d"));
        sl2.insert(new KVPair<Integer, String>(4, "d2"));
        sl2.insert(new KVPair<Integer, String>(5, "e"));

        ArrayList<KVPair<Integer, String>> testArray = new ArrayList<>();
        KVPair<Integer, String> num1 = new KVPair<Integer, String>(4, "d2");
        KVPair<Integer, String> num2 = new KVPair<Integer, String>(4, "d");
        testArray.add(num1);
        testArray.add(num2);

        assertEquals(num1.getValue(), sl2.search(4).get(0).getValue());
        assertEquals(num2.getValue(), sl2.search(4).get(1).getValue());

        assertEquals(true, sl2.search(15).isEmpty());
        assertEquals(0, sl2.search(10).size());

        sl2.insert(new KVPair<Integer, String>(6, "f"));
        assertEquals(1, sl2.search(6).size());

        sl2.insert(new KVPair<Integer, String>(6, "f2"));
        assertEquals(2, sl2.search(6).size());

        assertEquals(true, sl2.search(100).isEmpty());
        assertEquals(true, sl2.search(0).isEmpty());

        SkipList<Integer, String> emptySkipList = new SkipList<>();
        assertEquals(true, emptySkipList.search(10).isEmpty());
    }


    /**
     * tests the insert method and by extension the adjust head method
     */
    public void testInsert() {
        assertEquals(0, sl2.size());
        sl2.insert(new KVPair<Integer, String>(4, "3"));
        sl2.insert(new KVPair<Integer, String>(1, "1"));
        sl2.insert(new KVPair<Integer, String>(8, "5"));
        sl2.insert(new KVPair<Integer, String>(6, "4"));
        sl2.insert(new KVPair<Integer, String>(2, "2"));
        sl2.insert(new KVPair<Integer, String>(9, "6"));
        assertEquals(sl2.size(), 6);

        Iterator<KVPair<Integer, String>> slIter = sl2.iterator();
        assertEquals(slIter.next().getValue(), "1");
        assertEquals(slIter.next().getValue(), "2");
        assertEquals(slIter.next().getValue(), "3");
        assertEquals(slIter.next().getValue(), "4");
        assertEquals(slIter.next().getValue(), "5");
        assertEquals(slIter.next().getValue(), "6");
    }


    /**
     * tests the remove by key from the skiplist
     */
    public void testRemovebykey() {
        assertEquals(sl.size(), 0);

        sl2.insert(new KVPair<Integer, String>(4, "b"));
        sl2.insert(new KVPair<Integer, String>(4, "a"));
        sl2.insert(new KVPair<Integer, String>(1, "c"));
        sl2.insert(new KVPair<Integer, String>(8, "d"));
        sl2.insert(new KVPair<Integer, String>(6, "e"));
        sl2.insert(new KVPair<Integer, String>(2, "f"));
        sl2.insert(new KVPair<Integer, String>(9, "g"));
        sl2.insert(new KVPair<Integer, String>(123, null));

        assertEquals(sl2.size(), 8);

        assertEquals("a", sl2.remove(4).getValue());
        assertEquals("g", sl2.remove(9).getValue());
        assertEquals("c", sl2.remove(1).getValue());
        assertEquals(sl2.size(), 5);

        assertEquals(null, sl2.remove(1));
        assertEquals(sl2.size(), 5);
        assertNull(sl2.remove(10));
        assertNull(sl2.helperRemove(10));

        assertNotNull(sl2.helperRemove(2));

        assertFalse("sl2.remove(10)", false);
        assertNull(sl2.remove(1212));
        assertNull(sl2.remove(1));
// assertEquals(4, sl2.size());
//
// SkipList<Integer, String> emptySkipList = new SkipList<>();
// assertNull(emptySkipList.remove(1));
    }


    /**
     * tests remove by value
     */
    public void testRemoveByValue() {
        assertEquals(sl2.size(), 0);
        sl2.insert(new KVPair<Integer, String>(4, "1"));
        sl2.insert(new KVPair<Integer, String>(4, "2"));
        sl2.insert(new KVPair<Integer, String>(1, "3"));
        sl2.insert(new KVPair<Integer, String>(8, "4"));
        sl2.insert(new KVPair<Integer, String>(6, "1"));
        sl2.insert(new KVPair<Integer, String>(2, "5"));
        sl2.insert(new KVPair<Integer, String>(9, "6"));
        assertEquals(sl2.size(), 7);
        assertEquals(4, (int)sl2.removeByValue("1").getKey());
        assertEquals(9, (int)sl2.removeByValue("6").getKey());
        assertEquals(1, (int)sl2.removeByValue("3").getKey());
        assertEquals(sl2.size(), 4);
        assertEquals(null, sl2.removeByValue("3"));
        assertEquals(sl2.size(), 4);
        assertNull(sl2.removeKV(4, "454"));

        Iterator<KVPair<Integer, String>> skipListIter = sl2.iterator();
        assertEquals(skipListIter.next().getValue(), "5");
        assertEquals(skipListIter.next().getValue(), "2");
        assertEquals(skipListIter.next().getValue(), "1");
        assertEquals(skipListIter.next().getValue(), "4");
        assertFalse("sl2.removeKV(10)", false);
    }


    /**
     * test dump
     */
    public void testDump() {
        TestableRandom.setNextInts(1, 2, 2, 2, 2, 1, 2, 3, 5, 7, 8, 8, 8, 9);
        sl2.dump();
        assertFuzzyEquals(systemOut().getHistory(), "SkipList dump:\r\n"
            + "  Node has depth 1, Value null \r\n" + "  SkipList size is: 0");
        systemOut().clearHistory();
        sl2.insert(new KVPair<Integer, String>(4, "rose"));
        sl2.dump();
        systemOut().clearHistory();

    }


    /**
     * tests has next
     */
    public void testHasNext() {
        sl2.insert(new KVPair<>(1, "One"));
        sl2.insert(new KVPair<>(2, "Two"));
        sl2.insert(new KVPair<>(3, "Three"));

        Iterator<KVPair<Integer, String>> skipListIter = sl2.iterator();
        assertTrue(skipListIter.hasNext());

        SkipList<Integer, String> sl2Empty = new SkipList<>();
        Iterator<KVPair<Integer, String>> empty = sl2Empty.iterator();
        assertFalse(empty.hasNext());
    }

}
