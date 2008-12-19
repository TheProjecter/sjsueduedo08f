package edu.sjsu.edo08f.gui;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import edu.sjsu.edo08f.jms.MessageClient;
import edu.sjsu.edo08f.domain.Person;

import javax.jms.Topic;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
/**
 * Created by IntelliJ IDEA.
 * User: TanTan
 * Date: Dec 15, 2008
 * Time: 11:16:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonClient extends MessageClient {
    public String getAll() throws JMSException {

        System.out.println("PersonClient getAll()");

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

        System.out.println("PersonClient search");
        System.out.println("searchedFieldName: " + searchedFieldName);
        System.out.println("searchedValue:     " + searchedValue);

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
        System.out.println(reply);
        System.out.println("===============================");
        return reply;
    }

    public String getById(String id) throws JMSException {

        System.out.println("PersonClient search");
        System.out.println("Id: " + id);

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