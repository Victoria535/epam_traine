package model.flowers;

import model.enums.RoseType;

public class Rose extends Flower implements Prick {
    private RoseType roseColor;

    public RoseType getRoseColor() {
        return roseColor;
    }

    public void setRoseColor(RoseType roseColor) {
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
                .append(", prick = ").append(prick()).toString();

    }

    @Override
    public boolean prick() {
        return true;
    }
}
