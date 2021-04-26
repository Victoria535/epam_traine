package filter;

import model.flowers.Flower;

/**
 * Stem length  and cost filter.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public class CostAndStemLengthFilter implements Filter {
    /**
     * Field beginning filter stem length.
     */
    private final int beginStem;
    /**
     * Field ending filter stem length.
     */
    private final int endStem;
    /**
     * Field beginning filter cost.
     */
    private final int beginCost;
    /**
     * Field ending filter cost.
     */
    private final int endCost;

    /**
     * Constructor for initialize fields.
     *
     * @param beginCost int beginning filter cost
     * @param endCost   int ending filter cost
     * @param beginStem int beginning filter stem length
     * @param endStem   int ending filter stem length
     */
    public CostAndStemLengthFilter(int beginCost, int endCost, int beginStem, int endStem) {
        this.beginCost = beginCost;
        this.endCost = endCost;
        this.beginStem = beginStem;
        this.endStem = endStem;
    }

    /**
     * @return beginStem
     */
    public int getBeginStem() {
        return beginStem;
    }

    /**
     * @return endStem
     */
    public int getEndStem() {
        return endStem;
    }

    /**
     * @return beginCost
     */
    public int getBeginCost() {
        return beginCost;
    }

    /**
     * @return endCost
     */
    public int getEndCost() {
        return endCost;
    }

    @Override
    public boolean check(Flower flower) {
        CostFilter costFilter = new CostFilter(getBeginCost(), getEndCost());
        StemLengthFilter stemLengthFilter = new StemLengthFilter(getBeginStem(), getEndStem());
        return costFilter.check(flower) && stemLengthFilter.check(flower);
    }
}
