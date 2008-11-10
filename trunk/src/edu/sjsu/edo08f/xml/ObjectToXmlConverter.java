package edu.sjsu.edo08f.xml;

import edu.sjsu.edo08f.exceptions.GeneralException;
import edu.sjsu.edo08f.domain.Course;

/**
 * Created by: Alex Yarmula
 * Date: Nov 8, 2008
 */
public class ObjectToXmlConverter {

    public String getExceptionXmlTemplate() {
        return "<exception>" +
                        "%s" +
                    "</exception>" +
                    "<exceptionCode>" +
                        "%s" +
                    "</exceptionCode>" +
                "</exception>";
    }

    public String getBadXmlMessage (String reason) {
        return String.format (getExceptionXmlTemplate(), GeneralException.class.getName(), reason);
    }

    public String getOutputForCreateCourseService (Course course) {
        return  "<some xml>";
    }

}
