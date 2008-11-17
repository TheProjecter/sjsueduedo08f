package edu.sjsu.edo08f.support;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class ParserUtilsTest {

    @Test (expectedExceptions = RuntimeException.class)

    public void verifyCourseLocationTest ()
    {
        ArrayList<String> correctLocationArr = new ArrayList<String>();
    	ArrayList<String> incorrectLocationArr = new ArrayList<String>();

        correctLocationArr.add("TBATBA");
        correctLocationArr.add("ENG183");

    	incorrectLocationArr.add("TBA183");
    	incorrectLocationArr.add("ENGTBA");
    	incorrectLocationArr.add("TBA");
    	incorrectLocationArr.add(" ");

    	for (int i=0; i<incorrectLocationArr.size(); i++)
    	{
	    	System.out.print("Verify Location: " + incorrectLocationArr.get(i));
	    	if (ParserUtils.verifyCourseLocation(incorrectLocationArr.get(i)))
	    	{
	    		System.out.println("  - Pass");
	    	} else
	    	{
                System.out.println("The pattern [" + incorrectLocationArr.get(i) + "] didn't pass as expected");
	       		//System.out.println("  - Error");
	       		throw new RuntimeException();
	    	}
    	}

//        boolean isCorrect = ParserUtils.verifyCourseLocation("TBA183");
//        if (!isCorrect) throw new RuntimeException();
    }

    //Zip code is required to match these two patterns
	//[0-9][0-9][0-9][0-9][0-9]
	//or
	//[0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]
    public void verifyZipCodeTest()
    {
        ArrayList<String> correctZipCodeArr = new ArrayList<String>();
    	ArrayList<String> incorrectZipCodeArr = new ArrayList<String>();

        correctZipCodeArr.add("95123");
        correctZipCodeArr.add("95192");
        correctZipCodeArr.add("10293");
        correctZipCodeArr.add("90086-1929");

    	incorrectZipCodeArr.add("1247");
    	incorrectZipCodeArr.add("1829A");
    	incorrectZipCodeArr.add("37849-392");
    	incorrectZipCodeArr.add("56890-392A");
    	incorrectZipCodeArr.add("2374-2384");
    	incorrectZipCodeArr.add("2374-2384B");

    	for (int i=0; i<incorrectZipCodeArr.size(); i++)
    	{
	    	System.out.print("Verify Zip Code: " + incorrectZipCodeArr.get(i));
	    	if (ParserUtils.verifyZipCode(incorrectZipCodeArr.get(i))){
	    		System.out.println("  - Pass");
	    	} else
	    	{
                 System.out.println("The pattern [" + incorrectZipCodeArr.get(i) + "] didn't pass as expected");
	       		//System.out.println("  - Error");
	       		throw new RuntimeException();
	    	}
    	}
    }

    public void verifyStudentIdTest ()
    {
        ArrayList<String> correctStudentIdArr = new ArrayList<String>();
    	ArrayList<String> incorrectStudentIdArr = new ArrayList<String>();

        correctStudentIdArr.add("352-56-4789");
        correctStudentIdArr.add("006-14-5715");

    	incorrectStudentIdArr.add("123456789");
    	incorrectStudentIdArr.add("1-234-56789");
    	incorrectStudentIdArr.add("12-345-6789");
    	incorrectStudentIdArr.add("123-456-789");
    	incorrectStudentIdArr.add("123-4567-89");
    	incorrectStudentIdArr.add("123-4567-89");
    	incorrectStudentIdArr.add("123-45678-9");

    	for (int i=0; i<incorrectStudentIdArr.size(); i++)
    	{
	    	System.out.print("Verify Student Id: " + incorrectStudentIdArr.get(i));
	    	if (ParserUtils.verifyStudentId(incorrectStudentIdArr.get(i))){
	    		System.out.println("  - Pass");
	    	} else
	    	{
                System.out.println("The pattern [" + incorrectStudentIdArr.get(i) + "] didn't pass as expected");
	       		//System.out.println("  - Error");
	       		throw new RuntimeException();
	    	}
    	}
    }

    public void verifyOfficeHoursTest()
    {
        ArrayList<String> correctOfficeHoursArr = new ArrayList<String>();
    	ArrayList<String> incorrectOfficeHoursArr = new ArrayList<String>();

        correctOfficeHoursArr.add("MWF 0800-1000");
        correctOfficeHoursArr.add("TR 1200-1400");

    	incorrectOfficeHoursArr.add("WM 0800 - 1000");
        incorrectOfficeHoursArr.add("MWF 1200 - 1400");
    	incorrectOfficeHoursArr.add("TTT 1000-1200");
        incorrectOfficeHoursArr.add("T 1000 - 1200");
    	incorrectOfficeHoursArr.add("M 1000");
    	incorrectOfficeHoursArr.add("1200-1400");
    	incorrectOfficeHoursArr.add("MTWF 1400 - 1200");
    	incorrectOfficeHoursArr.add("MTWRF 1000 - 1200");
    	incorrectOfficeHoursArr.add("MWF 2300 - 0230");

    	for (int i=0; i<incorrectOfficeHoursArr.size(); i++)
    	{
	    	System.out.print("Verify Office Hours: " + incorrectOfficeHoursArr.get(i));
	    	if (ParserUtils.verifyOfficeHours(incorrectOfficeHoursArr.get(i))){
	    		System.out.println("  - Pass");
	    	} else
	    	{
                System.out.println("The pattern [" + incorrectOfficeHoursArr.get(i) + "] didn's pass as expected");
	       		//System.out.println("  - Error");
	       		throw new RuntimeException();
	    	}
    	}
    }

    //Do I need to write the test for method "verifyState"
    //public void verifyState()
    //{
    //	boolean isCorrectState = UnitedStatesEnum.verifyState();
    //	if (!isCorrectState) thorw new RuntimeException();
    //}

}