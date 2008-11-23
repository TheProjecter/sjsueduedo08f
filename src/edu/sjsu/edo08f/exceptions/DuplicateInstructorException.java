package edu.sjsu.edo08f.exceptions;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public class DuplicateInstructorException extends GeneralException {

    public DuplicateInstructorException (String id) {
        super (String.format("The instructor with this employee id [%s] already exists", id));
    }
}
