package model.accessories;

/**
 * Ribbon.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public class Ribbon extends Accessory {
    @Override
    public String toString() {
        return new StringBuilder().append("\nname = ").append(getName())
                .append(", cost = ").append(getCost()).toString();
    }
}
