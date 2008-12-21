package edu.sjsu.edo08f.support;

import org.testng.annotations.Test;
import org.testng.Assert;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.services.StudentService;
import edu.sjsu.edo08f.services.CourseService;
import edu.sjsu.edo08f.services.InstructorService;
import edu.sjsu.edo08f.Main;
import edu.sjsu.edo08f.BeanRetriever;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Anita
 * Date: Dec 3, 2008
 * Time: 5:02:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class EnrolStudentTest {

    StudentService studentService = (StudentService) BeanRetriever.getBeanFactory().getBean("studentService");
    CourseService courseService = (CourseService) BeanRetriever.getBeanFactory().getBean("courseService");
    InstructorService instructorService = (InstructorService) BeanRetriever.getBeanFactory().getBean("instructorService");

    boolean checkFlag = false;

    //Test for enroll 1 student in 1 course

    @Test

    public void testEnrollStud() {

        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Jill");
        student.setAddress("98 ABC Street");
        student.setState("CA");
        student.setCity("San Jose");
        student.setZipCode("12345");
        student.setStudentId("129-00-0098");


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

        try {
            Course courseFromDB = courseService.create(course, instructorFromDB);
            courseService.enrollStudent(courseFromDB, studentFromDB);
            List<Student> studentsEnrolled = courseService.getStudentsByCourse(courseFromDB);

            List<Course> tempCourses = studentService.getAssociatedCourses(studentFromDB);
            if (tempCourses.size() > 1) checkFlag = false;

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

    // Test for enrolling 1 student in multiple courses

    @Test

    public void testEnrollStudMultipleCourses() {

        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Jill");
        student.setAddress("98 ABC Street");
        student.setState("CA");
        student.setCity("San Jose");
        student.setZipCode("12345");
        student.setStudentId("123-03-0098");


        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("198-23-4445");
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
        course.setUnits(9);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Tuesday, "1300", "1600"));
        course.setMeetingHours(meetingHrs);
        try {

        Course course2 = new Course();
        course2.setName("Art");
        course2.setLocation("BNR11");
        course2.setSection(1);
        course2.setUnits(8);
        List<EventInformation> meetingHrs2 = new ArrayList<EventInformation>();
        meetingHrs2.add(new EventInformation(DayOfWeek.Monday, "1300", "1600"));
        course2.setMeetingHours(meetingHrs2);

        Course course3 = new Course();
        course3.setName("Fun");
        course3.setLocation("BNR11");
        course3.setSection(1);
        course3.setUnits(7);
        List<EventInformation> meetingHrs3 = new ArrayList<EventInformation>();
        meetingHrs3.add(new EventInformation(DayOfWeek.Monday, "1800", "1900"));
        course3.setMeetingHours(meetingHrs3);

        Student studentFromDB = studentService.create(student);
        Instructor instructorFromDB = instructorService.create(instructor);


            Course courseFromDB = courseService.create(course, instructorFromDB);
            Course courseFromDB2 = courseService.create(course2, instructorFromDB);
            Course courseFromDB3 = courseService.create(course3, instructorFromDB);
            courseService.enrollStudent(courseFromDB, studentFromDB);
            courseService.enrollStudent(courseFromDB2, studentFromDB);
            courseService.enrollStudent(courseFromDB3, studentFromDB);

            List<Course> tempCourses = studentService.getAssociatedCourses(studentFromDB);

            for (Course tempCoursesCheck : tempCourses) {
                if (tempCoursesCheck.getName().toString().toLowerCase() == "design" || tempCoursesCheck.getName().toString().toLowerCase() == "art" || tempCoursesCheck.getName().toString().toLowerCase() == "fun") {
                    checkFlag = false;
                } else {
                    checkFlag = true;
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

    //Student enrolled in courses with >24 units.
    @Test

    public void testEnrollStudExceedUnits() {

        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Jill");
        student.setAddress("98 ABC Street");
        student.setState("CA");
        student.setCity("San Jose");
        student.setZipCode("12345");
        student.setStudentId("103-00-0098");


        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("103-13-4445");
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
        course.setUnits(9);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Tuesday, "1300", "1600"));
        course.setMeetingHours(meetingHrs);


        Course course2 = new Course();
        course2.setName("Art");
        course2.setLocation("BNR11");
        course2.setSection(1);
        course2.setUnits(8);
        List<EventInformation> meetingHrs2 = new ArrayList<EventInformation>();
        meetingHrs2.add(new EventInformation(DayOfWeek.Monday, "1300", "1600"));
        course2.setMeetingHours(meetingHrs2);

        Course course3 = new Course();
        course3.setName("Fun");
        course3.setLocation("BNR11");
        course3.setSection(1);
        course3.setUnits(7);
        List<EventInformation> meetingHrs3 = new ArrayList<EventInformation>();
        meetingHrs3.add(new EventInformation(DayOfWeek.Monday, "1800", "1900"));
        course3.setMeetingHours(meetingHrs3);

        Student studentFromDB = studentService.create(student);
        Instructor instructorFromDB = instructorService.create(instructor);

        try {
            Course courseFromDB = courseService.create(course, instructorFromDB);
            Course courseFromDB2 = courseService.create(course2, instructorFromDB);
            Course courseFromDB3 = courseService.create(course3, instructorFromDB);
            courseService.enrollStudent(courseFromDB, studentFromDB);
            courseService.enrollStudent(courseFromDB2, studentFromDB);
            courseService.enrollStudent(courseFromDB3, studentFromDB);


            Course course4 = new Course();
            course4.setName("fourth");
            course4.setLocation("BNR11");
            course4.setSection(1);
            course4.setUnits(3);
            List<EventInformation> meetingHrs4 = new ArrayList<EventInformation>();
            meetingHrs4.add(new EventInformation(DayOfWeek.Thursday, "1800", "1900"));
            course4.setMeetingHours(meetingHrs4);
            Course courseFromDB4 = courseService.create(course3, instructorFromDB);
            courseService.enrollStudent(courseFromDB4, studentFromDB);

            List<Course> tempCourses = studentService.getAssociatedCourses(studentFromDB);

            for (Course tempCoursesCheck : tempCourses) {
                if (tempCoursesCheck.getName().toString().toLowerCase() == "fourth") {
                    checkFlag = true;
                } else {
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
    //Student enrolled in course ie TBA.

    @Test

    public void testEnrollStudNonExistCourses() {

        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Jill");
        student.setAddress("98 ABC Street");
        student.setState("CA");
        student.setCity("San Jose");
        student.setZipCode("12345");
        student.setStudentId("123-00-0058");


        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("123-28-4445");
        instructor.setFirstName("Jack");
        instructor.setLastName("Jill");
        instructor.setOffice("CLK111");
        instructor.setAddress("1237 Snatal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");

        course.setName("TBA");
        course.setLocation("TBA");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Tuesday, "TBA", "TBA"));
        course.setMeetingHours(meetingHrs);


        Student studentFromDB = studentService.create(student);
        Instructor instructorFromDB = instructorService.create(instructor);
        Course courseFromDB = courseService.create(course, instructorFromDB);
        courseService.enrollStudent(courseFromDB, studentFromDB);


        try {
            courseService.enrollStudent(course, studentFromDB);
            List<Course> tempCourses = studentService.getAssociatedCourses(studentFromDB);
            for (Course tempCoursesCheck : tempCourses) {
                if ((tempCoursesCheck.getName().toString().toLowerCase() == "tba") && (tempCoursesCheck.getLocation().toString().toLowerCase() == "tba")) {
                    checkFlag = true;
                } else {
                    checkFlag = true;
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


    //Student enrolled in non existing course.
    @Test

    public void testEnrollStudTBACourses() {

        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Jill");
        student.setAddress("98 ABC Street");
        student.setState("CA");
        student.setCity("San Jose");
        student.setZipCode("12345");
        student.setStudentId("123-01-0098");


        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("123-76-4445");
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

        try {
            courseService.enrollStudent(course, studentFromDB);
            List<Course> tempCourses = studentService.getAssociatedCourses(studentFromDB);
            for (Course tempCoursesCheck : tempCourses) {
                if (tempCoursesCheck.getName().toString().toLowerCase() == "design") {
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


    //Enroll student who doesnt exist.
    @Test

    public void testEnrollNonStud() {

        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Jill");
        student.setAddress("98 ABC Street");
        student.setState("CA");
        student.setCity("San Jose");
        student.setZipCode("12345");
        student.setStudentId("123-80-0098");


        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("123-11-4445");
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
            courseService.enrollStudent(courseFromDB, student);
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


    //Enroll student in 2 different courses at same time different locations.
    @Test

    public void testEnroll2CoursesSameTime() {

        Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Jill");
        student.setAddress("98 ABC Street");
        student.setState("CA");
        student.setCity("San Jose");
        student.setZipCode("12345");
        student.setStudentId("123-44-0098");


        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("113-23-4445");
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
        try {
        Instructor instructor2 = new Instructor();
        Course course2 = new Course();
        instructor2.setEmployeeId("156-23-4445");
        instructor2.setFirstName("Black");
        instructor2.setLastName("White");
        instructor2.setOffice("CLK10");
        instructor2.setAddress("1723 SnaTatal st");
        instructor2.setCity("San Jose");
        instructor2.setState("CA");
        instructor2.setZipCode("14345");
        instructor2.setDepartment("CMPE");


        course2.setName("Systems");
        course2.setLocation("CLK01");
        course2.setSection(1);
        course2.setUnits(3);
        List<EventInformation> meetingHrs2 = new ArrayList<EventInformation>();
        meetingHrs2.add(new EventInformation(DayOfWeek.Tuesday, "1300", "1600"));
        course2.setMeetingHours(meetingHrs2);


        Student studentFromDB = studentService.create(student);
        Instructor instructorFromDB = instructorService.create(instructor);
        Instructor instructorFromDB2 = instructorService.create(instructor2);
        Course courseFromDB = courseService.create(course, instructorFromDB);
        Course courseFromDB2 = courseService.create(course2, instructorFromDB2);



            courseService.enrollStudent(courseFromDB, studentFromDB);
            courseService.enrollStudent(courseFromDB2, studentFromDB);
            List<Course> tempCourses = studentService.getAssociatedCourses(studentFromDB);
            for (Course tempCoursesCheck : tempCourses) {
                if (tempCoursesCheck.getName().toString().toLowerCase() == "systems") {
                    checkFlag = false;
                } else {
                    checkFlag = true;
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


}
