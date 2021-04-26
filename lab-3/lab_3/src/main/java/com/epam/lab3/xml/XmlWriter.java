package com.epam.lab3.xml;

import com.epam.lab3.model.Greenhouse;

import java.util.List;

/**
 * Xml writer.
 * <p>
 * Date: apr 16 2021
 *
 * @author Viktoria Symaniuk
 */
public interface XmlWriter {
    /**
     * Method for writing into xml file.
     *
     * @param greenhouses List<Greenhouse> list of greenhouses
     * @param fileName    String name of file
     */
    void write(List<Greenhouse> greenhouses, String fileName);
}
