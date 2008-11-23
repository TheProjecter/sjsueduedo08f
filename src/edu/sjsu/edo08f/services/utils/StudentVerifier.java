package edu.sjsu.edo08f.services.utils;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.exceptions.*;
import edu.sjsu.edo08f.support.ParserUtils;
import edu.sjsu.edo08f.support.UnitedStatesEnum;

import java.util.List;

/**
 * Created by: Alex Yarmula
 * Date: Nov 18, 2008
 */
public class StudentVerifier  extends CommonVerifier {

    private Logger logger = Logger.getLogger(StudentVerifier.class);

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

    public void verifyOnCreate (Student student) {
        verifyStudent(student);
        verifyStudentDuplicates(student);
    }

    public void verifyOnUpdate (Student student) {
        verifyStudent(student);
        verifyStudentExists(student);
        verifyStudentDuplicates(student);
    }

    public void verifyOnDelete (Student student) {
        verifyStudentExists(student);

        List<Course> inWhichCoursesIsEnrolled = courseDao.getCoursesByStudentId(student.getId());
        if (inWhichCoursesIsEnrolled.size() > 0) {
            throw new HasDependenciesException(
                    String.format("The student is enrolled in %d courses and can't be deleted", inWhichCoursesIsEnrolled.size()));
        }
    }

    public void verifyStudent(Student student) {
        if (student == null) throw new InvalidArgumentException("No student provided");

        if (! StringUtils.hasText(student.getLastName())) throw new InvalidStudentException("Student must have the last name");
        if (! StringUtils.hasText(student.getFirstName())) throw new InvalidStudentException("Student must have the first name");

        if (! StringUtils.hasText(student.getStudentId())) throw new InvalidStudentException("Student must have the student/tower ID");
        if (! ParserUtils.verifyStudentId(student.getStudentId())) throw new InvalidStudentException("Student's student/tower ID is invalid");

        if (! StringUtils.hasText(student.getAddress())) throw new InvalidStudentException("Student must have the address");

        if (! StringUtils.hasText(student.getState())) throw new InvalidStudentException("Student must have the state where he lives");
        if (! UnitedStatesEnum.verifyState(student.getState())) throw new InvalidStudentException("Student has an incorrect state provided");

        if (! StringUtils.hasText(student.getZipCode())) throw new InvalidStudentException("Student must have the ZIP code set");
        if (! ParserUtils.verifyZipCode(student.getZipCode())) throw new InvalidStudentException("Student's ZIP code is invalid");

        if (! StringUtils.hasText(student.getCity())) throw new InvalidStudentException("Student must have the city set");

        student.setType("STUDENT");
    }

    public void verifyStudentExists (Student student) {
        if (student == null) throw new InvalidArgumentException("No student provided");
        if (student.getId() == null) throw new InvalidArgumentException("Student ID has to be set");
        Student studentFromDB = studentDao.getById(student.getId());
        if (studentFromDB == null) throw new NoSuchStudentException(student.getId());
    }

    public void verifyStudentDuplicates (Student student) {
        Student studentFromDB = studentDao.getByTowerId (student.getStudentId());
        if (studentFromDB != null) {
            if (student.getId() != null) {
                if (! studentFromDB.getId().equals(student.getId())) throw new DuplicateStudentException(student.getStudentId());
                // in else case, this is the same student  
            } else {
                throw new DuplicateStudentException(student.getStudentId());
            }
        }
    }



}
