package com.jjcommon.resourceBundle;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 */
public class ResourceBundleFactory {
    private static final ResourceBundle generalBundle =
            PropertyResourceBundle.getBundle(ResourceBundleFactory.class.getPackage().getName() + ".general");

    public static ResourceBundle getGeneralBundle() {
        return generalBundle;
    }
}
