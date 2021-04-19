package builder;

import exceptions.FlowerFreshException;
import factory.FlowerFactory;
import model.Bouquet;
import model.accessories.Accessory;
import model.enums.FlowerType;
import model.enums.RoseType;
import model.flowers.Flower;
import model.flowers.Rose;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public final class BouquetBuilder {
    private static final Random RANDOM = new Random();
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(BouquetBuilder.class));

    private BouquetBuilder() {
    }

    /**
     * This method use for creating a new bouquet.
     *
     * @param count       int                    count of flowers in bouquet
     * @param accessories List<Accessory>  list of accessories for new bouquet
     * @return new Bouquet
     * @see Accessory
     */
    public static Bouquet newBouquet(int count, List<Accessory> accessories) {
        List<Flower> flowers = randomFlower(count);

        return buildBouquet(accessories, flowers, getFlowerSum(flowers) + getAccessorySum(accessories));
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
     * This method is used to get a random number.
     *
     * @return int random number
     */
    private static int randomNumber(int number) {
        return RANDOM.nextInt(number);
    }

    /**
     * This method get random flowers in bouquet.
     *
     * @param count count flowers in bouquet
     */
    private static List<Flower> randomFlower(int count) {
        List<Flower> flowers = new ArrayList<>();
        FlowerFactory flowerFactory = new FlowerFactory();

        for (int i = 0; i < count; i++) {
            int index = randomNumber(FlowerType.values().length);
            FlowerType flowerType = FlowerType.values()[index];

            if (flowerType.equals(FlowerType.ROSE)) {
                randomRose(flowers, flowerFactory, index);
            } else {
                Flower flower = flowerFactory.createFlower(flowerType);
                flowers.add(flower);
            }
        }
        randomParasite(count, flowers);
        return flowers;
    }

    private static void randomParasite(int count, List<Flower> flowers) {
        flowers.get(randomNumber(count)).setParasite(true);
        try {
            checkFlowersForParasite(flowers);
        } catch (FlowerFreshException freshException) {
            LOGGER.warning(freshException.getMessage());
        }
    }


    private static void checkFlowersForParasite(List<Flower> flowers) throws FlowerFreshException {
        for (Flower flower : flowers) {
            if (checkParasite(flower)) {
                flower.setParasite(false);
                flower.setFresh(1);
                throw new FlowerFreshException("Cannot add not fresh flower in bouquet. Parasite is on this flower.");
            }
        }
    }

    private static boolean checkParasite(Flower flower) {
        return flower.isParasite();
    }

    private static void randomRose(List<Flower> flowers, FlowerFactory flowerFactory, int index) {
        int typeRose = randomTypeRose();
        Rose rose = (Rose) flowerFactory.createFlower(FlowerType.values()[index]);
        rose.setRoseColor(RoseType.values()[typeRose]);
        flowers.add(rose);
    }

    /**
     * This method get random type rose in bouquet.
     */
    private static int randomTypeRose() {
        return randomNumber(RoseType.values().length);
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
