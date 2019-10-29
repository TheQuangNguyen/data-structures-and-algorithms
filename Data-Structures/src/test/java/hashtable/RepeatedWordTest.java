package hashtable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static hashtable.RepeatedWord.*;

public class RepeatedWordTest {

    // Test for a string that has one repeated word
    @Test
    public void testFirstRepeatedWordForStringThatHasSingleRepeatedWord() {
        String testString = "Once upon a time, there was a brave princess who...";
        String repeatedWord = repeatedWord(testString);

        assertEquals("a", repeatedWord);
    }

    // test for a long string that has multiple repeated words
    @Test
    public void testFirstRepeatedWordForStringThatHasMultipleRepeatedWord() {
        String testString = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way – in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only...";
        String repeatedWord = repeatedWord(testString);

        assertEquals("it", repeatedWord);
    }

    // test for a string that has no repeated word
    @Test
    public void testRepeatedWordForStringThatHasNoRepeatedWord() {
        String testString = "Gentlemen, you can't fight in here. This is the war room.";

        assertNull(repeatedWord(testString));
    }

    // test for string that has repeated words like don't or can't since there are special characters in between the word.
    @Test
    public void testRepeatedWordForStringThatHasRepeatedWordsContainingApostrophe() {
        String testString = "If you don't mean it, then don't say it";
        String repeatedWord = repeatedWord(testString);

        assertEquals("don't", repeatedWord);
    }
    // test for empty string
    @Test
    public void testRepeatedWordForEmptyString() {
        String testString = "";
        assertNull(repeatedWord(testString));
    }

    // test for string that has multiple special characters next to each other
    @Test
    public void testRepeatedWordForStringThatHasRepeatedWordsAndMultipleSpecialCharactersAdjacent() {
        String testString = "one two three?!?!? Testing, testing!!!! ";
        String repeatedWord = repeatedWord(testString);

        assertEquals("testing", repeatedWord);
    }
}