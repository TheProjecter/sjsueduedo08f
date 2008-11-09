package edu.sjsu.edo08f.services;

import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Course;

import java.util.List;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public interface StudentService {

    List<Student> getAll (); // exceptions: general exception. may return empty list
    Student getById (Long id);  //thows general exception, no such student, invalid argument

    Student create (Student student); // exceptions: invalid student, duplicate student, general exception, invalid argument exception
    Student update (Student student); // exceptions: no such student, invalid student, duplicate student, general exception, invalid argument exception
    void delete (Student student); // exceptions: no such student, hasDependencies, general exception, invalid argument exception

    List<Course> getAssociatedCourses (Student student); // general exception, no such student exception, invalid argument exception
}
