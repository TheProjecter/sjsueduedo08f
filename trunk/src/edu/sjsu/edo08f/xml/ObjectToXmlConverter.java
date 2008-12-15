package edu.sjsu.edo08f.xml;

import edu.sjsu.edo08f.exceptions.GeneralException;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Person;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.support.EventInformation;
import edu.sjsu.edo08f.support.converters.EventInformationConverter;
import com.thoughtworks.xstream.*;

import java.util.List;

/**
 * 
 * Created by: Oleksiy Yarmula
 * Date: Nov 8, 2008
 */
public class ObjectToXmlConverter {

    public ObjectToXmlConverter() {

    }

    public XStream getPersonServiceConverter () {

        XStream xs = new XStream();

        xs.aliasType("person", Person.class);

        xs.aliasField("first-name", Person.class, "firstName");
        xs.aliasField("last-name", Person.class, "lastName");
        xs.aliasField("zip-code", Person.class, "zipCode");

        return xs;
    }

    public XStream getStudentServiceConverter () {

        XStream xs = new XStream();

        xs.aliasType("student", Student.class);

        xs.aliasField("first-name", Person.class, "firstName");
        xs.aliasField("last-name", Person.class, "lastName");
        xs.aliasField("zip-code", Person.class, "zipCode");

        xs.aliasField("student-id", Student.class, "studentId");
        return xs;
    }

    public XStream getCourseServiceConverter () {

        XStream xs = new XStream();

        xs.aliasType("course", Course.class);

        xs.aliasField("meeting-hours", Course.class, "meetingHours");

        EventInformationConverter eventConverter = new EventInformationConverter();

        xs.registerLocalConverter(Course.class, "meetingHours", eventConverter);

        return xs;
    }

    public XStream getInstructorServiceConverter () {

        XStream xs = new XStream();

        xs.aliasType("instructor", Instructor.class);

        xs.aliasField("first-name", Person.class, "firstName");
        xs.aliasField("last-name", Person.class, "lastName");
        xs.aliasField("zip-code", Person.class, "zipCode");

        xs.aliasField("office-hours", Instructor.class, "officeHours");
        xs.aliasField("employee-id", Instructor.class, "employeeId");

        EventInformationConverter eventConverter = new EventInformationConverter();

        xs.registerLocalConverter(Instructor.class, "officeHours", eventConverter);

        return xs;        
    }



    private String getExceptionXmlTemplate() {
        return "<exception>\n" +
                        "\t<name>\n" +
                                "\t\t%s\n" +
                        "\t</name>\n" +
                        "\t<reason>\n" +
                                "\t\t%s\n" +
                        "\t</reason>\n" +
                "</exception>";
    }

    public String getBadXmlMessage (String reason) {
        return String.format (getExceptionXmlTemplate(), GeneralException.class.getName(), reason);
    }

    public String getExceptionXmlMessage (Exception exception) {
        return String.format (getExceptionXmlTemplate(), exception.getClass().getSimpleName(), exception.getMessage());
    }
    // Output for StudentServices

    public String getOutputForAllStudent(List<Student> student) {

        XStream xs = getStudentServiceConverter();
        String xml = xs.toXML(student);
        return  xml;
    }
    public String getOutputForGetByIdStudentService (Student student) {

        XStream xs = getStudentServiceConverter();
        String xml = xs.toXML(student);
        return  xml;
    }
    public String getOutputForCreateStudentService (Student student) {

        XStream xs = getStudentServiceConverter();
        String xml = xs.toXML(student);
        return  xml;
    }
    public String getOutputForUpdateStudentService (Student student) {

        XStream xs = getStudentServiceConverter();
        String xml = xs.toXML(student);
        return  xml;
    }

    public String getOutputForDeleteStudentService (Student student) {

        XStream xs = getStudentServiceConverter();
        String xml = xs.toXML(student);
        return  xml;
    }
    public String getOutputForGenerateInvoiceStudentService (String generatInvoice) {
        return String.format("<invoice>\n\t%s\n</invoice>", generatInvoice);
    }
    public String getOutputForgetAssociatedCoursesStudentService (List<Course> course) {

        XStream xs = getCourseServiceConverter();
        String xml = xs.toXML(course);
        return  xml;
    }

    // Output for PersonServices

    public String getOutputForAllPerson(List<Person> person) {
        XStream xs = getPersonServiceConverter();
        String xml = xs.toXML(person);
        return  xml;
    }
    public String getOutputForGetByIdPersonService (Person person) {
        XStream xs = getPersonServiceConverter();
        String xml = xs.toXML(person);
        return  xml;
    }
    public String getOutputForSearchPerson (List<Person> person) {
        XStream xs = getPersonServiceConverter();
        String xml = xs.toXML(person);
        return  xml;
    }
    
    // Output for InstructorServices

    public String getOutputForAllInstructor(List<Instructor> instructor) {

        XStream xs = getInstructorServiceConverter();
        String xml = xs.toXML(instructor);
        return  xml;
    }
    public String getOutputForGetByIdInstructorService (Instructor instructor) {

        XStream xs = getInstructorServiceConverter();
        String xml = xs.toXML(instructor);
        return  xml;
    }
    public String getOutputForCreateInstructorService (Instructor instructor) {

        XStream xs = getInstructorServiceConverter();
        String xml = xs.toXML(instructor);
        return  xml;
    }
    public String getOutputForUpdateInstructorService (Instructor instructor) {
        XStream xs = getInstructorServiceConverter();
        String xml = xs.toXML(instructor);
        return  xml;
    }
    public String getOutputForgetAssociatedCoursesInstructorService (List<Course> course) {
        XStream xs = getCourseServiceConverter();
        String xml = xs.toXML(course);
        return  xml;
    }

    // Output for CourseServices

    public String getOutputForAllCourse(List<Course> course) {
        XStream xs = getCourseServiceConverter();
        String xml = xs.toXML(course);
        return  xml;
    }
    public String getOutputForGetByIdCourseService(Course course) {
        XStream xs = getCourseServiceConverter();
        String xml = xs.toXML(course);
        return  xml;
    }
    public String getOutputForGetStudentsByCourseCourseService(List<Student> student) {

        XStream xs = getStudentServiceConverter();
        String xml = xs.toXML(student);
        return  xml;
    }
    public String getOutputForGetInstructorByCourseCourseService(Instructor instructor) {

        XStream xs = getInstructorServiceConverter();
        String xml = xs.toXML(instructor);
        return  xml;
    }
    public String getOutputForCreateCourseService(Course course) {
        XStream xs = getCourseServiceConverter();
        String xml = xs.toXML(course);
        return  xml;
    }
    public String getOutputForUpdateCourseService(Course course) {
        XStream xs = getCourseServiceConverter();
        String xml = xs.toXML(course);
        return  xml;
    }
    public String getOutputForSearchInstructorCourse(List<Course> course) {
        XStream xs = getCourseServiceConverter();
        String xml = xs.toXML(course);
        return  xml;
    }
}
