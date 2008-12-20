package edu.sjsu.edo08f.gui;

import edu.sjsu.edo08f.jms.MessageClient;

import javax.jms.JMSException;

/**
 * Created by IntelliJ IDEA.
 * User: Tan Tan
 * Date: Dec 18, 2008
 * Time: 3:38:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class CourseClient  extends MessageClient {

    public String getAll()  throws JMSException {

        sendAsynchronousMessage(
            "<request>" +
                "<courseService>"  +
                    "<getAll/>"    +
                "</courseService>" +
            "</request>"
        );
        String reply = getReply();
        return reply;

    }

    public String search(String searchedFieldName, String searchedValue)  throws JMSException {

        sendAsynchronousMessage(
            "<request>" +
                "<courseService>"  +
                    "<search>"    +
                        "<searched-field-name>" + searchedFieldName + "</searched-field-name>" +
                        "<searched-value>"      + searchedValue     +  "</searched-value>"     +
                    "</search>"    +
                "</courseService>" +
            "</request>"
        );
        String reply = getReply();
        return reply;

    }


    public String getCourseByPersionId(String id, String personType) throws JMSException {

        System.out.println("CourseClient getCourseByPersionId() id: "+id+"personType: "+personType+"|");
        System.out.println("personType: "+personType+"|");
        System.out.println("personType: "+"STUDENT"+"|");

        String reply;
        if ( personType.equals("STUDENT") ){
            // Get Student
            sendAsynchronousMessage(
                "<request>" +
                      "<studentService>" +
                          "<getById>" +
                                "<id>" + id + "</id>" +
                          "</getById>" +
                      "</studentService>" +
                "</request>"
            );
            String student = getReply();

            sendAsynchronousMessage(
                    "<request>" +
                          "<studentService>" +
                              "<getAssociatedCourses>" +
                                  student +
                              "</getAssociatedCourses>" +
                          "</studentService>" +
                    "</request>"
            );
            reply = getReply();
        } else {
            //Get Instructor
            sendAsynchronousMessage(
                "<request>" +
                      "<instructorService>" +
                          "<getById>" +
                                "<id>" + id + "</id>" +
                          "</getById>" +
                      "</instructorService>" +
                "</request>"
            );
            String instructor = getReply();

            sendAsynchronousMessage(
                    "<request>" +
                          "<instructorService>" +
                              "<getAssociatedCourses>" +
                                  instructor +
                              "</getAssociatedCourses>" +
                          "</instructorService>" +
                    "</request>"
            );
            reply = getReply();
        }
        return reply;
    }


    public String getPersonByCourse(String id, String name, String section, String meetingHours
                                  , String location, String units) throws JMSException {
        sendAsynchronousMessage(
            "<request>" +
                "<courseService>"  +
                    "<getStudentsByCourse>"    +
                        "<course>"    +
                            "<id>"+id+"</id>"    +
                            "<name>"+name+"</name>"    +
                            "<section>"+section+"</section>"    +
                            "<meeting-hours>"+meetingHours+"</meeting-hours>"    +
                            "<location>"+location+"</location>"    +
                            "<units>"+units+"</units>"    +
                        "</course>"    +
                    "</getStudentsByCourse>"    +
                "</courseService>" +
            "</request>"
        );
        String student = getReply();
        System.out.println("getPersonByCourse");
        System.out.println(student);
        return student;
    }
}
