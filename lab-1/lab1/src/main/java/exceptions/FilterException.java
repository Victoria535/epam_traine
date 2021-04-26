package exceptions;

/**
 * FilterException.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public class FilterException extends Exception {
    /**
     * Filed start interval for filter.
     */
    private final int start;
    /**
     * Filed finish interval for filter.
     */
    private final int finish;

    /**
     * Constructor for initialization filed.
     *
     * @param message String message exception
     * @param start   int start interval for filter
     * @param finish  int finish interval for filter
     */
    public FilterException(String message, int start, int finish) {
        super(message);
        this.start = start;
        this.finish = finish;
    }

    /**
     * @return start
     */
    public int getStart() {
        return start;
    }

    /**
     * @return finish
     */
    public int getFinish() {
        return finish;
    }
}
