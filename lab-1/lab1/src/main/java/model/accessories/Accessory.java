package model.accessories;

import model.Entity;
import model.enums.AccessoryColor;

/**
 * Accessory.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public abstract class Accessory extends Entity {
    /**
     * Field accessory color.
     */
    private AccessoryColor accessoryColor;

    /**
     * @return accessoryColor
     * @see AccessoryColor
     */
    public AccessoryColor getAccessoryColor() {
        return accessoryColor;
    }

    /**
     * Method for setting the field accessory color.
     *
     * @param accessoryColor AccessoryColor accessory color
     * @see AccessoryColor
     */
    public void setAccessoryColor(AccessoryColor accessoryColor) {
        this.accessoryColor = accessoryColor;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("\nname = ").append(getName())
                .append(", cost = ").append(getCost()).toString();
    }
}
