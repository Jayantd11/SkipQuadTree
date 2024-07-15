import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import student.TestableRandom;

/**
 * This class implements SkipList data structure and contains an inner SkipNode
 * class which the SkipList will make an array of to store data.
 * 
 * @author CS Staff
 * 
 * @version 2024-01-22
 * @param <K>
 *            Key
 * @param <V>
 *            Value
 */
public class SkipList<K extends Comparable<? super K>, V>
    implements Iterable<KVPair<K, V>> {
    private SkipNode head; // First element (Sentinel Node)
    private int size; // number of entries in the Skip List
    private Random rng;
    private int lvl;
    private Iterator<KVPair<K, V>> itr1;

    /**
     * Initializes the fields head, size and level
     */
    public SkipList() {
        head = new SkipNode(null, 0);
        size = 0;
        this.rng = new TestableRandom();
        lvl = -1;
    }


    /**
     * returns a random level using geometric distribtuion, minimum of 1
     * 
     * @return an integer of a random level
     */
    public int randomLevel() {
        int level = 1;
        while (rng.nextBoolean())
            level++;
        return level;
    }


    /**
     * Searches for the KVPair using the key which is a Comparable object.
     * 
     * @param key
     *            key to be searched for
     * @return the key of the search ArrayList
     */
    public ArrayList<KVPair<K, V>> search(K key) {
        ArrayList<KVPair<K, V>> result = new ArrayList<>();
        SkipNode x = head; // Dummy header node
        for (int i = lvl; i >= 0; i--) {
            // For each level...
            while ((x.forward[i] != null) && (x.forward[i].element().getKey()
                .compareTo(key) < 0))
            // go forward
            {
                x = x.forward[i]; // Go one last step
            }
        }
        x = x.forward[0]; // Move to actual record, if it exists
        if ((x != null) && (x.element().getKey().compareTo(key) == 0)) {
            result.add(x.element()); // Got it
            // Traverse horizontally to find all nodes with the same key
            while (x.forward[0] != null && x.forward[0].element().getKey()
                .compareTo(key) == 0) {
                x = x.forward[0]; // Go one step forward
                result.add(x.element());
            }
        }
        return result; // if not any pair it will return an empty list
    }


    /**
     * @return the size of the SkipList
     */
    public int size() {
        return size;
    }


    /**
     * Inserts the KVPair in the SkipList at its appropriate spot as designated
     * by its lexicoragraphical order.
     * 
     * @param it
     *            the KVPair to be inserted
     */
    @SuppressWarnings("unchecked")
    public void insert(KVPair<K, V> it) {
        int newLevel = randomLevel(); // New node's level
        if (newLevel > lvl) { // If new node is deeper
            adjustHead(newLevel); // adjust the header
        }
        // Track end of level
        SkipNode[] update = (SkipNode[])Array.newInstance(SkipNode.class, lvl
            + 1);

        SkipNode x = head; // Start at header node
        for (int i = lvl; i >= 0; i--) { // Find insert position
            while ((x.forward[i] != null) && (x.forward[i].element().getKey()
                .compareTo(it.getKey()) < 0)) {
                x = x.forward[i];
            }
            update[i] = x; // Track end at level i
        }
        x = new SkipNode(it, newLevel);
        for (int i = 0; i <= newLevel; i++) { // Splice into list
            x.forward[i] = update[i].forward[i]; // Who x points to
            update[i].forward[i] = x; // Who points to x
        }
        size++; // Increment dictionary size
    }


    /**
     * Increases the number of levels in head so that no element has more
     * indices than the head.
     * 
     * @param newLevel
     *            the number of levels to be added to head
     */
    public void adjustHead(int newLevel) {
        SkipNode temp = head;
        head = new SkipNode(null, newLevel);
        for (int i = 0; i <= lvl; i++) {
            head.forward[i] = temp.forward[i];
        }
        lvl = newLevel;
    }


    /**
     * Removes the KVPair that is passed in as a parameter and returns true if
     * the pair was valid and false if not.
     * 
     * @param key
     *            the KVPair to be removed
     * @return returns the removed pair if the pair was valid and null if not
     */

    @SuppressWarnings("unchecked")
    public KVPair<K, V> helperRemove(K key) {
        SkipNode[] update = (SkipNode[])Array.newInstance(SkipNode.class, lvl
            + 1);
        SkipNode x = head;

        // Find the node with the given key or the predecessor of that node
        for (int i = lvl; i >= 0; i--) {
            while (x.forward[i] != null && x.forward[i].pair.getKey().compareTo(
                key) < 0) {
                x = x.forward[i];
            }
            update[i] = x;
        }

        x = x.forward[0];
        if (x != null && x.element().getKey().equals(key)) {
            // Remove the node from each level
            for (int i = 0; i <= lvl; i++) {
                if (update[i].forward[i] != x) {
                    break;
                }
                update[i].forward[i] = x.forward[i];
            }
            size--; // Decrement the size of the skip list
            return x.element(); // Return the removed key-value pair
        }
        else {
            return null; // Key not found
        }
    }


    /**
     * 
     * @param key
     *            this is the value that the key of the pair
     * @return the key of the kvpair that is being removed
     */
    public KVPair<K, V> remove(K key) {
        itr1 = iterator();
        while (itr1.hasNext()) {
            KVPair<K, V> pair1 = itr1.next();
            if (pair1.getKey().equals(key)) {
                return helperRemove(pair1.getKey());
            }
        }
        return null;

    }


    /**
     * this is the skiplist remove by key and value
     * 
     * @param key
     *            key being remobed
     * @param val
     *            value being removed
     * @return the key value pair that was removed
     */
    public KVPair<K, V> removeKV(K key, V val) {
        @SuppressWarnings("unchecked")
        SkipNode[] update = (SkipNode[])Array.newInstance(SkipNode.class, lvl
            + 1);
        SkipNode x = head;
        // Find the node with the given key or the predecessor of that node
        for (int i = lvl; i >= 0; i--) {
            while (x.forward[i] != null && x.forward[i].pair.getKey().compareTo(
                key) <= 0 && !(x.forward[i].pair.getValue().equals(val))) {
                x = x.forward[i];
            }
            update[i] = x;
        }

        x = x.forward[0];
        if (x != null && x.element().getKey().equals(key) && x.element()
            .getValue().equals(val)) {
            // Remove the node from each level
            for (int i = 0; i <= lvl; i++) {
                if (update[i].forward[i] != x) {
                    break;
                }
                update[i].forward[i] = x.forward[i];
            }
            size--; // Decrement the size of the skip list
            return x.element(); // Return the removed key-value pair
        }
        return null;

    }


    /**
     * Removes a KVPair with the specified value.
     * 
     * @param val
     *            the value of the KVPair to be removed
     * @return returns true if the removal was successful
     */
    public KVPair<K, V> removeByValue(V val) {

        // Step 1: iterate through entire skiplist (level 0) and find KVPair to
        // be removed
        // Step 2: generate update array based on standard skiplist traversal
        // taking into account
        // key and value to be removed instead of just key
        // Step 3: update all pointers using updates
        itr1 = iterator();
        while (itr1.hasNext()) {
            KVPair<K, V> pair1 = itr1.next();
            if (pair1.getValue().equals(val)) {
                return removeKV(pair1.getKey(), pair1.getValue());
            }
        }
        return null;

    }


    /**
     * Prints out the SkipList in a human readable format to the console.
     */
    public void dump() {
        if (size == 0) {
            System.out.println("SkipList dump:");
            System.out.println("Node has depth 1, Value null");
            System.out.println("SkipList size is: 0");
            return;
        }
        System.out.println("SkipList dump:");
        SkipNode x = head;
        System.out.println("Node has depth " + x.forward.length
            + ", value null");
        x = x.forward[0];
        while (x != null) {
            System.out.println("Node has depth " + x.forward.length
                + ", value (" + x.element().getValue().toString() + ")");
            x = x.forward[0];
        }
        System.out.println("SkipList size is: " + size);
    }

    /**
     * This class implements a SkipNode for the SkipList data structure.
     * 
     * @author CS Staff
     * 
     * @version 2016-01-30
     */
    private class SkipNode {

        // the KVPair to hold
        private KVPair<K, V> pair;
        // An array of pointers to subsequent nodes
        private SkipNode[] forward;
        // the level of the node
        private int level;

        /**
         * Initializes the fields with the required KVPair and the number of
         * levels from the random level method in the SkipList.
         * 
         * @param tempPair
         *            the KVPair to be inserted
         * @param level
         *            the number of levels that the SkipNode should have
         */
        @SuppressWarnings("unchecked")
        public SkipNode(KVPair<K, V> tempPair, int level) {
            pair = tempPair;
            forward = (SkipNode[])Array.newInstance(SkipList.SkipNode.class,
                level + 1);
            this.level = level;
        }


        /**
         * Returns the KVPair stored in the SkipList.
         * 
         * @return the KVPair
         */
        public KVPair<K, V> element() {
            return pair;
        }

    }


    private class SkipListIterator implements Iterator<KVPair<K, V>> {
        private SkipNode current;

        public SkipListIterator() {
            current = head;
        }


        @Override
        public boolean hasNext() {
            // Auto-generated method stub
            return current.forward[0] != null;
        }


        @Override
        public KVPair<K, V> next() {
            // Auto-generated method stub
            KVPair<K, V> elem = current.forward[0].element();
            current = current.forward[0];
            return elem;
        }

    }

    @Override
    public Iterator<KVPair<K, V>> iterator() {
        // Auto-generated method stub
        return new SkipListIterator();
    }

}
