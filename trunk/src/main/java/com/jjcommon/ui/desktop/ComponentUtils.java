package com.jjcommon.ui.desktop;

import org.apache.commons.lang.ArrayUtils;

import java.awt.*;
import java.util.Vector;

/**
 *
 */
public class ComponentUtils {

    public static Component[] filterByClass(Component[] components, Class clazz) {
        Vector<Component> vector = new Vector<Component>();
        for (int i=0; i < components.length; i++) {
            if (components[i].getClass().equals(clazz)) {
                vector.add(components[i]);
            }
        }

        Component[] filteredComponents = new Component[vector.size()];
        vector.toArray(filteredComponents);

        return filteredComponents;
    }
}
