package builder.randomizer;

import exceptions.FlowerFreshException;
import model.flowers.Flower;

import java.util.List;

import static builder.randomizer.NumberRandomizer.randomNumber;
import static worker.Printable.printWarning;

/**
 * Class for random parasite.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public final class ParasiteRandomizer {
    /**
     * Constructor.
     */
    private ParasiteRandomizer() {
    }

    /**
     * This method get parasite in random flower.
     *
     * @param flowers flowers of bouquet
     */
    public static void randomParasite(List<Flower> flowers) {
        flowers.get(randomNumber(flowers.size())).setParasite(true);
        try {
            checkFlowersForParasite(flowers);
        } catch (FlowerFreshException freshException) {
            printWarning(freshException.getMessage());
        }
    }

    /**
     * This method check flowers for parasite.
     *
     * @param flowers List<Flower> flowers of bouquet
     * @throws FlowerFreshException cannot add not fresh flower in bouquet
     */
    private static void checkFlowersForParasite(List<Flower> flowers) throws FlowerFreshException {
        for (Flower flower : flowers) {
            if (checkParasite(flower)) {
                flower.setParasite(false);
                flower.setFresh(1);
                throw new FlowerFreshException("Cannot add not fresh flower in bouquet. Parasite is on this flower.");
            }
        }
    }

    /**
     * This method check flower on parasite.
     *
     * @param flower List<Flower> flowers of bouquet
     * @return true, if the flower has a parasite, false in the opposite case
     */
    private static boolean checkParasite(Flower flower) {
        return flower.isParasite();
    }

}
