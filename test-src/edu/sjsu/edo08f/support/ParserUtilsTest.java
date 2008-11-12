package edu.sjsu.edo08f.support;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class ParserUtilsTest {

    @Test (expectedExceptions = RuntimeException.class);

    public void verifyCourseLocationTest ()
    {
    	ArrayList<String> MyLocationArr = new ArrayList<String>;
    	MyLocationArr.add("TBA183");
    	MyLocationArr.add("ENGTBA");
    	MyLocationArr.add("TBA");
    	MyLocationArr.add(" ");

    	for (int i=0; i<MyLocationArr.size(); i++)
    	{
	    	System.out.print("Verify Course Location: " + Location);
	    	if (ParserUtils.verifyCourseLocation(MyLocationArr.get(i)))
	    	{
	    		System.out.println("  - Pass");
	    	} else
	    	{
	       		System.out.println("  - Error");
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
    	ArrayList<String> MyZipCodeArr = new ArrayList<String>;
    	MyZipCodeArr.add("1247");
    	MyZipCodeArr.add("1829A");
    	MyZipCodeArr.add("37849-392");
    	MyZipCodeArr.add("56890-392A");
    	MyZipCodeArr.add("2374-2384");
    	MyZipCodeArr.add("2374-2384B");

    	for (int i=0; i<MyZipCodeArr.size(); i++)
    	{
	    	System.out.print("Verify Zip Code: " + MyZipCodeArr.get(i));
	    	if (ParserUtils.verifyZipCode(MyZipCodeArr.get(i))){
	    		System.out.println("  - Pass");
	    	} else
	    	{
	       		System.out.println("  - Error");
	       		throw new RuntimeException();
	    	}
    	}
    }

    public void verifyStudentIdTest ()
    {
    	ArrayList<String> MyStudentIdArr = new ArrayList<String>;
    	MyStudentIdArr.add("123456789");
    	MyStudentIdArr.add("1-234-56789");
    	MyStudentIdArr.add("12-345-6789");
    	MyStudentIdArr.add("123-456-789");
    	MyStudentIdArr.add("123-4567-89");
    	MyStudentIdArr.add("123-4567-89");
    	MyStudentIdArr.add("123-45678-9");

    	for (int i=0; i<MyStudentIdArr.size(); i++)
    	{
	    	System.out.print("Verify Student Id: " + MyStudentIdArr.get(i));
	    	if (ParserUtils.verifyStudentId(MyStudentIdArr.get(i))){
	    		System.out.println("  - Pass");
	    	} else
	    	{
	       		System.out.println("  - Error");
	       		throw new RuntimeException();
	    	}
    	}
    }

    public void verifyOfficeHoursTest()
    {
    	ArrayList<String> MyOfficeHoursArr = new ArrayList<String>;
    	MyOfficeHoursArr.add("WM 0800 - 1000");
    	MyOfficeHoursArr.add("TTT 1000 - 1200");
    	MyOfficeHoursArr.add("M 1000");
    	MyOfficeHoursArr.add("1200 - 1400");
    	MyOfficeHoursArr.add("MTWF 1400 - 1200");
    	MyOfficeHoursArr.add("MTWRF 1000 - 1200");
    	MyOfficeHoursArr.add("MWF 2300 - 0230");

    	for (int i=0; i<MyOfficeHoursArr.size(); i++)
    	{
	    	System.out.print("Verify Office Hours: " + MyOfficeHoursArr.get(i));
	    	if (ParserUtils.verifyOfficeHours(MyOfficeHoursArr.get(i))){
	    		System.out.println("  - Pass");
	    	} else
	    	{
	       		System.out.println("  - Error");
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