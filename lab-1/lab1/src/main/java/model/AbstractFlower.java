package model;

public abstract class AbstractFlower extends AbstractField {
    private int fresh;
    private double stemLength;
    private boolean parasite;

    public boolean isParasite() {
        return parasite;
    }

    public void setParasite(boolean parasite) {
        if (parasite) {
            setFresh(0);
        }
        this.parasite = parasite;
    }

    public int getFresh() {
        return fresh;
    }

    public void setFresh(int fresh) {
        this.fresh = fresh;
    }

    public double getStemLength() {
        return stemLength;
    }

    public void setStemLength(double stemLength) {
        this.stemLength = stemLength;
    }
}
