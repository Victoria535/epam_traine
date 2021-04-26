package builder.randomizer;

import java.util.Random;

/**
 * Class for random number.
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public final class NumberRandomizer {
    private static final Random RANDOM = new Random();

    /**
     * Constructor.
     */
    private NumberRandomizer() {
    }

    /**
     * This method is used to get a random number.
     *
     * @return int random number
     */
    public static int randomNumber(int number) {
        return RANDOM.nextInt(number);
    }
}
