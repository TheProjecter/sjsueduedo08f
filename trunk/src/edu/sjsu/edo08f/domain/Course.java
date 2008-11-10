package edu.sjsu.edo08f.domain;

import java.util.List;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public class Course {

    private Long id;

    private String name;

    private int section;

    private List<String> meetingHours;

    private String location;

    private Instructor instructor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
