package edu.sjsu.edo08f.xml;

import edu.sjsu.edo08f.objectWrappers.XmlParsingError;

/**
 * Created by: Alex Yarmula
 * Date: Nov 8, 2008
 */
public class XmlReceiver {

    private XmlVerifier xmlVerifier;
    private XmlParser xmlParser;
    private ObjectToXmlConverter objectToXmlConverter;

    public XmlReceiver() {
        this.xmlVerifier = new XmlVerifier ();
        this.xmlParser = new XmlParser ();
        this.objectToXmlConverter = new ObjectToXmlConverter();
    }

    public String processRequest (String textMessage) {

        XmlParsingError possibleErrors = xmlVerifier.verifyMessage(textMessage);
        if (possibleErrors.isNotEmpty()) return getBadXmlMessage(possibleErrors.getErrorMessage()); 

       return xmlParser.parse(textMessage);

    }

    private String getBadXmlMessage (String reason) {
        return objectToXmlConverter.getBadXmlMessage(reason);
    }

}
