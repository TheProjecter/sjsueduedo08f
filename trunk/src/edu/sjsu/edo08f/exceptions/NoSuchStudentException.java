package edu.sjsu.edo08f.exceptions;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public class NoSuchStudentException extends GeneralException {

    public NoSuchStudentException(String message) {
        super(message);
    }

    public NoSuchStudentException (Long id) {
        super (String.format("The student with id =[%d] doesn't exist", id));
    }
}
