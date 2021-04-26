package filter;

import model.flowers.Flower;

/**
 * Stem length filter.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public class StemLengthFilter implements Filter {
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
    public StemLengthFilter(double start, double finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public boolean check(Flower flower) {
        return flower.getStemLength() >= start && flower.getStemLength() <= finish;
    }
}
