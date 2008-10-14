package edu.sjsu.edo08f.services;

import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Instructor;

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
    void delete (Course course); //throws no such course exception, general exception

    void enrollStudent (Course course, Student student); //throws can't enroll exception, no such course exception, no such student exception, general exception
    void unEnrollStudent (Course course, Student student); //throws can't unenroll exception, no such course exception, no such student exception, general exception

    void assignInstructor (Course course, Instructor instructor); //exc: course already has instructor, no such course, no such instructor
    void removeInstructor (Course course, Instructor instructor); // exc: course doesn't have instructors exception, has dependencies, no such course, no such instructor 

    /*
    Need to think more about how search is going to work:
    Maybe field - valueToSeach isn't enough. It may need to seach > 5 and < 10 of somrthing
     */
    List<Course> search (Map<String /*name of field*/, String /*value*/> params); // may return an empty list

}

