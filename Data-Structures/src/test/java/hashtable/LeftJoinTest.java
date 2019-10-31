package hashtable;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;
import static hashtable.LeftJoin.*;

public class LeftJoinTest {

    HashMap<String, String> synonym;
    HashMap<String, String> antonym;

    @Before
    public void setUp() throws Exception {
        synonym = new HashMap<>();
        antonym = new HashMap<>();
    }

    // test for normal case where some keys in synonym table are found in antonym and some keys are not found in antonym
    @Test
    public void testLeftJoinKeysInSynonymBothExistAndNotExistInAntonym() {
        synonym.put("fond", "enamored");
        synonym.put("wrath", "anger");
        synonym.put("diligent", "employed");
        synonym.put("outfit", "garb");
        synonym.put("guide", "usher");

        antonym.put("fond", "averse");
        antonym.put("wrath", "delight");
        antonym.put("diligent", "idle");
        antonym.put("guide", "follow");
        antonym.put("flow", "jam");

        String[][] result = leftJoin(synonym, antonym);
        String[][] expected = new String[][]{   {"diligent", "employed", "idle"},
                                                {"outfit", "garb", null},
                                                {"wrath", "anger", "delight"},
                                                {"guide", "usher", "follow"},
                                                {"fond", "enamored", "averse"}  };

        assertArrayEquals(expected, result);
    }

    // test if antonym do not have any keys that match synonym
    // should just return keys and values of synonym along with null for every keys
    @Test
    public void testLeftJoinWhenAntonymDoNotHaveAnyKeysMatchWithSynonym() {
        synonym.put("fond", "enamored");
        synonym.put("wrath", "anger");
        synonym.put("diligent", "employed");
        synonym.put("outfit", "garb");
        synonym.put("guide", "usher");

        antonym.put("love", "hate");

        String[][] result = leftJoin(synonym, antonym);
        String[][] expected = new String[][]{   {"diligent", "employed", null},
                                                {"outfit", "garb", null},
                                                {"wrath", "anger", null},
                                                {"guide", "usher", null},
                                                {"fond", "enamored", null}  };
        assertArrayEquals(expected, result);
    }

    // test when antonym have all keys match with synonym
    @Test
    public void testLeftJoinWhenAntonymHaveAllKeysMatchWithSynonym() {
        synonym.put("fond", "enamored");
        synonym.put("wrath", "anger");
        synonym.put("diligent", "employed");
        synonym.put("guide", "usher");

        antonym.put("fond", "averse");
        antonym.put("wrath", "delight");
        antonym.put("diligent", "idle");
        antonym.put("guide", "follow");

        String[][] result = leftJoin(synonym, antonym);
        String[][] expected = new String[][]{   {"diligent", "employed", "idle"},
                                                {"wrath", "anger", "delight"},
                                                {"guide", "usher", "follow"},
                                                {"fond", "enamored", "averse"}  };

        assertArrayEquals(expected, result);
    }

    // test when synonym has only one keys while antonym has many keys
    @Test
    public void testLeftJoinWhenSynonymHasOneEntryWhileAntonymHasMany() {
        synonym.put("fond", "enamored");

        antonym.put("fond", "averse");
        antonym.put("wrath", "delight");
        antonym.put("diligent", "idle");
        antonym.put("guide", "follow");

        String[][] result = leftJoin(synonym, antonym);
        String[][] expected = new String[][]{   {"fond", "enamored", "averse"}  };

        assertArrayEquals(expected, result);
    }

    // test when both synonym and antonym are empty
    @Test
    public void testLeftJoinWhenBothHashMapAreEmpty() {
        String[][] result = leftJoin(synonym, antonym);
        String[][] expected = new String[][]{};

        assertArrayEquals(expected, result);
    }

}