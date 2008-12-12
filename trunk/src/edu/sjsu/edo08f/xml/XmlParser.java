package edu.sjsu.edo08f.xml;

import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Person;
import edu.sjsu.edo08f.services.*;
import edu.sjsu.edo08f.support.ParserUtils;

import java.util.List;
import java.util.ArrayList;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlParser {

    DocumentBuilderFactory Dfactory;
    DocumentBuilder DBuilder;
    Document d;

    //StudentServiceImpl ss = new StudentServiceImpl();
    Attr attribute;
    NodeList nodeList;
    Node node;
    NamedNodeMap attList;

    private ObjectToXmlConverter objectToXmlConverter;
    private PersonService personService;
    private CourseService courseService;
    private StudentService studentService;
    private InstructorService instructorService;

    public XmlParser() {
        objectToXmlConverter = new ObjectToXmlConverter();
    }

    public void setInstructorService(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public String parse (String textMessage) throws Exception {

        String result;
        Dfactory = DocumentBuilderFactory.newInstance();
        DBuilder = Dfactory.newDocumentBuilder();

        InputStream inputStream = ParserUtils.convertStringToInputStream (textMessage);

        d = DBuilder.parse(inputStream);
        d.getDocumentElement().normalize();
        result = findServices();
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

                    // StudentService methods
                    if(serviceName.equalsIgnoreCase("studentService")){
                        if(methodName.equalsIgnoreCase("getAll")){
                            List<Student> returnAllStudent = studentService.getAll();
                            return objectToXmlConverter.getOutputForAllStudent(returnAllStudent);
                        }
                        if(methodName.equalsIgnoreCase("getById")){
                            Student student = parseStudentWithId();
                            return objectToXmlConverter.getOutputForGetByIdStudentService(student);
                        }
                        if(methodName.equalsIgnoreCase("create")){
                            Student createStudentService = parseStudentWithId();
                            Student returnedCreatedStudent = studentService.create(createStudentService);
                            return objectToXmlConverter.getOutputForCreateStudentService(returnedCreatedStudent);
                        }
                        if(methodName.equalsIgnoreCase("update")){
                            Student updateStudentService= parseStudentWithId();
                            Student returnedUpdatedStudent = studentService.update(updateStudentService);
                            return objectToXmlConverter.getOutputForUpdateStudentService(returnedUpdatedStudent);
                        }
                        if(methodName.equalsIgnoreCase("delete")){
                            Student student =parseStudentWithId();
                            studentService.delete(student);
                        }
                        if(methodName.equalsIgnoreCase("generateInvoice")){
                            Student student = parseStudentWithId();
                            String returnedgenerateInvoiceStudent = studentService.generateInvoice(student);
                            return objectToXmlConverter.getOutputForGenerateInvoiceStudentService(returnedgenerateInvoiceStudent);
                        }
                        if(methodName.equalsIgnoreCase("getAssociatedCourses")){
                            Student student = parseStudentWithId();
                            List<Course> returnedAssociatedCoursesStudent = studentService.getAssociatedCourses(student);
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
                            Person person = parsePersonWithId ();
                            return objectToXmlConverter.getOutputForGetByIdPersonService(person);
                        }
                        if(methodName.equalsIgnoreCase("search")){
                            String searchedFieldName= getSearchField();
                            String searchedFieldValue= getSearchedValue();
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
                            Instructor instructor = parseInstructorWithId();
                            return objectToXmlConverter.getOutputForGetByIdInstructorService(instructor);
                        }
                        if(methodName.equalsIgnoreCase("create")){
                            Instructor createInstructorService = parseInstructorWithId();
                            Instructor returnedCreatedInstructor = instructorService.create(createInstructorService);
                            return objectToXmlConverter.getOutputForCreateInstructorService(returnedCreatedInstructor);
                        }
                        if(methodName.equalsIgnoreCase("update")){
                            Instructor updateInstructorService= parseInstructorWithId();
                            Instructor returnedUpdatedInstructor = instructorService.update(updateInstructorService);
                            return objectToXmlConverter.getOutputForUpdateInstructorService(returnedUpdatedInstructor);
                        }
                        if(methodName.equalsIgnoreCase("delete")){
                            Instructor getInstructorId =  parseInstructorWithId();
                            instructorService.delete(getInstructorId);
                        }
                        if(methodName.equalsIgnoreCase("getAssociatedCourses")){
                            Instructor getAssociatedCoursesInstructorService= parseInstructorWithId();
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
                            Course course = parseCourseWithId();
                            return objectToXmlConverter.getOutputForGetByIdCourseService(course);
                        }
                        if(methodName.equalsIgnoreCase("getStudentsByCourse")){
                            Course course= parseCourseWithId ();
                            List<Student> returnedGetStudentsByCourse = courseService.getStudentsByCourse(course);
                            return objectToXmlConverter.getOutputForGetStudentsByCourseCourseService(returnedGetStudentsByCourse);
                        }
                        if(methodName.equalsIgnoreCase("getInstructorByCourse")){
                            Course InstructorByCourseCourseService= parseCourseWithId();
                            Instructor returnedGetInstructorByCourse = courseService.getInstructorByCourse(InstructorByCourseCourseService);
                            return objectToXmlConverter.getOutputForGetInstructorByCourseCourseService(returnedGetInstructorByCourse);
                        }
                        if(methodName.equalsIgnoreCase("create")){
                            Course createCourseService = parseCourseWithId();
                            Instructor createInstructorCourseService = parseInstructorWithId();
                            Course returnedCreatedCourse = courseService.create(createCourseService,createInstructorCourseService );
                            return objectToXmlConverter.getOutputForCreateCourseService(returnedCreatedCourse);
                        }
                        if(methodName.equalsIgnoreCase("update")){
                            Course updateCourseService= parseCourseWithId();
                            Course returnedUpdatedCourse = courseService.update(updateCourseService);
                            return objectToXmlConverter.getOutputForUpdateCourseService(returnedUpdatedCourse);
                        }
                        if(methodName.equalsIgnoreCase("delete")){
                            Course course = parseCourseWithId();
                            courseService.delete(course);
                        }
                        if(methodName.equalsIgnoreCase("enrollStudent")){
                            Course courseWithId =  parseCourseWithId();
                            Student studentWithId = parseStudentWithId();
                            courseService.enrollStudent(courseWithId, studentWithId);
                        }
                        if(methodName.equalsIgnoreCase("unEnrollStudent")){
                            Course courseWithId =  parseCourseWithId();
                            Student studentWithId = parseStudentWithId();
                            courseService.unEnrollStudent(courseWithId, studentWithId);
                        }
                        if(methodName.equalsIgnoreCase("updateInstructor")) {
                            Course course = parseCourseWithId();
                            Instructor instructor = parseInstructorWithId();
                            courseService.updateInstructor(course, instructor);
                        }
                        if(methodName.equalsIgnoreCase("search")){
                            String searchedFieldName= getSearchField();
                            String searchedFieldValue= getSearchedValue();
                            List<Course> returnSearchInstructor = courseService.search(searchedFieldName,searchedFieldValue);
                            return objectToXmlConverter.getOutputForSearchInstructorCourse(returnSearchInstructor);
                        }

                    }

                }
            }

        }
        return "";
    }

    public Student parseStudentWithId() {

        Student student = new Student();

        NodeList nodeLst = d.getElementsByTagName("student");

        NodeList studentElements = nodeLst.item(0).getChildNodes();

        for (int i = 0; i < studentElements.getLength(); i++ ) {
            Node currentNode = studentElements.item(i);

            if (currentNode.getNodeName().equals("id")) {
                student.setId(Long.parseLong(currentNode.getTextContent()));
            } else if (currentNode.getNodeName().equals("first-name")) {
                student.setFirstName(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("last-name")) {
                student.setLastName(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("address")) {
                student.setAddress(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("city")) {
                student.setCity(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("state")) {
                student.setState(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("zip-code")) {
                student.setZipCode(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("type")) {
                student.setType(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("student-id")) {
                student.setStudentId(currentNode.getTextContent());
            }
        }

        return student;
    }

    public Person parsePersonWithId() {

        Person person = new Person();

        NodeList nodeLst = d.getElementsByTagName("instructor");

        NodeList personElements = nodeLst.item(0).getChildNodes();

        for (int i = 0; i < personElements.getLength(); i++ ) {
            Node currentNode = personElements.item(i);

            if (currentNode.getNodeName().equals("id")) {
                person.setId(Long.parseLong(currentNode.getTextContent()));
            } else if (currentNode.getNodeName().equals("first-name")) {
                person.setFirstName(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("last-name")) {
                person.setLastName(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("address")) {
                person.setAddress(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("city")) {
                person.setCity(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("state")) {
                person.setState(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("zip-code")) {
                person.setZipCode(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("type")) {
                person.setType(currentNode.getTextContent());
            }
        }

        return person;
    }


    public Instructor parseInstructorWithId() {

        Instructor instructor = new Instructor();

        NodeList nodeLst = d.getElementsByTagName("instructor");

        NodeList instructorElements = nodeLst.item(0).getChildNodes();

        for (int i = 0; i < instructorElements.getLength(); i++ ) {
            Node currentNode = instructorElements.item(i);

            if (currentNode.getNodeName().equals("id")) {
                instructor.setId(Long.parseLong(currentNode.getTextContent()));
            } else if (currentNode.getNodeName().equals("first-name")) {
                instructor.setFirstName(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("last-name")) {
                instructor.setLastName(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("address")) {
                instructor.setAddress(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("city")) {
                instructor.setCity(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("state")) {
                instructor.setState(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("zip-code")) {
                instructor.setZipCode(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("type")) {
                instructor.setType(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("department")) {
                instructor.setDepartment(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("employee-id")) {
                instructor.setEmployeeId(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("office")) {
                instructor.setOffice(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("office-hours")) {
                List<String> officeHoursList = new ArrayList<String>();
                officeHoursList.add(currentNode.getTextContent());
                instructor.setOfficeHours(ParserUtils.parseOfficeHours(officeHoursList));
            }
        }

        return instructor;

    }


    public Course parseCourseWithId(){

        Course course = new Course();

        NodeList nodeLst = d.getElementsByTagName("course");

        NodeList courseElements = nodeLst.item(0).getChildNodes();

        for (int i = 0; i < courseElements.getLength(); i++ ) {
            Node currentNode = courseElements.item(i);

            if (currentNode.getNodeName().equals("id")) {
                course.setId(Long.parseLong(currentNode.getTextContent()));
            } else if (currentNode.getNodeName().equals("name")) {
                course.setName(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("section")) {
                course.setSection(Integer.parseInt(currentNode.getTextContent()));
            } else if (currentNode.getNodeName().equals("units")) {
                course.setUnits(Integer.parseInt(currentNode.getTextContent()));
            } else if (currentNode.getNodeName().equals("location")) {
                course.setLocation(currentNode.getTextContent());
            } else if (currentNode.getNodeName().equals("meeting-hours")) {
                List<String> meetingHoursList = new ArrayList<String>();
                meetingHoursList.add(currentNode.getTextContent());
                course.setMeetingHours(ParserUtils.parseOfficeHours(meetingHoursList));
            }
        }

        return course;

    }

    public String getSearchField(){

        NodeList searchFieldName=d.getElementsByTagName("searched-field-name");

        for (int s = 0; s < searchFieldName.getLength(); s++){
            return searchFieldName.item(s).getTextContent();
        }
        return null;
    }
    public String getSearchedValue(){

        NodeList searchFieldValue=d.getElementsByTagName("searched-value");

        for (int s = 0; s < searchFieldValue.getLength(); s++){
            return searchFieldValue.item(s).getTextContent();

        }
        return null;
    }

}
