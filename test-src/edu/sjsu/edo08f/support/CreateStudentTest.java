package edu.sjsu.edo08f.support;

/**
 * Created by IntelliJ IDEA.
 * User: Anita
 * Date: Nov 21, 2008
 * Time: 7:42:09 PM
 * To change this template use File | Settings | File Templates.
 */

import org.testng.annotations.Test;
import org.testng.Assert;
import edu.sjsu.edo08f.services.StudentService;
import edu.sjsu.edo08f.services.StudentServiceImpl;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.Main;
import edu.sjsu.edo08f.BeanRetriever;

import java.util.List;


public class CreateStudentTest {
        StudentService studentService = (StudentService) BeanRetriever.getBeanFactory().getBean("studentService");

        boolean checkFlag= false;

    public CreateStudentTest() {
    }

    @Test

       //Test for First Name

        public void testFirstName() {
                  Student student = new Student();
                  student.setFirstName("Jack");
                  student.setLastName("Jill");
                  student.setAddress("98 ABC Street");
                  student.setState("CA");
                  student.setCity("San Jose");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");

                try{
                    Student studentFromDB = studentService.create(student);



                  String temp = studentFromDB.getFirstName().toString();
                  String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + temp);



           if (temp.toLowerCase().equals("jack")&& tempType.equals("student"))
           checkFlag = true;
           else
           checkFlag = false;
           }

