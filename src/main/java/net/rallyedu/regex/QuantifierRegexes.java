package net.rallyedu.regex;

public class QuantifierRegexes {
    public static final String QUESTION_MARK = "a?";
    public static final String ASTERISK = "a*";
    public static final String PLUS = "a+";
    public static final String COUNT = "a{3}";
    public static final String MIN = "a{3,}";
    public static final String MIN_MAX = "a{3,5}";
    public static final String GREEDY = ".*do";
    public static final String RELUCTANT = ".*?do";
    public static final String POSSESSIVE = "[^!]*+!";
}
