package edu.sjsu.edo08f.support;

import org.testng.annotations.Test;
import org.testng.Assert;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Person;
import edu.sjsu.edo08f.services.PersonService;
import edu.sjsu.edo08f.Main;

/**
 * Created by IntelliJ IDEA.
 * User: Anita
 * Date: Nov 21, 2008
 * Time: 3:51:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreatePersonTest {
    boolean checkFlag= false;
            PersonService studentService = (PersonService) Main.getBeanFactory().getBean("personService");
            Person person = new Person();
    
           @Test(groups = {"main"})
            public void studentCreateAndCheckWithDBTest() {
               person.setFirstName("Jack");

               Person personFromDB = PersonService.create(person);

               String tempFirstName = studentFromDB.getFirstName().toString();
               System.out.println("Value of temp" + tempFirstName);

               if (tempFirstName.toLowerCase().equals("jack"))
               checkFlag = true;
               else
               checkFlag = false;

               Assert.assertFalse(checkFlag,"true");
            }

        @Test(groups = {"main"})
            public void testLastName() {
                person.setLastName("Jill");

                Student studentFromDB = studentService.create(person);

                String tempFirstName = studentFromDB.getLastName().toString();
                System.out.println("Value of temp" + tempFirstName);

                if (tempFirstName.toLowerCase().equals("jill"))
                    checkFlag = true;
                else
                    checkFlag = false;

                Assert.assertFalse(checkFlag,"true");
            }

        @Test(groups = {"main"})
            public void testAddress() {
            person.setAddress("123 ABC Street , San Jose ");

               Student studentFromDB = studentService.create(person);

               String tempFirstName = studentFromDB.getAddress().toString();
               System.out.println("Value of temp" + tempFirstName);

               if (tempFirstName.equals("123 ABC Street , San Jose "))
               checkFlag = true;
               else
               checkFlag = false;

               Assert.assertFalse(checkFlag,"true");


            }
        @Test(groups = {"main"})
            public void testCity() {
            person.setCity("San Jose");

               Student studentFromDB = studentService.create(person);

               String tempFirstName = studentFromDB.getCity().toString();
               System.out.println("Value of temp" + tempFirstName);

               if (tempFirstName.toLowerCase().equals("san jose"))
               checkFlag = true;
               else
               checkFlag = false;

               Assert.assertFalse(checkFlag,"true");


            }
        @Test(groups = {"main"})
            public void testState() {
            person.setState("CA");

               Student studentFromDB = studentService.create(person);

               String tempFirstName = studentFromDB.getState().toString();
               System.out.println("Value of temp" + tempFirstName);

               if (tempFirstName.toLowerCase().equals("ca"))
               checkFlag = true;
               else
               checkFlag = false;

               Assert.assertFalse(checkFlag,"true");


            }
        @Test(groups = {"main"})
            public void testZip() {
               person.setZipCode("95123");
               Student studentFromDB = studentService.create(person);

               String tempFirstName = studentFromDB.getZipCode();
               System.out.println("Value of temp" + tempFirstName);

               if (tempFirstName.toLowerCase().equals("95123"))
               checkFlag = true;
               else
               checkFlag = false;

               Assert.assertFalse(checkFlag,"true");


            }


}
