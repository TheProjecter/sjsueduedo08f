package edu.sjsu.edo08f.support;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import edu.sjsu.edo08f.domain.Person;
import edu.sjsu.edo08f.support.converters.PersonXMLConverter;
import edu.sjsu.edo08f.support.converters.ConvertFromXML;
import edu.sjsu.edo08f.gui.PersonClient;

import javax.jms.JMSException;
import java.util.List;
import java.util.ArrayList;


/**
 * Created by IntelliJ IDEA.
 * User: francist
 * Date: Dec 16, 2008
 * Time: 5:38:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonTest {
    public static void main(String[] args) {

        String[][] personList;
        PersonClient personclient = new PersonClient();
        ConvertFromXML convert = new ConvertFromXML();
        String xml = new String();
        try {
//            xml = personclient.getAll();
            xml = personclient.search("firstName", "alex");
            personList = convert.PersonConvertFromXML(xml);
        } catch (JMSException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(xml);

    }
}
