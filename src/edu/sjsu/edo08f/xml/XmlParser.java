package edu.sjsu.edo08f.xml;

import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Person;
import edu.sjsu.edo08f.services.*;
import edu.sjsu.edo08f.support.EventInformation;
import edu.sjsu.edo08f.support.ParserUtils;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.thoughtworks.xstream.*;

public class XmlParser {

    DocumentBuilderFactory Dfactory;
    DocumentBuilder DBuilder;
    Document d;
    Student student = new Student();
    Person person = new Person();
    Instructor instructor = new Instructor();
    Course course = new Course();
    //StudentServiceImpl ss = new StudentServiceImpl();
    Attr attribute;
    NodeList nodeList;
    Node node;
    NamedNodeMap attList;

    long id;
    String FirstName, LastName, Address, City, State;
    String ZipCode, Type, StudentID, FieldValue, FieldName;

    private ObjectToXmlConverter objectToXmlConverter;
    private PersonService personService;
    private CourseService courseService;
    private StudentService studentService;
    private InstructorService instructorService;

    public XmlParser() {
        objectToXmlConverter = new ObjectToXmlConverter();
        courseService = new CourseServiceImpl();
        personService = new PersonServiceImpl();
        studentService = new StudentServiceImpl();
        instructorService = new InstructorServiceImpl();

    }

    public String parse (String textMessage) {

//          XmlParser reader = new XmlParser();
//          reader.readXML();
        String result=null;
        try{
            Dfactory = DocumentBuilderFactory.newInstance();
            DBuilder = Dfactory.newDocumentBuilder();
            d = DBuilder.parse(textMessage);
            //d = DBuilder.parse(new File("person.xml"));
            d.getDocumentElement().normalize();
            System.out.println("Reading XML");
            result= findServices();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error:"+e);
        }

        return result;
    }

