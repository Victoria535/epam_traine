package com.epam.lab3.model;

/**
 * GrowingTips.
 * <p>
 * Date: apr 16 2021
 *
 * @author Viktoria Symaniuk
 */
public class GrowingTips {
    private String lighting;
    private Integer temperature;
    private Integer watering;

    /**
     * @return lighting
     */
    public String getLighting() {
        return lighting;
    }

    /**
     * Method for setting field lighting.
     *
     * @param lighting String field lighting
     */
    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    /**
     * @return temperature
     */
    public Integer getTemperature() {
        return temperature;
    }

    /**
     * Method for setting field temperature.
     *
     * @param temperature Integer field temperature
     */
    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    /**
     * @return watering
     */
    public Integer getWatering() {
        return watering;
    }

    /**
     * Method for setting field watering.
     *
     * @param watering Integer field watering
     */
    public void setWatering(Integer watering) {
        this.watering = watering;
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
