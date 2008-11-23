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
import edu.sjsu.edo08f.support.EventInformation;
import edu.sjsu.edo08f.support.DayOfWeek;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by: Alex Yarmula
 * Date: Nov 10, 2008
 */
public class Main {

    public static void main (String[] args) {

        PersonService personService  = (PersonService) getBeanFactory().getBean("personService");
        Person person = personService.getById(2L);
        List<Person> persons = personService.getAll();

        StudentService studentService = (StudentService) getBeanFactory().getBean("studentService");
        List<Student> students = studentService.getAll();

        InstructorService instructorService = (InstructorService) getBeanFactory().getBean("instructorService");
        List<Instructor> instructors  = instructorService.getAll();

        CourseService courseService = (CourseService) getBeanFactory().getBean("courseService");
        List<Course> courses = courseService.getAll();

        Instructor instructor = new Instructor();
        instructor.setEmployeeId("123-23-4444");
        instructor.setFirstName("Bill");
        instructor.setLastName("Gates");
        instructor.setOffice("CLK118");
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
        courseToCreate.setLocation("CLK118");
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
        int b =5;
    }


    private static BeanFactory getBeanFactory() {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        xmlBeanDefinitionReader.loadBeanDefinitions(new FileSystemResource("config/application-config.xml"));

        return factory;
    }

}
