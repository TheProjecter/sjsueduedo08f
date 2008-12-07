package edu.sjsu.edo08f.support;

import edu.sjsu.edo08f.services.StudentService;
import edu.sjsu.edo08f.Main;
import edu.sjsu.edo08f.BeanRetriever;
import edu.sjsu.edo08f.domain.Student;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Anita
 * Date: Nov 22, 2008
 * Time: 2:20:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpdateStudentTest {

    StudentService studentService = (StudentService) BeanRetriever.getBeanFactory().getBean("studentService");
    Student student = new Student();
    boolean checkFlag = false;


    @Test(groups = {"main"})

    //Test for updating any 1 feild - taken here :Student Id
    public void testStudId() {
        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Jill");
        student.setAddress("123 ABC St");
        student.setStudentId("123-00-004");
        student.setCity("San Jose");
        student.setState("CA");
        student.setZipCode("95112");
        Student studentFromDB = studentService.create(student);
        student.setStudentId("123-11-1212");

        try {
            studentService.update(student);

            String temp = studentFromDB.getStudentId();
            String tempType = studentFromDB.getType().toString().toLowerCase();

            if (temp.toLowerCase().equals("123-11-1212") && tempType.equals("student"))
                checkFlag = false;
            else
                checkFlag = true;
        }

        catch (Exception e) {
            checkFlag = false;
        }
        finally {
                   Assert.assertEquals(checkFlag, true);
                   List<Student> students = studentService.getAll();
                   for (Student studentToBeDeleted : students) {
                       studentService.delete(studentToBeDeleted);
                   }
               }

    }

    //Test for updating more than 1 field at a time : StudentId ,First Name , Last Name , Address

    @Test(groups = {"main"})
    public void testStudIdName() {
        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Jill");
        student.setAddress("123 ABC St");
        student.setStudentId("123-00-004");
        student.setCity("San Jose");
        student.setState("CA");
        student.setZipCode("95112");
        Student studentFromDB = studentService.create(student);
        //student.setStudentId("123-11-1212");
        student.setFirstName("Changed_Jack");
        student.setLastName("Changed_Jill");
        student.setAddress("787 ABC St");

        try {
            studentService.update(student);

            // String temp = studentFromDB.getStudentId();
            String tempType = studentFromDB.getType().toString().toLowerCase();
            String tempFName = studentFromDB.getFirstName().toString().toLowerCase();
            String tempLName = studentFromDB.getLastName().toString().toLowerCase();
            String tempAddress = studentFromDB.getAddress().toString().toLowerCase();

            if (tempType.equals("student") && tempFName.toLowerCase().equals("Changed_Jack") && tempLName.toLowerCase().equals("Changed_Jill") && tempAddress.toLowerCase().equals("787 ABC St"))
                checkFlag = true;
            else
                checkFlag = false;
        }
        catch (Exception e) {
            checkFlag = false;
        }
        finally {
                   Assert.assertEquals(checkFlag, true);
                   List<Student> students = studentService.getAll();
                   for (Student studentToBeDeleted : students) {
                       studentService.delete(studentToBeDeleted);
                   }
               }
    }

    //Test for updating with incorrect info for fields.: first name to have numbers, student id as all 0s

    @Test(groups = {"main"})
    public void testStudIdWrong() {
        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Jill");
        student.setAddress("123 ABC St");
        student.setStudentId("123-00-004");
        student.setCity("San Jose");
        student.setState("CA");
        student.setZipCode("95112");
        Student studentFromDB = studentService.create(student);
        student.setStudentId("000-00-0000");
        student.setFirstName("C123_Jack");
        student.setLastName("Changed_Jill");
        student.setAddress("787 ABC St");
        try {
            studentService.update(student);

            String temp = studentFromDB.getStudentId();
            String tempType = studentFromDB.getType().toString().toLowerCase();
            String tempFName = studentFromDB.getFirstName().toString().toLowerCase();
            String tempLName = studentFromDB.getLastName().toString().toLowerCase();
            String tempAddress = studentFromDB.getAddress().toString().toLowerCase();

            if ((temp.toLowerCase().equals("000-00-0000") || tempFName.toLowerCase().equals("C123_Jack")) && tempLName.equals("student"))
                checkFlag = false;
            else
                checkFlag = true;
        }
        catch (Exception e) {
            checkFlag = false;
        }
       finally {
                   Assert.assertEquals(checkFlag, true);
                   List<Student> students = studentService.getAll();
                   for (Student studentToBeDeleted : students) {
                       studentService.delete(studentToBeDeleted);
                   }
               }
    }

    //Test of 2 identical students .

    @Test(groups = {"main"})
    public void testStudExsits() {
        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Jill");
        student.setAddress("123 ABC St");
        student.setStudentId("123-00-004");
        student.setCity("San Jose");
        student.setState("CA");
        student.setZipCode("95112");
        Student studentFromDB = studentService.create(student);

        Student student2 = new Student();
        student2.setFirstName("Jk");
        student2.setLastName("Jill");
        student2.setAddress("123 ABC St");
        student2.setStudentId("123-11-004");
        student2.setCity("San Jose");
        student2.setState("CA");
        student2.setZipCode("95112");
        Student studentFromDB2 = studentService.create(student2);


        student2.setStudentId("123-00-004");
        student2.setFirstName("Jack");

        try {
            studentService.update(student2);

            String temp = studentFromDB2.getStudentId();
            String tempType = studentFromDB2.getType().toString().toLowerCase();
            String tempFName = studentFromDB2.getFirstName().toString().toLowerCase();
            if (temp.toLowerCase().equals("123-00-004") && tempType.equals("student") && tempFName.toLowerCase().equals("Jack")) {
                checkFlag = false;
                System.out.println("2 students with completely identical details- updated student 2 to look like student1");
            } else
                checkFlag = true;
        }
        catch (Exception e) {
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
