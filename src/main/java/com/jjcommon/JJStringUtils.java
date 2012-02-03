package com.jjcommon;

import com.jjcommon.resourceBundle.ResourceBundleFactory;

import java.text.Collator;
import java.util.Locale;

/**
 * Utility class for strings.
 * Check out <code>org.apache.commons.lang.StringUtils</code> and <code>org.springframework.util.StringUtils</code>
 * for more utility methods around Strings.
 */
public class JJStringUtils {

    /**
     * Creates a random string.
     * @param nrChars The number of characters the string will have.
     * @return A random string.
     */
    public static String createRandom(int nrChars) {
        return "ABC";  // TODO: generate random string.
    }

    /**
     * Checks if the string represents boolean <code>true</code>.
     * <br>A string represents true if it has the number <em>1</em> (one), the word <em>"yes"</em>
     * or the word <em>"true"</em>.
     * <br>The words are also checked in the native locale (in addition to the default).
     * <br>Comparison is case and diacritics insensitive. Spaces are trimmed.
     * @param string    The string to check if represents <code>true</code>.
     * @return  <code>true</code> if the string represents boolean <code>true</code>,
     *          <code>false</code> otherwise.
     */
    public static boolean isTrue(String string) {
        return string != null && (
                string.trim().equals("1") ||
                JJStringUtils.equalsIgnoreCaseAndAccent(string, ("true")) ||
                JJStringUtils.equalsIgnoreCaseAndAccent(string, ("yes")) ||
                JJStringUtils.equalsIgnoreCaseAndAccent(string, ResourceBundleFactory.getGeneralBundle().getString("Yes")) ||
                JJStringUtils.equalsIgnoreCaseAndAccent(string, ResourceBundleFactory.getGeneralBundle().getString("True")));
    }

    /**
     * Checks if the string represents boolean <code>false</code>.
     * <br>A string represents false if it has the number <em>0</em> (zero), the word <em>"no"</em>
     * or the word <em>"false"</em>.
     * <br>The words are also checked in the native locale (in addition to the default).
     * <br>Comparison is case and diacritics insensitive. Spaces are trimmed.
     * @param string    The string to check if represents <code>false</code>.
     * @return  <code>true</code> if the string represents boolean <code>false</code>,
     *          <code>false</code> otherwise.
     */
    public static boolean isFalse(String string) {
        return string != null && (
                string.trim().equals("0") ||
                JJStringUtils.equalsIgnoreCaseAndAccent(string, ("false")) ||
                JJStringUtils.equalsIgnoreCaseAndAccent(string, ("yes")) ||
                JJStringUtils.equalsIgnoreCaseAndAccent(string, ResourceBundleFactory.getGeneralBundle().getString("No")) ||
                JJStringUtils.equalsIgnoreCaseAndAccent(string, ResourceBundleFactory.getGeneralBundle().getString("False")));
    }

    public static boolean equalsIgnoreCaseAndAccent(String string1, String string2) {
        return compareIgnoreCaseAndAccent(string1, string2) == 0;
    }

    public static boolean equalsIgnoreCaseAndAccent(String string1, String string2, Locale locale) {
        return compareIgnoreCaseAndAccent(string1, string2, locale) == 0;
    }

    /**
     * Performs a string comparison ignoring case and accent. Beginning and ending spaces are trimmed.
     * @param string1   string to be compared.
     * @param string2   string to be compared.
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.
     */
    public static int compareIgnoreCaseAndAccent(String string1, String string2) {
        return compareIgnoreCaseAndAccent(string1, string2, Locale.getDefault());
    }

    /**
     * Performs a string comparison ignoring case and accent. Beginning and ending spaces are trimmed.
     * @param string1   string to be compared.
     * @param string2   string to be compared.
     * @param locale    The locale to perform the comparison.
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.
     */
    public static int compareIgnoreCaseAndAccent(String string1, String string2, Locale locale) {
        if (string1 == null || string2 == null) {
            if (string1 == null && string2 == null) return 0;
            if (string1 == null) return -1;
            return 1;
        }
        
        Collator collator = Collator.getInstance(locale);
        collator.setStrength(Collator.PRIMARY);
        collator.setDecomposition(Collator.FULL_DECOMPOSITION);

        return collator.compare(string1, string2);
    }
}
