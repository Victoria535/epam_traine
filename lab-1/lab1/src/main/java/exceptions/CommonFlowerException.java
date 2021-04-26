package exceptions;

/**
 * CommonFlowerException.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public class CommonFlowerException extends RuntimeException {
    /**
     * Field arguments.
     */
    private final String[] arg;

    /**
     * Constructor for initialization filed.
     *
     * @param message String message exception
     * @param arg     String... arguments exception
     */
    public CommonFlowerException(String message, String... arg) {
        super(message);
        this.arg = arg;
    }

    /**
     * @return arg
     */
    public String[] getArg() {
        return arg;
    }
}
