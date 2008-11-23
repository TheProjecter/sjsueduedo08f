package edu.sjsu.edo08f.support;

/**
 * Created by IntelliJ IDEA.
 * User: Anita
 * Date: Nov 22, 2008
 * Time: 7:42:09 PM
 * To change this template use File | Settings | File Templates.
 */

import org.testng.annotations.Test;
import org.testng.Assert;
import edu.sjsu.edo08f.services.StudentService;
import edu.sjsu.edo08f.services.StudentServiceImpl;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.Main;
import edu.sjsu.edo08f.exceptions.NoSuchStudentException;

public class CreateStudentTest {
        StudentService studentService = (StudentService) Main.getBeanFactory().getBean("studentService");
        Student student = new Student();
        boolean checkFlag= false;


       @Test(groups = {"main"})

       //Test for First Name

        public void testFirstName() {
           student.setFirstName("Jack");

           Student studentFromDB = studentService.create(student);

           String temp = studentFromDB.getFirstName().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + temp);

           if (temp.toLowerCase().equals("jack")&& tempType.equals("student"))
           checkFlag = true;
           else
           checkFlag = false;
                                                   
           Assert.assertFalse(checkFlag,"true");
        }


     public void testFirstNameSpecial() {
           student.setFirstName("$#%0--09 *^ ");

           Student studentFromDB = studentService.create(student);

           String temp = studentFromDB.getFirstName().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + temp);

           if (temp.toLowerCase().equals("$#%0--09 *^ ")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");
        }

      public void testFirstNameNumbers() {
           student.setFirstName("12387986");

           Student studentFromDB = studentService.create(student);

           String temp = studentFromDB.getFirstName().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + temp);

           if (temp.toLowerCase().equals("12387986")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");
        }

      public void testFirstNameEmpty() {
           student.setFirstName("");

           Student studentFromDB = studentService.create(student);

           String temp = studentFromDB.getFirstName().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + temp);

           if (temp.toLowerCase().equals("")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");
        }

    //Tests for Last Name

        public void testLastName() {
            student.setLastName("Jill");

            Student studentFromDB = studentService.create(student);

            String tempFirstName = studentFromDB.getLastName().toString();
        String tempType = studentFromDB.getType().toString().toLowerCase();

            System.out.println("Value of temp" + tempFirstName);

            if (tempFirstName.toLowerCase().equals("jill")&& tempType.equals("student"))
                checkFlag = true;
            else
                checkFlag = false;

            Assert.assertFalse(checkFlag,"true");
        }

    public void testLastNameEmpty() {
            student.setLastName("");

            Student studentFromDB = studentService.create(student);

            String tempFirstName = studentFromDB.getLastName().toString();
        String tempType = studentFromDB.getType().toString().toLowerCase();

            System.out.println("Value of temp" + tempFirstName);

            if (tempFirstName.toLowerCase().equals("")&& tempType.equals("student"))
                checkFlag = false;
            else
                checkFlag = true;

            Assert.assertFalse(checkFlag,"true");
        }

     public void testLastNameSpecial() {
            student.setLastName("^%$0 )(*");

            Student studentFromDB = studentService.create(student);

            String tempFirstName = studentFromDB.getLastName().toString();
        String tempType = studentFromDB.getType().toString().toLowerCase();

            System.out.println("Value of temp" + tempFirstName);

            if (tempFirstName.toLowerCase().equals("^%$0 )(*")&& tempType.equals("student"))
                checkFlag = false;
            else
                checkFlag = true;

            Assert.assertFalse(checkFlag,"true");
        }

    public void testLastNameNumber() {
               student.setLastName("12587");

               Student studentFromDB = studentService.create(student);

               String tempFirstName = studentFromDB.getLastName().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

               System.out.println("Value of temp" + tempFirstName);

               if (tempFirstName.toLowerCase().equals("12587")&& tempType.equals("student"))
                   checkFlag = false;
               else
                   checkFlag = true;

               Assert.assertFalse(checkFlag,"true");
           }


      //Test for Address
        public void testAddress() {
        student.setAddress("123 ABC Street , San Jose ");

            Student studentFromDB = studentService.create(student);

            String tempFirstName = studentFromDB.getAddress().toString();
            String tempType = studentFromDB.getType().toString().toLowerCase();
        
           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.equals("123 ABC Street , San Jose ")&& tempType.equals("student"))
           checkFlag = true;
           else
           checkFlag = false;

           Assert.assertFalse(checkFlag,"true");


        }

     public void testAddressSpecial() {
        student.setAddress("^&%_) (* #@$@#  ");

            Student studentFromDB = studentService.create(student);

            String tempFirstName = studentFromDB.getAddress().toString();
            String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.equals("^&%_) (* #@$@#   ")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");


        }

     public void testAddressNegetiveNum() {
        student.setAddress("-123 ABC Street , San Jose ");

            Student studentFromDB = studentService.create(student);

            String tempFirstName = studentFromDB.getAddress().toString();
            String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.equals("123 ABC Street , San Jose ")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");


        }

    public void testAddressEmpty() {
        student.setAddress("");

            Student studentFromDB = studentService.create(student);

            String tempFirstName = studentFromDB.getAddress().toString();
            String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.equals("")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");


        }

    //Tests For City

        public void testCity() {
        student.setCity("San Jose");

           Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getCity().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.toLowerCase().equals("san jose")&& tempType.equals("student"))
           checkFlag = true;
           else
           checkFlag = false;

           Assert.assertFalse(checkFlag,"true");


        }

         public void testCitySpecial() {
        student.setCity("^^@$% 87 *&");

           Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getCity().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.toLowerCase().equals("^^@$% 87 *&")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");


        }

     public void testCityNumber() {
        student.setCity("124567");

           Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getCity().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.toLowerCase().equals("124567")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");

        }

     public void testCityEmpty() {
        student.setCity("");

           Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getCity().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.toLowerCase().equals("")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");


        }

    //Tests For States

        public void testState() {
        student.setState("CA");

           Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getState().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.toLowerCase().equals("ca") && tempType.equals("student") )
           checkFlag = true;
           else
           checkFlag = false;

           Assert.assertFalse(checkFlag,"true");


        }

     public void testStateSpecial() {
        student.setState("*&");

           Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getState().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.toLowerCase().equals("*&") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");


        }
          public void testStateWrong() {
        student.setState("MP");

           Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getState().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.toLowerCase().equals("mp") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");


        }

     public void testStateEmpty() {
        student.setState("");

           Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getState().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.toLowerCase().equals("") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");


        }

    public void testStateNumber() {
        student.setState("23");

           Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getState().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.toLowerCase().equals("23") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");


        }

    //Tests for Zip Codes

        public void testZip() {
           student.setZipCode("95123");
           Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getZipCode();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.toLowerCase().equals("95123") && tempType.equals("student") )
           checkFlag = true;
           else
           checkFlag = false;

           Assert.assertFalse(checkFlag,"true");


        }


        public void testZipAlpha() {
           student.setZipCode("4j-23");
           Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getZipCode();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.toLowerCase().equals("4j-23") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");


        }

           public void testZipNeg() {
           student.setZipCode("-98823");
           Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getZipCode();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.toLowerCase().equals("-98823") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");


        }

    public void testZipEmpty() {
           student.setZipCode("");
           Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getZipCode();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.toLowerCase().equals("") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");


        }

     public void testZipSpecial() {
           student.setZipCode("^$%__(");
           Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getZipCode();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.toLowerCase().equals("^$%__(") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;

           Assert.assertFalse(checkFlag,"true");


        }
}
