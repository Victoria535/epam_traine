package com.epam.lab3.xml;

import com.epam.lab3.model.Greenhouse;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            writer = factory.createXMLStreamWriter(output, "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("greenhouses");
            writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute("xmlns", "http://www.example.org/greenhouses");
            writer.writeAttribute("xsi:schemaLocation", "http://www.example.org/greenhouses greenhouses.xsd");
            for (Greenhouse greenhouse : greenhouses) {
                writer.writeStartElement("greenhouse");
                writer.writeAttribute("id", greenhouse.getId());
                writer.writeStartElement("name");
                writer.writeCharacters(greenhouse.getName());
                writer.writeEndElement();
                writer.writeStartElement("soil");
                writer.writeCharacters(greenhouse.getSoilType().toString());
                writer.writeEndElement();
                writer.writeStartElement("origin");
                writer.writeCharacters(greenhouse.getOrigin());
                writer.writeEndElement();

                writer.writeStartElement("visual-parameters");
                writer.writeStartElement("colorStem");
                writer.writeCharacters(greenhouse.getParameters().getColorStem());
                writer.writeEndElement();
                writer.writeStartElement("colorLeaf");
                writer.writeCharacters(greenhouse.getParameters().getColorLeaf());
                writer.writeEndElement();
                writer.writeStartElement("mediumSize");
                writer.writeCharacters(String.valueOf(greenhouse.getParameters().getMediumSize()));
                writer.writeEndElement();
                writer.writeEndElement();

                writer.writeStartElement("growing-tips");
                writer.writeStartElement("temperature");
                writer.writeCharacters(String.valueOf(greenhouse.getTips().getTemperature()));
                writer.writeEndElement();
                writer.writeStartElement("lighting");
                writer.writeCharacters(greenhouse.getTips().getLighting());
                writer.writeEndElement();
                writer.writeStartElement("watering");
                writer.writeCharacters(String.valueOf(greenhouse.getTips().getWatering()));
                writer.writeEndElement();
                writer.writeEndElement();

                writer.writeStartElement("multiplying");
                writer.writeCharacters(greenhouse.getMultiplyingType().toString());
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
        } catch (XMLStreamException | IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (XMLStreamException exception) {
                exception.printStackTrace();
            }
        }
    }
}
