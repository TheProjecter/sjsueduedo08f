package edu.sjsu.edo08f.support;

import org.testng.annotations.Test;

/**
 * Created by: Alex Yarmula
 * Date: Oct 18, 2008
 */
public class ParserUtilsTest {

    @Test (expectedExceptions = RuntimeException.class)
    public void verifyCourseLocation () {
        boolean isCorrect = ParserUtils.verifyCourseLocation("TBA183");
        if (isCorrect) throw new RuntimeException();
    }

}
