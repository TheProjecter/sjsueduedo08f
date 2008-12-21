package edu.sjsu.edo08f.support;

import edu.sjsu.edo08f.services.InstructorService;
import edu.sjsu.edo08f.services.CourseService;
import edu.sjsu.edo08f.BeanRetriever;
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
 * Time: 1:14:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class InstructorAssignCourseTest {


    InstructorService instructorService = (InstructorService) BeanRetriever.getBeanFactory().getBean("instructorService");
    CourseService courseService = (CourseService) BeanRetriever.getBeanFactory().getBean("courseService");
    boolean checkFlag = false;


    @Test(groups = {"main"})

    //Test for Assign Course while creating
    public void testAssignWhileCreate() {
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

        Course course = new Course();
        course.setName("Design");
        course.setLocation("BNR01");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Tuesday, "1300", "1600"));
        course.setMeetingHours(meetingHrs);
        Instructor instructorFromDB = instructorService.create(instructor);

        try {
            Course courseFromDB = courseService.create(course, instructorFromDB);
            Instructor tempInstr = courseService.getInstructorByCourse(courseFromDB);
            String temp = tempInstr.getFirstName();
            Instructor tempInstructor = courseService.getInstructorByCourse(courseFromDB);

            if (tempInstructor.equals(instructorFromDB))
                checkFlag = true;
            else
                checkFlag = false;
        }
        catch (Exception e) {
            checkFlag = false;
        }
        finally {
            Assert.assertEquals(checkFlag, true);
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

    //Test for Assign Course after creating
    public void testAssignAfterCreate() {
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

        Instructor instructor2 = new Instructor();
        instructor2.setEmployeeId("123-23-4445");
        instructor2.setFirstName("Jack");
        instructor2.setLastName("Jill");
        instructor2.setOffice("CLK111");
        instructor2.setAddress("1237 Snatal st");
        instructor2.setCity("San Diego");
        instructor2.setState("CA");
        instructor2.setZipCode("12345");
        instructor2.setDepartment("CMPE");

        Course course = new Course();
        course.setName("Design");
        course.setLocation("BNR01");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Tuesday, "1300", "1600"));
        course.setMeetingHours(meetingHrs);
        Instructor instructorFromDB = instructorService.create(instructor);
        Instructor instructorFromDB2 = instructorService.create(instructor);

        try {
            Course courseFromDB = courseService.create(course, instructorFromDB);
            courseService.updateInstructor(course, instructorFromDB2);
            Instructor tempInstr = courseService.getInstructorByCourse(courseFromDB);
            String temp = tempInstr.getFirstName();
            Instructor tempInstructor = courseService.getInstructorByCourse(courseFromDB);

            if (tempInstructor.equals(instructorFromDB2))
                checkFlag = true;
            else
                checkFlag = false;
        }
        catch (Exception e) {
            checkFlag = false;
        }
        finally {
            Assert.assertEquals(checkFlag, true);
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
