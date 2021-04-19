package model.accessories;

import model.AbstractAccessory;

public class Accessory extends AbstractAccessory {
    @Override
    public String toString() {
        return new StringBuilder().append("\nname = ").append(getName())
                .append(", cost = ").append(getCost()).toString();
    }
}
