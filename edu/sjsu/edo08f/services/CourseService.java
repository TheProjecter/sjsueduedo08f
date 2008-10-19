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
    Course create (Course course); //throws invalid course exception, duplicate course exception, general exception
    Course update (Course course); //throws invalid course exception, no such course exception, duplicate course exception, general exception 
    void delete (Course course); //throws no such course exception, general exception, hasDependencies

    void enrollStudent (Course course, Student student); //throws can't enroll exception, no such course exception, no such student exception, general exception
    void unEnrollStudent (Course course, Student student); //throws can't unenroll exception, no such course exception, no such student exception, general exception

    void assignInstructor (Course course, Instructor instructor); //exc: course already has instructor, no such course, no such instructor, invalid operation
    void removeInstructor (Course course, Instructor instructor); // exc: course doesn't have instructors exception, has dependencies, no such course, no such instructor 

    List<Course> search (String searchedFieldName, String searchedValue); // exc: general exception, invalid argument exception (if nulls are passed in)

    List<Course> getAssociatedCourses (Person person); // general exception, no such student exception, no such instructor exception

}

