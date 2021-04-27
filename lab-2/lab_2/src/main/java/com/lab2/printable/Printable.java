package com.lab2.printable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Class for printing some information.
 * <p>
 * Date: apr 25, 2021
 *
 * @author Symaniuk Victoryia
 */
public final class Printable {
    private static final Logger LOGGER = LogManager.getLogger(Printable.class);

    /**
     * Constructor.
     */
    private Printable() {
    }

    /**
     * Method for printing list.
     *
     * @param list printing this list
     */
    public static void printList(List<?> list) {
        for (Object elem : list) {
            LOGGER.info(elem);
        }
    }

    /**
     * Method for print info.
     *
     * @param info String info for print
     * @param arg  Object... object for print
     */
    public static void printInfo(String info, Object... arg) {
        LOGGER.info(info, arg);
    }

    /**
     * Method for print warning.
     *
     * @param warning String info for print
     * @param arg  Object... object for print
     */
    public static void printWarning(String warning, Object... arg) {
        LOGGER.warn(warning, arg);
    }
}