           catch(Exception e)
           {
               checkFlag=false;
           }
           finally {
                   Assert.assertEquals(checkFlag, true);
                   List<Student> students = studentService.getAll();
                   for (Student studentToBeDeleted : students) {
                       studentService.delete(studentToBeDeleted);
                   }
               }
           
        }

    @Test
     public void testFirstNameSpecial() {


                  Student student = new Student();
                  student.setFirstName("$#%0--09 *^ ");
                  student.setLastName("Jill");
                  student.setAddress("98 ABC Street");
                  student.setState("CA");
                  student.setCity("San Jose");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");

       try{
           Student studentFromDB = studentService.create(student);

           String temp = studentFromDB.getFirstName().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + temp);


           if (temp.toLowerCase().equals("$#%0--09 *^ ")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;
            }

            catch (Exception e){

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

      @Test
      public void testFirstNameNumbers() {

             Student student = new Student();
                 student.setFirstName("12387986");
                  student.setLastName("Jill");
                  student.setAddress("98 ABC Street");
                  student.setState("CA");
                  student.setCity("San Jose");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");

               try{
           Student studentFromDB = studentService.create(student);

           String temp = studentFromDB.getFirstName().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + temp);


              if (temp.toLowerCase().equals("12387986")&& tempType.equals("student"))
                         checkFlag = false;
                         else
                         checkFlag = true;

          }
               catch (Exception e)
               {
                   checkFlag= true;
               }

          Assert.assertFalse(checkFlag,"true");
        }


      @Test
      public void testFirstNameEmpty() {

            Student student = new Student();
                 student.setFirstName("");
                  student.setLastName("Jill");
                  student.setAddress("98 ABC Street");
                  student.setState("CA");
                  student.setCity("San Jose");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
       try{     Student studentFromDB = studentService.create(student);

           String temp = studentFromDB.getFirstName().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + temp);


                   if (temp.toLowerCase().equals("")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;
          }
              catch(Exception e ){
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

          @Test
      public void testFirstNameAlpha() {

          Student student = new Student();
                   student.setFirstName("Skj23");
                  student.setLastName("Jill");
                  student.setAddress("98 ABC Street");
                  student.setState("CA");
                  student.setCity("San Jose");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");

     try{      Student studentFromDB = studentService.create(student);

           String temp = studentFromDB.getFirstName().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + temp);


           if (temp.toLowerCase().equals("Skj23")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;}

              catch(Exception e){ checkFlag = true;}

     finally {
                 Assert.assertEquals(checkFlag, true);
                 List<Student> students = studentService.getAll();
                 for (Student studentToBeDeleted : students) {
                     studentService.delete(studentToBeDeleted);
                 }
             }

        }

    //Tests for Last Name

      @Test

        public void testLastName() {

            Student student = new Student();
                   student.setFirstName("Jack");
                  student.setLastName("Jill");
                  student.setAddress("98 ABC Street");
                  student.setState("CA");
                  student.setCity("San Jose");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
         try{      Student studentFromDB = studentService.create(student);

            String tempFirstName = studentFromDB.getLastName().toString();
        String tempType = studentFromDB.getType().toString().toLowerCase();

            System.out.println("Value of temp" + tempFirstName);


            if (tempFirstName.toLowerCase().equals("jill")&& tempType.equals("student"))
                checkFlag = true;
            else
                checkFlag = false;
      }
                      catch(Exception e){ checkFlag = false;}
            Assert.assertFalse(checkFlag,"true");
        }

      @Test
    public void testLastNameEmpty() {

             Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("");
                  student.setAddress("98 ABC Street");
                  student.setState("CA");
                  student.setCity("San Jose");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
        try{     Student studentFromDB = studentService.create(student);

            String tempFirstName = studentFromDB.getLastName().toString();
        String tempType = studentFromDB.getType().toString().toLowerCase();

            System.out.println("Value of temp" + tempFirstName);


            if (tempFirstName.toLowerCase().equals("")&& tempType.equals("student"))
                checkFlag = false;
            else
                checkFlag = true;
            }
            catch(Exception e){ checkFlag = true;}
        finally {
                    Assert.assertEquals(checkFlag, true);
                    List<Student> students = studentService.getAll();
                    for (Student studentToBeDeleted : students) {
                        studentService.delete(studentToBeDeleted);
                    }
                }

        }

      @Test

     public void testLastNameSpecial() {

           Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("^%$0 )(*");
                  student.setAddress("98 ABC Street");
                  student.setState("CA");
                  student.setCity("San Jose");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
            try{        Student studentFromDB = studentService.create(student);

            String tempFirstName = studentFromDB.getLastName().toString();
        String tempType = studentFromDB.getType().toString().toLowerCase();

            System.out.println("Value of temp" + tempFirstName);


            if (tempFirstName.toLowerCase().equals("^%$0 )(*")&& tempType.equals("student"))
                checkFlag = false;
            else
                checkFlag = true;
          }
          catch(Exception e){ checkFlag = true;}
            finally {
                        Assert.assertEquals(checkFlag, true);
                        List<Student> students = studentService.getAll();
                        for (Student studentToBeDeleted : students) {
                            studentService.delete(studentToBeDeleted);
                        }
                    }

        }


      @Test

    public void testLastNameNumber() {

               Student student = new Student();
                   student.setFirstName("Jack");
                  student.setLastName("12587");
                  student.setAddress("98 ABC Street");
                  student.setState("CA");
                  student.setCity("San Jose");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
         try{       Student studentFromDB = studentService.create(student);

               String tempFirstName = studentFromDB.getLastName().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

               System.out.println("Value of temp" + tempFirstName);


               if (tempFirstName.toLowerCase().equals("12587")&& tempType.equals("student"))
                   checkFlag = false;
               else
                   checkFlag = true;
          }
        catch(Exception e){ checkFlag = true;}
         finally {
                     Assert.assertEquals(checkFlag, true);
                     List<Student> students = studentService.getAll();
                     for (Student studentToBeDeleted : students) {
                         studentService.delete(studentToBeDeleted);
                     }
                 }

        }



      @Test
     public void testLastNameAlpha() {

                Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("hu87sf");
                  student.setAddress("98 ABC Street");
                  student.setState("CA");
                  student.setCity("San Jose");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
          try{     Student studentFromDB = studentService.create(student);

               String tempFirstName = studentFromDB.getLastName().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

               System.out.println("Value of temp" + tempFirstName);


               if (tempFirstName.toLowerCase().equals("hu87sf")&& tempType.equals("student"))
                   checkFlag = false;
               else
                   checkFlag = true;
          }
          catch(Exception e){ checkFlag = true;}
          finally {
                      Assert.assertEquals(checkFlag, true);
                      List<Student> students = studentService.getAll();
                      for (Student studentToBeDeleted : students) {
                          studentService.delete(studentToBeDeleted);
                      }
                  }

           }


      //Test for Address

      @Test
        public void testAddress() {

             Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("hu87sf");
                  student.setAddress("98 ABC Street");
                  student.setState("CA");
                  student.setCity("San Jose");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
        try{      Student studentFromDB = studentService.create(student);

            String tempFirstName = studentFromDB.getAddress().toString();
            String tempType = studentFromDB.getType().toString().toLowerCase();
        
           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.equals("123 ABC Street , San Jose ")&& tempType.equals("student"))
           checkFlag = true;
           else
           checkFlag = false;
          }

          catch(Exception e){ checkFlag =false;}
        finally {
                    Assert.assertEquals(checkFlag, true);
                    List<Student> students = studentService.getAll();
                    for (Student studentToBeDeleted : students) {
                        studentService.delete(studentToBeDeleted);
                    }
                }


        }

      @Test
     public void testAddressSpecial() {

            Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("hu87sf");
                   student.setAddress("^&%_) (* #@$@#  ");
                  student.setState("CA");
                  student.setCity("San Jose");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
         try{       Student studentFromDB = studentService.create(student);

            String tempFirstName = studentFromDB.getAddress().toString();
            String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.equals("^&%_) (* #@$@#   ")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;
          }

          catch(Exception e){ checkFlag = true;}
         finally {
                     Assert.assertEquals(checkFlag, true);
                     List<Student> students = studentService.getAll();
                     for (Student studentToBeDeleted : students) {
                         studentService.delete(studentToBeDeleted);
                     }
                 }

        }

      @Test
     public void testAddressNegetiveNum() {
           Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("hu87sf");
                   //student.setAddress("^&%_) (* #@$@#  ");
                  student.setState("CA");
                  student.setCity("San Jose");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
        student.setAddress("-123 ABC Street , San Jose ");

       try{        Student studentFromDB = studentService.create(student);

            String tempFirstName = studentFromDB.getAddress().toString();
            String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.equals("-123 ABC Street , San Jose ")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;
      }
           catch(Exception e){ checkFlag = true;}
       finally {
                   Assert.assertEquals(checkFlag, true);
                   List<Student> students = studentService.getAll();
                   for (Student studentToBeDeleted : students) {
                       studentService.delete(studentToBeDeleted);
                   }
               }



        }

                                @Test
    public void testAddressEmpty() {
                                    try {Thread.sleep(5000); } catch (Exception e) {}
          Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("hu87sf");
                   //student.setAddress("^&%_) (* #@$@#  ");
                  student.setState("CA");
                  student.setCity("San Jose");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
        student.setAddress("");

      try{       Student studentFromDB = studentService.create(student);

            String tempFirstName = studentFromDB.getAddress().toString();
            String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.equals("")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;
          }
            catch(Exception e){ checkFlag = true;}
      finally {
                  Assert.assertEquals(checkFlag, true);
                  List<Student> students = studentService.getAll();
                  for (Student studentToBeDeleted : students) {
                      studentService.delete(studentToBeDeleted);
                  }
              }


        }

    //Tests For City

      @Test
        public void testCity() {
              Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("Jill");
                   student.setAddress("123 ABC St");
                  student.setState("CA");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
        student.setCity("San Jose");

       try{      Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getCity().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


          if (tempFirstName.toLowerCase().equals("san jose")&& tempType.equals("student"))
           checkFlag = true;
           else
           checkFlag = false;
          }
           catch(Exception e){ checkFlag = false;}
       finally {
                   Assert.assertEquals(checkFlag, true);
                   List<Student> students = studentService.getAll();
                   for (Student studentToBeDeleted : students) {
                       studentService.delete(studentToBeDeleted);
                   }
               }

        }

      @Test
         public void testCitySpecial() {
             Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("Jill");
                    student.setAddress("123 ABC St");
                  student.setState("CA");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
        student.setCity("^^@$% 87 *&");

          try{         Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getCity().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.toLowerCase().equals("^^@$% 87 *&")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;
          }

          catch(Exception e){ checkFlag = true;}
          finally {
                      Assert.assertEquals(checkFlag, true);
                      List<Student> students = studentService.getAll();
                      for (Student studentToBeDeleted : students) {
                          studentService.delete(studentToBeDeleted);
                      }
                  }

        }

      @Test

     public void testCityNumber() {
          Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("Jill");
                   student.setAddress("123 ABC St");
                  student.setState("CA");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
        student.setCity("124567");

    try{        Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getCity().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


          if (tempFirstName.toLowerCase().equals("124567")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;
          }
          catch(Exception e){ checkFlag = true;}
    finally {
                Assert.assertEquals(checkFlag, true);
                List<Student> students = studentService.getAll();
                for (Student studentToBeDeleted : students) {
                    studentService.delete(studentToBeDeleted);
                }
            }

        }

      @Test
     public void testCityEmpty() {
          Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("Jill");
                   student.setAddress("123 ABC Str");
                  student.setState("CA");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
        student.setCity("");

       try{       Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getCity().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.toLowerCase().equals("")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;
          }
           catch(Exception e){ checkFlag = true;}
       finally {
                   Assert.assertEquals(checkFlag, true);
                   List<Student> students = studentService.getAll();
                   for (Student studentToBeDeleted : students) {
                       studentService.delete(studentToBeDeleted);
                   }
               }


        }

      @Test

    public void testCityAlpha() {
         Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("Jill");
                   student.setAddress("123 ABS St");
                  student.setState("CA");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
        student.setCity("C6th9");

          try{        Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getCity().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.toLowerCase().equals("C6th9")&& tempType.equals("student"))
           checkFlag = false;
           else
           checkFlag = true;
          }
           catch(Exception e){ checkFlag = true;}
          finally {
                      Assert.assertEquals(checkFlag, true);
                      List<Student> students = studentService.getAll();
                      for (Student studentToBeDeleted : students) {
                          studentService.delete(studentToBeDeleted);
                      }
                  }

        }

    //Tests For States


      @Test
        public void testState() {
             Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("Jill");
                   student.setAddress("123 ABC Street");
                   student.setZipCode("12345");
                  student.setStudentId("123-00-004");

        student.setState("CA");

       try{       Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getState().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.toLowerCase().equals("ca") && tempType.equals("student") )
           checkFlag = true;
           else
           checkFlag = false;
          }
           catch(Exception e){ checkFlag = false;}
       finally {
                   Assert.assertEquals(checkFlag, true);
                   List<Student> students = studentService.getAll();
                   for (Student studentToBeDeleted : students) {
                       studentService.delete(studentToBeDeleted);
                   }
               }


        }

      @Test
     public void testStateSpecial() {
          Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("Jill");
                   student.setAddress("123 ABC St");
                  student.setCity("San Jose");
                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");

        student.setState("*&");

          try{       Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getState().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


          if (tempFirstName.toLowerCase().equals("*&") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;
          }
 catch(Exception e){ checkFlag = true;}
          finally {
                      Assert.assertEquals(checkFlag, true);
                      List<Student> students = studentService.getAll();
                      for (Student studentToBeDeleted : students) {
                          studentService.delete(studentToBeDeleted);
                      }
                  }

        }

      @Test
          public void testStateWrong() {
               Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("Jill");
                   student.setAddress("123 ABC St");

                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
        student.setCity("San Jose");
        student.setState("MP");

       try{        Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getState().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.toLowerCase().equals("mp") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;
          }
           catch(Exception e){ checkFlag = true;}
       finally {
                   Assert.assertEquals(checkFlag, true);
                   List<Student> students = studentService.getAll();
                   for (Student studentToBeDeleted : students) {
                       studentService.delete(studentToBeDeleted);
                   }
               }
         
        }

      @Test
     public void testStateEmpty() {
               Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("Jill");
                   student.setAddress("123 ABC St");

                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
        student.setCity("San Jose");

        student.setState("");

       try{      Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getState().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.toLowerCase().equals("") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;
          }
           catch(Exception e){ checkFlag = true;}
         finally {
            Assert.assertEquals(checkFlag, true);
            List<Student> students = studentService.getAll();
            for (Student studentToBeDeleted : students) {
                studentService.delete(studentToBeDeleted);
            }
        }


        }

      @Test
    public void testStateNumber() {
              Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("Jill");
                   student.setAddress("123 ABC St");

                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
        student.setCity("San Jose");
        student.setState("23");

     try{       Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getState().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


          if (tempFirstName.toLowerCase().equals("23") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;
          }
           catch(Exception e){ checkFlag = true;}
     finally {
                 Assert.assertEquals(checkFlag, true);
                 List<Student> students = studentService.getAll();
                 for (Student studentToBeDeleted : students) {
                     studentService.delete(studentToBeDeleted);
                 }
             }

        }

      @Test
    public void testStateAlpha() {
              Student student = new Student();
                   student.setFirstName("Jack");
                 student.setLastName("Jill");
                   student.setAddress("123 ABC St");

                  student.setZipCode("12345");
                  student.setStudentId("123-00-004");
        student.setCity("San Jose");
        student.setState("2C");

   try{         Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getState().toString();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.toLowerCase().equals("2C") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;
          }
          catch(Exception e){ checkFlag = true;}
   finally {
               Assert.assertEquals(checkFlag, true);
               List<Student> students = studentService.getAll();
               for (Student studentToBeDeleted : students) {
                   studentService.delete(studentToBeDeleted);
               }
           }

      }

    //Tests for Zip Codes

      @Test
        public void testZip() {
                    Student student = new Student();
                    student.setFirstName("Jack");
                    student.setLastName("Jill");
                    student.setAddress("123 ABC St");
                    student.setStudentId("123-00-004");
                    student.setCity("San Jose");
                    student.setState("CA");
                    student.setZipCode("95123");
          try{      Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getZipCode();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.toLowerCase().equals("95123") && tempType.equals("student") )
           checkFlag = true;
           else
           checkFlag = false;
          }
           catch(Exception e){ checkFlag = false;}
          finally {
                      Assert.assertEquals(checkFlag, true);
                      List<Student> students = studentService.getAll();
                      for (Student studentToBeDeleted : students) {
                          studentService.delete(studentToBeDeleted);
                      }
                  }


        }

          @Test
        public void testZipAlpha() {
            Student student = new Student();
                    student.setFirstName("Jack");
                    student.setLastName("Jill");
                    student.setAddress("123 ABC St");
                    student.setStudentId("123-00-004");
                    student.setCity("San Jose");
                    student.setState("CA");
           student.setZipCode("4j-23");
       try{         Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getZipCode();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


              if (tempFirstName.toLowerCase().equals("4j-23") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;
              }

               catch(Exception e){ checkFlag = true;}
       finally {
                   Assert.assertEquals(checkFlag, true);
                   List<Student> students = studentService.getAll();
                   for (Student studentToBeDeleted : students) {
                       studentService.delete(studentToBeDeleted);
                   }
               }

        }
            @Test
           public void testZipNeg() {
               Student student = new Student();
                    student.setFirstName("Jack");
                    student.setLastName("Jill");
                    student.setAddress("123 ABC St");
                    student.setStudentId("123-00-004");
                    student.setCity("San Jose");
                    student.setState("CA");
           student.setZipCode("-98823");
             try{       Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getZipCode();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.toLowerCase().equals("-98823") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;
           }

            catch(Exception e){ checkFlag = true;}
             finally {
                         Assert.assertEquals(checkFlag, true);
                         List<Student> students = studentService.getAll();
                         for (Student studentToBeDeleted : students) {
                             studentService.delete(studentToBeDeleted);
                         }
                     }


        }
           @Test
    public void testZipEmpty() {
        Student student = new Student();
                    student.setFirstName("Jack");
                    student.setLastName("Jill");
                    student.setAddress("123 ABC St");
                    student.setStudentId("123-00-004");
                    student.setCity("San Jose");
                    student.setState("CA");
           student.setZipCode("");
       try{          Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getZipCode();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.toLowerCase().equals("") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;
               }

                catch(Exception e){ checkFlag = true;}
       finally {
                   Assert.assertEquals(checkFlag, true);
                   List<Student> students = studentService.getAll();
                   for (Student studentToBeDeleted : students) {
                       studentService.delete(studentToBeDeleted);
                   }
               }


        }
           @Test
     public void testZipSpecial() {
         Student student = new Student();
                    student.setFirstName("Jack");
                    student.setLastName("Jill");
                    student.setAddress("123 ABC St");
                    student.setStudentId("123-00-004");
                    student.setCity("San Jose");
                    student.setState("CA");
           student.setZipCode("^$%__(");
           try{      Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getZipCode();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


               if (tempFirstName.toLowerCase().equals("^$%__(") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;
               }

            catch(Exception e){ checkFlag = true;}
           finally {
                       Assert.assertEquals(checkFlag, true);
                       List<Student> students = studentService.getAll();
                       for (Student studentToBeDeleted : students) {
                           studentService.delete(studentToBeDeleted);
                       }
                   }



        }

    //test for Id
              @Test
     public void testStudId() {
         Student student = new Student();
                    student.setFirstName("Jack");
                    student.setLastName("Jill");
                    student.setAddress("123 ABC St");
                    student.setStudentId("123-00-004");
                    student.setCity("San Jose");
                    student.setState("CA");
           student.setZipCode("95112");
          try{     Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getStudentId();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.toLowerCase().equals("123-00-004") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;
        }
         catch(Exception e){ checkFlag = true;}
          finally {
                      Assert.assertEquals(checkFlag, true);
                      List<Student> students = studentService.getAll();
                      for (Student studentToBeDeleted : students) {
                          studentService.delete(studentToBeDeleted);
                      }
                  }



        }

      @Test
    public void testStudIdEmpty() {
         Student student = new Student();
                    student.setFirstName("Jack");
                    student.setLastName("Jill");
                    student.setAddress("123 ABC St");
                    student.setStudentId("");
                    student.setCity("San Jose");
                    student.setState("CA");
           student.setZipCode("95112");
        try{      Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getStudentId();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.toLowerCase().equals("") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;
          }
           catch(Exception e){ checkFlag = true;}
        finally {
                    Assert.assertEquals(checkFlag, true);
                    List<Student> students = studentService.getAll();
                    for (Student studentToBeDeleted : students) {
                        studentService.delete(studentToBeDeleted);
                    }
                }

        }

      @Test
     public void testStudIdSpecial() {
         Student student = new Student();
                    student.setFirstName("Jack");
                    student.setLastName("Jill");
                    student.setAddress("123 ABC St");
                    student.setStudentId("123-^&-004");
                    student.setCity("San Jose");
                    student.setState("CA");
           student.setZipCode("95112");
        try{     Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getStudentId();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

           if (tempFirstName.toLowerCase().equals("123-^&-004") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;
          }
            catch(Exception e){ checkFlag = true;}
        finally {
                    Assert.assertEquals(checkFlag, true);
                    List<Student> students = studentService.getAll();
                    for (Student studentToBeDeleted : students) {
                        studentService.delete(studentToBeDeleted);
                    }
                }



        }

      @Test
         public void testStudIdAlpha() {
         Student student = new Student();
                    student.setFirstName("Jack");
                    student.setLastName("Jill");
                    student.setAddress("123 ABC St");
                    student.setStudentId("12K-AB-004");
                    student.setCity("San Jose");
                    student.setState("CA");
           student.setZipCode("95112");
      try{          Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getStudentId();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);


           if (tempFirstName.toLowerCase().equals("12K-AB-004") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;
          }
           catch(Exception e){ checkFlag = true;}
      finally {
                  Assert.assertEquals(checkFlag, true);
                  List<Student> students = studentService.getAll();
                  for (Student studentToBeDeleted : students) {
                      studentService.delete(studentToBeDeleted);
                  }
              }


        }

      @Test
    public void testStudIdFormat() {
         Student student = new Student();
                    student.setFirstName("Jack");
                    student.setLastName("Jill");
                    student.setAddress("123 ABC St");
                    student.setStudentId("1234-00004");
                    student.setCity("San Jose");
                    student.setState("CA");
           student.setZipCode("95112");
       try{       Student studentFromDB = studentService.create(student);

           String tempFirstName = studentFromDB.getStudentId();
           String tempType = studentFromDB.getType().toString().toLowerCase();

           System.out.println("Value of temp" + tempFirstName);

   
           if (tempFirstName.toLowerCase().equals("1234-00004") && tempType.equals("student") )
           checkFlag = false;
           else
           checkFlag = true;
          }
            catch(Exception e){ checkFlag = true;}
       finally {
                   Assert.assertEquals(checkFlag, true);
                   List<Student> students = studentService.getAll();
                   for (Student studentToBeDeleted : students) {
                       studentService.delete(studentToBeDeleted);
                   }
               }


        }

}
