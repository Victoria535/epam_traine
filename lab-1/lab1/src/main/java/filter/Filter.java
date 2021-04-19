package filter;

import model.flowers.Flower;

public interface Filter {
    boolean check(Flower flower);
}