    public String findServices() {
        NodeList rootNode = d.getElementsByTagName("request");
        NodeList childNodeList = rootNode.item(0).getChildNodes();
        String serviceName = "";
        String methodName = null;

        for (int i = 0; i < childNodeList.getLength(); i++) {
            if (childNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                if (childNodeList.item(i).getNodeName().matches(".*Service")) {
                    Node serviceNode = childNodeList.item(i);
                    serviceName = childNodeList.item(i).getNodeName();
                    NodeList serviceChildNodeList = serviceNode.getChildNodes();
                    // to find which method is called in an xml
                    for (int j = 0; j < serviceChildNodeList.getLength(); j++) {
                        if (serviceChildNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                            Node methodNode = serviceChildNodeList.item(i);
                            methodName = methodNode.getNodeName();
                            break;
                        }
                    }
                    // call another method
                    String temp = "Service is " + serviceName + " and method is " + methodName;

                    // StudentService methods
                    if(serviceName.equalsIgnoreCase("studentService")){
                        if(methodName.equalsIgnoreCase("getAll")){
                            List<Student> returnAllStudent = studentService.getAll();
                            return objectToXmlConverter.getOutputForAllStudent(returnAllStudent);
                        }
                        if(methodName.equalsIgnoreCase("getById")){
                            Long id= getByIdStudentService();
                            Student returnedGetByIdStudent = studentService.getById(id);
                            return objectToXmlConverter.getOutputForGetByIdStudentService(returnedGetByIdStudent);
                        }
                        if(methodName.equalsIgnoreCase("create")){
                            Student createStudentService =createUpdateStudentService();
                            Student returnedCreatedStudent = studentService.create(createStudentService);
                            return objectToXmlConverter.getOutputForCreateStudentService(returnedCreatedStudent);
                        }
                        if(methodName.equalsIgnoreCase("update")){
                            Student updateStudentService= createUpdateStudentService();
                            Student returnedUpdatedStudent = studentService.update(updateStudentService);
                            return objectToXmlConverter.getOutputForUpdateStudentService(returnedUpdatedStudent);
                        }
                        if(methodName.equalsIgnoreCase("delete")){
                            Student getStudentId=   getIdStudentService();
                            studentService.delete(getStudentId);
                        }
                        if(methodName.equalsIgnoreCase("generateInvoice")){
                            Student generateInvoiceStudentService = getIdStudentService();
                            String returnedgenerateInvoiceStudent = studentService.generateInvoice(generateInvoiceStudentService);
                            return objectToXmlConverter.getOutputForGenerateInvoiceStudentService(returnedgenerateInvoiceStudent);
                        }
                        if(methodName.equalsIgnoreCase("getAssociatedCourses")){
                            Student getAssociatedCoursesStudentService= getAssociatedCoursesStudentService();
                            List<Course> returnedAssociatedCoursesStudent = studentService.getAssociatedCourses(getAssociatedCoursesStudentService);
                            return objectToXmlConverter.getOutputForgetAssociatedCoursesStudentService(returnedAssociatedCoursesStudent);
                        }
                    }

                    // PersonService methods
                    if(serviceName.equalsIgnoreCase("personService")){
                        if(methodName.equalsIgnoreCase("getAll")){
                            List<Person> returnAllPerson = personService.getAll();
                            return objectToXmlConverter.getOutputForAllPerson(returnAllPerson);
                        }
                        if(methodName.equalsIgnoreCase("getById")){
                            Long id= getByIdPersonService();
                            Person returnedGetByIdPerson = personService.getById(id);
                            return objectToXmlConverter.getOutputForGetByIdPersonService(returnedGetByIdPerson);
                        }
                        if(methodName.equalsIgnoreCase("search")){
                            String searchedFieldName= getsearchedFieldName();
                            String searchedFieldValue= getsearchedFieldValue();
                            List<Person> returnSearchPerson = personService.search(searchedFieldName,searchedFieldValue);
                            return objectToXmlConverter.getOutputForSearchPerson(returnSearchPerson);
                        }

                    }

                    // InstructorService methods
                    if(serviceName.equalsIgnoreCase("instructorService")){
                        if(methodName.equalsIgnoreCase("getAll")){
                            List<Instructor> returnAllInstructor = instructorService.getAll();
                            return objectToXmlConverter.getOutputForAllInstructor(returnAllInstructor);
                        }
                        if(methodName.equalsIgnoreCase("getById")){
                            Long id= getByIdInstructorService();
                            Instructor returnedGetByIdInstructor = instructorService.getById(id);
                            return objectToXmlConverter.getOutputForGetByIdInstructorService(returnedGetByIdInstructor);
                        }
                        if(methodName.equalsIgnoreCase("create")){
                            Instructor createInstructorService = createUpdateInstructorService();
                            Instructor returnedCreatedInstructor = instructorService.create(createInstructorService);
                            return objectToXmlConverter.getOutputForCreateInstructorService(returnedCreatedInstructor);
                        }
                        if(methodName.equalsIgnoreCase("update")){
                            Instructor updateInstructorService= createUpdateInstructorService();
                            Instructor returnedUpdatedInstructor = instructorService.update(updateInstructorService);
                            return objectToXmlConverter.getOutputForUpdateInstructorService(returnedUpdatedInstructor);
                        }
                        if(methodName.equalsIgnoreCase("delete")){
                            Instructor getInstructorId=   getIdInstructorService();
                            instructorService.delete(instructor);
                        }
                        if(methodName.equalsIgnoreCase("getAssociatedCourses")){
                            Instructor getAssociatedCoursesInstructorService= getAssociatedCoursesInstructorService();
                            List<Course> returnedAssociatedCoursesInstructor = instructorService.getAssociatedCourses(getAssociatedCoursesInstructorService);
                            return objectToXmlConverter.getOutputForgetAssociatedCoursesInstructorService(returnedAssociatedCoursesInstructor);
                        }

                    }
                    // CourseServices methods

                    if(serviceName.equalsIgnoreCase("courseService")){
                        if(methodName.equalsIgnoreCase("getAll")){
                            List<Course> returnAllCourse = courseService.getAll();
                            return objectToXmlConverter.getOutputForAllCourse(returnAllCourse);
                        }
                        if(methodName.equalsIgnoreCase("getById")){
                            Long id= getByIdCourseService();
                            Course returnedGetByIdCourse = courseService.getById(id);
                            return objectToXmlConverter.getOutputForGetByIdCourseService(returnedGetByIdCourse);
                        }
                        if(methodName.equalsIgnoreCase("getStudentsByCourse")){
                            Course StudentsByCourseCourseService= getCourseIdCourseService();
                            List<Student> returnedGetStudentsByCourse = courseService.getStudentsByCourse(StudentsByCourseCourseService);
                            return objectToXmlConverter.getOutputForGetStudentsByCourseCourseService(returnedGetStudentsByCourse);
                        }
                        if(methodName.equalsIgnoreCase("getInstructorByCourse")){
                            Course InstructorByCourseCourseService= getCourseIdCourseService();
                            Instructor returnedGetInstructorByCourse = courseService.getInstructorByCourse(InstructorByCourseCourseService);
                            return objectToXmlConverter.getOutputForGetInstructorByCourseCourseService(returnedGetInstructorByCourse);
                        }
                        if(methodName.equalsIgnoreCase("create")){
                            Course createCourseService = createCourseService();
                            Instructor createInstructorCourseService = createInstructorCourseService();
                            Course returnedCreatedCourse = courseService.create(createCourseService,createInstructorCourseService );
                            return objectToXmlConverter.getOutputForCreateCourseService(returnedCreatedCourse);
                        }
                        if(methodName.equalsIgnoreCase("update")){
                            Course updateCourseService= updateCourseService();
                            Course returnedUpdatedCourse = courseService.update(updateCourseService);
                            return objectToXmlConverter.getOutputForUpdateCourseService(returnedUpdatedCourse);
                        }
                        if(methodName.equalsIgnoreCase("delete")){
                            Course getCourseId=   getCourseIdCourseService();
                            courseService.delete(getCourseId);
                        }
                        if(methodName.equalsIgnoreCase("enrollStudent")){
                            Course getCourseId =  getCourseIdCourseService();
                            Student getStudentId = getIdStudentService();
                            courseService.enrollStudent(getCourseId, getStudentId);
                        }
                        if(methodName.equalsIgnoreCase("unEnrollStudent")){
                            Course getCourseId =  getCourseIdCourseService();
                            Student getStudentId = getIdStudentService();
                            courseService.unEnrollStudent(getCourseId, getStudentId);
                        }
                        if(methodName.equalsIgnoreCase("updateInstructor")){
                            courseService.updateInstructor(course, instructor);
                        }
                        if(methodName.equalsIgnoreCase("search")){
                            String searchedFieldName= getsearchedFieldNameInstructor();
                            String searchedFieldValue= getsearchedFieldValueInstructor();
                            List<Course> returnSearchInstructor = courseService.search(searchedFieldName,searchedFieldValue);
                            return objectToXmlConverter.getOutputForSearchInstructorCourse(returnSearchInstructor);
                        }

                    }

//        	            System.out.println(temp);
//        	            break;
                }
            }

        }
        return "";
    }
    // Bellow methods is used to get data for SutdentServices

