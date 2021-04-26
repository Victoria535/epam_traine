package model;

/**
 * Bouquet.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public class Bouquet extends AbstractBouquet {
    @Override
    public String toString() {
        return new StringBuilder().append("\nname: ").append(getName())
                .append("\ncost = ").append(getCost())
                .append("\ncount = ").append(getFlowers().size())
                .append("\nflowers: ").append(getFlowers())
                .append("\naccessory: ").append(getAccessory()).toString();
    }
}
