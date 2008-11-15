package edu.sjsu.edo08f.exceptions;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public class NoSuchCourseException extends GeneralException {

    public NoSuchCourseException(String message) {
        super(message);
    }

    public NoSuchCourseException () {
        super ("The course with this ID doesn't exist");
    }
    
}
