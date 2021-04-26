package model.flowers;

import model.Entity;

/**
 * Flower.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public abstract class Flower extends Entity {
    /**
     * Field fresh.
     */
    private int fresh;
    /**
     * Field stem length.
     */
    private double stemLength;
    /**
     * Field  parasite.
     */
    private boolean parasite;

    /**
     * @return parasite
     */
    public boolean isParasite() {
        return parasite;
    }

    /**
     * Method for setting the field parasite.
     *
     * @param parasite boolean parasite
     */
    public void setParasite(boolean parasite) {
        if (parasite) {
            setFresh(0);
        }
        this.parasite = parasite;
    }

    /**
     * @return fresh
     */
    public int getFresh() {
        return fresh;
    }

    /**
     * Method for setting the field fresh.
     *
     * @param fresh int fresh
     */
    public void setFresh(int fresh) {
        this.fresh = fresh;
    }

    /**
     * @return stemLength
     */
    public double getStemLength() {
        return stemLength;
    }

    /**
     * Method for setting the field stem length.
     *
     * @param stemLength double stem length
     */
    public void setStemLength(double stemLength) {
        this.stemLength = stemLength;
    }

    /**
     * Method shows how the flower smells.
     *
     * @return String how the flower smells
     */
    public abstract String smell();

    @Override
    public String toString() {
        return new StringBuilder().append("\n").append(getName()).append(": ")
                .append(", stem length = ").append(getStemLength())
                .append(", fresh = ").append(getFresh())
                .append(", cost = ").append(getCost())
                .append(", parasite = ").append(isParasite())
                .append(", ").append(smell()).toString();
    }
}
