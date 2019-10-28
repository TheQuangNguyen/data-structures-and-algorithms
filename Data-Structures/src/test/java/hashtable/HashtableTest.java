package hashtable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashtableTest {

    Hashtable<Integer, String> hashtable;

    @Before
    public void setUp() throws Exception {
        hashtable = new Hashtable<>();
    }

    // test if we can successfully add an entry to the hash table
    @Test
    public void testAddingEntryToHashTable() {
        assertTrue(hashtable.add(10, "ten"));
    }

    // test that we cannot add if there is already the same key in the hash table
    @Test
    public void testAddingEntryWithDuplicateKeyToHashTable() {
        hashtable.add(10, "ten");
        assertFalse(hashtable.add(10, "10"));
    }

    // test that we can check for an entry that already exists for a hashtable that has only one entry
    @Test
    public void testContainsTrueForHashTableThatHasOneEntry() {
        hashtable.add(5, "five");
        assertTrue(hashtable.contains(5));
    }

    // test that we can check for an entry that does not exist yet for a hashtable that has only one entry
    @Test
    public void testContainsFalseForHashTableThatHasOneEntry() {
        hashtable.add(5, "five");
        assertFalse(hashtable.contains(15));
    }

    // test that we can get the value from an entry given a key for a hashtable that has only one entry
    @Test
    public void testGetValueGivenKeyForHashTableThatHasOneEntry() {
        hashtable.add(1, "one");
        assertEquals("one", hashtable.get(1));
    }

    // test that given two keys have the same hashcode, they will added onto the same linked list in the hashtable
    // since the initial capacity of hashtable is 5, if we add 6 entries, we are guaranteed that one linked list in hashtable will contains at least 2 entries
    @Test
    public void testCollisionsWhenTwoKeysHaveSameHashCodeInHashTable() {
        hashtable.add(0, "zero");
        hashtable.add(1, "one");
        hashtable.add(2, "two");
        hashtable.add(3, "three");
        hashtable.add(4, "four");
        hashtable.add(5, "five");



    }
}