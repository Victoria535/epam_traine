package com.epam.lab3.model;

/**
 * Greenhouse.
 * <p>
 * Date: apr 16 2021
 *
 * @author Viktoria Symaniuk
 */
public class Greenhouse {
    private String id;
    private String name;
    private SoilType soilType;
    private String origin;
    private VisualParameters parameters = new VisualParameters();
    private GrowingTips tips = new GrowingTips();
    private MultiplyingType multiplyingType;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Method for setting field id.
     *
     * @param id String field id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method for setting field name.
     *
     * @param name String field name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return SoilType field soilType
     * @see SoilType
     */
    public SoilType getSoilType() {
        return soilType;
    }

    /**
     * Method for setting field soilType.
     *
     * @param soilType SoilType field soilType
     * @see SoilType
     */
    public void setSoilType(SoilType soilType) {
        this.soilType = soilType;
    }

    /**
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Method for setting field origin.
     *
     * @param origin String field origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return parameters
     * @see VisualParameters
     */
    public VisualParameters getParameters() {
        return parameters;
    }

    /**
     * @return tips
     * @see GrowingTips
     */
    public GrowingTips getTips() {
        return tips;
    }

    /**
     * @return multiplyingType
     * @see MultiplyingType
     */
    public MultiplyingType getMultiplyingType() {
        return multiplyingType;
    }

    /**
     * Method for setting field multiplyingType.
     *
     * @param multiplyingType String MultiplyingType multiplyingType
     * @see MultiplyingType
     */
    public void setMultiplyingType(MultiplyingType multiplyingType) {
        this.multiplyingType = multiplyingType;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Greenhouse: ").append(id)
                .append(",\n\t name: ").append(getName())
                .append(",\n\t soil: ").append(getSoilType())
                .append(",\n\t origin: ").append(getOrigin())
                .append(",\n\t Visual parameters: ")
                .append("\n\t\t color stem: ").append(getParameters().getColorStem())
                .append(",\n\t\t color leaf: ").append(getParameters().getColorLeaf())
                .append(",\n\t\t medium size: ").append(getParameters().getMediumSize())
                .append(",\n\t Growing tips: ")
                .append("\n\t\t temperature: ").append(getTips().getTemperature())
                .append(",\n\t\t lighting: ").append(getTips().getLighting())
                .append(",\n\t\t watering: ").append(getTips().getWatering())
                .append(",\n multiplying: ").append(getMultiplyingType()).toString();
    }
}
