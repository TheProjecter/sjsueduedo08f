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

import java.util.List;

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

    }


    private static BeanFactory getBeanFactory() {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        xmlBeanDefinitionReader.loadBeanDefinitions(new FileSystemResource("config/application-config.xml"));

        return factory;
    }

}
