package filter;

import model.flowers.Flower;

/**
 * Cost filter.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public class CostFilter implements Filter {
    /**
     * Field start filter.
     */
    private final double start;
    /**
     * Field finish filter.
     */
    private final double finish;

    /**
     * Constructor for initialize fields.
     *
     * @param start  double start filter
     * @param finish double finish filter
     */
    public CostFilter(double start, double finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public boolean check(Flower flower) {
        return flower.getCost() >= start && flower.getCost() <= finish;
    }
}
