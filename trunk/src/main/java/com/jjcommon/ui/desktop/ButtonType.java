package com.jjcommon.ui.desktop;

/**
 * Types of commonly used buttons.
 */
public enum ButtonType {
    OK("Ok"),
    CANCEL("Cancel"),
    YES("Yes"),
    NO("No");
    
    private String propertyName;
    
    ButtonType(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * Gets the localized text for this button type.
     * @return the localized text of the button.
     */
    public String getText() {
        return ResourceBundleFactory.getUiBundle().getString(propertyName);
    }
}
