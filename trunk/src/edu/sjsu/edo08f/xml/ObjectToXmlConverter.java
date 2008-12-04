package edu.sjsu.edo08f.xml;

import edu.sjsu.edo08f.exceptions.GeneralException;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Person;
import edu.sjsu.edo08f.domain.Instructor;
import com.thoughtworks.xstream.*;

import java.util.List;

/**
 * Created by: Alex Yarmula
 * Date: Nov 8, 2008
 */
public class ObjectToXmlConverter {

    XStream xs = new XStream();
    String xml;
    private String getExceptionXmlTemplate() {
        return "<exception>" +
                        "<name>" +
                                "%s" +
                        "</name>" +
                        "<reason>" +
                                "%s" +
                        "</reason>" +
                "</exception>";
    }

    public String getBadXmlMessage (String reason) {
        return String.format (getExceptionXmlTemplate(), GeneralException.class.getName(), reason);
    }

    public String getExceptionXmlMessage (Exception exception) {
        return String.format (getExceptionXmlTemplate(), exception.getClass().getName(), exception.getMessage());
    }
    // Output for StudentServices

    public String getOutputForAllStudent(List<Student> student) {
        xml  = xs.toXML(student);
        return  xml;
    }
    public String getOutputForGetByIdStudentService (Student student) {
        xml  = xs.toXML(student);
        return  xml;
    }
    public String getOutputForCreateStudentService (Student student) {
        xml  = xs.toXML(student);
        return  xml;
    }
    public String getOutputForUpdateStudentService (Student student) {
        xml  = xs.toXML(student);
        return  xml;
    }

    public String getOutputForDeleteStudentService (Student student) {
        xml  = xs.toXML(student);
        return  xml;
    }
    public String getOutputForGenerateInvoiceStudentService (String generatInvoice) {
        xml  = xs.toXML(generatInvoice);
        return  xml;
    }
    public String getOutputForgetAssociatedCoursesStudentService (List<Course> course) {
        xml  = xs.toXML(course);
        return  xml;
    }

    // Output for PersonServices

    public String getOutputForAllPerson(List<Person> person) {
        xml  = xs.toXML(person);
        return  xml;
    }
    public String getOutputForGetByIdPersonService (Person person) {
        xml  = xs.toXML(person);
        return  xml;
    }
    public String getOutputForSearchPerson (List<Person> person) {
        xml  = xs.toXML(person);
        return  xml;
    }
    
    // Output for InstructorServices

    public String getOutputForAllInstructor(List<Instructor> instructor) {
        xml  = xs.toXML(instructor);
        return  xml;
    }
    public String getOutputForGetByIdInstructorService (Instructor instructor) {
        xml  = xs.toXML(instructor);
        return  xml;
    }
    public String getOutputForCreateInstructorService (Instructor instructor) {
        xml  = xs.toXML(instructor);
        return  xml;
    }
    public String getOutputForUpdateInstructorService (Instructor instructor) {
        xml  = xs.toXML(instructor);
        return  xml;
    }
    public String getOutputForgetAssociatedCoursesInstructorService (List<Course> course) {
        xml  = xs.toXML(course);
        return  xml;
    }

    // Output for CourseServices

    public String getOutputForAllCourse(List<Course> course) {
        xml  = xs.toXML(course);
        return  xml;
    }
    public String getOutputForGetByIdCourseService(Course course) {
        xml  = xs.toXML(course);
        return  xml;
    }
    public String getOutputForGetStudentsByCourseCourseService(List<Student> student) {
        xml  = xs.toXML(student);
        return  xml;
    }
    public String getOutputForGetInstructorByCourseCourseService(Instructor instructor) {
        xml  = xs.toXML(instructor);
        return  xml;
    }
    public String getOutputForCreateCourseService(Course course) {
        xml  = xs.toXML(course);
        return  xml;
    }
    public String getOutputForUpdateCourseService(Course course) {
        xml  = xs.toXML(course);
        return  xml;
    }
    public String getOutputForSearchInstructorCourse(List<Course> course) {
        xml  = xs.toXML(course);
        return  xml;
    }
}