    public Long getByIdStudentService(){
        NodeList nodeLst = d.getElementsByTagName("student");
        NodeList sid=d.getElementsByTagName("id");

        for (int s = 0; s < nodeLst.getLength(); s++){
            student.setId(Long.parseLong(sid.item(s).getTextContent()));
            Long id = student.getId();
        }
        return id;
    }
    public Student createUpdateStudentService(){
        NodeList nodeLst = d.getElementsByTagName("student");
        NodeList sid=d.getElementsByTagName("id");
        NodeList firstName=d.getElementsByTagName("first-name");
        NodeList lastName=d.getElementsByTagName("last-name");
        NodeList address=d.getElementsByTagName("address");
        NodeList city=d.getElementsByTagName("city");
        NodeList state=d.getElementsByTagName("state");
        NodeList zipCode=d.getElementsByTagName("zip-code");
        NodeList type=d.getElementsByTagName("type");
        NodeList studentId=d.getElementsByTagName("student-id");


        for (int s = 0; s < nodeLst.getLength(); s++){

            student.setFirstName(firstName.item(s).getTextContent());
            student.setId(Long.parseLong(sid.item(s).getTextContent()));
            student.setLastName(lastName.item(s).getTextContent());
            student.setAddress(address.item(s).getTextContent());
            student.setCity(city.item(s).getTextContent());
            student.setState(state.item(s).getTextContent());
            student.setZipCode(zipCode.item(s).getTextContent());
            student.setType(type.item(s).getTextContent());
            student.setStudentId(studentId.item(s).getTextContent());

        }
        return student;
    }

    public Student getIdStudentService(){
        NodeList nodeLst = d.getElementsByTagName("student");
        NodeList sid=d.getElementsByTagName("id");

        for (int s = 0; s < nodeLst.getLength(); s++){
            student.setId(Long.parseLong(sid.item(s).getTextContent()));
        }
        return student;
    }
    public Student getAssociatedCoursesStudentService(){
        NodeList nodeLst = d.getElementsByTagName("student");
        NodeList studentId=d.getElementsByTagName("student-id");

        for (int s = 0; s < nodeLst.getLength(); s++){
            student.setStudentId(studentId.item(s).getTextContent());
        }
        return student;
    }

