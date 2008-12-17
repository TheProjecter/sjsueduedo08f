package edu.sjsu.edo08f.support.converters;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import edu.sjsu.edo08f.domain.Person;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Tan Tan
 * Date: Dec 16, 2008
 * Time: 6:56:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConvertFromXML {
    public String[][] PersonConvertFromXML(String xml){

        XStream xStream = new XStream(new DomDriver());
        Converter myConvert = new PersonXMLConverter();
        xStream.registerConverter(myConvert);
        xStream.alias("person", Person.class);

        Person person;

        List<Person> personList = (List<Person>)xStream.fromXML(xml);
        String[][] returnTable = new String[personList.size()][8];

        for ( int i=0; i< personList.size(); i++ ){
            person = personList.get(i);
            returnTable[i][0] = "" + person.getId();
            returnTable[i][1] = person.getFirstName();
            returnTable[i][2] = person.getLastName();
            returnTable[i][3] = person.getAddress();
            returnTable[i][4] = person.getCity();
            returnTable[i][5] = person.getState();
            returnTable[i][6] = person.getZipCode();
            returnTable[i][7] = person.getType();
        }
        return returnTable;
    }
}
