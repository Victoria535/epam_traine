package model;

/**
 * Entity.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public abstract class Entity {
    /**
     * Field name.
     */
    private String name;
    /**
     * Field cost.
     */
    private int cost;

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method for setting the field name.
     *
     * @param name String name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * Method for setting the field cost.
     *
     * @param cost int cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }
}
