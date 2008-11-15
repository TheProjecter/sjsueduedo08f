package edu.sjsu.edo08f.services;

import org.apache.log4j.Logger;
import edu.sjsu.edo08f.dao.CourseDao;
import edu.sjsu.edo08f.dao.StudentDao;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.exceptions.NoSuchCourseException;
import edu.sjsu.edo08f.services.utils.ObjectVerifier;

import java.util.List;

/**
 * Created by: Alex Yarmula
 * Date: Nov 11, 2008
 */
public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao;
    private StudentDao studentDao;
    private ObjectVerifier objectVerifier;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void setObjectVerifier(ObjectVerifier objectVerifier) {
        this.objectVerifier = objectVerifier;
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

        objectVerifier.verifyCourseExists(course);
        List<Student> students = studentDao.getStudentsByCourse(course.getId());
        if (students.size() == 0) {
            logger.info("No students enrolled in this course were found");
        }
        return students;
    }

    public Instructor getInstructorByCourse(Course course) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Course create(Course course, Instructor instructor) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Course update(Course course) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void delete(Course course) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void enrollStudent(Course course, Student student) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void unEnrollStudent(Course course, Student student) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateInstructor(Course course, Instructor instructor) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Course> search(String searchedFieldName, String searchedValue) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
