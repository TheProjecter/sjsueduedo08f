package edu.sjsu.edo08f.jms;

import org.testng.annotations.Test;

import javax.jms.JMSException;

/**
 * Author: Oleksiy Yarmula
 * Date: Dec 11, 2008
 */
public class CourseServiceMessageTest extends MessageClient {

    @Test
    public void runTest () {
        
        try {

            String createInstructorReply = createInstructorMessage();

            assert (createInstructorReply.length() > 0 && createInstructorReply.contains("<employee-id>123-56-4595</employee-id>") && !createInstructorReply.contains("Exception"));

            String allInstructorsReply = getAllInstructorMessage();

            assert (allInstructorsReply.length() > 0 && allInstructorsReply.contains("<employee-id>123-56-4595</employee-id>") && !allInstructorsReply.contains("Exception"));

            String createCourseReply = createCourse(createInstructorReply);

            assert (createCourseReply.length() > 0 && createCourseReply.contains("AlexCourse") && ! createCourseReply.contains("Exception"));

            //duplicate test
            String createCourseDuplicateErrorReply = createCourse(createInstructorReply);

            assert (createCourseDuplicateErrorReply.contains("Exception"));

            // update course exception
            String updateCourseRequest = createCourseReply.replace("<section>1</section>", "<section>2</section>");

            String updateCourseReply = updateCourse (updateCourseRequest);

            assert (updateCourseReply.contains("<section>2</section>") && !updateCourseReply.contains("Exception"));

            // get all courses reply            
            String allCoursesReply = getAllCoursesMessage();

            assert (allCoursesReply.length() > 0 && allCoursesReply.contains("AlexCourse") && ! allCoursesReply.contains("Exception"));

            String createStudentReply = createStudentMessage();

            String enrollStudentReply = enrollStudentMessage( createCourseReply, createStudentReply);

            assert (enrollStudentReply.trim().length() == 0);

            String deleteReply = deleteCourse(createCourseReply);

            assert (deleteReply.contains("Exception"));

            // get associated with student courses
            String getCoursesByStudentReply = getAssociatedCoursesStudent (createStudentReply);

            assert (getCoursesByStudentReply.contains("AlexCourse") && !getCoursesByStudentReply.contains("Exception"));

            String generateInvoiceReply = generateInvoice (createStudentReply);

            assert (generateInvoiceReply.contains("699.6") && !generateInvoiceReply.contains("Exception"));

            // get instructor by course
            String getInstructorByCourseReply = getInstructorByCourseMessage (createCourseReply);

            assert (getInstructorByCourseReply.contains("<employee-id>123-56-4595</employee-id>") && !getInstructorByCourseReply.contains("Exception"));

            // get associated courses by instructor
            String getCourseByInstructorReply = getAssociatedCoursesInstructor (createInstructorReply);

            assert (getCourseByInstructorReply.contains("AlexCourse") && ! getCourseByInstructorReply.contains("Exception"));

            // search for course

            String searchCourseInvalidReply = searchCourse ("aa", "bb");

            assert (searchCourseInvalidReply.contains("Exception"));

            String searchCourseNotFoundReply = searchCourse ("location", "Stanford");

            assert (searchCourseNotFoundReply.contains("<list/>") && !searchCourseNotFoundReply.contains("Exception"));

            String searchCourseReply = searchCourse ("name", "Alex");

            assert (searchCourseReply.contains("AlexCourse") && !searchCourseNotFoundReply.contains("Exception"));

            // update instructor
            String updatedInstructorRequest = getInstructorByCourseReply.replace("<employee-id>123-56-4595</employee-id>", "<employee-id>000-11-2222</employee-id>");

            String updatedInstructorReply = updateInstructorMessage(updatedInstructorRequest);

            assert (updatedInstructorReply.contains("<employee-id>000-11-2222</employee-id>") && !updatedInstructorReply.contains("<employee-id>123-56-4595</employee-id>") &&
                                    !updatedInstructorReply.contains("Exception"));

            // get instructor by course
            getInstructorByCourseReply = getInstructorByCourseMessage (createCourseReply);

            assert (getInstructorByCourseReply.contains("<employee-id>000-11-2222</employee-id>") && !getInstructorByCourseReply.contains("Exception"));

            String getStudentsByCourseReply = getStudentsByCourse (createCourseReply);

            assert (getStudentsByCourseReply.contains("<student-id>") && getStudentsByCourseReply.contains("<list>") && getStudentsByCourseReply.contains("San Diego"));

            String createDifferentInstructorReply  = createDifferentInstructorMessage ();

            assert (createDifferentInstructorReply.length() > 0 && createDifferentInstructorReply.contains("<employee-id>444-44-4444</employee-id>") && !createDifferentInstructorReply.contains("Exception"));

            //replace instructor for course            
            String replaceInstructorReply = updateInstructorInCourse (createCourseReply, createDifferentInstructorReply);

            assert (!replaceInstructorReply.contains("Exception"));

            getInstructorByCourseReply = getInstructorByCourseMessage (createCourseReply);

            assert (getInstructorByCourseReply.contains("<employee-id>444-44-4444</employee-id>") && !getInstructorByCourseReply.contains("Exception"));

            // get associated courses by instructor that doesn't have courses anymore
            getCourseByInstructorReply = getAssociatedCoursesInstructor (createInstructorReply);

            assert (! getCourseByInstructorReply.contains("AlexCourse") && ! getCourseByInstructorReply.contains("Exception"));

            // get associated courses by instructor that doesn't have courses anymore
            String getCoursesByDifferentInstructorReply = getAssociatedCoursesInstructor (createDifferentInstructorReply);

            assert (getCoursesByDifferentInstructorReply.contains("AlexCourse") && ! getCoursesByDifferentInstructorReply.contains("Exception"));

            // un enroll student
            String unenrollStudentReply = unenrollStudentMessage( createCourseReply, createStudentReply);

            assert (unenrollStudentReply.trim().length() == 0);

            // get associated courses by student now that he doesn't have anymore
            getCoursesByStudentReply = getAssociatedCoursesStudent (createStudentReply);

            assert (! getCoursesByStudentReply.contains("AlexCourse") && !getCoursesByStudentReply.contains("Exception"));

            generateInvoiceReply = generateInvoice (createStudentReply);

            assert (generateInvoiceReply.contains("0") && !generateInvoiceReply.contains("Exception"));

            deleteReply = deleteCourse(createCourseReply);

            assert (deleteReply.length() == 0 && ! deleteReply.contains("Exception"));

            //delete instructor
            String deleteInstructorReply = deleteInstructor (createInstructorReply);

            assert (deleteInstructorReply.length() == 0 && ! deleteInstructorReply.contains("Exception"));

            //delete "different" instructor
            String deleteDifferentInstructorReply = deleteInstructor (createDifferentInstructorReply);

            assert (deleteDifferentInstructorReply.length() == 0 && ! deleteDifferentInstructorReply.contains("Exception"));

            //delete student
            String deleteStudentReply = deleteStudentMessage (createStudentReply);

            assert (deleteStudentReply.length() == 0 && ! deleteStudentReply.contains("Exception"));

        }   catch(JMSException JMSException) {
            System.out.println("JMS Exception: "+JMSException);
        }
    }

