package edu.sjsu.edo08f.exceptions;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public class NoSuchInstructorException extends GeneralException {

    public NoSuchInstructorException(String message) {
        super(message);
    }

    public NoSuchInstructorException () {
        super ("The instructor with this ID doesn't exist");
    }
}
