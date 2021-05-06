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
import static com.epam.lab3.Printable.printInfo;
import static com.epam.lab3.Printable.printWarning;
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
     */
    public static void main(String[] args) {
        GreenhouseXmlValidator validator = new GreenhouseXmlValidator(SCHEMA_FILE_NAME, XML_FILE_NAME);
        try {
            if (validator.validate()) {
                List<Greenhouse> greenhouses = readFromFile();

                randomChanges(greenhouses);

                printInfo("Sort by temperature: ");
                greenhouses.sort(new TemperatureComparator());
                printGreenhouses(greenhouses);

                printInfo("\nSort by origin: ");
                greenhouses.sort(new OriginComparator());
                printGreenhouses(greenhouses);

                writeToFile(greenhouses);
            }
        } catch (IOException | XMLStreamException exception) {
            printWarning(String.valueOf(exception));
        }
    }

    /**
     * Method for writing to file greenhouses.
     *
     * @param greenhouses Greenhouse greenhouses
     * @see Greenhouse
     */
    private static void writeToFile(List<Greenhouse> greenhouses) {
        GreenhouseXmlWriter writer = new GreenhouseXmlWriter();
        writer.write(greenhouses, NEW_XML_FILE);
    }

    /**
     * Method for reading from file greenhouses.
     *
     * @return List list of greenhouses
     * @throws XMLStreamException exception
     * @see Greenhouse
     */
    private static List<Greenhouse> readFromFile() throws XMLStreamException {
        GreenhouseXmlReader reader = new GreenhouseXmlReader();
        return reader.read(XML_FILE_NAME);
    }
}
