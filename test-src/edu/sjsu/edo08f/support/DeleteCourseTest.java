package edu.sjsu.edo08f.support;

import edu.sjsu.edo08f.services.CourseService;
import edu.sjsu.edo08f.services.InstructorService;
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
 * Date: Dec 13, 2008
 * Time: 2:44:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class DeleteCourseTest {
    CourseService courseService = (CourseService) BeanRetriever.getBeanFactory().getBean("courseService");
    InstructorService instructorService = (InstructorService) BeanRetriever.getBeanFactory().getBean("instructorService");
    boolean checkFlag = false;

    //Test for create course and then delete it.

    @Test(groups = {"main"})

    public void testCourse() {
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
        Instructor instructorFromDB = instructorService.create(instructor);

        try {
            Course courseFromDB = courseService.create(course, instructorFromDB);
            Instructor tempInstr = courseService.getInstructorByCourse(courseFromDB);
            // String tempCourseId = courseFromDB.getId().toString();

            course.setName("Design");
        course.setLocation("BNR01");

            courseService.delete(courseFromDB);
            String temp = tempInstr.getFirstName();
            String tempType = instructorFromDB.getType().toString().toLowerCase();

            if (temp.toLowerCase().equals("Jack") && tempType.equals("instructor"))
                checkFlag = false;
            else
                checkFlag = true;
        }
        catch (Exception e) {
            checkFlag = true;
        }
         finally {
            Assert.assertEquals(checkFlag,true);
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

    //Retrieve then delete all courses known by the system

    @Test(groups = {"main"})

    public void testCourseDeleteAll() {
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
        Instructor instructorFromDB = instructorService.create(instructor);

        Course course2 = new Course();

        course2.setName("ABC");
        course2.setLocation("BNR01");
        course2.setSection(1);
        course2.setUnits(3);
        List<EventInformation> meetingHrs2 = new ArrayList<EventInformation>();
        meetingHrs2.add(new EventInformation(DayOfWeek.Friday, "1300", "1600"));
        course2.setMeetingHours(meetingHrs2);

        Course course3 = new Course();
        course3.setName("Design");
        course3.setLocation("BNR01");
        course3.setSection(1);
        course3.setUnits(3);
        List<EventInformation> meetingHrs3 = new ArrayList<EventInformation>();
        meetingHrs3.add(new EventInformation(DayOfWeek.Monday, "1300", "1600"));
        course3.setMeetingHours(meetingHrs);


        try {
            Course courseFromDB = courseService.create(course, instructorFromDB);
            Instructor tempInstr = courseService.getInstructorByCourse(courseFromDB);
            // String tempCourseId = courseFromDB.getId().toString();

            List<Course> courses = courseService.getAll();
            if (courses.size()!=3){
                checkFlag = false;
            }
            else{
             for (Course courseToBeDeleted : courses) {
             courseService.delete(courseToBeDeleted);
             }
            }
              List<Course> tempCourses = courseService.getAll();
            if (tempCourses.size()>0)
                checkFlag = false;
            else
                checkFlag = true;
        }
        catch (Exception e) {
            checkFlag = true;
        }
         finally {
            Assert.assertEquals(checkFlag,true);
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
