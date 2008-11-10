package edu.sjsu.edo08f.domain;

import java.util.List;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public class Course {

    private Long id;
    /*
    Standard name
     */
    private String courseName;

    /*
    1-2-3-4, standard int
     */
    private int courseSection;

    /*
    need to decide if we need a map <Day, Hours> or something else
    all depends on how are we going to perform search
     */
    private List<String> meetingHours;

    /*
     This is a full-format class location, like ENG222, or CLR107
     See also: Instructor.officeHours
     */
    private String location;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseSection() {
        return courseSection;
    }

    public void setCourseSection(int courseSection) {
        this.courseSection = courseSection;
    }

    public List<String> getMeetingHours() {
        return meetingHours;
    }

    public void setMeetingHours(List<String> meetingHours) {
        this.meetingHours = meetingHours;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
