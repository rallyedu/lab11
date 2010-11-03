package net.rallyedu.regex;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import static net.rallyedu.regex.StringLiteralRegexes.SINGLE;
import static net.rallyedu.regex.StringLiteralRegexes.MULTIPLE;

@Test
public class StringLiteralRegexesTest {

    public void singleShouldMatchExactCharacter() {
        assertTrue("a".matches(SINGLE));
    }

    public void singleShouldNotMatchDifferentCharacter() {
        assertFalse("b".matches(SINGLE));
    }

    public void singleShouldNotMatchMultipleCharacters() {
        assertFalse("aa".matches(SINGLE));
    }

    public void multipleShouldMatchExactCharacters() {
        assertTrue("foo".matches(MULTIPLE));
    }

    public void multipleShouldNotMatchDifferentCharacters() {
        assertFalse("bar".matches(MULTIPLE));
    }

}
