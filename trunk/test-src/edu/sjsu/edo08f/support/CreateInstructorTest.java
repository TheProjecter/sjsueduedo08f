package edu.sjsu.edo08f.support;

import org.testng.annotations.Test;
import org.testng.Assert;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.services.InstructorService;
import edu.sjsu.edo08f.Main;
import edu.sjsu.edo08f.BeanRetriever;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Anita
 * Date: Nov 22, 2008
 * Time: 3:58:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateInstructorTest {

    InstructorService instructorService = (InstructorService) BeanRetriever.getBeanFactory().getBean("instructorService");

    boolean checkFlag = false;
         public CreateInstructorTest() {

        try {
            List<Instructor> instructors = instructorService.getAll();
            for (Instructor instructorsToBeDeleted : instructors) {
                instructorService.delete(instructorsToBeDeleted);
            }
               Thread.sleep (5000);
            int i = 0;
   //         Thread.sleep (5000);
        } catch (Exception e) {}

    }

    @Test(groups = {"main"})

    //Test for First Name
    public void testFirstName() {
        Instructor instructor = new Instructor();
        instructor.setEmployeeId("103-23-4445");
        instructor.setFirstName("Jack");
        instructor.setLastName("Jill");
       instructor.setOffice("OKS90");
        instructor.setAddress("1237 Snatal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");

        try {
            Instructor instructorFromDB = instructorService.create(instructor);

            String tempFirstName = instructorFromDB.getFirstName().toString();
            String tempType = instructorFromDB.getType().toString().toLowerCase();
            System.out.println("Value of temp" + tempFirstName);


            if (tempFirstName.toLowerCase().equals("jack") && tempType.equals("instructor"))
                checkFlag = true;
            else
                checkFlag = false;
        }
        catch (Exception e) {
            checkFlag = false;
        }
         finally {
            Assert.assertEquals(checkFlag,true);
            List<Instructor> instructors = instructorService.getAll();
            for (Instructor instructorsToBeDeleted : instructors) {
                instructorService.delete(instructorsToBeDeleted);
            }
        }
    }
}
