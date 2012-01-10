package com.jjcommon;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class StringUtilTest {
    @Test
    public void testIsNullOrEmpty_isNull() throws Exception {
        assertTrue(StringUtil.isNullOrEmpty(null));
    }

    @Test
    public void testIsNullOrEmpty_isEmpty() throws Exception {
        assertTrue(StringUtil.isNullOrEmpty(""));
    }

    @Test
    public void testIsNullOrEmpty_notEmpty() throws Exception {
        assertFalse(StringUtil.isNullOrEmpty(" "));
    }
}
