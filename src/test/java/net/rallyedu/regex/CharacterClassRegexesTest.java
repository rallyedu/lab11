package net.rallyedu.regex;

import org.testng.annotations.Test;

import static java.lang.String.valueOf;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import static net.rallyedu.regex.CharacterClassRegexes.SIMPLE;
import static net.rallyedu.regex.CharacterClassRegexes.NEGATION;
import static net.rallyedu.regex.CharacterClassRegexes.RANGE;

@Test
public class CharacterClassRegexesTest {

    public void simpleShouldMatchSpecifiedCharacters() {
        for(char letter = 'x'; letter <= 'z'; letter++) {
            assertTrue(valueOf(letter).matches(SIMPLE));
        }
    }

    public void simpleShouldNotMatchUnspecifiedCharacters() {
        for(char letter = 'a'; letter <= 'w'; letter++) {
            assertFalse(valueOf(letter).matches(SIMPLE));
        }
    }

    public void negationShouldContainCaratCharacter() {
        assertTrue(NEGATION.contains("^"));
    }

    public void negationShouldMatchUnspecifiedCharacters() {
        for(char letter = 'd'; letter <= 'z'; letter++) {
            assertTrue(valueOf(letter).matches(NEGATION));
        }
    }

    public void negationShouldNotMatchSpecifiedCharacters() {
        for(char letter = 'a'; letter <= 'c'; letter++) {
            assertFalse(valueOf(letter).matches(NEGATION));
        }
    }
    
    public void rangeShouldContainDashCharacter() {
        assertTrue(RANGE.contains("-"));
    }

    public void rangeShouldMatchSpecifiedCharacters() {
        for(char letter = 'a'; letter <= 'm'; letter++) {
            assertTrue(valueOf(letter).matches(RANGE));
        }
    }

    public void rangeShouldNotMatchUnspecifiedCharacters() {
        for(char letter = 'n'; letter <= 'z'; letter++) {
            assertFalse(valueOf(letter).matches(RANGE));
        }
    }

}
