package edu.sjsu.edo08f.domain;

import java.util.List;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public class Instructor extends Person {

    /*
    The name of department. Like, 'Computer Engineering'
     */
    private String department;

    /*
    Employee ID. Supposedly the same format as student ID
     */
    private String employeeId;

    /*
    This is office hours, in a special format
    Please see: ParserUtils.verifyOfficeHours
     */
    private List<String> officeHours;

    /*
    This is a full-format office location, like ENG222, or CLR107
     */
    private String office;


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public List<String> getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(List<String> officeHours) {
        this.officeHours = officeHours;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
