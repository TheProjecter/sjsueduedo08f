package edu.sjsu.edo08f.services.utils;

import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.exceptions.*;
import org.springframework.util.StringUtils;
import org.apache.log4j.Logger;

/**
 * Created by: Alex Yarmula
 * Date: Nov 11, 2008
 */
public class CourseVerifier extends CommonVerifier {

    private Logger logger = Logger.getLogger(CommonVerifier.class);

    private InstructorVerifier instructorVerifier;

    public void setInstructorVerifier(InstructorVerifier instructorVerifier) {
        this.instructorVerifier = instructorVerifier;
    }

    public void verifyCourseOnCreate (Course course, Instructor instructor) {
        verifyCourse(course);
        verifyCourseDuplicates(course);
        instructorVerifier.verifyInstructorExists(instructor);
        if (isInstructorOccupiedForThisCourse(instructor, course)) {
            throw new ScheduleConflictException("This course conflicts with current schedule of this instructor"); 
        }
    }

    public void verifyCourseOnUpdate (Course course) {
        verifyCourse(course);
        verifyCourseExists(course);

        Instructor instructor = instructorDao.getInstructorByCourse(course.getId());

        if (isInstructorOccupiedForThisCourse(instructor, course)) {
            throw new ScheduleConflictException("This course conflicts with current schedule of this instructor");
        }
    }

    public void verifyCourseOnDelete (Course course) {
        verifyCourseExists(course);
    }

    private void verifyCourse (Course course) {

        if (course == null ) {
            logger.warn("The course has to be defined");
            throw new InvalidArgumentException("The course has to be defined");
        }
        if (! StringUtils.hasLength(course.getName())) {
            logger.warn("The course should have a name");
            throw new InvalidCourseException("The course should have a name");
        }
        if (! StringUtils.hasLength(course.getLocation())) {
            logger.warn("The course should have a location");
            throw new InvalidCourseException("The course should have a location");
        }
        if (course.getSection() == null || course.getSection()  < 0) {
            logger.warn("The course section should be defined and be 1 or more");
            throw new InvalidCourseException("The course section should be defined and be 0 or more");
        }
        verifyHours(course.getMeetingHours());

        if (isCourseOverlappingWithDB(course)) {
            throw new RoomBookedException();
        }
    }

    public void verifyCourseExists (Course course) {
        if (course == null ) {
            logger.warn("The course has to be defined");
            throw new InvalidArgumentException("The course has to be defined");
        }
        if (course.getId() == null) {
            logger.warn("The course must have an ID set");
            throw new InvalidArgumentException("The course must have an ID set");
        }
        if (courseDao.getById(course.getId()) == null) {
            throw new NoSuchCourseException();
        }
    }

    // called only after "verifyCourse" to avoid NPE
    private void verifyCourseDuplicates (Course course) {
        Course courseFromDB = courseDao.getByNameAndSection
                (course.getName(), course.getSection());
        if (courseFromDB != null ) {
            if (course.getId() != null) {
                if (!courseFromDB.getId().equals(course.getId())) {
                    throw new DuplicateCourseException(course.getName(), course.getSection());
                }
            } else {
                throw new DuplicateCourseException(course.getName(), course.getSection());
            }
        }
    }
   

}
