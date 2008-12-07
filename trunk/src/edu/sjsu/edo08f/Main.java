package edu.sjsu.edo08f;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import edu.sjsu.edo08f.dao.PersonDao;
import edu.sjsu.edo08f.domain.Person;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.services.PersonService;
import edu.sjsu.edo08f.services.StudentService;
import edu.sjsu.edo08f.services.InstructorService;
import edu.sjsu.edo08f.services.CourseService;
import edu.sjsu.edo08f.services.utils.SearchUtils;
import edu.sjsu.edo08f.support.EventInformation;
import edu.sjsu.edo08f.support.DayOfWeek;
import edu.sjsu.edo08f.xml.XmlReceiver;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by: Alex Yarmula
 * Date: Nov 10, 2008
 */
public class Main {

    public static void main (String[] args) {

        String[] text = new String[] {

//                "<request>" +
//                "        <studentService>" +
//                "            <getAll/>" +
//                "        </studentService>" +
//                "    </request>",
//
//                "<request>" +
//                        "        <courseService>" +
//                        "            <getAll/>" +
//                        "        </courseService>" +
//                        "    </request>",
//
//                "<request>" +
//                        "        <instructorService>" +
//                        "            <getAll/>" +
//                        "        </instructorService>" +
//                        "    </request>",
//
//                "<request>" +
//                        "        <personService>" +
//                        "            <getAll/>" +
//                        "        </personService>" +
//                        "    </request>",
//
//                "<request>" +
//                        "        <personService>" +
//                        "            <getById>" +
//                        "                   <id>1</id>" +
//                        "            </getById>" +
//                        "        </personService>" +
//                        "    </request>",

                "<request>" +
                        "        <instructorService>" +
                        "            <create>" +
                        "<instructor>" +
                                    "  <first-name>Dan</first-name>" +
                                    "  <last-name>Harkey</last-name>" +
                                    "  <address>A Good Place</address>" +
                                    "  <city>San Jose</city>" +
                                    "  <state>CA</state>" +
                                    "  <zip-code>95118</zip-code>" +
                                    "  <type>INSTRUCTOR</type>" +
                                    "  <department>CMPE</department>" +
                                    "  <employee-id>111-22-3456</employee-id>" +
                                    "  <office-hours>M 2000-2100</office-hours>" +
                                    "  <office>CLK120</office>" +
                            "</instructor>" +
                        "            </create>" +
                        "        </instructorService>" +
                        "    </request>",


                "<request>" +
                        "        <instructorService>" +
                        "            <getById>" +
                        "                   <id>9</id>" +
                        "            </getById>" +
                        "        </instructorService>" +
                        "    </request>",


                "<request>" +
                        "        <instructorService>" +
                        "            <update>" +
                       "<instructor>\n" +
                        "  <id>9</id>\n" +
                        "  <first-name>Dan</first-name>\n" +
                        "  <last-name>Harkey</last-name>\n" +
                        "  <address>THE Good Place</address>\n" +
                        "  <city>San Jose</city>\n" +
                        "  <state>CA</state>\n" +
                        "  <zip-code>95118</zip-code>\n" +
                        "  <type>INSTRUCTOR</type>\n" +
                        "  <department>CMPE</department>\n" +
                        "  <employee-id>111-22-3457</employee-id>\n" +
                        "  <office-hours>M 2000-2100</office-hours>\n" +
                        "  <office>CLK120</office>\n" +
                        "</instructor>" +
                        "            </update>" +
                        "        </instructorService>" +
                        "    </request>",

                "<request>" +
                        "        <instructorService>" +
                        "            <delete>" +
                       "<instructor>\n" +
                        "  <id>9</id>\n" +
                        "  <first-name>Dan</first-name>\n" +
                        "  <last-name>Harkey</last-name>\n" +
                        "  <address>A Good Place</address>\n" +
                        "  <city>San Jose</city>\n" +
                        "  <state>CA</state>\n" +
                        "  <zip-code>95118</zip-code>\n" +
                        "  <type>INSTRUCTOR</type>\n" +
                        "  <department>CMPE</department>\n" +
                        "  <employee-id>111-22-3456</employee-id>\n" +
                        "  <office-hours>M 2000-2100</office-hours>\n" +
                        "  <office>CLK120</office>\n" +
                        "</instructor>" +
                        "            </delete>" +
                        "        </instructorService>" +
                        "    </request>",

        };

        XmlReceiver xmlReceiver = (XmlReceiver) BeanRetriever.getBeanFactory().getBean("xmlReceiver");

        for (String iteration : text) {
            String result = xmlReceiver.processRequest(iteration);
            System.out.println (result);
        }

    }