    // Bellow methods is used to get data for PersonServices
    public Long getByIdPersonService(){
        NodeList nodeLst = d.getElementsByTagName("person");
        NodeList sid=d.getElementsByTagName("id");

        for (int s = 0; s < nodeLst.getLength(); s++){
            person.setId(Long.parseLong(sid.item(s).getTextContent()));
            Long id = person.getId();
        }
        return id;
    }
    public String getsearchedFieldName(){
        NodeList nodeLst = d.getElementsByTagName("person");
        NodeList searchFieldName=d.getElementsByTagName("searched-field-name");

        for (int s = 0; s < nodeLst.getLength(); s++){
            FieldName = searchFieldName.item(s).getTextContent();
        }
        return FieldName;
    }
    public String getsearchedFieldValue(){

        NodeList nodeLst = d.getElementsByTagName("person");
        NodeList searchFieldValue=d.getElementsByTagName("searched-value");

        for (int s = 0; s < nodeLst.getLength(); s++){
            FieldValue = searchFieldValue.item(s).getTextContent();

        }
        return FieldValue;
    }

    // Bellow methods is used to get data for InstructorServices
    public Long getByIdInstructorService(){
        NodeList nodeLst = d.getElementsByTagName("instructor");
        NodeList sid=d.getElementsByTagName("id");

        for (int s = 0; s < nodeLst.getLength(); s++){
            instructor.setId(Long.parseLong(sid.item(s).getTextContent()));
            Long id = instructor.getId();
        }
        return id;
    }
    public Instructor getIdInstructorService(){
        NodeList nodeLst = d.getElementsByTagName("instructor");
        NodeList sid=d.getElementsByTagName("id");

        for (int s = 0; s < nodeLst.getLength(); s++){
            instructor.setId(Long.parseLong(sid.item(s).getTextContent()));

        }
        return instructor;
    }

    public Instructor createUpdateInstructorService(){
        NodeList nodeLst = d.getElementsByTagName("instructor");
        NodeList sid=d.getElementsByTagName("id");
        NodeList firstName=d.getElementsByTagName("first-name");
        NodeList lastName=d.getElementsByTagName("last-name");
        NodeList address=d.getElementsByTagName("address");
        NodeList city=d.getElementsByTagName("city");
        NodeList state=d.getElementsByTagName("state");
        NodeList zipCode=d.getElementsByTagName("zip-code");
        NodeList type=d.getElementsByTagName("type");
        NodeList department=d.getElementsByTagName("department");
        NodeList employeeId=d.getElementsByTagName("employee-id");
        NodeList officeHours=d.getElementsByTagName("office-hours");
        NodeList office=d.getElementsByTagName("office");


        for (int s = 0; s < nodeLst.getLength(); s++){

            instructor.setFirstName(firstName.item(s).getTextContent());
            instructor.setId(Long.parseLong(sid.item(s).getTextContent()));
            instructor.setLastName(lastName.item(s).getTextContent());
            instructor.setAddress(address.item(s).getTextContent());
            instructor.setCity(city.item(s).getTextContent());
            instructor.setState(state.item(s).getTextContent());
            instructor.setZipCode(zipCode.item(s).getTextContent());
            instructor.setType(type.item(s).getTextContent());
            instructor.setDepartment(department.item(s).getTextContent());
            instructor.setEmployeeId(employeeId.item(s).getTextContent());

            List<String> officeHoursList = new ArrayList<String>();
            officeHoursList.add(officeHours.item(s).getTextContent());

            instructor.setOfficeHours(ParserUtils.parseOfficeHours(officeHoursList));
            instructor.setOffice(office.item(s).getTextContent());
        }
        return instructor;
    }
    public Instructor getAssociatedCoursesInstructorService(){
        NodeList nodeLst = d.getElementsByTagName("instructor");
        NodeList studentId=d.getElementsByTagName("employee-id");

        for (int s = 0; s < nodeLst.getLength(); s++){
            instructor.setEmployeeId(studentId.item(s).getTextContent());
        }
        return instructor;
    }

    // Bellow methods is used to get data for CourseServices

