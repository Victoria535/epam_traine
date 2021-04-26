package com.epam.lab3.xml;

import org.xml.sax.ErrorHandler;

import java.io.IOException;

/**
 * Xml validator.
 * <p>
 * Date: apr 16 2021
 *
 * @author Viktoria Symaniuk
 */
public interface XmlValidator extends ErrorHandler {
    /**
     * Method for validation xml file.
     *
     * @return boolean validate or not validate
     * @throws IOException exception
     */
    boolean validate() throws IOException;
}
