package edu.sjsu.edo08f.gui;

import edu.sjsu.edo08f.jms.GuiClient;

import javax.jms.JMSException;

/**
 * Created by IntelliJ IDEA.
 * User: TanTan
 * Date: Dec 15, 2008
 * Time: 11:16:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonClient extends GuiClient {
    public String getAll() throws JMSException {

        sendAsynchronousMessage(
            "<request>" +
                "<personService>"  +
                    "<getAll/>"    +
                "</personService>" +
            "</request>"
        );
        String reply = getReply();
        return reply;
    }

    public String search(String searchedFieldName, String searchedValue) throws JMSException {

        sendAsynchronousMessage(
            "<request>" +
                "<personService>" +
                    "<search>" +
                        "<searched-field-name>" + searchedFieldName + "</searched-field-name>" +
                        "<searched-value>"      + searchedValue     +  "</searched-value>"     +
                    "</search>" +
                "</personService>" +
            "</request>"
        );
        String reply = getReply();
        return reply;
    }

    public String getById(String id) throws JMSException {

        sendAsynchronousMessage(
            "<request>" +
                "<personService>"  +
                    "<getbyid>"    +
                        "<id>"     + id  +  "</id>" +
                    "</getbyid>"   +
                "</personService>" +
            "</request>"
        );
        String reply = getReply();
        return reply;
    }

    public String updateStudent(String id, String firstName, String lastName, String address
                   , String city, String state, String zipCode, String type, String studentId) throws JMSException {

        sendAsynchronousMessage(
            "<request>" +
                "<studentService>"  +
                    "<update>"    +
                        "<student>" +
                            "<id>"+id+"</id>" +
                            "<first-name>"+firstName+"</first-name>" +
                            "<last-name>"+lastName+"</last-name>" +
                            "<address>"+address+"</address>" +
                            "<city>"+city+"</city>" +
                            "<state>"+state+"</state>" +
                            "<zip-code>"+zipCode+"</zip-code>" +
                            "<type>"+type+"</type>" +
                            "<student-id>"+studentId+"</student-id>" +
                        "</student>" +
                    "</update>"   +
                "</studentService>" +
            "</request>"
        );
        String reply = getReply();
        return reply;
    }

    public String update(String id, String firstName, String lastName, String address
                   , String city, String state, String zipCode, String type
                   , String department, String employeeId, String officeHours) throws JMSException {

        sendAsynchronousMessage(
            "<request>" +
                "<instructorServicee>"  +
                    "<update>"    +
                        "<instructor>" +
                            "<id>"+id+"</id>" +
                            "<first-name>"+firstName+"</first-name>" +
                            "<last-name>"+lastName+"</last-name>" +
                            "<address>"+address+"</address>" +
                            "<city>"+city+"</city>" +
                            "<state>"+state+"</state>" +
                            "<zip-code>"+zipCode+"</zip-code>" +
                            "<type>"+type+"</type>" +
                            "<department>"+department+"</department>" +
                            "<employee-id>"+employeeId+"</employee-id>" +
                            "<office-hours>"+officeHours+"</office-hours>" +
                        "</instructor>" +
                    "</update>"   +
                "</instructorService>" +
            "</request>"
        );
        String reply = getReply();
        return reply;
    }
}