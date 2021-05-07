package builder;

import exceptions.InvalidNumberException;
import model.Bouquet;
import model.accessories.Accessory;
import model.flowers.Flower;

import java.util.List;

import static builder.randomizer.FlowerRandomizer.randomFlower;
import static builder.randomizer.NumberRandomizer.randomNumber;
import static worker.Printable.printWarning;

/**
 * Bouquet builder.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public final class BouquetBuilder {

    /**
     * Constructor.
     */
    private BouquetBuilder() {
    }

    /**
     * This method use for creating a new bouquet.
     *
     * @param count       int                    count of flowers in bouquet
     * @param accessories List<Accessory>  list of accessories for new bouquet
     * @return Bouquet new bouquet
     * @see Accessory
     */
    public static Bouquet newBouquet(int count, List<Accessory> accessories) {
        checkNumber(count);
        List<Flower> flowers = randomFlower(count);

        return buildBouquet(accessories, flowers, getFlowerSum(flowers) + getAccessorySum(accessories));
    }

    /**
     * This method check count of flowers in bouquet.
     *
     * @param count count of flowers
     */
    private static void checkNumber(int count) {
        try {
            if (count < 0) {
                throw new InvalidNumberException("Number should be greater than 0", count);
            }
        } catch (InvalidNumberException ex) {
            printWarning(String.valueOf(ex));
        }
    }

    /**
     * This method build bouquet.
     *
     * @param accessoryList list of accessories
     * @param flowerList    list of flowers
     * @param cost          bouquet cost
     * @return bouquet
     * @see Bouquet
     */
    private static Bouquet buildBouquet(List<Accessory> accessoryList, List<Flower> flowerList, int cost) {
        Bouquet bouquet = new Bouquet();
        bouquet.setName("Bouquet №" + randomNumber(100));
        bouquet.setAccessory(accessoryList);
        bouquet.setFlowers(flowerList);
        bouquet.setCost(cost);
        return bouquet;
    }

    /**
     * This method get cost flowers in bouquet.
     *
     * @param flowers List<Flower> list of flowers in bouquet
     * @return cost flowers in bouquet
     */
    private static int getFlowerSum(List<Flower> flowers) {
        return flowers.stream().mapToInt(Flower::getCost).sum();
    }

    /**
     * This method get cost accessories in bouquet.
     *
     * @param accessories List<Accessory> list of accessories in bouquet
     * @return cost accessories in bouquet
     */
    private static int getAccessorySum(List<Accessory> accessories) {
        return accessories.stream().mapToInt(Accessory::getCost).sum();
    }
}
