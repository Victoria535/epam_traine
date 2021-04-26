package worker;

import exceptions.FilterException;
import model.Bouquet;
import model.accessories.Accessory;

import java.util.List;

import static builder.AccessoryBuilder.createAccessories;
import static builder.BouquetBuilder.newBouquet;
import static util.Util.findStemLength;
import static util.Util.findStemLengthAndCost;
import static util.Util.sortByFresh;
import static worker.Printable.printBouquet;
import static worker.Printable.printWarning;

/**
 * Main.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public final class Main {

    /**
     * Constructor.
     */
    private Main() {
    }

    /**
     * This method is input point of program.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        startAlgorithm();
    }

    /**
     * This method is start algorithm.
     * In this method create a new bouquet, call sorting in the bouquet and finding in interval.
     */
    private static void startAlgorithm() {
        List<Accessory> accessories = createAccessories();
        int count = 10;
        Bouquet bouquet = newBouquet(count, accessories);
        printBouquet(bouquet);
        sortByFresh(bouquet);
        int begin = 70;
        int end = 20;
        invokeFind(bouquet, begin, end);
        begin = 20;
        end = 40;
        invokeFind(bouquet, begin, end);
    }

    /**
     * This method invoke method find the length of the stem in bouquet.
     *
     * @param bouquet bouquet flowers
     * @param begin   the beginning is the interval by which will find the length of the stem in the bouquet
     * @param end     the end is the interval by which will find the length of the stem in the bouquet
     */
    private static void invokeFind(Bouquet bouquet, int begin, int end) {
        int startCost = 1;
        int finishCost = 10;
        try {
            findStemLength(bouquet, begin, end);
            findStemLengthAndCost(bouquet, begin, end, startCost, finishCost);
        } catch (FilterException ex) {
            printWarning("%s. start = %s, finish = %s.", ex.getMessage(), ex.getStart(), ex.getFinish());
        }
    }
}


