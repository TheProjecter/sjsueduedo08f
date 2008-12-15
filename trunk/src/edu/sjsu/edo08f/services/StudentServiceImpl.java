package edu.sjsu.edo08f.services;

import edu.sjsu.edo08f.dao.StudentDao;
import edu.sjsu.edo08f.dao.CourseDao;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.exceptions.NoSuchStudentException;
import edu.sjsu.edo08f.services.utils.StudentVerifier;
import edu.sjsu.edo08f.support.BillCalculator;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Created by: Oleksiy Yarmula
 * Date: Nov 11, 2008
 */
public class StudentServiceImpl implements StudentService {

    private static Logger logger = Logger.getLogger(StudentServiceImpl.class);

    private StudentDao studentDao;
    private StudentVerifier studentVerifier;
    private CourseDao courseDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void setStudentVerifier(StudentVerifier studentVerifier) {
        this.studentVerifier = studentVerifier;
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }


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
        studentVerifier.verifyOnCreate (student);
        return studentDao.create(student);
    }

    public Student update(Student student) {
        studentVerifier.verifyOnUpdate(student);
        studentDao.update(student);
        return student;
    }

    public void delete(Student student) {
        studentVerifier.verifyOnDelete(student);
        studentDao.delete (student.getId());
    }

    public String generateInvoice(Student student) {
        studentVerifier.verifyStudentExists(student);
        Student studentFromDB = studentDao.getById(student.getId());

        int numberOfUnitsTaken = studentVerifier.getStudentsUnits(student.getId());

        double amount =
                BillCalculator.getCalculatedValue(numberOfUnitsTaken, studentVerifier.isCaliforniaResedent(studentFromDB));

        return Double.toString(amount);

    }

    public List<Course> getAssociatedCourses(Student student) {
        studentVerifier.verifyStudentExists(student);
        return courseDao.getCoursesByStudentId (student.getId());
    }
}
