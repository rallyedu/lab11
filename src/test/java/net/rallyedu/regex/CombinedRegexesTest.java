package net.rallyedu.regex;

import org.testng.annotations.Test;

import static net.rallyedu.regex.RegexUtils.findGroups;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import static net.rallyedu.regex.CombinedRegexes.PHONE_NUMBER;
import static net.rallyedu.regex.CombinedRegexes.EMPHASIZED_TEXT;

@Test
public class CombinedRegexesTest {

    public void phoneNumberShouldMatchPhoneNumberWithDashes() {
        assertTrue("303-777-1234".matches(PHONE_NUMBER));
    }

    public void phoneNumberShouldMatchPhoneNumberWithoutDashes() {
        assertTrue("3037771234".matches(PHONE_NUMBER));
    }

    public void phoneNumberDoesNotMatchNonTenDigitNumber() {
        assertFalse("7771234".matches(PHONE_NUMBER));
    }

    public void empasizedTextShouldMatchTextBetweenEmTagsOne() {
        assertEquals(findGroups("This is <em>really</em> fun.", EMPHASIZED_TEXT).get(1), "really");
    }

    public void empasizedTextShouldMatchTextBetweenEmTagsTwo() {
        assertEquals(findGroups("This <em>is</em> really fun.", EMPHASIZED_TEXT).get(1), "is");
    }

    public void emphasizedTextShouldNotMatchTextOutsideOfEmTags() {
        assertTrue(findGroups("This is really fun.", EMPHASIZED_TEXT).isEmpty());
    }

}
