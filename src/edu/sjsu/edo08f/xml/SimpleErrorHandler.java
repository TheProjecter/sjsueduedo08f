package edu.sjsu.edo08f.xml;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
/**
 * Created by IntelliJ IDEA.
 * User: Sandip
 * Date: Nov 23, 2008
 * Time: 1:02:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleErrorHandler implements ErrorHandler {
    public void warning(SAXParseException e) throws SAXException {
        System.out.println(e.getMessage());
    }

    public void error(SAXParseException e) throws SAXException {
        System.out.println(e.getMessage());
    }

    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println(e.getMessage());
    }
    
}
