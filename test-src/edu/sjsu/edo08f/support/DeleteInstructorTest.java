package edu.sjsu.edo08f.support;

import edu.sjsu.edo08f.services.InstructorService;
import edu.sjsu.edo08f.Main;
import edu.sjsu.edo08f.BeanRetriever;
import edu.sjsu.edo08f.domain.Instructor;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * Created by IntelliJ IDEA.
 * User: Anita
 * Date: Dec 1, 2008
 * Time: 8:51:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeleteInstructorTest {

    InstructorService instructorService = (InstructorService) BeanRetriever.getBeanFactory().getBean("instructorService");

        boolean checkFlag= false;


              @Test(groups = {"main"})

                    //Test for Create then delete

                    public void testDeleteInstr() {

                    Instructor instructor = new Instructor();
                    instructor.setEmployeeId("123-23-4445");
                    instructor.setFirstName("Jack");
                    instructor.setLastName("Jill");
                    instructor.setOffice("CLK111");
                    instructor.setAddress("1237 Snatal st");
                    instructor.setCity("San Diego");
                    instructor.setState("CA");
                    instructor.setZipCode("12345");
                    instructor.setDepartment("CMPE");

                    instructorService.create(instructor);


                  try{
                      instructorService.delete(instructor);
                      String temp = null , tempType= null;

                       temp = instructor.getFirstName().toString();
                       tempType= instructor.getType().toString().toLowerCase();
                        if (temp.toLowerCase()!= null || tempType.equals("instructor"))
                        checkFlag = false;
                         else
                        checkFlag = true;
                      }
                    catch(Exception e)   // need to put exact exception
                    {
                     checkFlag = true;
                    }

                  finally{
                  Assert.assertFalse(checkFlag,"true");
                  }
               }


                       //Test for deleting a non existing instructor

              @Test(groups = {"main"})



                    public void testDeleteNoIntruc() {

                    Instructor instructor = new Instructor();
                  
                    try{
                       instructorService.delete(instructor);
                        checkFlag=false;
                      }
                    catch(Exception e)   // need to put exact exception
                    {
                     checkFlag = true;
                    }

                  Assert.assertFalse(checkFlag,"true");
               }

}
