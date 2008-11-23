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
 * Date: Nov 23, 2008
 * Time: 3:58:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateInstructorTest {

    InstructorService instructorService = (InstructorService) Main.getBeanFactory().getBean("instructorService");
    Instructor instructor = new Instructor();
     boolean checkFlag= false;


           @Test(groups = {"main"})

                 //Test for First Name
            public void testFirstName() {
               instructor.setFirstName("Jack");

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


     public void testFirstNameSpecial() {
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

      public void testFirstNameNumbers() {
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

      public void testFirstNameEmpty() {
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

      public void testFirstNameAlphaN() {
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

            public void testLastName() {
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

            public void testLastNameSpecial() {
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

    public void testLastNameNumber() {
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

    public void testLastNameEmpty() {
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


    public void testLastNameAlpha() {
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

            public void testAddress() {
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


    public void testAddressEmpty() {
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

    public void testAddressSpecial() {
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


    public void testAddressNeg() {
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
            public void testCity() {
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

      public void testCitySpecial() {
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

     public void testCityNumber() {
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

    public void testCityEmpty() {
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

    public void testCityAlphaN() {
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
            public void testState() {
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

    public void testStateEmpty() {
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

     public void testStateAlpha() {
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
    
    public void testStateSpecial() {
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

    public void testStateWrong() {
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
            public void testZip() {
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
    public void testZipEmpty() {
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

    public void testZipSpecial() {
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

    public void testZipNeg() {
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

     public void testZipAlpha() {
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



}
