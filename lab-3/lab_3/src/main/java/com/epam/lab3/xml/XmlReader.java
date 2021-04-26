package com.epam.lab3.xml;

import com.epam.lab3.model.Greenhouse;

import javax.xml.stream.XMLStreamException;
import java.util.List;

/**
 * Xml reader.
 * <p>
 * Date: apr 16 2021
 *
 * @author Viktoria Symaniuk
 */
public interface XmlReader {
    /**
     * Method for reading xml file.
     *
     * @param file String name of file
     * @return List<Greenhouse> list of greenhouse
     * @throws XMLStreamException exception
     */
    List<Greenhouse> read(String file) throws XMLStreamException;
}
