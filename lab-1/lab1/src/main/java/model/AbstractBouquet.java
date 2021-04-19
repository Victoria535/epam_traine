package model;

import filter.Filter;
import model.accessories.Accessory;
import model.flowers.Flower;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractBouquet extends AbstractField {
    private List<Flower> flowers;
    private List<Accessory> accessory;

    public List<Accessory> getAccessory() {
        return accessory;
    }

    public void setAccessory(List<Accessory> accessory) {
        this.accessory = accessory;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

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
     * @param flowers List<Flower> list of flowers
     * @param filter  Filter filter
     * @return count of flowers
     * @see Filter
     * @see Flower
     */
    public int find(List<Flower> flowers, Filter filter) {
        for (Flower fl : getFlowers()) {
            if (filter.check(fl)) {
                flowers.add(fl);
            }
        }
        return flowers.size();
    }
}
