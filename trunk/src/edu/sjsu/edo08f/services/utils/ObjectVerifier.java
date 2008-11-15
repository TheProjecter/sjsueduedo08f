package edu.sjsu.edo08f.services.utils;

import edu.sjsu.edo08f.dao.StudentDao;
import edu.sjsu.edo08f.dao.CourseDao;
import edu.sjsu.edo08f.dao.InstructorDao;
import edu.sjsu.edo08f.dao.PersonDao;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.exceptions.InvalidCourseException;
import edu.sjsu.edo08f.exceptions.InvalidArgumentException;
import edu.sjsu.edo08f.exceptions.NoSuchCourseException;
import org.springframework.util.StringUtils;
import org.apache.log4j.Logger;

/**
 * Created by: Alex Yarmula
 * Date: Nov 11, 2008
 */
public class ObjectVerifier {

    private StudentDao studentDao;
    private PersonDao personDao;
    private InstructorDao instructorDao;
    private CourseDao courseDao;
    private Logger logger = Logger.getLogger(ObjectVerifier.class);

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

    public void verifyCourse (Course course) {

        if (course == null ) {
            logger.error("The course has to be defined");
            throw new InvalidArgumentException("The course has to be defined");
        }

        if (! StringUtils.hasLength(course.getName())) {
            logger.error("The course should have a name");
            throw new InvalidCourseException("The course should have a name");
        }
        if (! StringUtils.hasLength(course.getLocation())) {
            logger.error("The course should have a location");
            throw new InvalidCourseException("The course should have a location"); 
        }
        if (course.getSection() == null || course.getSection()  < 1) {
            logger.error("The course section should be defined and be 1 or more");
            throw new InvalidCourseException("The course section should be defined and be 1 or more");
        }
    }

    public void verifyCourseExists (Course course) {
        if (course == null ) {
            logger.error("The course has to be defined");
            throw new InvalidArgumentException("The course has to be defined");
        }
        if (course.getId() == null) {
            logger.error("The course must have an ID set");
            throw new InvalidArgumentException("The course must have an ID set");
        }
        if (courseDao.getById(course.getId()) == null) {
            throw new NoSuchCourseException();
        }
    }

}
