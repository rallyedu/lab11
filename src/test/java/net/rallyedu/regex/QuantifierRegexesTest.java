package net.rallyedu.regex;

import org.testng.annotations.Test;

import static net.rallyedu.regex.RegexUtils.findGroups;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import static net.rallyedu.regex.QuantifierRegexes.QUESTION_MARK;
import static net.rallyedu.regex.QuantifierRegexes.ASTERISK;
import static net.rallyedu.regex.QuantifierRegexes.PLUS;
import static net.rallyedu.regex.QuantifierRegexes.COUNT;
import static net.rallyedu.regex.QuantifierRegexes.MIN;
import static net.rallyedu.regex.QuantifierRegexes.MIN_MAX;
import static net.rallyedu.regex.QuantifierRegexes.GREEDY;
import static net.rallyedu.regex.QuantifierRegexes.RELUCTANT;
import static net.rallyedu.regex.QuantifierRegexes.POSSESSIVE;

@Test
public class QuantifierRegexesTest {

    public void questionMarkShouldMatchZeroOccurrences() {
        assertTrue("".matches(QUESTION_MARK));
    }

    public void questionMarkShouldMatchOneOccurrence() {
        assertTrue("a".matches(QUESTION_MARK));
    }

    public void questionMarkShouldNotMatchManyOccurrences() {
        assertFalse("aaaaa".matches(QUESTION_MARK));
    }

    public void asteriskShouldMatchZeroOccurrences() {
        assertTrue("".matches(ASTERISK));
    }

    public void asteriskShouldMatchManyOccurrences() {
        assertTrue("aaaaa".matches(ASTERISK));
    }

    public void plusShouldNotMatchZeroOccurrences() {
        assertFalse("".matches(PLUS));
    }

    public void plusShouldMatchManyOccurrences() {
        assertTrue("aaaaa".matches(PLUS));
    }

    public void countShouldContainOpenCurlyBrace() {
        assertTrue(COUNT.contains("{"));
    }

    public void countShouldNotMatchLessThanThreeOccurrences() {
        assertFalse("aa".matches(COUNT));
    }

    public void countShouldMatchThreeOccurrences() {
        assertTrue("aaa".matches(COUNT));
    }

    public void countShouldNotMatchMoreThanThreeOccurrences() {
        assertFalse("aaaa".matches(COUNT));
    }

    public void minShouldNotMatchLessThanThreeOccurrence() {
        assertFalse("aa".matches(MIN));
    }

    public void minShouldMatchThreeOccurrences() {
        assertTrue("aaa".matches(MIN));
    }

    public void minShouldMatchMoreThanThreeOccurrences() {
        assertTrue("aaaa".matches(MIN));
    }

    public void minMaxShouldNotMatchLessThanThreeOccurrences() {
        assertFalse("aa".matches(MIN_MAX));
    }

    public void minMaxShouldMatchThreeOccurrences() {
        assertTrue("aaa".matches(MIN_MAX));
    }

    public void minMaxShouldMatchFourOccurrences() {
        assertTrue("aaaa".matches(MIN_MAX));
    }

    public void minMaxShouldMatchFiveOccurrences() {
        assertTrue("aaaaa".matches(MIN_MAX));
    }

    public void minMaxShouldNotMatchMoreThanFiveOccurrences() {
        assertFalse("aaaaaa".matches(MIN_MAX));
    }

    public void greedyShouldContainAsterisk() {
        assertTrue(GREEDY.contains("*"));
    }

    public void greedyShouldMatchAsMuchAsPossible() {
        assertEquals(findGroups("You gotta do what you gotta do!", GREEDY).get(0), "You gotta do what you gotta do");
    }

    public void reluctantShouldContainAsteriskAndQuestionMark() {
        assertTrue(RELUCTANT.contains("*?"));
    }

    public void reluctantShouldMatchAsLittleAsPossible() {
        assertEquals(findGroups("You gotta do what you gotta do!", RELUCTANT).get(0), "You gotta do");
    }

    public void possessiveShouldContainAsteriskAndPlus() {
        assertTrue(POSSESSIVE.contains("*+"));
    }

    public void possessiveShouldMatchAsMuchAsPossible() {
        assertEquals(findGroups("You gotta do what you gotta do!", POSSESSIVE).get(0), "You gotta do what you gotta do!");
    }

}
