package com.jjcommon.ui.desktop;

import com.jjcommon.ui.desktop.Options.*;
import com.jjcommon.ui.desktop.component.DecisionButtonsPanel;
import com.jjcommon.ui.desktop.component.ExceptionPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public static void showComponent(
            Component component, Window owner, String title, boolean modal) {

        showComponent(component, owner, title, modal, Buttons.OK, Alignment.CENTER);
    }

    public static ButtonType showComponent(
            Component component, Window owner, String title, boolean modal, Buttons buttons, Alignment alignment) {

        JDialog dialog = new JDialog(owner, title);
        dialog.setModal(modal);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new GridBagLayout());
        
        GridBagConstraints c;
        Container container = dialog.getContentPane();
        
        // Component
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.anchor = GridBagConstraints.PAGE_START;
        c.fill = GridBagConstraints.BOTH;
        container.add(component, c);
        
        // Buttons
        DecisionButtonsPanel decisionButtonsPanel = null;
        if (buttons != Buttons.NONE) {
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 1;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.insets = new Insets(5, 5, 5, 5);

            decisionButtonsPanel = new DecisionButtonsPanel(buttons, alignment);
            final JDialog dialogFinal = dialog;
            decisionButtonsPanel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialogFinal.setVisible(false);
                }
            });
            container.add(decisionButtonsPanel, c);
        }

        // Show
        dialog.pack();
        if (buttons != Buttons.NONE) {
            Dimension buttonsSize = container.getComponent(1).getSize();
            dialog.setMinimumSize(new Dimension(buttonsSize.width + 20, buttonsSize.height + 80));
        }

        dialog.setLocationRelativeTo(owner);  // Center of screen if null.
        dialog.setVisible(true);

        ButtonType buttonTypeClicked = null;
        if (buttons != Buttons.NONE) {
            buttonTypeClicked = decisionButtonsPanel.getButtonClicked();
        }

        return buttonTypeClicked;
    }
    
    public static void showException(Exception ex) {
        showException(ex, null);
    }

    public static void showException(Exception ex, Window owner) {
        showComponent(new ExceptionPanel(ex), owner, "", true);
    }
}
