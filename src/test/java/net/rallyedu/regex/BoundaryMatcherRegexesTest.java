package net.rallyedu.regex;

import org.testng.annotations.Test;


import static net.rallyedu.regex.BoundaryMatcherRegexes.BEGINNING_OF_LINE;
import static net.rallyedu.regex.BoundaryMatcherRegexes.END_OF_LINE;
import static net.rallyedu.regex.BoundaryMatcherRegexes.WORD_BOUNDARY;
import static net.rallyedu.regex.BoundaryMatcherRegexes.NON_WORD_BOUNDARY;
import static net.rallyedu.regex.RegexUtils.findGroups;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test
public class BoundaryMatcherRegexesTest {

    public void beginningOfLineShouldMatchAtBeginning() {
        assertEquals(findGroups("one two three", BEGINNING_OF_LINE).get(0), "one");
    }

    public void beginningOfLineShouldNotMatchElsewhere() {
        assertTrue(findGroups("two one three", BEGINNING_OF_LINE).isEmpty());
    }

    public void endOfLineShouldMatchAtEnd() {
        assertEquals(findGroups("one two three", END_OF_LINE).get(0), "three");
    }

    public void endOfLineShouldNotMatchElsewhere() {
        assertTrue(findGroups("one three two", END_OF_LINE).isEmpty());
    }

    public void wordBoundaryShouldMatchWholeWord() {
        assertEquals(findGroups("bar", WORD_BOUNDARY).get(0), "bar");
    }

    public void wordBoundaryShouldNotMatchPartialWord() {
        assertTrue(findGroups("foobarbaz", WORD_BOUNDARY).isEmpty());
    }

    public void nonWordBoundaryShouldNotMatchWholeWord() {
        assertTrue(findGroups("bar", NON_WORD_BOUNDARY).isEmpty());
    }

    public void nonWordBoundaryShouldMatchPartialWord() {
        assertEquals(findGroups("foobarbaz", NON_WORD_BOUNDARY).get(0), "bar");
    }

}
