package com.epam.lab3;

import com.epam.lab3.comparator.OriginComparator;
import com.epam.lab3.comparator.TemperatureComparator;
import com.epam.lab3.model.Greenhouse;
import com.epam.lab3.xml.GreenhouseXmlReader;
import com.epam.lab3.xml.GreenhouseXmlValidator;
import com.epam.lab3.xml.GreenhouseXmlWriter;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

import static com.epam.lab3.Printable.printGreenhouses;
import static com.epam.lab3.randomizer.RandomChangesGreenhouse.randomChanges;

/**
 * Main.
 * <p>
 * Date: apr 16 2021
 *
 * @author Viktoria Symaniuk
 */
public final class Main {
    private static final String SCHEMA_FILE_NAME = "greenhouses.xsd";
    private static final String XML_FILE_NAME = "greenhouses.xml";
    private static final String NEW_XML_FILE = "greenhouse_new.xml";

    /**
     * Constructor.
     */
    private Main() {
    }

    /**
     * Method for start algorithm of programs.
     *
     * @param args arguments
     * @throws IOException        exception in file
     * @throws XMLStreamException exception in XMLStream
     */
    public static void main(String[] args) throws IOException, XMLStreamException {
        GreenhouseXmlValidator validator = new GreenhouseXmlValidator(SCHEMA_FILE_NAME, XML_FILE_NAME);
        if (validator.validate()) {
            GreenhouseXmlReader reader = new GreenhouseXmlReader();
            List<Greenhouse> greenhouses = reader.read(XML_FILE_NAME);

            randomChanges(greenhouses);

            greenhouses.sort(new TemperatureComparator());
            printGreenhouses(greenhouses);

            greenhouses.sort(new OriginComparator());
            printGreenhouses(greenhouses);

            GreenhouseXmlWriter writer = new GreenhouseXmlWriter();
            writer.write(greenhouses, NEW_XML_FILE);
        }
    }
}
