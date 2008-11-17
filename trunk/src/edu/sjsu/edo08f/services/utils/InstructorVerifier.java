package edu.sjsu.edo08f.services.utils;

import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.exceptions.*;
import org.apache.log4j.Logger;

/**
 * Created by: Alex Yarmula
 * Date: Nov 16, 2008
 */
public class InstructorVerifier extends CommonVerifier {

    Logger logger = Logger.getLogger(InstructorVerifier.class);

    public void verifyInstructorExists (Instructor instructor) {
        if (instructor == null ) {
            logger.warn("The instructor has to be defined");
            throw new InvalidArgumentException("The instructor has to be defined");
        }
        if (instructor.getId() == null) {
            logger.warn("The instructor must have an ID set");
            throw new InvalidArgumentException("The instructor must have an ID set");
        }
        if (instructorDao.getById(instructor.getId()) == null) {
            throw new NoSuchInstructorException();
        }
    }

}
