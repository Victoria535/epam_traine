package com.epam.lab3.comparator;

import com.epam.lab3.model.Greenhouse;

import java.util.Comparator;

/**
 * Temperature comparator of greenhouse.
 * <p>
 * Date: apr 16 2021
 *
 * @author Viktoria Symaniuk
 */
public class TemperatureComparator implements Comparator<Greenhouse> {
    @Override
    public int compare(Greenhouse greenhouse1, Greenhouse greenhouse2) {
        return greenhouse1.getTips().getTemperature() - greenhouse2.getTips().getTemperature();
    }
}
