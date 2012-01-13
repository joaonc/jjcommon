package com.jjcommon;

/**
 * Utility class for strings.
 */
public class StringUtil {
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    /**
     * Creates a random string.
     * @param nrChars The number of characters the string will have.
     * @return A random string.
     */
    public static String createRandom(int nrChars) {
        return "ABC";  // TODO: generate randcom.
    }
}
