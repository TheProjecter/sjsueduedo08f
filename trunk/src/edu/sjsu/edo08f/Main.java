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

        Course courseToCreate = new Course();
        courseToCreate.setName("Some new course");
        courseToCreate.setLocation("CLK117");
        courseToCreate.setSection(1);
        courseToCreate.setUnits(3);
        List<EventInformation> meetingHours = new ArrayList<EventInformation>();
        meetingHours.add(new EventInformation(DayOfWeek.Monday, "1700", "1800"));
        meetingHours.add(new EventInformation(DayOfWeek.Tuesday, "1700", "1800"));
        courseToCreate.setMeetingHours(meetingHours);
        courseService.create(courseToCreate, instructorService.getById(2L));


        int a = 5;
    }


    private static BeanFactory getBeanFactory() {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        xmlBeanDefinitionReader.loadBeanDefinitions(new FileSystemResource("config/application-config.xml"));

        return factory;
    }

}
