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

    List<Course> getAll();
    Course getById (Long id);
    List<Student> getStudentsByCourse (Course course);
    Instructor getInstructorByCourse (Course course);

    Course create (Course course, Instructor instructor);
    Course update (Course course);
    void delete (Course course);

    void enrollStudent (Course course, Student student);
    void unEnrollStudent (Course course, Student student);

    void updateInstructor (Course course, Instructor instructor);

    List<Course> search (String searchedFieldName, String searchedValue);

}

