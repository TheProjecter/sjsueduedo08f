package edu.sjsu.edo08f.xml;

import edu.sjsu.edo08f.objectWrappers.XmlParsingError;
import edu.sjsu.edo08f.support.ParserUtils;
import edu.sjsu.edo08f.exceptions.GeneralException;

import java.io.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.SchemaFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.jms.TextMessage;

import org.xml.sax.*;

/**
 * Created by: Alex Yarmula
 * Date: Nov 8, 2008
 */
public class XmlVerifier {

    public XmlParsingError verifyMessage(String testMessage ) {

        final XmlParsingError possibleErrors = new XmlParsingError();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(false);
            factory.setNamespaceAware(true);
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            factory.setSchema(schemaFactory.newSchema(new File("resources/inputSchema.xsd")));
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setErrorHandler(new ErrorHandler() {
                public void warning(SAXParseException e) throws SAXException {
                    // dont care about warnings
                }

                public void error(SAXParseException e) throws SAXException {
                    possibleErrors.add(e.toString());
                }

                public void fatalError(SAXParseException e) throws SAXException {
                    possibleErrors.add(e.toString());
                }
            });

            InputStream messageInputStream = ParserUtils.convertStringToInputStream(testMessage);

            InputSource inputSource = new InputSource(messageInputStream);

            reader.parse(inputSource);
        }

        catch (Exception e) {
            possibleErrors.add(e.toString());
        }

        return possibleErrors;


    }

}
