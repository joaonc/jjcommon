package com.jjcommon.ui.desktop;

import javax.swing.*;
import java.awt.*;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 */
public class DecisionButtonsPanel extends JPanel {
    public enum Buttons {
        OK,
        OK_CANCEL,
        YES_NO
    }

    public enum Alignment {
        LEFT,
        RIGHT,
        CENTER
    }

    private static final ResourceBundle uiBundle = PropertyResourceBundle.getBundle(
            DecisionButtonsPanel.class.getPackage().getName() + ".ui");

    private void addHSpacer(JPanel panel, int gridx, int gridy) {
        Component hSpacer = Box.createHorizontalGlue();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.weightx = 0.5;

        panel.add(hSpacer, constraints);
    }

    public JPanel createPanel(Buttons buttons) {
        return createPanel(buttons, Alignment.RIGHT);
    }

    public JPanel createPanel(Buttons buttons, Alignment alignment) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints;
        JButton button;
        String text;
        int gridx = 0;
        
        if (alignment == Alignment.RIGHT) {
            addHSpacer(panel, gridx++, 0);
        }
        
        // 1st button
        switch (buttons) {
            case YES_NO:
                text = uiBundle.getString("Yes");
                break;
            default:
                text = uiBundle.getString("Ok");
        }
        button = new JButton(text);
        constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = gridx++;
        panel.add(button, constraints);

        // 2nd button
        switch (buttons) {
            case YES_NO:
                text = uiBundle.getString("No");
                break;
            default:
                text = uiBundle.getString("Cancel");
        }
        button = new JButton(text);
        constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = gridx++;
        panel.add(button, constraints);

        if (alignment == Alignment.LEFT) {
            addHSpacer(panel, gridx, 0);
        }

        return panel;
    }
}
