package com.jjcommon.ui.desktop.component;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class ExceptionPanel extends JPanel {

    Exception exception;

    public ExceptionPanel(Exception exception) {
        super(new GridBagLayout());
        this.exception = exception;
        setUI();
    }

    private void setUI() {
        GridBagConstraints c;

        JTextArea messageTextArea = new JTextArea(exception.getLocalizedMessage());
        messageTextArea.setOpaque(false);
        messageTextArea.setEditable(false);
        messageTextArea.setLineWrap(true);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(messageTextArea, c);
    }
}
