package com.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class for printing some information.
 * <p>
 * Date: apr 30 2021
 *
 * @author Viktoria Symaniuk
 */
public final class Printable {
    private static final Logger LOGGER = LogManager.getLogger(Printable.class);

    /**
     * Constructor.
     */
    private Printable() {
    }

    /**
     * Method for printing information.
     *
     * @param info String information of printing
     */
    public static void printInfo(String info) {
        LOGGER.info(info);
    }

    /**
     * Method for printing warning.
     *
     * @param warning String warning of printing
     */
    public static void printWarning(String warning) {
        LOGGER.warn(warning);
    }


}
