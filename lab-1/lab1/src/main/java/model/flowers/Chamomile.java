package model.flowers;

/**
 * Chamomile.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public class Chamomile extends Flower {
    @Override
    public String smell() {
        return "Chamomile smells amazing";
    }

    @Override
    public String toString() {
        return new StringBuilder().append("\n").append(getName()).append(": ")
                .append("stem length = ").append(getStemLength())
                .append(", fresh = ").append(getFresh())
                .append(", cost = ").append(getCost())
                .append(", parasite = ").append(isParasite())
                .append(", ").append(smell())
                .toString();
    }
}
