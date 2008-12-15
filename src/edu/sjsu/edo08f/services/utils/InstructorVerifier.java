package edu.sjsu.edo08f.services.utils;

import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.exceptions.*;
import edu.sjsu.edo08f.support.ParserUtils;
import edu.sjsu.edo08f.support.UnitedStatesEnum;
import edu.sjsu.edo08f.support.EventInformation;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

/**
 * Created by: Oleksiy Yarmula
 * Date: Nov 16, 2008
 */
public class InstructorVerifier extends CommonVerifier {

    Logger logger = Logger.getLogger(InstructorVerifier.class);

    public void verifyOnCreate (Instructor instructor) {
        verifyInstructor(instructor);
        verifyInstructorDuplicates(instructor);
        if (isInstructorsOfficeHoursOverlapWithLocation (instructor) ) {
            throw new RoomBookedException("This place is unavailable for specified office hours");
        }
    }

    public void verifyOnUpdate (Instructor instructor) {
        verifyInstructor(instructor);
        verifyInstructorExists(instructor);
        verifyInstructorDuplicates(instructor);
        if (! isInstructorsCourseTimeCorrectAfterChangedOfficeHours (instructor)) {
            throw new ScheduleConflictException("Instructor's new office hours overlap with some of his courses.");
        }
        if (isInstructorsOfficeHoursOverlapWithLocation (instructor) ) {
            throw new RoomBookedException("This place is unavailable for specified office hours");
        }
    }

    public void verifyOnDelete (Instructor instructor) {
        verifyInstructorExists(instructor);
    }

    public void verifyInstructor(Instructor instructor) {
        if (instructor == null) throw new InvalidArgumentException("No instructor provided");

        if (! StringUtils.hasText(instructor.getLastName())) throw new InvalidInstructorException("Instructor must have the last name");
        if (! StringUtils.hasText(instructor.getFirstName())) throw new InvalidInstructorException("Instructor must have the first name");

        if (! StringUtils.hasText(instructor.getEmployeeId())) throw new InvalidInstructorException("Instructor must have the instructor/tower ID");
        if (! ParserUtils.verifyStudentId(instructor.getEmployeeId())) throw new InvalidInstructorException("Student's instructor/tower ID is invalid");

        if (! StringUtils.hasText(instructor.getAddress())) throw new InvalidInstructorException("Instructor must have the address");

        if (! StringUtils.hasText(instructor.getState())) throw new InvalidInstructorException("Instructor must have the state where he lives");
        if (! UnitedStatesEnum.verifyState(instructor.getState())) throw new InvalidInstructorException("Student has an incorrect state provided");

        if (! StringUtils.hasText(instructor.getZipCode())) throw new InvalidInstructorException("Instructor must have the ZIP code set");
        if (! ParserUtils.verifyZipCode(instructor.getZipCode())) throw new InvalidInstructorException("Student's ZIP code is invalid");

        if (! StringUtils.hasText(instructor.getCity())) throw new InvalidInstructorException("Instructor must have the city set");

        if (! StringUtils.hasText ( instructor.getDepartment() )) throw new InvalidInstructorException("Instructor must have the department set");
        if (! StringUtils.hasText( instructor.getOffice() )) throw new InvalidInstructorException("Instructor must have office specified");        

        if (instructor.getOfficeHours() == null) {
            logger.warn("The instructor didn't have office hours. Will set them for him as an empty list");
            instructor.setOfficeHours(new ArrayList<EventInformation>());
        } else {
            verifyOfficeHours(instructor.getOfficeHours());
        }

        instructor.setType("INSTRUCTOR");
    }

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

    public void verifyInstructorDuplicates(Instructor instructor) {
        Instructor instructorFromDB = instructorDao.getByEmployeeId (instructor.getEmployeeId());
        if (instructorFromDB != null) {
            if (instructor.getId() != null) {
                if (! instructorFromDB.getId().equals(instructor.getId())) throw new DuplicateInstructorException(instructor.getEmployeeId());
                // in else case, this is the same instructor
            } else {
                throw new DuplicateInstructorException(instructor.getEmployeeId());
            }
        }
    }

}
