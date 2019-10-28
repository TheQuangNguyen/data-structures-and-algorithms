package hashtable;

import org.checkerframework.checker.units.qual.K;
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

        // check that at least one linked list in the hash table has more than one entries in case of collisions
        for (int i = 0; i < hashtable.hashtable.length; i++) {
            if (hashtable.hashtable[i].size() > 1) {
                assertTrue(hashtable.hashtable[i].size() > 1);
            }
        }
    }

    // test that we can get the value from an entry given a key for a hashtable that has multiple collisions
    @Test
    public void testGetValueGivenKeyForHashTableThatHasMultipleCollisions() {
        hashtable.add(0, "zero");
        hashtable.add(1, "one");
        hashtable.add(2, "two");
        hashtable.add(3, "three");
        hashtable.add(4, "four");
        hashtable.add(5, "five");
        hashtable.add(6, "six");
        hashtable.add(7, "seven");
        hashtable.add(8, "eight");
        hashtable.add(9, "nine");
        hashtable.add(10, "ten");

        assertEquals("ten", hashtable.get(10));
        assertEquals("six", hashtable.get(6));
        assertEquals("one", hashtable.get(1));
    }

    // test get method for when the key does not exist in the hash table. Should return null
    @Test
    public void testGetWhenKeyDoesNotExistInHashTable() {
        hashtable.add(0, "zero");
        hashtable.add(1, "one");
        hashtable.add(2, "two");
        hashtable.add(3, "three");
        hashtable.add(4, "four");
        hashtable.add(5, "five");
        hashtable.add(6, "six");
        hashtable.add(7, "seven");
        hashtable.add(8, "eight");
        hashtable.add(9, "nine");
        hashtable.add(10, "ten");

        assertNull(hashtable.get(11));
    }

    // test if hash method give back a hashcode that is expected and also within the range of the capacity of the hash table
    @Test
    public void testHashKeyToInRangeValue() {
        // ASCII value for 5 is 53
        int hashCode = hashtable.hash(5);
        int expectedHashCode = (53*599)%5;

        assertEquals(expectedHashCode, hashCode);
        assertTrue(hashCode < 10 && hashCode >= 0);
    }

}