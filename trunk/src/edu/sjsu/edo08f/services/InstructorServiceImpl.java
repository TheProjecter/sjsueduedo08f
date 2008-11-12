package edu.sjsu.edo08f.services;

import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.dao.InstructorDao;
import edu.sjsu.edo08f.exceptions.NoSuchInstructorException;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Created by: Alex Yarmula
 * Date: Nov 11, 2008
 */
public class InstructorServiceImpl implements InstructorService {

    private InstructorDao instructorDao;

    public InstructorDao getInstructorDao() {
        return instructorDao;
    }

    private static Logger logger = Logger.getLogger(InstructorServiceImpl.class);

    public List<Instructor> getAll() {
        List<Instructor> instructors = instructorDao.getAll();
        if (instructors.size() == 0) {
            logger.info("There were no entries in Instructor table");
        }
        return instructors;
    }

    public Instructor getById(Long id) {
        Instructor instructor = instructorDao.getById(id);
        if (instructor == null) {
            logger.warn("The instructor with such id wasn't found");
            throw new NoSuchInstructorException("The instructor with such id wasn't found");
        }
        return instructor;
    }

    public Instructor create(Instructor instructor) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Instructor update(Instructor instructor) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void delete(Instructor instructor) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Course> getAssociatedCourses(Instructor instructor) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setInstructorDao(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }
}
