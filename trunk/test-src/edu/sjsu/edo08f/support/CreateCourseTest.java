package edu.sjsu.edo08f.support;

import edu.sjsu.edo08f.services.CourseService;
import edu.sjsu.edo08f.services.InstructorService;
import edu.sjsu.edo08f.Main;
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
 * Date: Dec 1, 2008
 * Time: 9:03:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateCourseTest {

    CourseService courseService = (CourseService) BeanRetriever.getBeanFactory().getBean("courseService");
    InstructorService instructorService = (InstructorService) BeanRetriever.getBeanFactory().getBean("instructorService");
    boolean checkFlag = false;

    //Test for create course

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
        course.setLocation("BNz01");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Friday, "1330", "1600"));
        course.setMeetingHours(meetingHrs);
        Instructor instructorFromDB = instructorService.create(instructor);

        try {
            Course courseFromDB = courseService.create(course, instructorFromDB);
            Instructor tempInstr = courseService.getInstructorByCourse(courseFromDB);
            // String tempCourseId = courseFromDB.getId().toString();

            String temp = tempInstr.getFirstName();
            String tempType = instructorFromDB.getType().toString().toLowerCase();

            if (temp.toLowerCase().equals("jack") && tempType.equals("instructor"))
                checkFlag = true;
            else
                checkFlag = false;
        }
        catch (Exception e) {
            checkFlag = false;
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

//Test for  create Course after mid night.

    @Test(groups = {"main"})

    public void testCoursePostMidNight() {
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
        meetingHrs.add(new EventInformation(DayOfWeek.Tuesday, "0100", "0400"));
        course.setMeetingHours(meetingHrs);

        Instructor instructorFromDB = instructorService.create(instructor);
        try {
            Course courseFromDB = courseService.create(course, instructorFromDB);
            String tempCourseName = courseFromDB.getName();
            // List<EventInformation> tempMeetingHrs= courseFromDB.getMeetingHours();
            int tempCourseSec = courseFromDB.getSection();

            if (tempCourseName.toLowerCase().equals("Design") && tempCourseSec == 1)
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


    //Test for create course with instructor having his meeting hrs at same time (differnt location)
    @Test(groups = {"main"})

    public void testCourseHrsMeetingHrsSame() {
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
        List<EventInformation> officeHrs = new ArrayList<EventInformation>();
        officeHrs.add(new EventInformation(DayOfWeek.Tuesday, "1200", "1400"));
        instructor.setOfficeHours(officeHrs);

        course.setName("TimeClash");
        course.setLocation("BNR01");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Tuesday, "1100", "1500"));
        course.setMeetingHours(meetingHrs);

        try {
            Instructor instructorFromDB = instructorService.create(instructor);
            Course courseFromDB = courseService.create(course, instructorFromDB);
            String tempCourseName = courseFromDB.getName();
            // List<EventInformation> tempMeetingHrs= courseFromDB.getMeetingHours();
            int tempCourseSec = courseFromDB.getSection();

            if (tempCourseName.toLowerCase().equals("timeclash") && tempCourseSec == 1)
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

//Test for create course with  1 instructor having his meeting hrs at the same location ;

    @Test(groups = {"main"})

    public void testCourseMeetingLocSame() {
        Instructor instructor = new Instructor();
        //Course course = new Course();
        instructor.setEmployeeId("123-23-4445");
        instructor.setFirstName("Jack");
        instructor.setLastName("Jill");
        instructor.setOffice("CLK111");
        instructor.setAddress("1237 Snatal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");
        List<EventInformation> officeHrs = new ArrayList<EventInformation>();
        officeHrs.add(new EventInformation(DayOfWeek.Tuesday, "1200", "1400"));
        instructor.setOfficeHours(officeHrs);

        Instructor instructor2 = new Instructor();
        Course course = new Course();
        instructor2.setEmployeeId("130-23-4445");
        instructor2.setFirstName("Bill");
        instructor2.setLastName("Kill");
        instructor2.setOffice("Eng111");
        instructor2.setAddress("1237 Snatal st");
        instructor2.setCity("San Diego");
        instructor2.setState("CA");
        instructor2.setZipCode("12345");
        instructor2.setDepartment("CMPE");
        List<EventInformation> officeHrs2 = new ArrayList<EventInformation>();
        officeHrs.add(new EventInformation(DayOfWeek.Tuesday, "1600", "1800"));
        instructor.setOfficeHours(officeHrs2);


        course.setName("LocClash");
        course.setLocation("CLK111");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Tuesday, "1350", "1500"));
        course.setMeetingHours(meetingHrs);

        try {
            Instructor instructorFromDB = instructorService.create(instructor);
            Instructor instructorFromDB2 = instructorService.create(instructor2);
            Course courseFromDB = courseService.create(course, instructorFromDB2);
            String tempCourseName = courseFromDB.getName();
            // List<EventInformation> tempMeetingHrs= courseFromDB.getMeetingHours();
            int tempCourseSec = courseFromDB.getSection();

            if (tempCourseName.toLowerCase().equals("locclash") && tempCourseSec == 1)
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

    // duplicate courses


    @Test(groups = {"main"})

    public void test2CoursesSame() {
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
        List<EventInformation> officeHrs = new ArrayList<EventInformation>();
        officeHrs.add(new EventInformation(DayOfWeek.Tuesday, "1200", "1400"));
        instructor.setOfficeHours(officeHrs);

        course.setName("LocClash");
        course.setLocation("CLK111");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Tuesday, "1500", "1700"));
        course.setMeetingHours(meetingHrs);


        Instructor instructor2 = new Instructor();
        Course course2 = new Course();
        instructor2.setEmployeeId("130-23-4445");
        instructor2.setFirstName("Bill");
        instructor2.setLastName("Kill");
        instructor2.setOffice("Eng111");
        instructor2.setAddress("1237 Snatal st");
        instructor2.setCity("San Diego");
        instructor2.setState("CA");
        instructor2.setZipCode("12345");
        instructor2.setDepartment("CMPE");
        List<EventInformation> officeHrs2 = new ArrayList<EventInformation>();
        officeHrs2.add(new EventInformation(DayOfWeek.Tuesday, "1600", "1800"));
        instructor2.setOfficeHours(officeHrs2);


        course2.setName("LocClash");
        course2.setLocation("CLK111");
        course2.setSection(1);
        course2.setUnits(3);
        List<EventInformation> meetingHrs2 = new ArrayList<EventInformation>();
        meetingHrs2.add(new EventInformation(DayOfWeek.Tuesday, "1500", "1700"));
        course2.setMeetingHours(meetingHrs2);

        try {
            Instructor instructorFromDB = instructorService.create(instructor);
            Instructor instructorFromDB2 = instructorService.create(instructor2);
            Course courseFromDB = courseService.create(course, instructorFromDB);
            Course courseFromDB2 = courseService.create(course2, instructorFromDB2);
            String tempCourseName = courseFromDB.getName();
            // List<EventInformation> tempMeetingHrs= courseFromDB.getMeetingHours();
            int tempCourseSec = courseFromDB.getSection();

            String tempCourseName2 = courseFromDB2.getName();
            // List<EventInformation> tempMeetingHrs= courseFromDB.getMeetingHours();
            int tempCourseSec2 = courseFromDB2.getSection();

            if (tempCourseName.toLowerCase().equals(tempCourseName2.toLowerCase()) && tempCourseSec == tempCourseSec2)
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

//Test for create cousrse with null values for class time .

    @Test(groups = {"main"})

    public void testCourseNull() {
        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("123-23-4445");
        instructor.setFirstName("Jackson");
        instructor.setLastName("Jill");
        instructor.setOffice("CLK111");
        instructor.setAddress("1237 Snatal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");
        List<EventInformation> officeHrs = new ArrayList<EventInformation>();
        officeHrs.add(new EventInformation(DayOfWeek.Tuesday, "1200", "1400"));
        instructor.setOfficeHours(officeHrs);

        course.setName("NULL");
        course.setLocation("");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        //   meetingHrs.add(new EventInformation(DayOfWeek.Tuesday, "1100", "1500"));
        course.setMeetingHours(null);

        try {
            Instructor instructorFromDB = instructorService.create(instructor);
            Course courseFromDB = courseService.create(course, instructorFromDB);
            String tempCourseName = courseFromDB.getName();
            // List<EventInformation> tempMeetingHrs= courseFromDB.getMeetingHours();
            int tempCourseSec = courseFromDB.getSection();
            String tempCourseLoc = courseFromDB.getLocation();

            if ((tempCourseName.toLowerCase().equals("null") || tempCourseName.toLowerCase().equals("null")) && tempCourseLoc == null)
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

// 2 different courses @ same location and time


    @Test(groups = {"main"})

    public void test2CoursesSameTime() {
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
        List<EventInformation> officeHrs = new ArrayList<EventInformation>();
        officeHrs.add(new EventInformation(DayOfWeek.Tuesday, "1200", "1400"));
        instructor.setOfficeHours(officeHrs);

        course.setName("Loc Same 1");
        course.setLocation("CLK111");
        course.setSection(2);
        course.setUnits(6);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Tuesday, "1500", "1700"));
        course.setMeetingHours(meetingHrs);


        Instructor instructor2 = new Instructor();
        Course course2 = new Course();
        instructor2.setEmployeeId("130-23-4445");
        instructor2.setFirstName("Bill");
        instructor2.setLastName("Kill");
        instructor2.setOffice("Eng111");
        instructor2.setAddress("1237 Snatal st");
        instructor2.setCity("San Diego");
        instructor2.setState("CA");
        instructor2.setZipCode("12345");
        instructor2.setDepartment("CMPE");
        List<EventInformation> officeHrs2 = new ArrayList<EventInformation>();
        officeHrs2.add(new EventInformation(DayOfWeek.Tuesday, "1600", "1800"));
        instructor2.setOfficeHours(officeHrs2);


        course2.setName("Loc Same 2");
        course2.setLocation("CLK111");
        course2.setSection(1);
        course2.setUnits(3);
        List<EventInformation> meetingHrs2 = new ArrayList<EventInformation>();
        meetingHrs2.add(new EventInformation(DayOfWeek.Tuesday, "1500", "1700"));
        course2.setMeetingHours(meetingHrs2);

        try {
            Instructor instructorFromDB = instructorService.create(instructor);
            Instructor instructorFromDB2 = instructorService.create(instructor2);
            Course courseFromDB = courseService.create(course, instructorFromDB);
            Course courseFromDB2 = courseService.create(course2, instructorFromDB2);
            String tempCourseName = courseFromDB.getName();

            int tempCourseSec = courseFromDB.getSection();

            String tempCourseName2 = courseFromDB2.getName();

            int tempCourseSec2 = courseFromDB2.getSection();

            if (tempCourseName.toLowerCase().equals(tempCourseName2.toLowerCase()) && tempCourseSec == tempCourseSec2)
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

    // Time TBD for course , location set

    @Test(groups = {"main"})

    public void testCourseTimeTBD() {
        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("123-23-4445");
        instructor.setFirstName("Jackson");
        instructor.setLastName("Jill");
        instructor.setOffice("CLK111");
        instructor.setAddress("1237 Snatal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");
        List<EventInformation> officeHrs = new ArrayList<EventInformation>();
        officeHrs.add(new EventInformation(DayOfWeek.Tuesday, "1200", "1400"));
        instructor.setOfficeHours(officeHrs);

        course.setName("LocSetTimeNull");
        course.setLocation("KLS120");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Monday, "TBD", "TBD"));
        course.setMeetingHours(meetingHrs);

        try {
            Instructor instructorFromDB = instructorService.create(instructor);
            Course courseFromDB = courseService.create(course, instructorFromDB);
            String tempCourseName = courseFromDB.getName();

            int tempCourseSec = courseFromDB.getSection();
            String tempCourseLoc = courseFromDB.getLocation();

            if (tempCourseName.toLowerCase().equals("locsettimenull") && tempCourseLoc == null)
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

    // Loc TBD for course , time set

    @Test(groups = {"main"})

    public void testCourseTBDLoc() {
        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("123-23-4445");
        instructor.setFirstName("Jackson");
        instructor.setLastName("Jill");
        instructor.setOffice("CLK111");
        instructor.setAddress("1237 Snatal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");
        List<EventInformation> officeHrs = new ArrayList<EventInformation>();
        officeHrs.add(new EventInformation(DayOfWeek.Tuesday, "1200", "1400"));
        instructor.setOfficeHours(officeHrs);

        course.setName("locTBA");
        course.setLocation("TBA");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Monday, "1200", "1400"));
        course.setMeetingHours(meetingHrs);

        try {
            Instructor instructorFromDB = instructorService.create(instructor);
            Course courseFromDB = courseService.create(course, instructorFromDB);
            String tempCourseName = courseFromDB.getName();

            int tempCourseSec = courseFromDB.getSection();
            String tempCourseLoc = courseFromDB.getLocation();

            if (tempCourseName.toLowerCase().equals("loctba") && tempCourseLoc == null)
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

    // Create Course with zero units
    @Test(groups = {"main"})

    public void testCourseZeroUnits() {
        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("123-23-4445");
        instructor.setFirstName("JacksonSa");
        instructor.setLastName("JillS");
        instructor.setOffice("CLK111");
        instructor.setAddress("1237 Snatal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");
        List<EventInformation> officeHrs = new ArrayList<EventInformation>();
        officeHrs.add(new EventInformation(DayOfWeek.Tuesday, "1200", "1400"));
        instructor.setOfficeHours(officeHrs);

        course.setName("UnitsZero");
        course.setLocation("KLS120");
        course.setSection(1);
        course.setUnits(0);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Monday, "1200", "1500"));
        course.setMeetingHours(meetingHrs);

        try {
            Instructor instructorFromDB = instructorService.create(instructor);
            Course courseFromDB = courseService.create(course, instructorFromDB);
            String tempCourseName = courseFromDB.getName();

            int tempCourseSec = courseFromDB.getSection();
            int tempCourseUnits = courseFromDB.getUnits();

            if (tempCourseName.toLowerCase().equals("unitszero") && tempCourseUnits == 0)
                checkFlag = true;
            else
                checkFlag = false;
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


    // Create Course with neg units
    @Test(groups = {"main"})

    public void testCourseNegUnits() {
        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("123-23-4445");
        instructor.setFirstName("JacksonSa");
        instructor.setLastName("JillS");
        instructor.setOffice("CLK111");
        instructor.setAddress("1237 Snatal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");
        List<EventInformation> officeHrs = new ArrayList<EventInformation>();
        officeHrs.add(new EventInformation(DayOfWeek.Tuesday, "1200", "1400"));
        instructor.setOfficeHours(officeHrs);

        course.setName("UnitsZero");
        course.setLocation("KLS120");
        course.setSection(1);
        course.setUnits(-3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Monday, "1200", "1500"));
        course.setMeetingHours(meetingHrs);

        try {
            Instructor instructorFromDB = instructorService.create(instructor);
            Course courseFromDB = courseService.create(course, instructorFromDB);
            String tempCourseName = courseFromDB.getName();

            int tempCourseSec = courseFromDB.getSection();
            int tempCourseUnits = courseFromDB.getUnits();

            if (tempCourseName.toLowerCase().equals("unitszero") && tempCourseUnits <0)
                checkFlag = false;
            else
                checkFlag = true;
        }
        catch (Exception e) {
            checkFlag = false;
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

    // Create Course with decimal units
    @Test(groups = {"main"})

    public void testCourseNullUnits() {
        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("123-23-4445");
        instructor.setFirstName("JacksonSa");
        instructor.setLastName("JillS");
        instructor.setOffice("CLK111");
        instructor.setAddress("1237 Snatal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");
        List<EventInformation> officeHrs = new ArrayList<EventInformation>();
        officeHrs.add(new EventInformation(DayOfWeek.Tuesday, "1200", "1400"));
        instructor.setOfficeHours(officeHrs);

        course.setName("nullunits");
        course.setLocation("KLS120");
        course.setSection(1);
        course.setUnits(null);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Monday, "1200", "1500"));
        course.setMeetingHours(meetingHrs);

        try {
            Instructor instructorFromDB = instructorService.create(instructor);
            Course courseFromDB = courseService.create(course, instructorFromDB);
            String tempCourseName = courseFromDB.getName();

            //int tempCourseSec = courseFromDB.getSection();
            //int tempCourseUnits = courseFromDB.getUnits();

            if (tempCourseName.toLowerCase().equals("nullunits"))
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


    // Create Course with end time before start time
    @Test(groups = {"main"})

    public void testCourseEndTimeWrong() {
        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("123-23-4445");
        instructor.setFirstName("JacksonSa");
        instructor.setLastName("JillS");
        instructor.setOffice("CLK111");
        instructor.setAddress("1237 Snatal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");
        List<EventInformation> officeHrs = new ArrayList<EventInformation>();
        officeHrs.add(new EventInformation(DayOfWeek.Tuesday, "1200", "1400"));
        instructor.setOfficeHours(officeHrs);

        course.setName("EndTime");
        course.setLocation("KLS120");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Monday, "1500", "1200"));
        course.setMeetingHours(meetingHrs);

        try {
            Instructor instructorFromDB = instructorService.create(instructor);
            Course courseFromDB = courseService.create(course, instructorFromDB);
            String tempCourseName = courseFromDB.getName();

            int tempCourseSec = courseFromDB.getSection();
            int tempCourseUnits = courseFromDB.getUnits();

            if (tempCourseName.toLowerCase().equals("endtime") && tempCourseUnits == 3)
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


    // Create Course with no end time
    @Test(groups = {"main"})

    public void testCourseNoEndTime() {
        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("123-23-4445");
        instructor.setFirstName("JacksonSa");
        instructor.setLastName("JillS");
        instructor.setOffice("CLK111");
        instructor.setAddress("1237 Snatal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");
        List<EventInformation> officeHrs = new ArrayList<EventInformation>();
        officeHrs.add(new EventInformation(DayOfWeek.Tuesday, "1200", "1400"));
        instructor.setOfficeHours(officeHrs);

        course.setName("NoEndTime");
        course.setLocation("KLS120");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Monday, "1500", ""));
        course.setMeetingHours(meetingHrs);

        try {
            Instructor instructorFromDB = instructorService.create(instructor);
            Course courseFromDB = courseService.create(course, instructorFromDB);
            String tempCourseName = courseFromDB.getName();

            int tempCourseSec = courseFromDB.getSection();
            int tempCourseUnits = courseFromDB.getUnits();

            if (tempCourseName.toLowerCase().equals("noendtime") && tempCourseUnits == 3)
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


    // Create Course with no start time
    @Test(groups = {"main"})

    public void testCourseNoStartTime() {
        Instructor instructor = new Instructor();
        Course course = new Course();
        instructor.setEmployeeId("123-23-4445");
        instructor.setFirstName("JacksonSa");
        instructor.setLastName("JillS");
        instructor.setOffice("CLK111");
        instructor.setAddress("1237 Snatal st");
        instructor.setCity("San Diego");
        instructor.setState("CA");
        instructor.setZipCode("12345");
        instructor.setDepartment("CMPE");
        List<EventInformation> officeHrs = new ArrayList<EventInformation>();
        officeHrs.add(new EventInformation(DayOfWeek.Tuesday, "1200", "1400"));
        instructor.setOfficeHours(officeHrs);

        course.setName("NoStartTime");
        course.setLocation("KLS120");
        course.setSection(1);
        course.setUnits(3);
        List<EventInformation> meetingHrs = new ArrayList<EventInformation>();
        meetingHrs.add(new EventInformation(DayOfWeek.Monday, "", "1500"));
        course.setMeetingHours(meetingHrs);

        try {
            Instructor instructorFromDB = instructorService.create(instructor);
            Course courseFromDB = courseService.create(course, instructorFromDB);
            String tempCourseName = courseFromDB.getName();

            int tempCourseSec = courseFromDB.getSection();
            int tempCourseUnits = courseFromDB.getUnits();

            if (tempCourseName.toLowerCase().equals("nostarttime") && tempCourseUnits == 3)
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





