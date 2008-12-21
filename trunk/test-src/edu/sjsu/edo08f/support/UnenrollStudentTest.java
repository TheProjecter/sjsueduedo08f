package edu.sjsu.edo08f.support;

import edu.sjsu.edo08f.services.StudentService;
import edu.sjsu.edo08f.services.CourseService;
import edu.sjsu.edo08f.services.InstructorService;
import edu.sjsu.edo08f.BeanRetriever;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.domain.Course;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Anita
 * Date: Dec 7, 2008
 * Time: 11:11:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class UnenrollStudentTest {
        StudentService studentService = (StudentService) BeanRetriever.getBeanFactory().getBean("studentService");
        CourseService courseService = (CourseService) BeanRetriever.getBeanFactory().getBean("courseService");
        InstructorService instructorService = (InstructorService) BeanRetriever.getBeanFactory().getBean("instructorService");

        boolean checkFlag = false;

        //Test for unenroll 1 student from 1 course

        @Test

        public void testUnEnrollStud() {

            Student student = new Student();
            student.setFirstName("Jack");
            student.setLastName("Jill");
            student.setAddress("98 ABC Street");
            student.setState("CA");
            student.setCity("San Jose");
            student.setZipCode("12345");
            student.setStudentId("123-00-0098");


            Instructor instructor = new Instructor();
            Course course = new Course();
            instructor.setEmployeeId("123-23-4445");
            instructor.setFirstName("Jack");
            instructor.setLastName("Jill");
            instructor.setOffice("CLK111");
            instructor.setAddress("1237 Snatal st");
            instructor.setCity("San Diego");
            instructor.setState("CA");
            instructor.setZipCode("12345");
            instructor.setDepartment("CMPE");


            course.setName("Design");
            course.setLocation("BNR01");
            course.setSection(1);
            course.setUnits(3);
            List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
            meetingHrs.add(new EventInformation(DayOfWeek.Tuesday, "1300", "1600"));
            course.setMeetingHours(meetingHrs);

            Student studentFromDB = studentService.create(student);
            Instructor instructorFromDB = instructorService.create(instructor);
            Course courseFromDB = courseService.create(course, instructorFromDB);
            courseService.enrollStudent(courseFromDB, studentFromDB);

            try {

                courseService.unEnrollStudent(courseFromDB, studentFromDB);
                List<Course> tempCourses = studentService.getAssociatedCourses(studentFromDB);
                if (tempCourses.size() > 0) checkFlag = false;

                for (Course tempCoursesCheck : tempCourses) {
                    if (tempCoursesCheck.getName().toString().toLowerCase() == "design") {
                        checkFlag = true;
                    }
                }

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
                List<Instructor> instructors = instructorService.getAll();
                for (Instructor instructorsToBeDeleted : instructors) {
                    instructorService.delete(instructorsToBeDeleted);
                }
                List<Course> courses = courseService.getAll();
                for (Course courseToBeDeleted : courses) {
                    courseService.delete(courseToBeDeleted);
                }
            }

        }

//Test for unenroll student from a never enrolled course

    @Test

    public void testUnEnrollNotEnrolledCourse() {

        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Jill");
        student.setAddress("98 ABC Street");
        student.setState("CA");
        student.setCity("San Jose");
        student.setZipCode("12345");
        student.setStudentId("123-00-0098");


        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("123-23-4445");
        instructor.setFirstName("Jack");
        instructor.setLastName("Jill");
        instructor.setOffice("CLK111");
        instructor.setAddress("1237 Snatal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");


        course.setName("Design");
        course.setLocation("BNR01");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Tuesday, "1300", "1600"));
        course.setMeetingHours(meetingHrs);

        Student studentFromDB = studentService.create(student);
        Instructor instructorFromDB = instructorService.create(instructor);
        Course courseFromDB = courseService.create(course, instructorFromDB);
        //courseService.enrollStudent(courseFromDB, studentFromDB);

        try {

            courseService.unEnrollStudent(courseFromDB, studentFromDB);
            List<Course> tempCourses = studentService.getAssociatedCourses(studentFromDB);
            for (Course tempCoursesCheck : tempCourses) {
                if (tempCoursesCheck.getName().toString().toLowerCase() == "design") {
                    checkFlag = false;
                }
            }

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
            List<Instructor> instructors = instructorService.getAll();
            for (Instructor instructorsToBeDeleted : instructors) {
                instructorService.delete(instructorsToBeDeleted);
            }
            List<Course> courses = courseService.getAll();
            for (Course courseToBeDeleted : courses) {
                courseService.delete(courseToBeDeleted);
            }
        }

    }

    //UnEnroll student who doesnt exist.
    @Test

    public void testEnrollNonStud() {

        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Jill");
        student.setAddress("98 ABC Street");
        student.setState("CA");
        student.setCity("San Jose");
        student.setZipCode("12345");
        student.setStudentId("123-00-0098");


        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("123-23-4445");
        instructor.setFirstName("Jack");
        instructor.setLastName("Jill");
        instructor.setOffice("CLK111");
        instructor.setAddress("1237 Snatal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");


        course.setName("Design");
        course.setLocation("BNR01");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Tuesday, "1300", "1600"));
        course.setMeetingHours(meetingHrs);

        //Student studentFromDB = studentService.create(student);
        Instructor instructorFromDB = instructorService.create(instructor);
        Course courseFromDB = courseService.create(course, instructorFromDB);


        try {
            courseService.unEnrollStudent(courseFromDB, student);
            List<Student> studentsEnrolled = courseService.getStudentsByCourse(courseFromDB);
            for (Student tempStudentCheck : studentsEnrolled) {
                if ((tempStudentCheck.getFirstName().toString().toLowerCase() == "jack") && (tempStudentCheck.getLastName().toString().toLowerCase() == "jill")) {
                    checkFlag = false;
                } else {
                    checkFlag = true;
                }
            }
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
            List<Instructor> instructors = instructorService.getAll();
            for (Instructor instructorsToBeDeleted : instructors) {
                instructorService.delete(instructorsToBeDeleted);
            }
            List<Course> courses = courseService.getAll();
            for (Course courseToBeDeleted : courses) {
                courseService.delete(courseToBeDeleted);
            }
        }

    }

  //UnEnroll student from course that doesnt exist.
    @Test

    public void testEnrollNonCourse() {

        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Jill");
        student.setAddress("98 ABC Street");
        student.setState("CA");
        student.setCity("San Jose");
        student.setZipCode("12345");
        student.setStudentId("123-00-0098");


        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("123-23-4445");
        instructor.setFirstName("Jack");
        instructor.setLastName("Jill");
        instructor.setOffice("CLK111");
        instructor.setAddress("1237 Snatal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");


        course.setName("Design");
        course.setLocation("BNR01");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Tuesday, "1300", "1600"));
        course.setMeetingHours(meetingHrs);

        Student studentFromDB = studentService.create(student);
        Instructor instructorFromDB = instructorService.create(instructor);
       // Course courseFromDB = courseService.create(course, instructorFromDB);


        try {
            courseService.unEnrollStudent(course, studentFromDB);
             List<Course> tempCourses = studentService.getAssociatedCourses(studentFromDB);
             if (tempCourses.size()>0) checkFlag = false;
             else checkFlag = true;
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
            List<Instructor> instructors = instructorService.getAll();
            for (Instructor instructorsToBeDeleted : instructors) {
                instructorService.delete(instructorsToBeDeleted);
            }
            List<Course> courses = courseService.getAll();
            for (Course courseToBeDeleted : courses) {
                courseService.delete(courseToBeDeleted);
            }
        }

    }


}