    public Long getByIdCourseService(){
        NodeList nodeLst = d.getElementsByTagName("course");
        NodeList sid=d.getElementsByTagName("id");

        for (int s = 0; s < nodeLst.getLength(); s++){
            course.setId(Long.parseLong(sid.item(s).getTextContent()));
            Long id = course.getId();
        }
        return id;
    }
    public Course getCourseIdCourseService(){
        NodeList nodeLst = d.getElementsByTagName("course");
        NodeList sid=d.getElementsByTagName("id");

        for (int s = 0; s < nodeLst.getLength(); s++){
            course.setId(Long.parseLong(sid.item(s).getTextContent()));
        }
        return course;
    }
    public Course createCourseService(){
        NodeList nodeLst = d.getElementsByTagName("course");
        NodeList sid=d.getElementsByTagName("id");
        NodeList courseName=d.getElementsByTagName("name");
        NodeList section=d.getElementsByTagName("section");
        NodeList meetingHours=d.getElementsByTagName("meeting-hours");
        NodeList location=d.getElementsByTagName("location");

        for (int s = 0; s < nodeLst.getLength(); s++){

            course.setId(Long.parseLong(sid.item(s).getTextContent()));
            course.setName(courseName.item(s).getTextContent());
            course.setSection(Integer.parseInt(section.item(s).getTextContent()));

            List<String> meetingHoursList = new ArrayList<String>();
            meetingHoursList.add(meetingHours.item(s).getTextContent());

            course.setMeetingHours(ParserUtils.parseOfficeHours(meetingHoursList));
            course.setLocation(location.item(s).getTextContent());

        }
        return course;
    }

    public List<EventInformation> getEventInfo(NodeList meetingHours)
    {
        List<EventInformation> meetingHour ;
        for (int s = 0; s < meetingHours.getLength(); s++){
            String str=   meetingHours.item(s).getTextContent();

        }
        return null;
    }

    public Instructor createInstructorCourseService(){
        NodeList nodeLst = d.getElementsByTagName("course");
        NodeList department=d.getElementsByTagName("department");
        NodeList employeeId=d.getElementsByTagName("employee-id");
        NodeList officeHours=d.getElementsByTagName("office-hours");
        NodeList office=d.getElementsByTagName("office");

        for (int s = 0; s < nodeLst.getLength(); s++){

            instructor.setDepartment(department.item(s).getTextContent());
            instructor.setEmployeeId(employeeId.item(s).getTextContent());

            List<String> officeHoursList = new ArrayList<String>();
            officeHoursList.add(officeHours.item(s).getTextContent());

            instructor.setOfficeHours(ParserUtils.parseOfficeHours(officeHoursList));
            
            instructor.setOffice(office.item(s).getTextContent());

        }
        return instructor;
    }

    public Course updateCourseService(){
        NodeList nodeLst = d.getElementsByTagName("course");
        NodeList sid=d.getElementsByTagName("id");
        NodeList courseName=d.getElementsByTagName("name");
        NodeList section=d.getElementsByTagName("section");
        NodeList meetingHours=d.getElementsByTagName("meeting-hours");
        NodeList location=d.getElementsByTagName("location");
        //List<String> meeting;
        for (int s = 0; s < nodeLst.getLength(); s++){

            course.setId(Long.parseLong(sid.item(s).getTextContent()));
            course.setName(courseName.item(s).getTextContent());
            course.setSection(Integer.parseInt(section.item(s).getTextContent()));

            List<String> meetingHoursList = new ArrayList<String>();
            meetingHoursList.add(meetingHours.item(s).getTextContent());

            course.setMeetingHours(ParserUtils.parseOfficeHours(meetingHoursList));

            //meeting.add(course.setMeetingHours(meetingHours.item(s).getTextContent()));
            course.setLocation(location.item(s).getTextContent());

        }
        return course;
    }
    public String getsearchedFieldNameInstructor(){
        NodeList nodeLst = d.getElementsByTagName("course");
        NodeList searchFieldName=d.getElementsByTagName("searched-field-name");

        for (int s = 0; s < nodeLst.getLength(); s++){
            FieldName = searchFieldName.item(s).getTextContent();
        }
        return FieldName;
    }
    public String getsearchedFieldValueInstructor(){

        NodeList nodeLst = d.getElementsByTagName("course");
        NodeList searchFieldValue=d.getElementsByTagName("searched-value");

        for (int s = 0; s < nodeLst.getLength(); s++){
            FieldValue = searchFieldValue.item(s).getTextContent();

        }
        return FieldValue;
    }

}
