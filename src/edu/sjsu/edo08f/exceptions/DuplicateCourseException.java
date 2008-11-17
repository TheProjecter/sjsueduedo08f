package edu.sjsu.edo08f.exceptions;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public class DuplicateCourseException extends GeneralException {

    public DuplicateCourseException(String message) {
        super(message);
    }

    public DuplicateCourseException(String name, Integer section) {
        super (String.format("The course with name %s and section %d already exists",
                name, section));
    }
}
