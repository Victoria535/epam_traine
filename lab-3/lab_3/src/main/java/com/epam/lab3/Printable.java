package com.epam.lab3;

import com.epam.lab3.model.Greenhouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    static void printGreenhouses(java.util.List<Greenhouse> greenhouses) {
        for (Greenhouse greenhouse : greenhouses) {
            LOGGER.info(greenhouse);
        }
    }

    /**
     * Method for print info.
     *
     * @param info String info for print
     */
    static void printInfo(String info) {
        LOGGER.info(String.format(info));
    }

    /**
     * Method for print error info.
     *
     * @param exception SAXParseException  exception
     * @return StringBuilder error
     */
    public static StringBuilder printErrorInfo(org.xml.sax.SAXParseException exception) {
        StringBuilder builder = new StringBuilder();
        builder.append(BRACKET_LEFT).append(exception.getLineNumber())
                .append(COLON).append(exception.getColumnNumber()).append(BRACKET_RIGHT);
        builder.append('\n').append(exception.getLocalizedMessage()).append('\n');
        return builder;
    }
}
