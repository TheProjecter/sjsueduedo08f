package edu.sjsu.edo08f.support;

import java.util.*;
import java.util.ArrayList;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */

/**
 * This class will be used for general functions, like parse office hours and validate if
 * they are correct, or assert other string literals.
 * PLEASE NOTE that this class should have only PUBLIC STATIC methods
 * and thus don't have any fields. 
 */

public class ParserUtils {

    /**
     *
     * @param officeHours in format [M?][T?][W?][R?][F?][S?][U?] [00-23][00-59]-[00-23][00-59]
     * @return if this is valid
     */
    public static boolean verifyOfficeHours (String officeHours) {

        // need to implement this method
        return true;

    }

    public static boolean verifyZipCode (String zipCode) {

        //need to implement this method

        return true;
    }

    /*
     * Student ID is supposed to be in this format
        [0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]
        like 111-22-3333
     */
    public static boolean verifyStudentId (String studentId) {

        //need to implement this method
        return true;
    }

    /*
    Must return a list with records for each meeting time. One record means one meeting.
    Even if input is provided as "MWT 1800-2000", it still has to be 3 records returnes.
     For list of 2 records : "MW 1800-2000" and "S 1000-1200" the method must return list with 3 records
     */
    public static List<EventInformation> parseOfficeHours (List<String> officeHoursLines) {
        return new ArrayList<EventInformation>();
    }

    /*
    The input can be like ENG183, TBATBA
     */
    public static boolean verifyCourseLocation (String courseLocation) {
        return true;
    }

}
