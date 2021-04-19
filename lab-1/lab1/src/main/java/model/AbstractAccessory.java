package model;

import model.enums.AccessoryColorType;

public abstract class AbstractAccessory extends AbstractField {
    private AccessoryColorType accessoryColor;

    public AccessoryColorType getAccessoryColor() {
        return accessoryColor;
    }

    public void setAccessoryColor(AccessoryColorType accessoryColor) {
        this.accessoryColor = accessoryColor;
    }
}
