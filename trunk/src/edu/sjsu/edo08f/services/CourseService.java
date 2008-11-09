package edu.sjsu.edo08f.services;

import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.domain.Person;

import java.util.List;
import java.util.Map;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public interface CourseService {

    List<Course> getAll(); //throws general exception. may return empty list
    Course getById (Long id); //thows general exception, no such course, invalid argument
    List<Student> getStudentsByCourse (Course course); // throws general exception, no such course, invalid argument exception. can return an empty list

    Course create (Course course, Instructor instructor); //throws invalid course exception, duplicate course exception, no such instructor, invalid operation, general exception, invalid argument exception, roomBookedException
    Course update (Course course); //throws invalid course exception, no such course exception, duplicate course exception, general exception, invalid argument exception, roomBookedException
    void delete (Course course); //throws no such course exception, general exception, hasDependencies, invalid argument exception

    void enrollStudent (Course course, Student student); //throws can't enroll exception, no such course exception, no such student exception, general exception, invalid argument exception
    void unEnrollStudent (Course course, Student student); //throws can't unenroll exception, no such course exception, no such student exception, general exception, invalid argument exception

    void updateInstructor (Course course, Instructor instructor); // exc: invalid operation, no such course, no such instructor, general exception, invalid argument exception

    List<Course> search (String searchedFieldName, String searchedValue); // exc: general exception, invalid argument exception

}

