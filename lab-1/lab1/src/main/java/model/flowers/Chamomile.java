package model.flowers;

public class Chamomile extends Flower {
    @Override
    public String toString() {
        return new StringBuilder().append("\n").append(getName()).append(": ")
                .append("stem length = ").append(getStemLength())
                .append(", fresh = ").append(getFresh())
                .append(", cost = ").append(getCost())
                .append(", parasite = ").append(isParasite()).toString();
    }
}
