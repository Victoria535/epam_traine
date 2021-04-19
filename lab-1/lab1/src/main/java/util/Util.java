package util;

import comparators.FreshComparator;
import exceptions.FilterException;
import filter.StemLengthFilter;
import model.Bouquet;
import model.flowers.Flower;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public final class Util {
    private static final Logger LOGGER = Logger.getLogger(Util.class.toString());

    /**
     * Constructor.
     */
    private Util() {
    }

    /**
     * This method sort the bouquet by fresh.
     *
     * @param bouquet Bouquet
     */
    public static void sortByFresh(Bouquet bouquet) {
        LOGGER.info("\nsort: ");

        bouquet.sort(new FreshComparator());
        for (Flower fl : bouquet.getFlowers()) {
            LOGGER.info(fl.getName() + ". fresh = " + fl.getFresh());
        }
    }

    /**
     * This method is used to find the length of stem in the interval.
     *
     * @param bouquet Bouquet the bouquet of flowers
     * @param begin   int the beginning of the interval
     * @param end     int the ending of the interval
     * @thows FilterException if the beginning of the interval less than ending of the interval
     * @see Bouquet
     */
    public static void findStemLength(Bouquet bouquet, int begin, int end) throws FilterException {
        LOGGER.info("\nFind the length of stem from " + begin + " to " + end + ": ");
        List<Flower> flowers = new ArrayList<>();

        checkInterval(begin, end);

        int countFlower = bouquet.find(flowers, new StemLengthFilter(begin, end));
        for (int i = 0; i < countFlower; i++) {
            LOGGER.info(flowers.get(i).getName() + ". stem length = " + flowers.get(i).getStemLength());
        }
    }

    /**
     * This method is used to call method find the length of stem and cost in the interval.
     *
     * @param bouquet   Bouquet the bouquet of flowers
     * @param beginStem int the beginning of the interval length of stem
     * @param endStem   int the ending of the interval length of stem
     * @param beginCost int the beginning of the interval of cost
     * @param endCost   int the ending of the interval of cost
     * @throws FilterException if the beginning of the interval less than ending of the interval
     * @see Bouquet
     */
    public static void findStemLengthAndCost(Bouquet bouquet, int beginStem, int endStem,
                                             int beginCost, int endCost) throws FilterException {
        LOGGER.info("\nFind the length of stem from " + beginStem + " to " + endStem
                + " and cost from " + beginCost + " to " + endCost + ": ");

        List<Flower> flowers = bouquet.getFlowers();

        checkInterval(beginStem, endStem);
        checkInterval(beginCost, endCost);

        List<Flower> list = filterStemLengthAndCost(beginStem, endStem, beginCost, endCost, flowers);

        for (Flower flower : list) {
            LOGGER.info(String.valueOf(flower));
        }
    }

    /**
     * This method is used to find the length of stem and cost in the interval.
     *
     * @param beginStem int the beginning of the interval length of stem
     * @param endStem   int the ending of the interval length of stem
     * @param beginCost int the beginning of the interval of cost
     * @param endCost   int the ending of the interval of cost
     * @param flowers   List<Flower> list of the flowers
     * @return List<Flower> found list of the flowers
     */
    private static List<Flower> filterStemLengthAndCost(int beginStem, int endStem,
                                                        int beginCost, int endCost,
                                                        List<Flower> flowers) {
        return flowers.stream()
                .filter(flower -> flower.getStemLength() > beginStem && flower.getStemLength() < endStem)
                .filter(flower -> flower.getCost() > beginCost && flower.getCost() < endCost)
                .collect(Collectors.toList());
    }

    /**
     * This method check interval.
     *
     * @param start  start of interval
     * @param finish finish of interval
     * @throws FilterException start of interval should be less then end of interval
     */
    private static void checkInterval(int start, int finish) throws FilterException {
        if (start > finish) {
            throw new FilterException("Start of interval should be less then end of interval", start, finish);
        }
    }
}
