package edu.sjsu.edo08f.services;

import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.domain.Course;

import java.util.List;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public interface InstructorService {

    List<Instructor> getAll(); // exceptions: general exception. may return empty list
    Instructor getById (Long id); //thows general exception, no such instructor, invalid argument

    Instructor create (Instructor instructor); // invalid instructor, duplicate instructor, general exception, invalid argument exception
    Instructor update (Instructor instructor); // exceptions: no such instructor, invalid instructor, duplicate instructor, general exception, invalid argument exception
    void delete (Instructor instructor); // no such instructor, hasDependencies, general exception, invalid argument exception 

    List<Course> getAssociatedCourses (Instructor instructor); // general exception, no such instructor exception, invalid argument exception
}