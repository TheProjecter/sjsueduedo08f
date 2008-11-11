package edu.sjsu.edo08f.xml;

import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.services.CourseService;

/**
 * Created by: Alex Yarmula
 * Date: Nov 8, 2008
 */
public class XmlParser {

    private ObjectToXmlConverter objectToXmlConverter;
    private CourseService courseService;

    public XmlParser() {
        objectToXmlConverter = new ObjectToXmlConverter();
 //       courseService = new CourseServiceImpl();
    }

    public String parse (String textMessage) {

        String serviceName = "";
        String methodName = "";

        // 1. parse xml
        // 2. call some service
        Course returnedCourse = courseService.create(new Course(), new Instructor());

        if (serviceName.equals("courseService")) {
            if (methodName.equals("create") ) {
                return objectToXmlConverter.getOutputForCreateCourseService(returnedCourse);
            }
        }

        return "";
    }

}
