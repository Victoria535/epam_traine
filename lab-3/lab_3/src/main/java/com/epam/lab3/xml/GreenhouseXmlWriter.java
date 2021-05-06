package com.epam.lab3.xml;

import com.epam.lab3.model.Greenhouse;
import javanet.staxutils.IndentingXMLStreamWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static com.epam.lab3.Printable.printWarning;
import static com.epam.lab3.xml.Element.COLOR_LEAF;
import static com.epam.lab3.xml.Element.COLOR_STEM;
import static com.epam.lab3.xml.Element.GREENHOUSE;
import static com.epam.lab3.xml.Element.GROWING_TIPS;
import static com.epam.lab3.xml.Element.ID;
import static com.epam.lab3.xml.Element.LIGHTING;
import static com.epam.lab3.xml.Element.MEDIUM_SIZE;
import static com.epam.lab3.xml.Element.MULTIPLYING;
import static com.epam.lab3.xml.Element.NAME;
import static com.epam.lab3.xml.Element.ORIGIN;
import static com.epam.lab3.xml.Element.SOIL;
import static com.epam.lab3.xml.Element.TEMPERATURE;
import static com.epam.lab3.xml.Element.VISUAL_PARAMETERS;
import static com.epam.lab3.xml.Element.WATERING;

/**
 * Greenhouse xml writer.
 * <p>
 * Date: apr 16 2021
 *
 * @author Viktoria Symaniuk
 */
public class GreenhouseXmlWriter implements XmlWriter {
    @Override
    public void write(List<Greenhouse> greenhouses, String fileName) {
        XMLStreamWriter writer = null;
        try (FileOutputStream output = new FileOutputStream(fileName)) {
            XMLOutputFactory factory = getOutputFactory();
            writer = new IndentingXMLStreamWriter(factory.createXMLStreamWriter(output, "UTF-8"));
            addHeader(writer);
            for (Greenhouse greenhouse : greenhouses) {
                writer.writeStartElement(GREENHOUSE);
                writer.writeAttribute(ID, greenhouse.getId());

                addElement(writer, NAME, greenhouse.getName());
                addElement(writer, SOIL, greenhouse.getSoilType().toString());
                addElement(writer, ORIGIN, greenhouse.getOrigin());
                addVisualParameters(writer, greenhouse);
                addGrowingTips(writer, greenhouse);
                addElement(writer, MULTIPLYING, greenhouse.getMultiplyingType().toString());

                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
        } catch (XMLStreamException | IOException exception) {
            printWarning(String.valueOf(exception));
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (XMLStreamException exception) {
                printWarning(String.valueOf(exception));
            }
        }
    }

    /**
     * Method for getting XMLOutputFactory.
     *
     * @return XMLOutputFactory factory
     */
    private XMLOutputFactory getOutputFactory() {
        return XMLOutputFactory.newFactory();
    }

    /**
     * Method for writing header for xml file.
     *
     * @param writer XMLStreamWriter writer for writing
     * @throws XMLStreamException exception
     * @see Greenhouse
     */
    private void addHeader(XMLStreamWriter writer) throws XMLStreamException {
        writer.writeStartDocument("UTF-8", "1.0");
        writer.writeStartElement("greenhouses");
        writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        writer.writeAttribute("xmlns", "http://www.example.org/greenhouses");
        writer.writeAttribute("xsi:schemaLocation", "http://www.example.org/greenhouses greenhouses.xsd");
    }

    /**
     * Method for add element.
     *
     * @param writer           XMLStreamWriter writer for writing
     * @param element          String element for xml file
     * @param characterElement String character for element
     * @throws XMLStreamException exception
     */
    private void addElement(XMLStreamWriter writer, String element, String characterElement) throws XMLStreamException {
        writer.writeStartElement(element);
        writer.writeCharacters(characterElement);
        writer.writeEndElement();
    }

    /**
     * Method for writing visual parameters.
     *
     * @param writer     XMLStreamWriter writer for writing
     * @param greenhouse Greenhouse greenhouse
     * @throws XMLStreamException exception
     * @see Greenhouse
     */
    private void addVisualParameters(XMLStreamWriter writer, Greenhouse greenhouse) throws XMLStreamException {
        writer.writeStartElement(VISUAL_PARAMETERS);

        addElement(writer, COLOR_STEM, greenhouse.getParameters().getColorStem());
        addElement(writer, COLOR_LEAF, greenhouse.getParameters().getColorLeaf());
        addElement(writer, MEDIUM_SIZE, String.valueOf(greenhouse.getParameters().getMediumSize()));

        writer.writeEndElement();
    }

    /**
     * Method for writing growing tips.
     *
     * @param writer     XMLStreamWriter writer for writing
     * @param greenhouse Greenhouse greenhouse
     * @throws XMLStreamException exception
     * @see Greenhouse
     */
    private void addGrowingTips(XMLStreamWriter writer, Greenhouse greenhouse) throws XMLStreamException {
        writer.writeStartElement(GROWING_TIPS);

        addElement(writer, TEMPERATURE, String.valueOf(greenhouse.getTips().getTemperature()));
        addElement(writer, LIGHTING, greenhouse.getTips().getLighting());
        addElement(writer, WATERING, String.valueOf(greenhouse.getTips().getWatering()));

        writer.writeEndElement();
    }
}
