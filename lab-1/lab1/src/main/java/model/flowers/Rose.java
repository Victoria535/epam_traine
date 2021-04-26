package model.flowers;

import model.enums.RoseColor;

/**
 * Util.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public class Rose extends Flower implements Prick {
    /**
     * Filed rose color.
     */
    private RoseColor roseColor;

    /**
     * @return roseColor
     * @see RoseColor
     */
    public RoseColor getRoseColor() {
        return roseColor;
    }

    /**
     * Method for setting the field rose color.
     *
     * @param roseColor RoseColor rose color
     * @see RoseColor
     */
    public void setRoseColor(RoseColor roseColor) {
        this.roseColor = roseColor;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("\n").append(getName()).append(": ")
                .append("color = ").append(getRoseColor())
                .append(", stem length = ").append(getStemLength())
                .append(", fresh = ").append(getFresh())
                .append(", cost = ").append(getCost())
                .append(", parasite = ").append(isParasite())
                .append(", prick = ").append(prick())
                .append(", ").append(smell()).toString();
    }

    @Override
    public boolean prick() {
        return true;
    }

    @Override
    public String smell() {
        return "Rose smells lovely";
    }
}
