package builder.randomizer;

import factory.FlowerFactory;
import model.enums.FlowerType;
import model.enums.RoseColor;
import model.flowers.Flower;
import model.flowers.Rose;

import java.util.ArrayList;
import java.util.List;

import static builder.randomizer.NumberRandomizer.randomNumber;
import static builder.randomizer.ParasiteRandomizer.randomParasite;

/**
 * Class for random flower.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public final class FlowerRandomizer {
    /**
     * Constructor.
     */
    private FlowerRandomizer() {
    }

    /**
     * This method get random flowers in bouquet.
     *
     * @param count count flowers in bouquet
     */
    public static List<Flower> randomFlower(int count) {
        List<Flower> flowers = new ArrayList<>();
        FlowerFactory flowerFactory = new FlowerFactory();
        for (int i = 0; i < count; i++) {
            int index = randomNumber(FlowerType.values().length);
            FlowerType flowerType = FlowerType.values()[index];
            if (flowerType.equals(FlowerType.ROSE)) {
                randomRose(flowers, flowerFactory, index);
            } else {
                flowers.add(flowerFactory.create(flowerType));
            }
        }
        randomParasite(flowers);
        return flowers;
    }

    /**
     * This method get random type of rose in the bouquet.
     *
     * @param flowers       List<Flower> flowers of bouquet
     * @param flowerFactory FlowerFactory types of flower
     * @param index         index rose in bouquet
     * @see FlowerFactory
     */
    private static void randomRose(List<Flower> flowers, FlowerFactory flowerFactory, int index) {
        int typeRose = randomTypeRose();
        Rose rose = (Rose) flowerFactory.create(FlowerType.values()[index]);
        rose.setRoseColor(RoseColor.values()[typeRose]);
        flowers.add(rose);
    }

    /**
     * This method get random type rose in bouquet.
     */
    private static int randomTypeRose() {
        return randomNumber(RoseColor.values().length);
    }
}
