package edu.sjsu.edo08f.services.utils;

import edu.sjsu.edo08f.dao.*;
import edu.sjsu.edo08f.support.EventInformation;
import edu.sjsu.edo08f.exceptions.InvalidCourseException;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Instructor;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by: Alex Yarmula
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

    protected void verifyHours(List<EventInformation> meetingHours) {
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


    protected boolean isCourseOverlappingWithDB (Course course) {
        boolean courseOverlapping = false;

        if (isNewLocation(course.getLocation()))  {
            return false;
        }
        List<Course> coursesForGivenLocation =
                courseDao.getByLocationName(course.getLocation());

        for (Course currentCourse : coursesForGivenLocation) {
            courseOverlapping = courseOverlapping || isOverlappingOf2Courses(currentCourse, course);
        }
        return courseOverlapping;
    }

    public boolean isNewLocation (String courseLocation) {
        return commonDao.getLocationIdByName(courseLocation) == null;
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
                    startTimeOfDBCourse < endTimeOfCreatedCourse)) {
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

        for (EventInformation meetingDayOfDBCourse : instructor.getOfficeHours()) {
            for (EventInformation meetingDayOfCreatedCourse : course.getMeetingHours()) {
                result = result || isMeetingTimeOverlapping(meetingDayOfDBCourse, meetingDayOfCreatedCourse);
            }
        }
        return result;
    }

    private boolean isInstructorsOtherCoursesOverlapWithCourse (Instructor instructor, Course course) {

        boolean result = false;

        List<Course> instructorsCourses = courseDao.getCoursesByInstructorId(instructor.getId());
        for (Course instructorsCourse : instructorsCourses ) {
            for (EventInformation meetingDayOfInstructorsCourse : instructorsCourse.getMeetingHours()) {
                for (EventInformation meetingDayOfCreatedCourse : course.getMeetingHours()) {
                    result = result ||
                            isMeetingTimeOverlapping(meetingDayOfInstructorsCourse, meetingDayOfCreatedCourse);
                }
            }
        }
        return result;
    }
}
