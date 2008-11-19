package edu.sjsu.edo08f.services.utils;

import org.apache.log4j.Logger;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.exceptions.InvalidArgumentException;
import edu.sjsu.edo08f.exceptions.NoSuchStudentException;

import java.util.List;

/**
 * Created by: Alex Yarmula
 * Date: Nov 18, 2008
 */
public class StudentVerifier  extends CommonVerifier {

    private Logger logger = Logger.getLogger(StudentVerifier.class);

    public void verifyStudentExists (Student student) {
        if (student == null) throw new InvalidArgumentException("No student provided");
        if (student.getId() == null) throw new InvalidArgumentException("Student ID has to be set");
        Student studentFromDB = studentDao.getById(student.getId());
        if (studentFromDB == null) throw new NoSuchStudentException(student.getId());
    }

    public int getStudentsUnits (Long studentId) {
        List<Course> coursesTakenByStudent = courseDao.getCoursesByStudentId(studentId);
        int totalOfUnitsTaken = 0;
        for (Course currentCourse : coursesTakenByStudent) {
            totalOfUnitsTaken += currentCourse.getUnits();
        }
        return totalOfUnitsTaken;
    }

    public boolean isCaliforniaResedent (Student student) {
        return student.getState().equalsIgnoreCase("CA");
    }

}
