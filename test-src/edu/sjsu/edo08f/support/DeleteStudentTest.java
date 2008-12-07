package edu.sjsu.edo08f.support;

import org.testng.annotations.Test;
import org.testng.Assert;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.services.StudentService;
import edu.sjsu.edo08f.Main;
import edu.sjsu.edo08f.BeanRetriever;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Anita
 * Date: Dec 1, 2008
 * Time: 9:43:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class DeleteStudentTest {
    StudentService studentService = (StudentService) BeanRetriever.getBeanFactory().getBean("studentService");

    boolean checkFlag = false;

    @Test(groups = {"main"})

    //Test for create then delete

    public void testDeleteStud() {
        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Jill");
        student.setAddress("98 ABC Street");
        student.setState("CA");
        student.setCity("San Jose");
        student.setZipCode("12345");
        student.setStudentId("123-00-004");
        studentService.create(student);

        try {
            studentService.delete(student);
            String temp = null, tempType = null;
            temp = student.getFirstName().toString();
            tempType = student.getType().toString().toLowerCase();
            // checkFlag = false;
            if (temp.toLowerCase() != null || tempType.equals("student"))
                checkFlag = false;
            else
                checkFlag = true;
        }
        catch (Exception e)   // need to put exact exception
        {
            checkFlag = true;
        }
         finally {
                   Assert.assertEquals(checkFlag, true);
                   List<Student> students = studentService.getAll();
                   for (Student studentToBeDeleted : students) {
                       studentService.delete(studentToBeDeleted);
                   }
               }
    }

    //Test for deleting a non existing client.

    public void testDeleteNoStudent() {
        Student student = new Student();
        try {
            studentService.delete(student);
            checkFlag = false;
        }
        catch (Exception e)   // need to put exact exception
        {
            checkFlag = true;
        }
         finally {
                   Assert.assertEquals(checkFlag, true);
                   List<Student> students = studentService.getAll();
                   for (Student studentToBeDeleted : students) {
                       studentService.delete(studentToBeDeleted);
                   }
               }
    }

}
