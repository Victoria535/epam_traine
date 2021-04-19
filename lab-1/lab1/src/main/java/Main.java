import exceptions.FilterException;
import exceptions.InvalidNumberException;
import model.Bouquet;
import model.accessories.Accessory;

import java.util.List;
import java.util.logging.Logger;

import static builder.AccessoryBuilder.createAccessories;
import static builder.BouquetBuilder.newBouquet;
import static util.Util.findStemLength;
import static util.Util.findStemLengthAndCost;
import static util.Util.sortByFresh;

/**
 * Цветочница. Определить иерархию цветов. Создать несколько объектов-цветов.
 * Собрать букет (используя аксессуары) с определением его стоимости.
 * Провести сортировку цветов в букете на основе уровня свежести.
 * Найти цветок в букете, соответствующий заданному диапазону длин стеблей.
 */

public final class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.toString());

    /**
     * Constructor.
     */
    private Main() {
    }

    /**
     * This method is input point of program.
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
        int count;
        count = -5;
        checkNumber(count);
        count = 10;
        Bouquet bouquet = newBouquet(count, accessories);
        LOGGER.info(bouquet.toString());

        sortByFresh(bouquet);
        int begin = 70;
        int end = 0;
        invokeFind(bouquet, begin, end);
        begin = 20;
        end = 70;
        invokeFind(bouquet, begin, end);
    }

    /**
     * This method check count of flowers in bouquet.
     *
     * @param count count of flowers
     */
    private static void checkNumber(int count) {
        try {
            if (count < 0) {
                throw new InvalidNumberException("Number should be much 0", count);
            }
        } catch (InvalidNumberException ex) {
            ex.printStackTrace();
        }
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
            findStemLengthAndCost(bouquet, begin, end, startCost, finishCost);
            findStemLength(bouquet, begin, end);

        } catch (FilterException ex) {
            LOGGER.warning(ex.getMessage());
            LOGGER.warning("start = " + ex.getStart() + ", finish = " + ex.getFinish());
        }
    }
}

