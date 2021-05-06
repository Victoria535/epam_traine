package com.epam.lab3.xml;

import com.epam.lab3.model.Greenhouse;
import com.epam.lab3.model.MultiplyingType;
import com.epam.lab3.model.SoilType;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.epam.lab3.Printable.printWarning;
import static com.epam.lab3.xml.Element.COLOR_LEAF;
import static com.epam.lab3.xml.Element.COLOR_STEM;
import static com.epam.lab3.xml.Element.GREENHOUSE;
import static com.epam.lab3.xml.Element.LIGHTING;
import static com.epam.lab3.xml.Element.MEDIUM_SIZE;
import static com.epam.lab3.xml.Element.MULTIPLYING;
import static com.epam.lab3.xml.Element.NAME;
import static com.epam.lab3.xml.Element.ORIGIN;
import static com.epam.lab3.xml.Element.SOIL;
import static com.epam.lab3.xml.Element.TEMPERATURE;
import static com.epam.lab3.xml.Element.WATERING;

/**
 * GreenhouseXmlReader.
 * <p>
 * Date: apr 16 2021
 *
 * @author Viktoria Symaniuk
 */
public class GreenhouseXmlReader implements XmlReader {
    private static final String EMPTY_PROPERTY = "";

    @Override
    public List<Greenhouse> read(String file) throws XMLStreamException {
        XMLStreamReader reader;
        List<Greenhouse> greenhouses = new ArrayList<>();
        Greenhouse greenhouse = null;
        String tagName;
        XMLInputFactory factory = getXmlInputFactory();
        try (InputStream inputStream = new FileInputStream(file)) {
            reader = factory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    tagName = reader.getLocalName();
                    if (GREENHOUSE.equals(tagName)) {
                        greenhouse = new Greenhouse();
                        greenhouse.setId(reader.getAttributeValue(null, "id"));
                    }
                    if (greenhouse != null) {
                        newGreenhouse(greenhouse, tagName, reader);
                    }
                } else if (type == XMLStreamConstants.END_ELEMENT) {
                    tagName = reader.getLocalName();
                    if (GREENHOUSE.equals(tagName)) {
                        greenhouses.add(greenhouse);
                    }
                }
            }
        } catch (IOException exception) {
            printWarning(String.valueOf(exception));
        }
        return greenhouses;
    }

    /**
     * Method for getting XMLInputFactory.
     *
     * @return XMLInputFactory factory
     */
    private XMLInputFactory getXmlInputFactory() {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        factory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, EMPTY_PROPERTY);
        factory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, EMPTY_PROPERTY);
        return factory;
    }

    /**
     * Method for create new greenhouse from file.
     *
     * @param greenhouse Greenhouse
     * @param tagName    String the tag that is read from the file
     * @param reader     XMLStreamReader reader from file
     * @throws XMLStreamException exception
     * @see Greenhouse
     */
    private void newGreenhouse(Greenhouse greenhouse, String tagName, XMLStreamReader reader)
            throws XMLStreamException {
        if (NAME.equals(tagName)) {
            greenhouse.setName(reader.getElementText());
        } else if (SOIL.equals(tagName)) {
            greenhouse.setSoilType(SoilType.valueOf(reader.getElementText()));
        } else if (ORIGIN.equals(tagName)) {
            greenhouse.setOrigin(reader.getElementText());
        } else if (COLOR_STEM.equals(tagName)) {
            greenhouse.getParameters().setColorStem(reader.getElementText());
        } else if (COLOR_LEAF.equals(tagName)) {
            greenhouse.getParameters().setColorLeaf(reader.getElementText());
        } else if (MEDIUM_SIZE.equals(tagName)) {
            greenhouse.getParameters().setMediumSize(Integer.valueOf(reader.getElementText()));
        } else if (TEMPERATURE.equals(tagName)) {
            greenhouse.getTips().setTemperature(Integer.valueOf(reader.getElementText()));
        } else if (LIGHTING.equals(tagName)) {
            greenhouse.getTips().setLighting(reader.getElementText());
        } else if (WATERING.equals(tagName)) {
            greenhouse.getTips().setWatering(Integer.valueOf(reader.getElementText()));
        } else if (MULTIPLYING.equals(tagName)) {
            greenhouse.setMultiplyingType(MultiplyingType.valueOf(reader.getElementText()));
        }
    }
}
