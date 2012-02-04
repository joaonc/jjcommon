package com.jjcommon.ui.desktop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class ComponentUtilsTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void showExceptionTest() {
        Exception ex = new Exception("Test exception");
        ComponentUtils.showException(ex);
    }

    @Test
    public void showComponentTest() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Test panel!"));

        ButtonType result = ComponentUtils.showComponent(
                panel, null, "Testing showComponent", true, Options.Buttons.OK, Options.Alignment.CENTER);

        logger.debug("Button clicked: " + (result == null ? "NONE" : result.toString()));
    }
}
