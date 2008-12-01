package edu.sjsu.edo08f.support;

import org.testng.annotations.Test;
import org.testng.Assert;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.services.InstructorService;
import edu.sjsu.edo08f.Main;

/**
 * Created by IntelliJ IDEA.
 * User: Anita
 * Date: Nov 22, 2008
 * Time: 3:58:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateInstructorTest {

    InstructorService instructorService = (InstructorService) Main.getBeanFactory().getBean("instructorService");

     boolean checkFlag= false;


           @Test(groups = {"main"})

                 //Test for First Name
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

                 String tempFirstName = instructorFromDB.getFirstName().toString();
                 String tempType = instructorFromDB.getType().toString().toLowerCase();
                 System.out.println("Value of temp" + tempFirstName);

                 if (tempFirstName.toLowerCase().equals("jack")&& tempType.equals("instructor"))
                 checkFlag = true;
                 else
                  checkFlag = false;

               Assert.assertFalse(checkFlag,"true");
            }


      @Test(groups = {"main"})
     public void testFirstNameSpecial() {
                Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setLastName("Jill");                                    
                 instructor.setOffice("CLK111");
                 instructor.setAddress("1237 Snatal st");
                 instructor.setCity("San Diego");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
           instructor.setFirstName("$#%0--09 *^ ");

          Instructor instructorFromDB = instructorService.create(instructor);

           String temp = instructorFromDB.getFirstName().toString();
           String tempType = instructorFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + temp);

           if (temp.toLowerCase().equals("$#%0--09 *^ ")&& tempType.equals("instructor"))
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");
        }

      @Test(groups = {"main"})

      public void testFirstNameNumbers() {
          Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setLastName("Jill");
                 instructor.setOffice("CLK111");
                 instructor.setAddress("1237 Snatal st");
                 instructor.setCity("San Diego");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
           instructor.setFirstName("12387986");

           Instructor instructorFromDB = instructorService.create(instructor);

           String temp = instructorFromDB.getFirstName().toString();
           String tempType = instructorFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + temp);

           if (temp.toLowerCase().equals("12387986")&& tempType.equals("instructor"))
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");
        }


      @Test(groups = {"main"})
      public void testFirstNameEmpty() {
          Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setLastName("Jill");
                 instructor.setOffice("CLK111");
                 instructor.setAddress("1237 Snatal st");
                 instructor.setCity("San Diego");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
           instructor.setFirstName("");

           Instructor instructorFromDB = instructorService.create(instructor);

           String temp = instructorFromDB.getFirstName().toString();
           String tempType = instructorFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + temp);

           if (temp.toLowerCase().equals("")&& tempType.equals("instructor"))
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");
        }

      @Test(groups = {"main"})
      public void testFirstNameAlphaN() {
          Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setLastName("Jill");
                 instructor.setOffice("CLK111");
                 instructor.setAddress("1237 Snatal st");
                 instructor.setCity("San Diego");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
           instructor.setFirstName("hir567");

           Instructor instructorFromDB = instructorService.create(instructor);

           String temp = instructorFromDB.getFirstName().toString();
           String tempType = instructorFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + temp);

           if (temp.toLowerCase().equals("hir567")&& tempType.equals("instructor"))
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");
        }
                //Test for Last Name
                                @Test(groups = {"main"})
            public void testLastName() {
                Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jill");
                 instructor.setOffice("CLK111");
                 instructor.setAddress("1237 Snatal st");
                 instructor.setCity("San Diego");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
                instructor.setLastName("Jill");

                Instructor instructorFromDB = instructorService.create(instructor);

                String temp = instructorFromDB.getLastName().toString();
             String tempType = instructorFromDB.getType().toString().toLowerCase();
                System.out.println("Value of temp" + temp);

                if (temp.toLowerCase().equals("jill")&& tempType.equals("instructor"))
                    checkFlag = true;
                else
                    checkFlag = false;

                Assert.assertFalse(checkFlag,"true");
            }

      @Test(groups = {"main"})

            public void testLastNameSpecial() {
                Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jill");
                 instructor.setOffice("CLK111");
                 instructor.setAddress("1237 Snatal st");
                 instructor.setCity("San Diego");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
               instructor.setLastName("^%$0 )(*");


             Instructor instructorFromDB = instructorService.create(instructor);

             String temp = instructorFromDB.getLastName().toString();
             String tempType = instructorFromDB.getType().toString().toLowerCase();

             System.out.println("Value of temp" + temp);

            if (temp.toLowerCase().equals("^^%$0 )(*")&& tempType.equals("instructor"))
                checkFlag = false;
            else
                checkFlag = true;

            Assert.assertFalse(checkFlag,"true");
           }

      @Test(groups = {"main"})
    public void testLastNameNumber() {
        Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jill");
                 instructor.setOffice("CLK111");
                 instructor.setAddress("1237 Snatal st");
                 instructor.setCity("San Diego");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
              instructor.setLastName("3434546");

               Instructor instructorFromDB = instructorService.create(instructor);

               String temp = instructorFromDB.getLastName().toString();
               String tempType = instructorFromDB.getType().toString().toLowerCase();

               System.out.println("Value of temp" + temp);

              if (temp.toLowerCase().equals("3434546")&& tempType.equals("instructor"))
                  checkFlag = false;
              else
                  checkFlag = true;

              Assert.assertFalse(checkFlag,"true");
              }


     @Test(groups = {"main"})
    public void testLastNameEmpty() {
        Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jill");
                 instructor.setOffice("CLK111");
                 instructor.setAddress("1237 Snatal st");
                 instructor.setCity("San Diego");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
              instructor.setLastName("");

               Instructor instructorFromDB = instructorService.create(instructor);

               String temp = instructorFromDB.getLastName().toString();
               String tempType = instructorFromDB.getType().toString().toLowerCase();

               System.out.println("Value of temp" + temp);

              if (temp.toLowerCase().equals("")&& tempType.equals("instructor"))
                  checkFlag = false;
              else
                  checkFlag = true;

              Assert.assertFalse(checkFlag,"true");
              }


      @Test(groups = {"main"})
    public void testLastNameAlpha() {
        Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jill");
                 instructor.setOffice("CLK111");
                 instructor.setAddress("1237 Snatal st");
                 instructor.setCity("San Diego");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
                  instructor.setLastName("jbh87");

                   Instructor instructorFromDB = instructorService.create(instructor);

                   String temp = instructorFromDB.getLastName().toString();
                   String tempType = instructorFromDB.getType().toString().toLowerCase();

                   System.out.println("Value of temp" + temp);

                  if (temp.toLowerCase().equals("jbh87")&& tempType.equals("instructor"))
                      checkFlag = false;
                  else
                      checkFlag = true;

                  Assert.assertFalse(checkFlag,"true");
                  }


          //Test for Address
                 @Test(groups = {"main"})
            public void testAddress() {
                Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setCity("San Diego");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
            instructor.setAddress("123 ABC Street , San Jose ");

               Instructor instructorFromDB = instructorService.create(instructor);

               String temp = instructorFromDB.getAddress().toString();
             String tempType = instructorFromDB.getType().toString().toLowerCase();
               System.out.println("Value of temp" + temp);

               if (temp.equals("123 ABC Street , San Jose ")&& tempType.equals("instructor"))
               checkFlag = true;
               else
               checkFlag = false;

               Assert.assertFalse(checkFlag,"true");
            }

      @Test(groups = {"main"})

    public void testAddressEmpty() {

                Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setCity("San Diego");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
            instructor.setAddress("");

               Instructor instructorFromDB = instructorService.create(instructor);

               String temp = instructorFromDB.getAddress().toString();
             String tempType = instructorFromDB.getType().toString().toLowerCase();
               System.out.println("Value of temp" + temp);

               if (temp.equals("")&& tempType.equals("instructor"))
               checkFlag = false;
               else
               checkFlag = true;

               Assert.assertFalse(checkFlag,"true");
            }
      @Test(groups = {"main"})
    public void testAddressSpecial() {
        Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setCity("San Diego");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
            instructor.setAddress("^&*&(* )(*)(* & n &^*&");

               Instructor instructorFromDB = instructorService.create(instructor);

               String temp = instructorFromDB.getAddress().toString();
             String tempType = instructorFromDB.getType().toString().toLowerCase();
               System.out.println("Value of temp" + temp);

               if (temp.equals("^&*&(* )(*)(* & n &^*&")&& tempType.equals("instructor"))
               checkFlag = false;
               else
               checkFlag = true;

               Assert.assertFalse(checkFlag,"true");
            }

         @Test(groups = {"main"})
    public void testAddressNeg() {
        Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setCity("San Diego");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
            instructor.setAddress("-123 ABC Street , San Jose");

               Instructor instructorFromDB = instructorService.create(instructor);

               String temp = instructorFromDB.getAddress().toString();
             String tempType = instructorFromDB.getType().toString().toLowerCase();
               System.out.println("Value of temp" + temp);

               if (temp.equals("-123 ABC Street , San Jose")&& tempType.equals("instructor"))
               checkFlag = false;
               else
               checkFlag = true;

               Assert.assertFalse(checkFlag,"true");
            }

    //Test for City


              @Test(groups = {"main"})
            public void testCity() {
        Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
            instructor.setCity("San Jose");

               Instructor instructorFromDB = instructorService.create(instructor);

               String temp = instructorFromDB.getCity().toString();
             String tempType = instructorFromDB.getType().toString().toLowerCase();
               System.out.println("Value of temp" + temp);

               if (temp.toLowerCase().equals("san jose")&& tempType.equals("instructor"))
               checkFlag = true;
               else
               checkFlag = false;

               Assert.assertFalse(checkFlag,"true");
            }

      @Test(groups = {"main"})
      public void testCitySpecial() {
           Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
            instructor.setCity("&^ $%^");

               Instructor instructorFromDB = instructorService.create(instructor);

               String temp = instructorFromDB.getCity().toString();
             String tempType = instructorFromDB.getType().toString().toLowerCase();
               System.out.println("Value of temp" + temp);

               if (temp.toLowerCase().equals("&^ $%^")&& tempType.equals("instructor"))
               checkFlag = false;
               else
               checkFlag = true;

               Assert.assertFalse(checkFlag,"true");
            }

    @Test(groups = {"main"})
     public void testCityNumber() {
          Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
            instructor.setCity("234");

               Instructor instructorFromDB = instructorService.create(instructor);

               String temp = instructorFromDB.getCity().toString();
             String tempType = instructorFromDB.getType().toString().toLowerCase();
               System.out.println("Value of temp" + temp);

               if (temp.toLowerCase().equals("234")&& tempType.equals("instructor"))
               checkFlag = false;
               else
               checkFlag = true;

               Assert.assertFalse(checkFlag,"true");
            }

                     @Test(groups = {"main"})
    public void testCityEmpty() {
         Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
               instructor.setCity("");

                  Instructor instructorFromDB = instructorService.create(instructor);

                  String temp = instructorFromDB.getCity().toString();
                String tempType = instructorFromDB.getType().toString().toLowerCase();
                  System.out.println("Value of temp" + temp);

                  if (temp.toLowerCase().equals("")&& tempType.equals("instructor"))
                  checkFlag = false;
                  else
                  checkFlag = true;

                  Assert.assertFalse(checkFlag,"true");
               }

      @Test(groups = {"main"})
    public void testCityAlphaN() {
         Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setState("CA");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
               instructor.setCity("UG87j9");

                  Instructor instructorFromDB = instructorService.create(instructor);

                  String temp = instructorFromDB.getCity().toString();
                String tempType = instructorFromDB.getType().toString().toLowerCase();
                  System.out.println("Value of temp" + temp);

                  if (temp.toLowerCase().equals("UG87j9")&& tempType.equals("instructor"))
                  checkFlag = false;
                  else
                  checkFlag = true;

                  Assert.assertFalse(checkFlag,"true");
               }


    //test for State
      @Test(groups = {"main"})
            public void testState() {
         Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setCity("San Jose");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
            instructor.setState("CA");

               Instructor instructorFromDB = instructorService.create(instructor);

               String temp = instructorFromDB.getState().toString();
             String tempType = instructorFromDB.getType().toString().toLowerCase();
               System.out.println("Value of temp" + temp);

               if (temp.toLowerCase().equals("ca")&& tempType.equals("instructor"))
               checkFlag = true;
               else
               checkFlag = false;

               Assert.assertFalse(checkFlag,"true");

            }
      @Test(groups = {"main"})
    public void testStateEmpty() {
        Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setCity("San Jose");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
                instructor.setState("");

                   Instructor instructorFromDB = instructorService.create(instructor);

                   String temp = instructorFromDB.getState().toString();
                 String tempType = instructorFromDB.getType().toString().toLowerCase();
                   System.out.println("Value of temp" + temp);

                   if (temp.toLowerCase().equals("")&& tempType.equals("instructor"))
                   checkFlag = false;
                   else
                   checkFlag = true;

                   Assert.assertFalse(checkFlag,"true");

                }

      @Test(groups = {"main"})
     public void testStateAlpha() {
         Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setCity("San Jose");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
                instructor.setState("2V");

                   Instructor instructorFromDB = instructorService.create(instructor);

                   String temp = instructorFromDB.getState().toString();
                 String tempType = instructorFromDB.getType().toString().toLowerCase();
                   System.out.println("Value of temp" + temp);

                   if (temp.toLowerCase().equals("2V")&& tempType.equals("instructor"))
                   checkFlag = false;
                   else
                   checkFlag = true;

                   Assert.assertFalse(checkFlag,"true");

                }

      @Test(groups = {"main"})
    
    public void testStateSpecial() {
        Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setCity("San Jose");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
                instructor.setState("*&");

                   Instructor instructorFromDB = instructorService.create(instructor);

                   String temp = instructorFromDB.getState().toString();
                 String tempType = instructorFromDB.getType().toString().toLowerCase();
                   System.out.println("Value of temp" + temp);

                   if (temp.toLowerCase().equals("*&")&& tempType.equals("instructor"))
                   checkFlag = false;
                   else
                   checkFlag = true;

                   Assert.assertFalse(checkFlag,"true");

                }

      @Test(groups = {"main"})
    public void testStateWrong() {
        Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setCity("San Jose");
                 instructor.setZipCode("12345");
                 instructor.setDepartment("CMPE");
                instructor.setState("MP");

                   Instructor instructorFromDB = instructorService.create(instructor);

                   String temp = instructorFromDB.getState().toString();
                 String tempType = instructorFromDB.getType().toString().toLowerCase();
                   System.out.println("Value of temp" + temp);

                   if (temp.toLowerCase().equals("mp")&& tempType.equals("instructor"))
                   checkFlag = false;
                   else
                   checkFlag = true;

                   Assert.assertFalse(checkFlag,"true");

                }


    //Test for Zip

      @Test(groups = {"main"})
            public void testZip() {
        Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setCity("San Jose");
                 instructor.setState("CA");
                 instructor.setDepartment("CMPE");
               instructor.setZipCode("95123");
               Instructor instructorFromDB = instructorService.create(instructor);

               String temp = instructorFromDB.getZipCode();
                String tempType = instructorFromDB.getType().toString().toLowerCase();
               System.out.println("Value of temp" + temp);

               if (temp.toLowerCase().equals("95123")&& tempType.equals("instructor"))
               checkFlag = true;
               else
               checkFlag = false;

               Assert.assertFalse(checkFlag,"true");

            }

      @Test(groups = {"main"})
    public void testZipEmpty() {
        Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setCity("San Jose");
                 instructor.setState("CA");
                 instructor.setDepartment("CMPE");
                  instructor.setZipCode("");
                  Instructor instructorFromDB = instructorService.create(instructor);

                  String temp = instructorFromDB.getZipCode();
                   String tempType = instructorFromDB.getType().toString().toLowerCase();
                  System.out.println("Value of temp" + temp);

                  if (temp.toLowerCase().equals("")&& tempType.equals("instructor"))
                  checkFlag = false;
                  else
                  checkFlag = true;

                  Assert.assertFalse(checkFlag,"true");

               }

      @Test(groups = {"main"})
    public void testZipSpecial() {
        Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setCity("San Jose");
                 instructor.setState("CA");
                 instructor.setDepartment("CMPE");
                  instructor.setZipCode("&^&*");
                  Instructor instructorFromDB = instructorService.create(instructor);

                  String temp = instructorFromDB.getZipCode();
                   String tempType = instructorFromDB.getType().toString().toLowerCase();
                  System.out.println("Value of temp" + temp);

                  if (temp.toLowerCase().equals("&^&*")&& tempType.equals("instructor"))
                      checkFlag = false;
                        else
                      checkFlag = true;


                  Assert.assertFalse(checkFlag,"true");

               }

      @Test(groups = {"main"})
    public void testZipNeg() {
        Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setCity("San Jose");
                 instructor.setState("CA");
                 instructor.setDepartment("CMPE");
                  instructor.setZipCode("-5123");
                  Instructor instructorFromDB = instructorService.create(instructor);

                  String temp = instructorFromDB.getZipCode();
                   String tempType = instructorFromDB.getType().toString().toLowerCase();
                  System.out.println("Value of temp" + temp);

                  if (temp.toLowerCase().equals("-5123")&& tempType.equals("instructor"))
                      checkFlag = false;
                       else
                       checkFlag = true;


                  Assert.assertFalse(checkFlag,"true");

               }

      @Test(groups = {"main"})
     public void testZipAlpha() {
         Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setCity("San Jose");
                 instructor.setState("CA");
                 instructor.setDepartment("CMPE");
                  instructor.setZipCode("Hhg345");
                  Instructor instructorFromDB = instructorService.create(instructor);

                  String temp = instructorFromDB.getZipCode();
                   String tempType = instructorFromDB.getType().toString().toLowerCase();
                  System.out.println("Value of temp" + temp);

                  if (temp.toLowerCase().equals("Hhg345")&& tempType.equals("instructor"))
                      checkFlag = false;
                       else
                       checkFlag = true;
               Assert.assertFalse(checkFlag,"true");

               }

      @Test(groups = {"main"})
             public void testEmpID() {
                 Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-23-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setCity("San Jose");
                 instructor.setState("CA");
                 instructor.setDepartment("CMPE");
                  instructor.setZipCode("98233");
                  Instructor instructorFromDB = instructorService.create(instructor);

                  String temp = instructorFromDB.getEmployeeId();
                   String tempType = instructorFromDB.getType().toString().toLowerCase();
                  System.out.println("Value of temp" + temp);

                  if (temp.toLowerCase().equals("123-23-4445")&& tempType.equals("instructor"))
                      checkFlag = true;
                       else
                       checkFlag = false;
               Assert.assertFalse(checkFlag,"true");

               }

      @Test(groups = {"main"})
     public void testEmpSpecial() {
                 Instructor instructor = new Instructor();
                 instructor.setEmployeeId("123-*&-4445");
                 instructor.setFirstName("Jack");
                 instructor.setOffice("CLK111");
                 instructor.setLastName("Jill");
                 instructor.setAddress("123 Jackson Str");
                 instructor.setCity("San Jose");
                 instructor.setState("CA");
                 instructor.setDepartment("CMPE");
                  instructor.setZipCode("98233");
                  Instructor instructorFromDB = instructorService.create(instructor);

                  String temp = instructorFromDB.getEmployeeId();
                   String tempType = instructorFromDB.getType().toString().toLowerCase();
                  System.out.println("Value of temp" + temp);

                  if (temp.toLowerCase().equals("123-*&-4445")&& tempType.equals("instructor"))
                      checkFlag = false;
                       else
                       checkFlag = true;
               Assert.assertFalse(checkFlag,"true");

               }
      @Test(groups = {"main"})

    public void testEmpEmpty() {
                     Instructor instructor = new Instructor();
                     instructor.setEmployeeId("");
                     instructor.setFirstName("Jack");
                     instructor.setOffice("CLK111");
                     instructor.setLastName("Jill");
                     instructor.setAddress("123 Jackson Str");
                     instructor.setCity("San Jose");
                     instructor.setState("CA");
                     instructor.setDepartment("CMPE");
                      instructor.setZipCode("98233");
                      Instructor instructorFromDB = instructorService.create(instructor);

                      String temp = instructorFromDB.getEmployeeId();
                       String tempType = instructorFromDB.getType().toString().toLowerCase();
                      System.out.println("Value of temp" + temp);

                      if (temp.toLowerCase().equals("")&& tempType.equals("instructor"))
                          checkFlag = false;
                           else
                           checkFlag = true;
                   Assert.assertFalse(checkFlag,"true");

                   }
      @Test(groups = {"main"})
      public void testEmpAlpha() {
                     Instructor instructor = new Instructor();
                     instructor.setEmployeeId("1AS-34-98f0");
                     instructor.setFirstName("Jack");
                     instructor.setOffice("CLK111");
                     instructor.setLastName("Jill");
                     instructor.setAddress("123 Jackson Str");
                     instructor.setCity("San Jose");
                     instructor.setState("CA");
                     instructor.setDepartment("CMPE");
                      instructor.setZipCode("98233");
                      Instructor instructorFromDB = instructorService.create(instructor);

                      String temp = instructorFromDB.getEmployeeId();
                       String tempType = instructorFromDB.getType().toString().toLowerCase();
                      System.out.println("Value of temp" + temp);

                      if (temp.toLowerCase().equals("1AS-34-98f0")&& tempType.equals("instructor"))
                          checkFlag = false;
                           else
                           checkFlag = true;
                   Assert.assertFalse(checkFlag,"true");

                   }

      @Test(groups = {"main"})
    public void testEmpFormat() {
                         Instructor instructor = new Instructor();
                         instructor.setEmployeeId("1346-98660");
                         instructor.setFirstName("Jack");
                         instructor.setOffice("CLK111");
                         instructor.setLastName("Jill");
                         instructor.setAddress("123 Jackson Str");
                         instructor.setCity("San Jose");
                         instructor.setState("CA");
                         instructor.setDepartment("CMPE");
                          instructor.setZipCode("98233");
                          Instructor instructorFromDB = instructorService.create(instructor);

                          String temp = instructorFromDB.getEmployeeId();
                           String tempType = instructorFromDB.getType().toString().toLowerCase();
                          System.out.println("Value of temp" + temp);

                          if (temp.toLowerCase().equals("1346-98660")&& tempType.equals("instructor"))
                              checkFlag = false;
                               else
                               checkFlag = true;
                       Assert.assertFalse(checkFlag,"true");

                       }
        
}
