package edu.sjsu.edo08f.services;

import edu.sjsu.edo08f.dao.StudentDao;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.exceptions.NoSuchStudentException;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Created by: Alex Yarmula
 * Date: Nov 11, 2008
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    private static Logger logger = Logger.getLogger(StudentServiceImpl.class);

    public List<Student> getAll() {
        List<Student> students = studentDao.getAll();
        if (students.size() == 0) logger.info("There were no entries in Student table");
        return students;
    }

    public Student getById(Long id) {
        Student student = studentDao.getById(id);
        if (student == null) {
            logger.warn("The student with such id wasn't found");
            throw new NoSuchStudentException("The student with such id wasn't found");
        }
        return student;
    }

    public Student create(Student student) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Student update(Student student) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void delete(Student student) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public String generateInvoice(Student student) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Course> getAssociatedCourses(Student student) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
