package edu.sjsu.edo08f.services;

import org.apache.log4j.Logger;
import edu.sjsu.edo08f.dao.CourseDao;
import edu.sjsu.edo08f.dao.StudentDao;
import edu.sjsu.edo08f.dao.CommonDao;
import edu.sjsu.edo08f.dao.InstructorDao;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.exceptions.NoSuchCourseException;
import edu.sjsu.edo08f.exceptions.GeneralException;
import edu.sjsu.edo08f.services.utils.CourseVerifier;
import edu.sjsu.edo08f.services.utils.SearchUtils;
import edu.sjsu.edo08f.support.EventInformation;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by: Alex Yarmula
 * Date: Nov 11, 2008
 */
public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao;
    private StudentDao studentDao;
    private CourseVerifier courseVerifier;
    private CommonDao commonDao;
    private InstructorDao instructorDao;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void setCourseVerifier(CourseVerifier courseVerifier) {
        this.courseVerifier = courseVerifier;
    }

    public void setCommonDao(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    public void setInstructorDao(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    private SearchUtils searchUtils;

    public void setSearchUtils(SearchUtils searchUtils) {
        this.searchUtils = searchUtils;
    }

    private Logger logger = Logger.getLogger(CourseServiceImpl.class);

    public List<Course> getAll() {
        List<Course> courses = courseDao.getAll();
        if (courses.size() == 0) {
            logger.info("There were no entries in Course table");
        }
        return courses;
    }

    public Course getById(Long id) {
        Course course = courseDao.getById(id);
        if (course == null) {
            logger.warn("The course with such id wasn't found");
            throw new NoSuchCourseException("The course with such id wasn't found");
        }
        return course;
    }

    public List<Student> getStudentsByCourse(Course course) {

        courseVerifier.verifyCourseExists(course);
        List<Student> students = studentDao.getStudentsByCourse(course.getId());
        if (students.size() == 0) {
            logger.info("No students enrolled in this course were found");
        }
        return students;
    }

    public Instructor getInstructorByCourse(Course course) {
        courseVerifier.verifyCourseExists(course);
        Instructor instructor = instructorDao.getInstructorByCourse(course.getId());
        if (instructor == null ) {
            logger.error("The course doesn't have an instructor. This shouldn't have happened");
            throw new GeneralException("The course doesn't have an instructor. This shouldn't have happened");
        }
        return instructor;

    }

    public Course create(Course course, Instructor instructor) {
        courseVerifier.verifyCourseOnCreate(course, instructor);

        Long locationId = commonDao.provideCourseLocation(course.getLocation());
        Course newlyCreatedCourse = courseDao.create(course, instructor.getId(), locationId);

        createMeetingHours (course);

        return courseDao.getById(newlyCreatedCourse.getId());
    }

    private void createMeetingHours (Course course) {
        for (EventInformation eventInformation : course.getMeetingHours()) {
            Long eventInformationId = commonDao.getEventInformationId(eventInformation);
            if (eventInformationId == null) {
                commonDao.createEventInformation(eventInformation);
                eventInformationId = commonDao.getEventInformationId(eventInformation);
            }
            commonDao.createMeetingHours(course.getId(), eventInformationId);
        }
    }

    public Course update(Course course) {
        courseVerifier.verifyCourseOnUpdate(course);

        commonDao.deleteAllMeetingHoursForCourse(course.getId());
        Long locationId = commonDao.provideCourseLocation(course.getLocation());

        courseDao.update(course, locationId);

        createMeetingHours (course);

        return courseDao.getById(course.getId());
    }

    public void delete(Course course) {

        courseVerifier.verifyCourseOnDelete (course);
        
        commonDao.deleteAllMeetingHoursForCourse(course.getId());
        courseDao.delete (course.getId());
    }

    public void enrollStudent(Course course, Student student) {
        courseVerifier.verifyEnrollStudent(course, student);
        courseDao.enrollStudent (course.getId(), student.getId());
    }

    public void unEnrollStudent(Course course, Student student) {
        courseVerifier.verifyUnenrollStudent(course, student);
        courseDao.unenrollStudent(course.getId(), student.getId());
    }

    public void updateInstructor(Course course, Instructor instructor) {
        courseVerifier.verifyUpdateInstructor(course, instructor);
        courseDao.updateInstructor(course.getId(), instructor.getId());
    }

    public List<Course> search(String searchedFieldName, String searchedValue) {
        return searchUtils.searchCourse(searchedFieldName, searchedValue);
    }
}
