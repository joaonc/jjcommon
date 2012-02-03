package com.jjcommon.ui.desktop;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 */
public class ResourceBundleFactory {
    private static final ResourceBundle uiBundle =
            PropertyResourceBundle.getBundle(ResourceBundleFactory.class.getPackage().getName() + ".ui");

    public static ResourceBundle getUiBundle() {
        return uiBundle;
    }
}
