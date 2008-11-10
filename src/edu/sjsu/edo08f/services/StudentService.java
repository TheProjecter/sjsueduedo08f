package edu.sjsu.edo08f.services;

import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Course;

import java.util.List;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public interface StudentService {

    List<Student> getAll ();
    Student getById (Long id);

    Student create (Student student);
    Student update (Student student);
    void delete (Student student);

    String generateInvoice (Student student);

    List<Course> getAssociatedCourses (Student student);
}
