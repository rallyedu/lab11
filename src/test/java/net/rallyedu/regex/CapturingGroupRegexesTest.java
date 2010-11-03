package net.rallyedu.regex;

import org.testng.annotations.Test;

import java.util.List;

import static net.rallyedu.regex.CapturingGroupRegexes.ONE;
import static net.rallyedu.regex.CapturingGroupRegexes.TWO;
import static net.rallyedu.regex.CapturingGroupRegexes.THREE;
import static net.rallyedu.regex.RegexUtils.findGroups;
import static org.testng.Assert.assertEquals;

@Test
public class CapturingGroupRegexesTest {

    public void oneShouldContainOneDefinedGroup() {
        List<String> groups = findGroups("aaabbbccc", ONE);
        assertEquals(groups.get(0), "aaabbbccc");
        assertEquals(groups.get(1), "bbb");
    }

    public void twoShouldContainTwoDefinedGroups() {
        List<String> groups = findGroups("aaabbbccc", TWO);
        assertEquals(groups.get(0), "aaabbbccc");
        assertEquals(groups.get(1), "bbbccc");
        assertEquals(groups.get(2), "ccc");
    }

    public void threeShouldContainThreeDefinedGroups() {
        List<String> groups = findGroups("aaabbbccc", THREE);
        assertEquals(groups.get(0), "aaabbbccc");
        assertEquals(groups.get(1), "aaabbb");
        assertEquals(groups.get(2), "aaa");
        assertEquals(groups.get(3), "ccc");
    }

}