    public void pureServiceTest () {
        PersonService personService  = (PersonService) BeanRetriever.getBeanFactory().getBean("personService");
        List<Person> results = personService.search("lastName", "Yar");
        Person person = personService.getById(2L);
        List<Person> persons = personService.getAll();

        StudentService studentService = (StudentService) BeanRetriever.getBeanFactory().getBean("studentService");
        List<Student> students = studentService.getAll();

        InstructorService instructorService = (InstructorService) BeanRetriever.getBeanFactory().getBean("instructorService");
        List<Instructor> instructors  = instructorService.getAll();

        CourseService courseService = (CourseService) BeanRetriever.getBeanFactory().getBean("courseService");
        List<Course> courses = courseService.getAll();

        Instructor instructor = new Instructor();
        instructor.setEmployeeId("123-23-4445");
        instructor.setFirstName("Bill");
        instructor.setLastName("Gates");
        instructor.setOffice("CLK111");
        instructor.setAddress("987 Cal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");

        List<EventInformation> officeHours = new ArrayList<EventInformation>();
        officeHours.add(new EventInformation(DayOfWeek.Monday, "1500", "1600"));
        officeHours.add(new EventInformation(DayOfWeek.Tuesday, "1500", "1600"));
        instructor.setOfficeHours(officeHours);

        instructor = instructorService.create(instructor);

        Course courseToCreate = new Course();
        courseToCreate.setName("Some new course");
        courseToCreate.setLocation("CLK111");
        courseToCreate.setSection(1);
        courseToCreate.setUnits(3);
        List<EventInformation> meetingHours = new ArrayList<EventInformation>();
        meetingHours.add(new EventInformation(DayOfWeek.Monday, "1500", "1600"));
        meetingHours.add(new EventInformation(DayOfWeek.Tuesday, "1500", "1600"));
        courseToCreate.setMeetingHours(meetingHours);
        Course courseCreated = courseService.create(courseToCreate, instructorService.getById(1L));

        courseCreated.getMeetingHours().add(new EventInformation(DayOfWeek.Wednesday, "1500", "1600"));
        courseService.update(courseCreated);

        Student studentToCreate = new Student() ;
        studentToCreate.setState("CA");
        studentToCreate.setCity("San Diego");
        studentToCreate.setFirstName("San");
        studentToCreate.setLastName("Diego");
        studentToCreate.setAddress("987 Cal st");
        studentToCreate.setZipCode("12345");
        studentToCreate.setStudentId("123-00-1234");

        studentService.create(studentToCreate);

        studentToCreate.setZipCode("65432");
        studentToCreate.setStudentId("654-32-2222");
        studentService.update(studentToCreate);

        courseService.enrollStudent(courseCreated, studentToCreate);

        try {
            studentService.delete(studentToCreate);
        } catch (Exception e) {
            System.out.println("Nelza!");
        }

        try {
            courseService.delete(courseCreated);
        } catch (Exception e) {
            System.out.println("Nelza!");
        }
        courseService.unEnrollStudent(courseCreated, studentToCreate);

        studentService.delete(studentToCreate);
        courseService.delete(courseCreated);
        instructorService.delete(instructor);
    }

}
