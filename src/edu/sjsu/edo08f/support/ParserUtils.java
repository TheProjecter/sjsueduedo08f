package edu.sjsu.edo08f.support;

import java.util.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

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

	//Student Ids are required to match the pattern of [0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]
    //For example, 111-22-3333
	private static final String PATTERN_STUDENT_ID = "\\d{3}-\\d{2}-\\d{4}";
	
	//Zip code is required to match these two patterns
	//[0-9][0-9][0-9][0-9][0-9]
	//or
	//[0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]
	private static final String PATTERN_ZIP_CODE = "(\\d{5}|\\d{5}-\\d{4})";

    private static final String PATTERN_OFFICE_HOUR = "(M?T?W?R?F?S?U? (([0-1][0-9])|(2[0-3]))[0-5][0-9]-(([0-1][0-9])|(2[0-3]))[0-5][0-9])|TBA";
    private static final int FIRST_HOUR = 8;
	/**
     *Modified by Tan Tan, Nov,09,2008
     * @param officeHours in format [M?][T?][W?][R?][F?][S?][U?] [00-23][00-59]-[00-23][00-59]
     * @return if this is valid
     */
    public static boolean verifyOfficeHours (String officeHours) 
    {
    	// need to implement this method
        if(!Pattern.matches(PATTERN_OFFICE_HOUR,officeHours))
        {
            return false;
        }
        int positionTime = officeHours.indexOf(" ");

        if(positionTime != -1)
        {
            String hours = officeHours.substring(positionTime+1);
            int startHour = Integer.parseInt(hours.substring(0, 2));
			int startMinutes = Integer.parseInt(hours.substring(2, 4));
			int endHour = Integer.parseInt(hours.substring(5, 7));
			int endMinutes = Integer.parseInt(hours.substring(7, 9));
			if(endHour != 0 && endHour < startHour) return false;
			if(endHour == startHour && endMinutes <= startMinutes) return false;
			if(startHour < FIRST_HOUR) return false;
			if(endHour == 0 && endMinutes != 0) return false;
        }
    	return true;
    }

    /*
     * Modified by Tan Tan, Nov,09,2008
    Zip code of the person.
    2 possible formats:
    [0-9][0-9][0-9][0-9][0-9]
    or
    [0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]
     */
    public static boolean verifyZipCode (String zipCode) 
    {  
        //need to implement this method
        return Pattern.matches(PATTERN_ZIP_CODE, zipCode);
    }

    /*
     * Modified by Tan Tan, Nov,09,2008
     * Student ID is supposed to be in this format
        [0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]
        like 111-22-3333
     */
    public static boolean verifyStudentId (String studentId) {

        //need to implement this method
        return Pattern.matches(PATTERN_STUDENT_ID, studentId);
    }

    /*
     * Modified by Tan Tan, Nov,10,2008
    Must return a list with records for each meeting time. One record means one meeting.
    Even if input is provided as "MWF 1800-2000", it still has to be 3 records returnes.
     For list of 2 records : "MW 1800-2000" and "S 1000-1200" the method must return list with 3 records
     */
    public static List<EventInformation> parseOfficeHours (List<String> officeHoursLines) 
    {
    	String myOfficeHoursLine;
    	ArrayList<EventInformation> officeHoursArrayList = new ArrayList<EventInformation>();

    	for (int i=0; i<officeHoursLines.size(); i++)
    	{
    		myOfficeHoursLine = officeHoursLines.get(i);
            if (verifyOfficeHours(myOfficeHoursLine))
            {
                String[] tempArr = myOfficeHoursLine.split(" ");
                String stringDayOfWeek = tempArr[0];
                String stringStartEnd = tempArr[1];

                tempArr = stringStartEnd.split("-");
                String startTime = tempArr[0];
                String endTime = tempArr[1];

                for (int j=0; j<stringDayOfWeek.length(); j++)
                {
                    EventInformation myEventInformation = new EventInformation();
                    String Day = String.valueOf(stringDayOfWeek.charAt(j));
                    if (DayOfWeek.isCorrectDayOfWeek(Day))
                    {
                        myEventInformation.setDayOfWeek(DayOfWeek.getDayByShortcutName(Day));
                        myEventInformation.setStartTime(startTime);
                        myEventInformation.setEndTime(endTime);
                        officeHoursArrayList.add(myEventInformation);
                    }
                }
            }
    	}
        return officeHoursArrayList;
    }
    /*
    * Modified by Tan Tan, Nov,10,2008
    * This method does the exact opposite things of method "parseOfficeHours"
     */
    public static List<String> convertOfficeHoursToLines(List<EventInformation> officeHours)
    {
        List<String> officeHoursLines = new ArrayList<String>();
        while(officeHours.size()>0){
            EventInformation officeHour  = officeHours.get(0);
            if (officeHour != null )
            {
                officeHours.remove(0);
                String startTime = officeHour.getStartTime();
                String endTime   = officeHour.getEndTime();
                String Days      = officeHour.getDayOfWeek().toString();
                for( int i=0 ; i <officeHours.size(); i++ ){
                   EventInformation officeHourTemp  = officeHours.get(i);
                   String startTimeTemp = officeHourTemp.getStartTime();
                   String endTimeTemp   = officeHourTemp.getEndTime();
                   if ( startTime == startTimeTemp && endTime == endTimeTemp){
                      Days = Days + officeHourTemp.getDayOfWeek().toString();
                      officeHours.remove(i);
                      i--;
                   }
                }
                String officeHoursLine = Days + " " + startTime+"-"+endTime;
                officeHoursLines.add(officeHoursLine);
            }

        }

    	return officeHoursLines;
        }
    /*
    The input can be like ENG183, TBATBA
     */
    public static boolean verifyCourseLocation (String courseLocation) {
        return true;
    }
    

}
