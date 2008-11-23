package edu.sjsu.edo08f.services;

import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.dao.InstructorDao;
import edu.sjsu.edo08f.dao.CourseDao;
import edu.sjsu.edo08f.dao.CommonDao;
import edu.sjsu.edo08f.exceptions.NoSuchInstructorException;
import edu.sjsu.edo08f.support.EventInformation;
import edu.sjsu.edo08f.services.utils.InstructorVerifier;

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

    private CourseDao courseDao;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    private CommonDao commonDao;

    public void setCommonDao(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    private InstructorVerifier instructorVerifier;

    public void setInstructorVerifier(InstructorVerifier instructorVerifier) {
        this.instructorVerifier = instructorVerifier;
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
        instructorVerifier.verifyOnCreate (instructor);
        Long locationId = commonDao.provideCourseLocation(instructor.getOffice());
        instructorDao.create (instructor, locationId);
        createOfficeHours(instructor);
        return instructorDao.getById(instructor.getId());
    }


    private void createOfficeHours (Instructor instructor) {
        for (EventInformation eventInformation : instructor.getOfficeHours()) {
            Long eventInformationId = commonDao.getEventInformationId(eventInformation);
            if (eventInformationId == null) {
                commonDao.createEventInformation(eventInformation);
                eventInformationId = commonDao.getEventInformationId(eventInformation);
            }
            commonDao.createOfficeHours(instructor.getId(), eventInformationId);
        }
    }

    public Instructor update(Instructor instructor) {
        instructorVerifier.verifyOnUpdate(instructor);
        Long locationId = commonDao.provideCourseLocation(instructor.getOffice());

        instructorDao.update (instructor, locationId);

        commonDao.deleteAllOfficeHoursForInstructor(instructor.getId());
        createOfficeHours(instructor);

        return instructorDao.getById(instructor.getId());

    }

    public void delete(Instructor instructor) {
        instructorVerifier.verifyOnDelete(instructor);
        commonDao.deleteAllOfficeHoursForInstructor(instructor.getId());
        instructorDao.delete(instructor.getId());
    }

    public List<Course> getAssociatedCourses(Instructor instructor) {
        List<Course> courses = courseDao.getCoursesByInstructorId (instructor.getId());
        if (courses.size() == 0) {
            logger.warn ("No courses were found for provided instructor");
        }
        return courses;
    }

    public void setInstructorDao(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }
}
