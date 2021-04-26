package exceptions;

/**
 * InvalidNumberException.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public class InvalidNumberException extends CommonFlowerException {

    /**
     * Constructor with parameter number.
     *
     * @param message String message exception
     * @param number  int number
     */
    public InvalidNumberException(String message, int number) {
        super(message, String.valueOf(number));
    }

    /**
     * Constructor.
     *
     * @param message String message exception
     */
    public InvalidNumberException(String message) {
        super(message);
    }

}
