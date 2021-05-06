package com.epam.lab3;

import com.epam.lab3.model.Greenhouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXParseException;

import java.util.List;

/**
 * Class for print some information.
 * <p>
 * Date: apr 16 2021
 *
 * @author Viktoria Symaniuk
 */
public final class Printable {
    private static final Logger LOGGER = LogManager.getLogger(Printable.class);
    private static final String BRACKET_LEFT = "[";
    private static final String BRACKET_RIGHT = "]";
    private static final String COLON = ":";

    /**
     * Constructor.
     */
    private Printable() {
    }

    /**
     * Method for print list of greenhouses.
     *
     * @param greenhouses List<Greenhouse> list of greenhouses
     */
    static void printGreenhouses(List<Greenhouse> greenhouses) {
        for (Greenhouse greenhouse : greenhouses) {
            LOGGER.info(greenhouse);
        }
    }

    /**
     * Method for print warning.
     *
     * @param warning String warning for print
     */
    public static void printWarning(String warning) {
        LOGGER.warn(warning);
    }

    /**
     * Method for print information.
     *
     * @param info String information for print
     */
    public static void printInfo(String info) {
        LOGGER.info(info);
    }

    /**
     * Method for print error info.
     *
     * @param exception SAXParseException  exception
     * @return StringBuilder error
     */
    public static StringBuilder printErrorInfo(SAXParseException exception) {
        return new StringBuilder().append(BRACKET_LEFT).append(exception.getLineNumber())
                .append(COLON).append(exception.getColumnNumber()).append(BRACKET_RIGHT)
                .append('\n').append(exception.getLocalizedMessage()).append('\n');
    }
}
