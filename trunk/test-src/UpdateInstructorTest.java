import org.testng.annotations.Test;
import org.testng.Assert;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.services.InstructorService;
import edu.sjsu.edo08f.Main;

/**
 * Created by IntelliJ IDEA.
 * User: Anita
 * Date: Nov 29, 2008
 * Time: 1:27:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class UpdateInstructorTest {

    InstructorService instructorService = (InstructorService) Main.getBeanFactory().getBean("instructorService");

         boolean checkFlag= false;

                   @Test(groups = {"main"})

                 //Test for Updating 1 feild.
               public void testFirstName() {
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

                 Instructor instructorFromDB = instructorService.create(instructor);
                 instructor.setEmployeeId("546-63-8765");
                 instructorService.update(instructor);


                 String temp = instructorFromDB.getEmployeeId().toString();
                 String tempType = instructorFromDB.getType().toString().toLowerCase();
                 System.out.println("Value of temp" + temp);

                 if (temp.toLowerCase().equals("546-63-8765")&& tempType.equals("instructor"))
                 checkFlag = true;
                 else
                  checkFlag = false;

               Assert.assertFalse(checkFlag,"true");
            }

            @Test(groups = {"main"})

                 //Test for updating multiple feilds
               public void testUpdFNID() {
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

                 Instructor instructorFromDB = instructorService.create(instructor);
               instructor.setEmployeeId("123-11-1212");
                       instructor.setFirstName("Changed_Jack");
                       instructor.setLastName("Changed_Jill");
                       instructor.setAddress("787 ABC St");
                       instructorService.update(instructor);

              String temp = instructorFromDB.getEmployeeId();
              String tempType = instructorFromDB.getType().toString().toLowerCase();
        String tempFName = instructorFromDB.getFirstName().toString().toLowerCase();
        String tempLName = instructorFromDB.getLastName().toString().toLowerCase();
        String tempAddress = instructorFromDB.getAddress().toString().toLowerCase();

                 if (temp.toLowerCase().equals("123-11-1212") && tempType.equals("instructor") && tempFName.toLowerCase().equals("Changed_Jack")&&tempLName.toLowerCase().equals("Changed_Jill") && tempAddress.toLowerCase().equals("787 ABC St"))
                 checkFlag = true;
                 else
                  checkFlag = false;

               Assert.assertFalse(checkFlag,"true");
            }


      @Test(groups = {"main"})

                 //Test for updating with incorrect info for fields.: first name to have numbers, instructor id as all 0s
               public void testInstIdWrong() {
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

                 Instructor instructorFromDB = instructorService.create(instructor);
                       instructor.setEmployeeId("000-00-0000");
                       instructor.setFirstName("C123_Jack");
                       instructor.setLastName("Changed_Jill");
                       instructor.setAddress("787 ABC St");
                       instructorService.update(instructor);

                 String temp = instructorFromDB.getEmployeeId().toString();
                 String tempFN = instructorFromDB.getFirstName().toString();
                 String tempType = instructorFromDB.getType().toString().toLowerCase();
                 System.out.println("Value of temp" + temp);

                 if ((temp.toLowerCase().equals("000-00-0000")|| tempFN.toLowerCase().equals("C123_Jack"))&& tempType.equals("instructor"));
                 else
                  checkFlag = false;

               Assert.assertFalse(checkFlag,"true");
            }


    //Test of 2 identical instructors .

                       @Test(groups = {"main"})

                       public void testInstDup() {
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

                                      Instructor instructorFromDB = instructorService.create(instructor);

                                      Instructor instructor2 = new Instructor();
                                      instructor2.setEmployeeId("333-36-3445");
                                      instructor2.setFirstName("Jk");
                                      instructor2.setLastName("lEF");
                                      instructor2.setOffice("CLM101");
                                      instructor2.setAddress("12 SnatA st");
                                      instructor2.setCity("San Jose");
                                      instructor2.setState("CA");
                                      instructor2.setZipCode("32435");
                                      instructor2.setDepartment("ELEC");

                                      Instructor instructorFromDB2 = instructorService.create(instructor);

                                      instructor.setEmployeeId("123-23-4445");
                                      instructor.setFirstName("Jack");

                                      instructorService.update(instructor2);


                                      String temp = instructorFromDB2.getEmployeeId().toString();
                                      String tempFN = instructorFromDB2.getFirstName().toString();
                                      String tempType = instructorFromDB2.getType().toString().toLowerCase();
                                      System.out.println("Value of temp" + temp);

                                      if ((temp.toLowerCase().equals("123-23-4445")|| tempFN.toLowerCase().equals("Jack"))&& tempType.equals("instructor"))
                                      checkFlag=false;
                                      else
                                       checkFlag = true;

                                    Assert.assertFalse(checkFlag,"true");
                                 }



                                                         
}
