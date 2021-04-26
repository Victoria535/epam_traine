package filter;

import model.flowers.Flower;

/**
 * Filter.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public interface Filter {
    /**
     * Method for checking for filter.
     *
     * @param flower Flower flower
     * @return boolean checked or not checked
     * @see Flower
     */
    boolean check(Flower flower);
}
