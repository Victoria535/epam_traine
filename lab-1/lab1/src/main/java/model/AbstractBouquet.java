package model;

import filter.Filter;
import model.accessories.Accessory;
import model.flowers.Flower;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * AbstractBouquet.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public abstract class AbstractBouquet extends Entity {
    /**
     * Filed flowers.
     */
    private List<Flower> flowers;

    /**
     * Field accessory.
     */
    private List<Accessory> accessory;

    /**
     * @return accessory
     * @see Accessory
     */
    public List<Accessory> getAccessory() {
        return accessory;
    }

    /**
     * Method for setting the field accessory.
     *
     * @param accessory Accessory accessory
     * @see Accessory
     */
    public void setAccessory(List<Accessory> accessory) {
        this.accessory = accessory;
    }

    /**
     * @return flowers
     * @see Flower
     */
    public List<Flower> getFlowers() {
        return flowers;
    }

    /**
     * Method for setting the field flowers.
     *
     * @param flowers Flower flowers
     * @see Flower
     */
    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    /**
     * This method sort flowers.
     *
     * @param comparator Comparator<Flower> comparator
     * @see Flower
     */
    public final void sort(Comparator<Flower> comparator) {
        getFlowers().sort(comparator);
    }

    /**
     * This method use for checking filter flowers.
     *
     * @param filter Filter filter
     * @return count of flowers
     * @see Filter
     * @see Flower
     */
    public List<Flower> find(Filter filter) {
        List<Flower> resultFlowers = new ArrayList<>();
        for (Flower flower : getFlowers()) {
            if (filter.check(flower)) {
                resultFlowers.add(flower);
            }
        }
        return resultFlowers;
    }
}
