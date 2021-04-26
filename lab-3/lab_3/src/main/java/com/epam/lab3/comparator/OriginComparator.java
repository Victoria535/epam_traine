package com.epam.lab3.comparator;

import com.epam.lab3.model.Greenhouse;

import java.util.Comparator;

/**
 * Origin comparator of greenhouse.
 * <p>
 * Date: apr 16 2021
 *
 * @author Viktoria Symaniuk
 */
public class OriginComparator implements Comparator<Greenhouse> {
    @Override
    public int compare(Greenhouse greenhouse1, Greenhouse greenhouse2) {
        return greenhouse1.getOrigin().compareTo(greenhouse2.getOrigin());
    }
}
