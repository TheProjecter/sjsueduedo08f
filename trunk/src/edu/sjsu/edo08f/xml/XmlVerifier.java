package edu.sjsu.edo08f.xml;

import edu.sjsu.edo08f.objectWrappers.XmlParsingError;

import java.io.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.SchemaFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.jms.TextMessage;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 * Created by: Alex Yarmula
 * Date: Nov 8, 2008
 */
public class XmlVerifier {

    public XmlParsingError verifyMessage(String testMessage ) {

        XmlParsingError possibleErrors = new XmlParsingError();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(false);
            factory.setNamespaceAware(true);
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            factory.setSchema(schemaFactory.newSchema(new Source[] { new StreamSource("file:///C:/Users/Sandip/Desktop/XML/inputSchema.xsd") }));
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setErrorHandler(new SimpleErrorHandler());
            reader.parse(testMessage);
            //reader.parse(new InputSource("file:///C:/Users/Sandip/Desktop/XML/person.xml"));
            System.out.println("XML is valid");
            }

            catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
            }
        // verification happens here
        //fill possible errors file
        
        return possibleErrors;

        
    }

}
