package worker;

import model.flowers.Flower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Class for print some information.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public final class Printable {
    private static final Logger LOGGER = LogManager.getLogger(Printable.class);

    /**
     * Constructor.
     */
    private Printable() {
    }

    /**
     * Method for print bouquet.
     *
     * @param bouquet bouquet
     */
    public static void printBouquet(String bouquet) {
        LOGGER.info(bouquet);
    }

    /**
     * This method for print result.
     *
     * @param resultFlowers result flowers
     */
    public static void printResult(List<Flower> resultFlowers) {
        for (Flower resultFlower : resultFlowers) {
            LOGGER.info("{}. stem length = {}. cost = {}",
                    resultFlower.getName(), resultFlower.getStemLength(),
                    resultFlower.getCost());
        }
    }

    /**
     * Method for print info.
     *
     * @param info String info for print
     * @param arg  Object... object for print
     */
    public static void printInfo(String info, Object... arg) {
        LOGGER.info(info, arg);
    }

    /**
     * Method for print warning.
     *
     * @param info String info for print
     * @param arg  Object... object for print
     */
    public static void printWarning(String info, Object... arg) {
        LOGGER.warn(info, arg);
    }
}
