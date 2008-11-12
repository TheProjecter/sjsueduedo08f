package edu.sjsu.edo08f.domain;

import edu.sjsu.edo08f.support.EventInformation;

import java.util.List;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public class Course {

    private Long id;

    private String name;

    private Integer section;

    private List<EventInformation> meetingHours;

    private String location;

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

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public List<EventInformation> getMeetingHours() {
        return meetingHours;
    }

    public void setMeetingHours(List<EventInformation> meetingHours) {
        this.meetingHours = meetingHours;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
