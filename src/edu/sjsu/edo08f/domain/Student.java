package edu.sjsu.edo08f.domain;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public class Student extends Person {

    /*
    Student ID in this format
    [0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]
    like 111-22-3333
     */
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
