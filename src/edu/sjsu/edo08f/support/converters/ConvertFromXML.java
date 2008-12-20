package edu.sjsu.edo08f.support.converters;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import edu.sjsu.edo08f.domain.Person;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.gui.CourseDataForGUI;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: TanTan
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

    public String[][] StudentConvertFromXML(String xml){

        XStream xStream = new XStream(new DomDriver());
        Converter myConvert = new StudentXMLConverter();
        xStream.registerConverter(myConvert);
        xStream.alias("student", Student.class);

        Student student;

        List<Student> studentList = (List<Student>)xStream.fromXML(xml);
        String[][] returnTable = new String[studentList.size()][9];

        for ( int i=0; i< studentList.size(); i++ ){
            student = studentList.get(i);
            returnTable[i][0] = "" + student.getId();
            returnTable[i][1] = student.getFirstName();
            returnTable[i][2] = student.getLastName();
            returnTable[i][3] = student.getAddress();
            returnTable[i][4] = student.getCity();
            returnTable[i][5] = student.getState();
            returnTable[i][6] = student.getZipCode();
            returnTable[i][7] = student.getType();
            returnTable[i][8] = student.getStudentId();        }
        return returnTable;
    }

    public String[][] CourseConvertFromXML(String xml) {

        XStream xStream = new XStream(new DomDriver());
        Converter myConvert = new CourseXMLConverter();
        xStream.registerConverter(myConvert);
        xStream.alias("course", CourseDataForGUI.class);

        CourseDataForGUI course;

        List<CourseDataForGUI> courseList = (List<CourseDataForGUI>)xStream.fromXML(xml);
        String[][] returnTable = new String[courseList.size()][6];

        for ( int i=0; i< courseList.size(); i++ ){
            course = courseList.get(i);
            returnTable[i][0] = course.id;
            returnTable[i][1] = course.name;
            returnTable[i][2] = course.section;
            returnTable[i][3] = course.meetingHours;
            returnTable[i][4] = course.location;
            returnTable[i][5] = course.units;
         }
        return returnTable;
    }
}
