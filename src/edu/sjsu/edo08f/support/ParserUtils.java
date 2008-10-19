package edu.sjsu.edo08f.support;

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

    /**
     *
     * @param studentId
     * @return if valid student ID
     * Student ID is supposed to be in this format
        [0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]
        like 111-22-3333
     */
    private static boolean verifyStudentId (String studentId) {

        //need to implement this method
        return true;
    }
    

}
