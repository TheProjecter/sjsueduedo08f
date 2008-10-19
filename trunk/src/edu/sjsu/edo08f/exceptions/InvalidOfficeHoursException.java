package edu.sjsu.edo08f.exceptions;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public class InvalidOfficeHoursException extends GeneralException {

    public InvalidOfficeHoursException(String hoursProvided) {
        super("This format of office hours is incorrect: " + hoursProvided);
    }
}
