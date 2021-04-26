package worker;

import model.Bouquet;
import model.flowers.Flower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Class for print some information.
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
    public static void printBouquet(Bouquet bouquet) {
        LOGGER.info(bouquet.toString());
    }

    /**
     * This method for print result.
     *
     * @param resultFlowers result flowers
     */
    public static void printResult(List<Flower> resultFlowers) {
        for (int i = 0; i < resultFlowers.size(); i++) {
            LOGGER.info("{}. stem length = {}. cost = {}",
                    resultFlowers.get(i).getName(), resultFlowers.get(i).getStemLength(),
                    resultFlowers.get(i).getCost());
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
