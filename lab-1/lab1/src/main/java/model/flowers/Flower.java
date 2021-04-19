package model.flowers;

import model.AbstractFlower;

public class Flower extends AbstractFlower {
    @Override
    public String toString() {
        return new StringBuilder().append("\n").append(getName()).append(": ")
                .append(", stem length = ").append(getStemLength())
                .append(", fresh = ").append(getFresh())
                .append(", cost = ").append(getCost())
                .append(", parasite = ").append(isParasite()).toString();
    }
}
