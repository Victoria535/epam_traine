package com.epam.lab3.model;

/**
 * VisualParameters.
 * <p>
 * Date: apr 16 2021
 *
 * @author Viktoria Symaniuk
 */
public class VisualParameters {
    private String colorLeaf;
    private String colorStem;
    private Integer mediumSize;

    /**
     * @return colorLeaf
     */
    public String getColorLeaf() {
        return colorLeaf;
    }

    /**
     * Method for setting field colorLeaf.
     *
     * @param colorLeaf String field colorLeaf
     */
    public void setColorLeaf(String colorLeaf) {
        this.colorLeaf = colorLeaf;
    }

    /**
     * @return colorStem
     */
    public String getColorStem() {
        return colorStem;
    }

    /**
     * Method for setting field colorStem.
     *
     * @param colorStem String field colorStem
     */
    public void setColorStem(String colorStem) {
        this.colorStem = colorStem;
    }

    /**
     * @return mediumSize
     */
    public Integer getMediumSize() {
        return mediumSize;
    }

    /**
     * Method for setting field mediumSize.
     *
     * @param mediumSize Integer field mediumSize
     */
    public void setMediumSize(Integer mediumSize) {
        this.mediumSize = mediumSize;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }

}
