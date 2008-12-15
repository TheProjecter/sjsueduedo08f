package edu.sjsu.edo08f.services.utils;

import edu.sjsu.edo08f.dao.*;
import edu.sjsu.edo08f.support.EventInformation;
import edu.sjsu.edo08f.exceptions.InvalidCourseException;
import edu.sjsu.edo08f.exceptions.InvalidInstructorException;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.domain.Student;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by: Oleksiy Yarmula
 * Date: Nov 16, 2008
 */
public class CommonVerifier {

    protected StudentDao studentDao;
    protected PersonDao personDao;
    protected InstructorDao instructorDao;
    protected CommonDao commonDao;
    protected CourseDao courseDao;

    private Logger logger = Logger.getLogger(CommonVerifier.class);

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void setInstructorDao(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void setCommonDao(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    protected void verifyMeetingHours(List<EventInformation> meetingHours) {
        if (meetingHours == null || meetingHours.size() == 0) {
            throw new InvalidCourseException("The meeting hours should be defined for the course");
        }
        for (EventInformation oneMeetingHours : meetingHours) {
            int startTime = Integer.parseInt(oneMeetingHours.getStartTime());
            int endTime = Integer.parseInt(oneMeetingHours.getEndTime());
            if (endTime - startTime <= 0 || endTime < 700) {
                throw new InvalidCourseException(String.format("Meeting hours " +
                        "for the course are incorrect for %s %d - %d",
                        oneMeetingHours.getDayOfWeek().name(), startTime, endTime));
            }
        }
    }

    protected void verifyOfficeHours(List<EventInformation> officeHours) {
        for (EventInformation oneOfficeHours : officeHours) {
            int startTime = Integer.parseInt(oneOfficeHours.getStartTime());
            int endTime = Integer.parseInt(oneOfficeHours.getEndTime());
            if (endTime - startTime <= 0 || endTime < 700) {
                throw new InvalidInstructorException(String.format("Office hours " +
                        "for the instructor are incorrect: %s %d - %d",
                        oneOfficeHours.getDayOfWeek().name(), startTime, endTime));
            }
        }
    }


    protected boolean isCourseOverlappingWithDBForThisTimeLocation(Course course) {
        boolean courseOverlapping = false;

        if (isNewLocation(course.getLocation()))  {
            return false;
        }
        List<Course> coursesForGivenLocation =
                courseDao.getByLocationName(course.getLocation());

        for (Course currentCourse : coursesForGivenLocation) {
            if (course.getId() != null && currentCourse.getId().equals(course.getId())) continue;
            courseOverlapping = courseOverlapping || isOverlappingOf2Courses(currentCourse, course);
        }
        return courseOverlapping;
    }

    public boolean isNewLocation (String location) {
        return commonDao.getLocationIdByName(location) == null;
    }

    private boolean isOverlappingOf2Courses(Course course1, Course course2) {
        boolean result = false;

        for (EventInformation meetingDayOfDBCourse : course1.getMeetingHours()) {
            for (EventInformation meetingDayOfCreatedCourse : course2.getMeetingHours()) {
                result = result || isMeetingTimeOverlapping(meetingDayOfDBCourse, meetingDayOfCreatedCourse);
            }
        }
        return result;
    }

    private boolean isMeetingTimeOverlapping(EventInformation time1, EventInformation time2) {
        if (time1.getDayOfWeek().
                equals(time2.getDayOfWeek())) {

            int startTimeOfDBCourse = Integer.valueOf(time1.getStartTime());
            int endTimeOfDBCourse = Integer.valueOf(time1.getEndTime());
            int startTimeOfCreatedCourse = Integer.valueOf(time2.getStartTime());
            int endTimeOfCreatedCourse = Integer.valueOf(time2.getEndTime());

            if ((startTimeOfDBCourse < startTimeOfCreatedCourse &&
                    endTimeOfDBCourse > startTimeOfCreatedCourse)
                    || (startTimeOfDBCourse > startTimeOfCreatedCourse &&
                    startTimeOfDBCourse < endTimeOfCreatedCourse)
                    || (startTimeOfDBCourse == startTimeOfCreatedCourse)
                    || (endTimeOfCreatedCourse == endTimeOfDBCourse)) {
                logger.warn(String.format(
                        "The time overlaps: [%d - %d] and [%d - %d]",
                        startTimeOfDBCourse, endTimeOfDBCourse,
                        startTimeOfCreatedCourse, endTimeOfCreatedCourse));
                return true;
            }
        }
        return false;
    }

    protected boolean isInstructorOccupiedForThisCourse(Instructor instructor, Course course) {
        return isInstructorsOfficeHoursOverlapWithCourse(instructor, course) ||
                isInstructorsOtherCoursesOverlapWithCourse (instructor, course);
    }

    private boolean isInstructorsOfficeHoursOverlapWithCourse (Instructor instructor, Course course) {
        boolean result = false;

        for (EventInformation oneInstructorsMeetingDay : instructor.getOfficeHours()) {
            for (EventInformation meetingDayOfCourse : course.getMeetingHours()) {
                result = result || isMeetingTimeOverlapping(oneInstructorsMeetingDay, meetingDayOfCourse);
            }
        }
        return result;
    }

    private boolean isInstructorsOtherCoursesOverlapWithCourse (Instructor instructor, Course course) {

        boolean result = false;

        List<Course> instructorsCourses = courseDao.getCoursesByInstructorId(instructor.getId());
        for (Course instructorsCourse : instructorsCourses ) {
            if (course.getId() != null && course.getId().equals(instructorsCourse.getId())) continue;
            for (EventInformation meetingDayOfInstructorsCourse : instructorsCourse.getMeetingHours()) {
                for (EventInformation meetingDayOfCreatedCourse : course.getMeetingHours()) {
                    result = result ||
                            isMeetingTimeOverlapping(meetingDayOfInstructorsCourse, meetingDayOfCreatedCourse);
                }
            }
        }
        return result;
    }

    public boolean isStudentsOtherCoursesOverlapWithCourse (Student student, Course course) {

        boolean result = false;

        List<Course> studentsCourses = courseDao.getCoursesByStudentId(student.getId());
        for (Course studentsCourse : studentsCourses ) {

            if (course.getId() != null && course.getId().equals(studentsCourse.getId())) continue;

            for (EventInformation meetingDayOfStudentsCourse : studentsCourse.getMeetingHours()) {
                for (EventInformation meetingDayOfCreatedCourse : course.getMeetingHours()) {
                    result = result ||
                            isMeetingTimeOverlapping(meetingDayOfStudentsCourse, meetingDayOfCreatedCourse);
                }
            }
        }
        return result;
    }

    protected boolean isInstructorsCourseTimeCorrectAfterChangedOfficeHours (Instructor instructor) {
        List<Course> coursesByThisInstructor = courseDao.getCoursesByInstructorId(instructor.getId());
        for (Course currentCourse: coursesByThisInstructor) {
            if (isInstructorsOfficeHoursOverlapWithCourse (instructor, currentCourse)) return false; 
        }
        return true;
    }

    protected boolean isInstructorsOfficeHoursOverlapWithLocation (Instructor instructor) {
        if (isNewLocation(instructor.getOffice()))  {
            return false;
        }

        List<Course> coursesForGivenLocation =
                courseDao.getByLocationName(instructor.getOffice());

        for (Course currentCourse: coursesForGivenLocation) {
            if (isInstructorsOfficeHoursOverlapWithCourse (instructor, currentCourse)) return true;
        }

        return false;
    }

    protected boolean isCoursesScheduleOverlapWithSomebodysOfficeHours (Course course) {
        List<Course> coursesForGivenLocation =
                courseDao.getByLocationName(course.getLocation());

        List<Instructor> instructors = instructorDao.getAll();
        for (Instructor currentInstructor : instructors) {
            if (isInstructorsOfficeHoursOverlapWithCourse (currentInstructor, course)) return true;
        }
        return false;
    }
}
