package com.despegar.extras.test;

public class TestUtils {

    private TestUtils() {
    }

    public static void check(boolean cond) {
        if (!cond) {
            error();
        }
    }

    public static void checkEquals(Object expected, Object actual) {
        if (expected != null || actual != null) {
            if (expected == null || !expected.equals(actual)) {
                error();
            }
        }
    }

    public static void error() {
        throw new AssertionError();
    }

}
