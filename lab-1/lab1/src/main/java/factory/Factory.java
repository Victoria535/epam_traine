package factory;

import model.enums.AbstractType;

/**
 * Factory.
 * @param <T> objects
 * @param <U> type for create
 * <p>
 * Date: apr 16, 2021
 *
 * @author Symaniuk Victoryia
 */
public interface Factory<T, U extends AbstractType> {
    /**
     * Method for create objects.
     *
     * @param type U type for create
     * @return T objects
     */
    T create(U type);
}