    private String getAllCoursesMessage () throws JMSException
    {

        sendAsynchronousMessage(
                "<request>" +
                        "        <courseService>" +
                        "            <getAll/>" +
                        "        </courseService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;
    }

    private String getAllInstructorMessage () throws JMSException {

        sendAsynchronousMessage(
                "<request>" +
                        "        <instructorService>" +
                        "            <getAll/>" +
                        "        </instructorService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;
    }

    private String createCourse (String instructorXml) throws JMSException
    {

        sendAsynchronousMessage(
                "<request>" +
                        "        <courseService>" +
                        "        <create>" +
                        "<course>\n" +
                        "    <name>AlexCourse</name>\n" +
                        "    <section>1</section>\n" +
                        "    <meeting-hours>T 1300-1600</meeting-hours>\n" +
                        "    <location>SomeRoom01</location>\n" +
                        "    <units>3</units>\n" +
                        "  </course>" +
                        instructorXml +
                        "       </create>" +
                        "        </courseService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;
    }

    private String updateCourse (String courseXml) throws JMSException
    {

        sendAsynchronousMessage(
                "<request>" +
                        "        <courseService>" +
                        "        <update>" +
                            courseXml +
                        "       </update>" +
                        "        </courseService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;
    }

    private String updateInstructorInCourse (String courseXml, String instructorXml) throws JMSException
    {

        sendAsynchronousMessage(
                "<request>" +
                        "        <courseService>" +
                        "        <updateInstructor>" +
                        courseXml +
                        instructorXml +
                        "       </updateInstructor>" +
                        "        </courseService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;
    }

    private String createInstructorMessage() throws JMSException
    {

        sendAsynchronousMessage(
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
    
    private String createDifferentInstructorMessage() throws JMSException
    {

        sendAsynchronousMessage(
                "<request>" +
                        "        <instructorService>" +
                        "        <create>" +
                        "  <instructor>\n" +
                        "    <id>1</id>\n" +
                        "    <first-name>Tom</first-name>\n" +
                        "    <last-name>Sawyer</last-name>\n" +
                        "    <address>Missisipi St</address>\n" +
                        "    <city>Missisipi City</city>\n" +
                        "    <state>MI</state>\n" +
                        "    <zip-code>12345</zip-code>\n" +
                        "    <type>INSTRUCTOR</type>\n" +
                        "    <department>CMPE</department>\n" +
                        "    <employee-id>444-44-4444</employee-id>\n" +
                        "    <office-hours>FU 1200-1300</office-hours>\n" +
                        "    <office>CLK117</office>\n" +
                        "  </instructor>  " +
                        "       </create>" +
                        "        </instructorService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;
    }

    private String updateInstructorMessage(String instructorXml) throws JMSException
    {

        sendAsynchronousMessage(
                "<request>" +
                        "        <instructorService>" +
                        "        <update>" +
                        instructorXml +
                        "       </update>" +
                        "        </instructorService>" +
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

    private String enrollStudentMessage (String courseXml, String studentXml) throws JMSException{

        sendAsynchronousMessage(
                "<request>" +
                        "        <courseService>" +
                        "        <enrollStudent>" +
                        courseXml +
                        studentXml +
                        "       </enrollStudent>" +
                        "        </courseService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;

    }

    private String unenrollStudentMessage (String courseXml, String studentXml) throws JMSException{

        sendAsynchronousMessage(
                "<request>" +
                        "        <courseService>" +
                        "        <unEnrollStudent>" +
                        courseXml +
                        studentXml +
                        "       </unEnrollStudent>" +
                        "        </courseService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;

    }

    private String deleteCourse (String courseXml) throws JMSException
    {

        sendAsynchronousMessage(
                "<request>" +
                        "        <courseService>" +
                        "        <delete>" +
                        courseXml +
                        "       </delete>" +
                        "        </courseService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;
    }

    private String getStudentsByCourse (String courseXml) throws JMSException
    {

        sendAsynchronousMessage(
                "<request>" +
                        "        <courseService>" +
                        "        <getStudentsByCourse>" +
                        courseXml +
                        "       </getStudentsByCourse>" +
                        "        </courseService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;
    }

    private String searchCourse (String field, String value) throws JMSException
    {

        sendAsynchronousMessage(
                "<request>" +
                        "        <courseService>" +
                        "        <search>" +
                        "               <searched-field-name>" + field + "</searched-field-name>"       +
                        "               <searched-value>" + value +  "</searched-value>"       + 
                        "       </search>" +
                        "        </courseService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;
    }

    private String deleteInstructor (String instructorXml) throws JMSException
    {

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

    private String getAssociatedCoursesInstructor (String instructorXml) throws JMSException
    {

        sendAsynchronousMessage(
                "<request>" +
                        "        <instructorService>" +
                        "        <getAssociatedCourses>" +
                        instructorXml +
                        "       </getAssociatedCourses>" +
                        "        </instructorService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;
    }

    private String getAssociatedCoursesStudent (String studentXml ) throws JMSException
    {

        sendAsynchronousMessage(
                "<request>" +
                        "        <studentService>" +
                        "        <getAssociatedCourses>" +
                        studentXml +
                        "       </getAssociatedCourses>" +
                        "        </studentService>" +
                        "    </request>"
        );
        String reply = getReply();

        return reply;
    }

    private String generateInvoice (String studentXml ) throws JMSException
    {

        sendAsynchronousMessage(
                "<request>" +
                        "        <studentService>" +
                        "        <generateInvoice>" +
                        studentXml +
                        "       </generateInvoice>" +
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


    private String getInstructorByCourseMessage (String courseXml) throws JMSException {
        sendAsynchronousMessage(
                "<request>" +
                        "        <courseService>" +
                        "            <getInstructorByCourse>" +
                        courseXml +
                        "           </getInstructorByCourse>" +
                        "        </courseService>" +
                        "    </request>"
        );
        String reply = getReply();
        return reply;
    }


}

