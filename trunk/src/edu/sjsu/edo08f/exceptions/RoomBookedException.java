package edu.sjsu.edo08f.exceptions;

/**
 * Created by: Oleksiy Yarmula
 * Date: Nov 16, 2008
 */
public class RoomBookedException extends GeneralException {

    public RoomBookedException() {
        super ("There was a time/place overlapping conflict between courses");
    }

    public RoomBookedException(String message) {
        super(message);
    }
}
