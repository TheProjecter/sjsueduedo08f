package edu.sjsu.edo08f.support.converters;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import edu.sjsu.edo08f.domain.Person;


/**
 * Created by IntelliJ IDEA.
 * User: Tan Tan
 * Date: Dec 16, 2008
 * Time: 5:25:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonXMLConverter implements Converter{
    public boolean canConvert(Class clazz) {
            return clazz.equals(Person.class); 
    }

    public void marshal(Object value, HierarchicalStreamWriter writer,
                    MarshallingContext context) {
        Person person = (Person) value;

        writer.startNode("id");
        writer.setValue(person.getId().toString());
        writer.endNode();

        writer.startNode("first-name");
        writer.setValue(person.getFirstName());
        writer.endNode();

        writer.startNode("last-name");
        writer.setValue(person.getLastName());
        writer.endNode();

        writer.startNode("address");
        writer.setValue(person.getAddress());
        writer.endNode();

        writer.startNode("city");
        writer.setValue(person.getCity());
        writer.endNode();

        writer.startNode("state");
        writer.setValue(person.getState());
        writer.endNode();

        writer.startNode("zip-code");
        writer.setValue(person.getZipCode());
        writer.endNode();

        writer.startNode("type");
        writer.setValue(person.getType());
        writer.endNode();
        
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Person person = new Person();

        reader.moveDown();
        person.setId(Long.parseLong(reader.getValue().trim()));
        reader.moveUp();

        reader.moveDown();
        person.setFirstName(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        person.setLastName(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        person.setAddress(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        person.setCity(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        person.setState(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        person.setZipCode(reader.getValue());
        reader.moveUp();

        reader.moveDown();
        person.setType(reader.getValue());
        reader.moveUp();

        return person;
    }
}
