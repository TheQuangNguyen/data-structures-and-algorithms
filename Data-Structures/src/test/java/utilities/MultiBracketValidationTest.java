package utilities;

import org.junit.Test;
import static utilities.MultiBracketValidation.*;
import static org.junit.Assert.*;

public class MultiBracketValidationTest {

    // test for simple two matching brackets for each type
    @Test
    public void testMatchingTwoBracketsForEachType() {
        assertTrue(multiBracketValidation("()"));
        assertTrue(multiBracketValidation("[]"));
        assertTrue(multiBracketValidation("{}"));
    }

    // Test for simple three pairs of matching brackets of each type
    @Test
    public void testMatchingBracketsThreePairsForEachTypeInOneString() {
        assertTrue(multiBracketValidation("()[]{}"));
    }

    // Test for pairs of matching brackets enclosing in one another
    @Test
    public void testMatchingBracketsEnclosingEachOther() {
        assertTrue(multiBracketValidation("([{}])"));
    }

    // Test for words in between pairs of matching brackets
    @Test
    public void testMatchingBracketsWordsInBetween() {
        assertTrue(multiBracketValidation("{}{Code}[Fellows](())"));
    }

    // Test for pairs of brackets not in correct order
    @Test
    public void testBracketPairsNotInCorrectOrder() {
        assertFalse(multiBracketValidation("[({}])"));
    }

    // Test for not matching brackets because of one bracket missing
    @Test
    public void testNotMatchingBracketsBecauseOneMissingBracket() {
        assertFalse(multiBracketValidation("[({}]"));
    }

    // Test for all left brackets
    @Test
    public void testNotMatchingBracketsAllLeftBrackets() {
        assertFalse(multiBracketValidation("([{{[(([[{"));
    }

    // Test for all right brackets
    @Test
    public void testNotMatchingBracketsAllRightBrackets() {
        assertFalse(multiBracketValidation(")]}})}])"));
    }

    // Test for no brackets
    @Test
    public void testNoBrackets() {
        assertTrue(multiBracketValidation("This should return true"));
    }
}