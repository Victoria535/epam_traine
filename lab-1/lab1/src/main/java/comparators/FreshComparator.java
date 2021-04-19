package comparators;

import model.flowers.Flower;

import java.util.Comparator;

public class FreshComparator implements Comparator<Flower> {
    @Override
    public int compare(Flower flower1, Flower flower2) {
        return flower1.getFresh() - flower2.getFresh();
    }
}
