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

/**
 * GreenhouseXmlReader.
 * <p>
 * Date: apr 16 2021
 *
 * @author Viktoria Symaniuk
 */
public class GreenhouseXmlReader implements XmlReader {
    private static final String PROPERTY = "";

    @Override
    public List<Greenhouse> read(String file) throws XMLStreamException {
        XMLStreamReader reader;
        List<Greenhouse> greenhouses = new ArrayList<>();
        Greenhouse greenhouse = null;
        XMLInputFactory factory = XMLInputFactory.newFactory();
        factory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, PROPERTY);
        factory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, PROPERTY);
        try (InputStream inputStream = new FileInputStream(file)) {
            reader = factory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        String tagName = reader.getLocalName();
                        if ("greenhouse".equals(tagName)) {
                            greenhouse = new Greenhouse();
                            greenhouse.setId(reader.getAttributeValue(null, "id"));
                        }
                        if (greenhouse != null) {
                            if ("name".equals(tagName)) {
                                greenhouse.setName(reader.getElementText());
                            } else if ("soil".equals(tagName)) {
                                greenhouse.setSoilType(SoilType.valueOf(reader.getElementText()));
                            } else if ("origin".equals(tagName)) {
                                greenhouse.setOrigin(reader.getElementText());
                            } else if ("colorStem".equals(tagName)) {
                                greenhouse.getParameters().setColorStem(reader.getElementText());
                            } else if ("colorLeaf".equals(tagName)) {
                                greenhouse.getParameters().setColorLeaf(reader.getElementText());
                            } else if ("mediumSize".equals(tagName)) {
                                greenhouse.getParameters().setMediumSize(Integer.valueOf(reader.getElementText()));
                            } else if ("temperature".equals(tagName)) {
                                greenhouse.getTips().setTemperature(Integer.valueOf(reader.getElementText()));
                            } else if ("lighting".equals(tagName)) {
                                greenhouse.getTips().setLighting(reader.getElementText());
                            } else if ("watering".equals(tagName)) {
                                greenhouse.getTips().setWatering(Integer.valueOf(reader.getElementText()));
                            } else if ("multiplying".equals(tagName)) {
                                greenhouse.setMultiplyingType(MultiplyingType.valueOf(reader.getElementText()));
                            }
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        tagName = reader.getLocalName();
                        if ("greenhouse".equals(tagName)) {
                            greenhouses.add(greenhouse);
                        }
                        break;
                    default:
                        throw new RuntimeException();
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return greenhouses;
    }
}
