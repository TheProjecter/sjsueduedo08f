package edu.sjsu.edo08f.jms;

import org.testng.annotations.Test;

import javax.jms.JMSException;

/**
 * Author: Oleksiy Yarmula
 * Date: Dec 12, 2008
 */
public class PersonServiceMessageTest extends MessageClient {

    @Test
    public void runTest () {
        
        try {

            String createStudentReply =createStudentMessage ();

            assert (createStudentReply.length() > 0 && createStudentReply.contains ("<student-id>123-00-1234</student-id>")  && ! createStudentReply.contains("Exception"));

            String createInstructorReply = createInstructorMessage();

            assert (createInstructorReply.length() > 0 && createInstructorReply.contains("<employee-id>123-56-4595</employee-id>") && !createInstructorReply.contains("Exception"));

            String getAllPersonsReply = getAllPersons ();

            assert (getAllPersonsReply.contains("<list>") && getAllPersonsReply.contains("<last-name>Diego</last-name>") &&
                    getAllPersonsReply.contains("<last-name>Yarmula</last-name>") && getAllPersonsReply.contains("<type>INSTRUCTOR</type>") &&
                    getAllPersonsReply.contains("<type>STUDENT</type>"));

            String searchPersonReply = searchPerson ("first-name", "Alex");

            assert (searchPersonReply.contains("<list>") && searchPersonReply.contains("<last-name>Diego</last-name>") &&
                    searchPersonReply.contains("<last-name>Yarmula</last-name>") && searchPersonReply.contains("<type>INSTRUCTOR</type>") &&
                    searchPersonReply.contains("<type>STUDENT</type>"));

            String searchPersonTwoReply = searchPerson ("last-name", "Diego");

            assert (searchPersonTwoReply.contains("Alex") && !searchPersonTwoReply.contains("Yarmula"));

            //delete instructor
            String deleteInstructorReply = deleteInstructor (createInstructorReply);

            assert (deleteInstructorReply.length() == 0 && ! deleteInstructorReply.contains("Exception"));

            //delete student
            String deleteStudentReply = deleteStudentMessage (createStudentReply);

            assert (deleteStudentReply.length() == 0 && ! deleteStudentReply.contains("Exception"));

        }   catch(JMSException JMSException) {
            System.out.println("JMS Exception: "+JMSException);
        }
    }


    private String getAllPersons() throws JMSException {

        sendAsynchronousMessage(
                "<request>" +
                        "        <personService>" +
                        "            <getAll/>" +
                        "        </personService>" +
                        "    </request>"
        );
        String reply = getReply();
        return reply;
    }

    private String searchPerson(String field, String value) throws JMSException
    {

        sendAsynchronousMessage(
                "<request>" +
                        "        <personService>" +
                        "        <search>" +
                        "               <searched-field-name>" + field + "</searched-field-name>"       +
                        "               <searched-value>" + value +  "</searched-value>"       +
                        "       </search>" +
                        "        </personService>" +
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

    private String createInstructorMessage() throws JMSException
    {

        sendAsynchronousMessage (
                "<request>" +
                        "        <instructorService>" +
                        "        <create>" +
                        "  <instructor>\n" +
                        "    <id>1</id>\n" +
                        "    <first-name>Alex</first-name>\n" +
                        "    <last-name>Yarmula</last-name>\n" +
                        "    <address>987 Cal st</address>\n" +
                        "    <city>San Diego</city>\n" +
                        "    <state>CA</state>\n" +
                        "    <zip-code>12345</zip-code>\n" +
                        "    <type>INSTRUCTOR</type>\n" +
                        "    <department>CMPE</department>\n" +
                        "    <employee-id>123-56-4595</employee-id>\n" +
                        "    <office-hours>MT 1700-1800</office-hours>\n" +
                        "    <office>CLK112</office>\n" +
                        "  </instructor>  " +
                        "       </create>" +
                        "        </instructorService>" +
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

    private String deleteInstructor (String instructorXml) throws JMSException {

        sendAsynchronousMessage(
                "<request>" +
                        "        <instructorService>" +
                        "        <delete>" +
                        instructorXml +
                        "       </delete>" +
                        "        </instructorService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;
    }


}
