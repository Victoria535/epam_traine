package model.flowers;

/**
 * Tulip.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public class Tulip extends Flower {
    @Override
    public String smell() {
        return "Tulip smells good";
    }

    @Override
    public String toString() {
        return new StringBuilder().append("\n").append(getName()).append(": ")
                .append("stem length = ").append(getStemLength())
                .append(", fresh = ").append(getFresh())
                .append(", cost = ").append(getCost())
                .append(", parasite = ").append(isParasite())
                .append(", ").append(smell()).toString();
    }
}
