package exceptions;

public class FilterException extends Exception {
    private final int start;
    private final int finish;

    public FilterException(String message, int start, int finish) {
        super(message);
        this.start = start;
        this.finish = finish;
    }

    public int getStart() {
        return start;
    }

    public int getFinish() {
        return finish;
    }
}
