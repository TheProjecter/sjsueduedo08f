package edu.sjsu.edo08f.jms;

import org.testng.annotations.Test;

import javax.jms.JMSException;

/**
 * Author: Oleksiy Yarmula
 * Date: Dec 11, 2008
 */
public class StudentServiceMessageTest extends MessageClient {

    @Test
    public void runTest () {
       
        try {

            String createdStudentReply =createStudentMessage ();

            assert (createdStudentReply.length() > 0 && createdStudentReply.contains ("<student-id>123-00-1234</student-id>")  && ! createdStudentReply.contains("Exception"));

            String createdStudentDuplicateReply =createStudentMessage ();

            assert (createdStudentDuplicateReply.contains("DuplicateStudentException"));

            String updatedStudentRequest = createdStudentReply.replace("123-00-1234", "123-00-4321");

            String updatedStudentReply = updateStudentMessage(updatedStudentRequest);

            assert (updatedStudentReply.length() > 0 && updatedStudentReply.contains ("<student-id>123-00-4321</student-id>")  && ! updatedStudentReply.contains("Exception"));

            String getAllReply = getAllStudents();

            assert (getAllReply.length() > 0 && getAllReply.contains("<student-id>123-00-4321</student-id>") && ! updatedStudentReply.contains("Exception"));

            String deletedStudentReply = deleteStudentMessage (updatedStudentReply);
            assert (deletedStudentReply.length() == 0 && !deletedStudentReply.contains("Exception"));

        }   catch(JMSException JMSException) {
            System.out.println("JMS Exception: "+JMSException);
        }
    }

    private String getAllStudents() throws JMSException {

        sendAsynchronousMessage(
                "<request>" +
                        "        <studentService>" +
                        "            <getAll/>" +
                        "        </studentService>" +
                        "    </request>"
        );
        String reply = getReply();
        return reply;
    }

    private String createStudentMessage () throws JMSException {

        sendAsynchronousMessage(
                "<request>" +
                        "        <studentService>" +
                        "            <create>" +
                        "<student>\n" +
                        "    <first-name>Alex</first-name>\n" +
                        "    <last-name>Diego</last-name>\n" +
                        "    <address>987 Cal st</address>\n" +
                        "    <city>San Diego</city>\n" +
                        "    <state>CA</state>\n" +
                        "    <zip-code>12345</zip-code>\n" +
                        "    <type>STUDENT</type>\n" +
                        "    <student-id>123-00-1234</student-id>\n" +
                        "  </student>" +
                        "           </create>" +
                        "        </studentService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;
    }

    private String updateStudentMessage (String studentXml) throws JMSException {

        sendAsynchronousMessage(
                "<request>" +
                        "        <studentService>" +
                        "            <update>" +
                        studentXml +
                        "           </update>" +
                        "        </studentService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;
    }

    private String deleteStudentMessage (String studentXml) throws JMSException {
        sendAsynchronousMessage(
                "<request>" +
                        "        <studentService>" +
                        "            <delete>" +
                        studentXml +
                        "           </delete>" +
                        "        </studentService>" +
                        "    </request>"
        );
        String reply = getReply();
        return reply;
    }


}
