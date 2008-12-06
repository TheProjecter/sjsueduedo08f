package edu.sjsu.edo08f.xml;

import edu.sjsu.edo08f.objectWrappers.XmlParsingError;
import edu.sjsu.edo08f.exceptions.GeneralException;

/**
 * Created by: Alex Yarmula
 * Date: Nov 8, 2008
 */
public class XmlReceiver {

    private XmlVerifier xmlVerifier;
    private XmlParser xmlParser;
    private ObjectToXmlConverter objectToXmlConverter;

    public void setXmlVerifier(XmlVerifier xmlVerifier) {
        this.xmlVerifier = xmlVerifier;
    }

    public void setXmlParser(XmlParser xmlParser) {
        this.xmlParser = xmlParser;
    }

    public void setObjectToXmlConverter(ObjectToXmlConverter objectToXmlConverter) {
        this.objectToXmlConverter = objectToXmlConverter;
    }

    public String processRequest (String textMessage) {

        XmlParsingError possibleErrors = xmlVerifier.verifyMessage(textMessage);
        if (possibleErrors.isNotEmpty()) return getBadXmlMessage(possibleErrors.getErrorMessage());

        String resultToReturn = "";
        try {
            resultToReturn = xmlParser.parse(textMessage);
        } catch (GeneralException e) {
            return objectToXmlConverter.getExceptionXmlMessage (e);
        } catch (Exception e) {
            return getBadXmlMessage (e.getMessage());
        }

        return resultToReturn;

    }

    private String getBadXmlMessage (String reason) {
        return objectToXmlConverter.getBadXmlMessage(reason);
    }
}
