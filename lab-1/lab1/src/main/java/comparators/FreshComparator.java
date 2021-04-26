package comparators;

import model.flowers.Flower;

import java.util.Comparator;

/**
 * FreshComparator.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public class FreshComparator implements Comparator<Flower> {

    @Override
    public int compare(Flower flower1, Flower flower2) {
        return flower1.getFresh() - flower2.getFresh();
    }
}
