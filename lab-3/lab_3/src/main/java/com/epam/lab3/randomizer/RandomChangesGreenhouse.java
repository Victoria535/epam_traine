package com.epam.lab3.randomizer;

import com.epam.lab3.model.Greenhouse;

import java.util.List;
import java.util.Random;

/**
 * Class for random changes of greenhouse.
 * <p>
 * Date: apr 16 2021
 *
 * @author Viktoria Symaniuk
 */
public final class RandomChangesGreenhouse {
    private static final Random RANDOM = new Random();

    /**
     * Constructor.
     */
    private RandomChangesGreenhouse() {
    }

    /**
     * Method for random changes in greenhouse.
     *
     * @param greenhouses List<Greenhouse> list of greenhouse
     */
    public static void randomChanges(List<Greenhouse> greenhouses) {
        for (Greenhouse greenhouse : greenhouses) {
            greenhouse.getParameters().setMediumSize(greenhouse.getParameters().getMediumSize() + RANDOM.nextInt(100));
            greenhouse.getTips().setWatering(greenhouse.getTips().getWatering() + RANDOM.nextInt(200));
        }
    }
}
