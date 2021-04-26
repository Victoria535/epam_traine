package com.epam.lab3.xml;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

import static com.epam.lab3.Printable.printErrorInfo;

/**
 * Greenhouse xml validator.
 * <p>
 * Date: apr 16 2021
 *
 * @author Viktoria Symaniuk
 */
public class GreenhouseXmlValidator implements XmlValidator {
    private static final String PROPERTY = "";
    /**
     * Field schema file for validate.
     */
    private final String schemaFile;
    /**
     * Field xml file for validate.
     */
    private final String xmlFile;
    /**
     * Filed error.
     */
    private final StringBuilder error = new StringBuilder();

    /**
     * Constructor for initialize field.
     *
     * @param schemaFile String field schemaFile
     * @param xmlFile    String field xmlFile
     */
    public GreenhouseXmlValidator(String schemaFile, String xmlFile) {
        this.schemaFile = schemaFile;
        this.xmlFile = xmlFile;
    }

    /**
     * @return xmlFile
     */
    public String getXmlFile() {
        return xmlFile;
    }

    /**
     * @return schemaFile
     */
    public String getSchemaFile() {
        return schemaFile;
    }

    @Override
    public boolean validate() throws IOException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            factory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, PROPERTY);
            factory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, PROPERTY);
            Schema schema = factory.newSchema(new File(getSchemaFile()));
            Validator validator = schema.newValidator();
            validator.setErrorHandler(this);
            validator.validate(new StreamSource(getXmlFile()));
            return getError() == null;
        } catch (SAXException e) {
            return false;
        }
    }

    /**
     * @return error
     */
    private String getError() {
        if (error.length() > 0) {
            return error.toString();
        } else {
            return null;
        }
    }

    @Override
    public void warning(SAXParseException exception) {
        error.append("WARNING: ");
        error.append(printErrorInfo(exception));
    }

    @Override
    public void error(SAXParseException exception) {
        error.append("ERROR: ");
        error.append(printErrorInfo(exception));
    }

    @Override
    public void fatalError(SAXParseException exception) {
        error.append("FATALERROR: ");
        error.append(printErrorInfo(exception));
    }
}
