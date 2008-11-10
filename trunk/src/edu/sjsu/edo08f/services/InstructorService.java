package edu.sjsu.edo08f.services;

import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.domain.Course;

import java.util.List;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public interface InstructorService {

    List<Instructor> getAll();
    Instructor getById (Long id);

    Instructor create (Instructor instructor);
    Instructor update (Instructor instructor);
    void delete (Instructor instructor);

    List<Course> getAssociatedCourses (Instructor instructor);
}