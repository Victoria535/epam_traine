package model.accessories;

public class Ribbon extends Accessory {
    @Override
    public String toString() {
        return new StringBuilder().append("\nname = ").append(getName())
                .append(", cost = ").append(getCost()).toString();
    }
}
