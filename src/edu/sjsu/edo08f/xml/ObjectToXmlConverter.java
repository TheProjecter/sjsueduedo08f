package edu.sjsu.edo08f.xml;

import edu.sjsu.edo08f.exceptions.GeneralException;
import edu.sjsu.edo08f.domain.Course;

/**
 * Created by: Alex Yarmula
 * Date: Nov 8, 2008
 */
public class ObjectToXmlConverter {

    private String getExceptionXmlTemplate() {
        return "<exception>" +
                        "<name>" +
                                "%s" +
                        "</name>" +
                        "<reason>" +
                                "%s" +
                        "</reason>" +
                "</exception>";
    }

    public String getBadXmlMessage (String reason) {
        return String.format (getExceptionXmlTemplate(), GeneralException.class.getName(), reason);
    }

    public String getExceptionXmlMessage (Exception exception) {
        return String.format (getExceptionXmlTemplate(), exception.getClass().getName(), exception.getMessage());
    }

    public String getOutputForCreateCourseService (Course course) {
        return  "<some xml>";
    }

}
