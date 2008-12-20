package edu.sjsu.edo08f.support.converters;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import edu.sjsu.edo08f.domain.Person;
import edu.sjsu.edo08f.domain.Student;


/**
 * Created by IntelliJ IDEA.
 * User: Tan Tan
 * Date: Dec 16, 2008
 * Time: 5:25:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class StudentXMLConverter implements Converter{
    public boolean canConvert(Class clazz) {
            return clazz.equals(Student.class);
    }

    public void marshal(Object value, HierarchicalStreamWriter writer,
                    MarshallingContext context) {
        Student student = (Student) value;

        writer.startNode("id");
        writer.setValue(student.getId().toString());
        writer.endNode();

        writer.startNode("first-name");
        writer.setValue(student.getFirstName());
        writer.endNode();

        writer.startNode("last-name");
        writer.setValue(student.getLastName());
        writer.endNode();

        writer.startNode("address");
        writer.setValue(student.getAddress());
        writer.endNode();

        writer.startNode("city");
        writer.setValue(student.getCity());
        writer.endNode();

        writer.startNode("state");
        writer.setValue(student.getState());
        writer.endNode();

        writer.startNode("zip-code");
        writer.setValue(student.getZipCode());
        writer.endNode();

        writer.startNode("type");
        writer.setValue(student.getType());
        writer.endNode();

        writer.startNode("student-id");
        writer.setValue(student.getStudentId());
        writer.endNode();    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Student student = new Student();
        //id
        reader.moveDown();
        student.setId(Long.parseLong(reader.getValue().trim()));
        reader.moveUp();
        //First Name
        reader.moveDown();
        student.setFirstName(reader.getValue());
        reader.moveUp();
        //Last Name
        reader.moveDown();
        student.setLastName(reader.getValue());
        reader.moveUp();
        //Address
        reader.moveDown();
        student.setAddress(reader.getValue());
        reader.moveUp();
        //City
        reader.moveDown();
        student.setCity(reader.getValue());
        reader.moveUp();
        //State
        reader.moveDown();
        student.setCity(reader.getValue());
        reader.moveUp();
        //Zip
        reader.moveDown();
        student.setState(reader.getValue());
        reader.moveUp();
        //type
        reader.moveDown();
        student.setZipCode(reader.getValue());
        reader.moveUp();
        //student-id
        reader.moveDown();
        student.setType(reader.getValue());
        reader.moveUp();

        return student;
    }
}