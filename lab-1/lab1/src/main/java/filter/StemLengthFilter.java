package filter;

import model.flowers.Flower;

public class StemLengthFilter implements Filter {
    private final double start;
    private final double finish;

    public StemLengthFilter(double start, double finish) {
        this.start = start;
        this.finish = finish;
    }
    @Override
    public boolean check(Flower flower) {
        return flower.getStemLength() >= start && flower.getStemLength() <= finish;
    }
}
