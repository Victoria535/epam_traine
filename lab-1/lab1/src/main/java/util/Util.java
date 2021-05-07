package util;

import comparators.FreshComparator;
import exceptions.FilterException;
import filter.CostAndStemLengthFilter;
import filter.StemLengthFilter;
import model.Bouquet;
import model.flowers.Flower;

import java.util.List;

import static worker.Printable.printInfo;
import static worker.Printable.printResult;

/**
 * Util.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public final class Util {
    /**
     * Constructor.
     */
    private Util() {
    }

    /**
     * This method sort bouquet by fresh.
     *
     * @param bouquet Bouquet
     */
    public static void sortByFresh(Bouquet bouquet) {
        printInfo("\nsort by fresh: ");

        bouquet.sort(new FreshComparator());
        for (Flower flower : bouquet.getFlowers()) {
            printInfo("{}. fresh = {}", flower.getName(), flower.getFresh());
        }
    }

    /**
     * This method use for search stem length in interval.
     *
     * @param bouquet Bouquet bouquet
     * @param begin   int the beginning of interval
     * @param end     int the ending of interval
     * @throws FilterException if start of interval less then end of interval
     */
    public static void findStemLength(Bouquet bouquet, int begin, int end) throws FilterException {
        printInfo("\nfind stem length from {} to {}: ", begin, end);

        checkInterval(begin, end);

        List<Flower> filterFlowers = bouquet.find(new StemLengthFilter(begin, end));
        for (Flower filterFlower : filterFlowers) {
            printInfo("{} stem length = {}", filterFlower.getName(), filterFlower.getStemLength());
        }
    }

    /**
     * This method use for search stem length and cost in interval.
     *
     * @param bouquet   Bouquet bouquet
     * @param beginStem int the beginning of interval stem length
     * @param endStem   int the ending of interval stem length
     * @param beginCost int the beginning of interval cost
     * @param endCost   int the ending of interval cost
     * @throws FilterException if start of interval less then end of interval
     */
    public static void findStemLengthAndCost(Bouquet bouquet, int beginStem, int endStem,
                                             int beginCost, int endCost) throws FilterException {
        printInfo("\nfind stem length from {} to {} and find cost from {} to {}",
                beginStem, endStem, beginCost, endCost);

        checkInterval(beginStem, endStem);
        checkInterval(beginCost, endCost);

        List<Flower> flowerList = bouquet.find(new CostAndStemLengthFilter(beginCost, endCost, beginStem, endStem));

        printResult(flowerList);
    }

    /**
     * This method check interval.
     *
     * @param begin int the beginning of interval
     * @param end   int the ending of interval
     * @throws FilterException if start of interval less then end of interval
     */
    private static void checkInterval(int begin, int end) throws FilterException {
        if (begin > end) {
            throw new FilterException("Start of interval should be less then end of interval", begin, end);
        }
    }
}
