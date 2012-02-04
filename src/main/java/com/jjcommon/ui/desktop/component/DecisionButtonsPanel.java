package com.jjcommon.ui.desktop.component;

import com.jjcommon.ui.desktop.ButtonType;
import com.jjcommon.ui.desktop.Options.*;
import com.jjcommon.ui.desktop.ResourceBundleFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 *
 */
public class DecisionButtonsPanel extends JPanel {

    private static final ResourceBundle uiBundle = ResourceBundleFactory.getUiBundle();

    Buttons buttons;
    Alignment alignment;

    ButtonType buttonClicked;

    public DecisionButtonsPanel(Buttons buttons) {
        super(new GridBagLayout());
        this.buttons = buttons;
        this.alignment = Alignment.CENTER;
        setUI();
    }

    public DecisionButtonsPanel(Buttons buttons, Alignment alignment) {
        super(new GridBagLayout());
        this.buttons = buttons;
        this.alignment = alignment;
        setUI();
    }

    private void setUI() {
        GridBagConstraints constraints;
        JButton button;
        int gridx = 0;

        if (alignment == Alignment.RIGHT) {
            addHSpacer(gridx++, 0);
        }

        ButtonType buttonType;

        // 1st button
        switch (buttons) {
            case YES_NO:
                buttonType = ButtonType.YES;
                break;
            default:
                buttonType = ButtonType.OK;
        }
        button = new JButton(buttonType.getText());
        button.setName(buttonType.toString());
        constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = gridx++;
        add(button, constraints);

        // 2nd button
        if (buttons != Buttons.OK && buttons != Buttons.NONE) {
            switch (buttons) {
                case YES_NO:
                    buttonType = ButtonType.NO;
                    break;
                default:
                    buttonType = ButtonType.CANCEL;
            }
            button = new JButton(buttonType.getText());
            button.setName(buttonType.toString());
            constraints = new GridBagConstraints();
            constraints.gridy = 0;
            constraints.gridx = gridx++;
            constraints.insets = new Insets(0, 5, 0, 0);
            add(button, constraints);
        }

        if (alignment == Alignment.LEFT) {
            addHSpacer(gridx, 0);
        }

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonTypeName = ((JButton)e.getSource()).getName();
                setButtonClicked(Enum.valueOf(ButtonType.class, buttonTypeName));
            }
        });

        validate();
    }

    public ButtonType getButtonClicked() {
        return buttonClicked;
    }

    private void setButtonClicked(ButtonType buttonClicked) {
        this.buttonClicked = buttonClicked;
    }

    private void addHSpacer(int gridx, int gridy) {
        Component hSpacer = Box.createHorizontalGlue();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.weightx = 0.5;

        add(hSpacer, constraints);
    }

    /**
     * Gets the n<sup>th</sup> button displayed.
     * @param n the index of the button to get.
     * @return the n<sup>th</sup> button or <code>null</code> if it doesn't exist..
     */
    public JButton getButton(int n) {
        JButton button = null;
        for (int i=0, j=0; i < getComponents().length; i++) {
            if (getComponent(i) instanceof JButton) {
                if (++j == n) {
                    button = (JButton)getComponent(i);
                    break;
                }
            }
        }

        return button;
    }

    /**
     * Gets the button of the given type.
     * @param buttonType the type of button to get.
     * @return the button of the given type or <code>null</code> if it doesn't exist..
     */
    public JButton getButton(ButtonType buttonType) {
        JButton button = null;
        for (Component component : getComponents()) {
            if ((component instanceof JButton) && component.getName().equals(buttonType.toString())) {
                button = (JButton)component;
                break;
            }
        }

        return button;
    }

    /**
     * Adds an <code>ActionListener</code> that gets called when any of the buttons is clicked.
     * <br>To know which button was clicked, get the ActionEvent's object's name, which is
     * <code>ButtonType.toString()</code>, with which you can get <code>ButtonType</code>.
     * <p>If you need to set a different <code>ActionListener</code> per button, use <code>getButton</code>
     * and add it there.
     * @param l the <code>ActionListener</code> to add
     */
    public void addActionListener(ActionListener l) {
        for (Component component : getComponents()) {
            if (component instanceof JButton) {
                ((JButton)component).addActionListener(l);
            }
        }
    }
}
