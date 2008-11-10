package edu.sjsu.edo08f.xml;

import edu.sjsu.edo08f.objectWrappers.XmlParsingError;

import java.io.File;

/**
 * Created by: Alex Yarmula
 * Date: Nov 8, 2008
 */
public class XmlVerifier {

    public XmlParsingError verifyMessage(String testMessage ) {

        XmlParsingError possibleErrors = new XmlParsingError();

        File xsdSchema = new File ("address-to-xsd");
        // verification happens here
        //fill possible errors file
        
        return possibleErrors;

        
    }

}
