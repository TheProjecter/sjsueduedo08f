package edu.sjsu.edo08f.exceptions;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public class DuplicateStudentException extends GeneralException {

    public DuplicateStudentException (String id) {
        super (String.format("The student with this tower id [%s] already exists", id));
    }
}
